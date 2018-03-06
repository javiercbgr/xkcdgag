import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

var current_gag_data_url = 'http://localhost:8005/gag?sort=number,desc';

export class Gag {

  data = null;
  private likeToggled = false;
  private dislikeToggled = false;

  constructor(private http: HttpClient, data) {
    this.data = data;
  }

  toggleLike() {
    if (this.likeToggled) {
       this.http.get('http://localhost:8005/gag/search/rmLike?number=' + this.data['number']);  
       this.data['likes']--; 
       console.log("Like removed");
    } else {
       this.http.get('http://localhost:8005/gag/search/addLike?number=' + this.data['number']);
       this.data['likes']++;  
       console.log("Like added");
    }
    this.likeToggled = !this.likeToggled;
  }

  toggleDislike() {
    if (this.dislikeToggled) {
       this.http.get('http://localhost:8005/gag/search/rmDislike?number=' + this.data['number']);  
       this.data['dislikes']--; 
       console.log("Dislike removed");
    } else {
       this.http.get('http://localhost:8005/gag/search/addDislike?number=' + this.data['number']);
       this.data['dislikes']++; 
       console.log("Dislike added");
    }
    this.dislikeToggled = !this.dislikeToggled;
  }
}

@Injectable()
export class GagService {

  constructor(private http: HttpClient) {}

  getGag(num: number) {
    return this.http.get('http://localhost:8005/gag/' + num)
             .subscribe(
             data => {
                return new Gag(this.http, data['_embedded']['gag']);
             },
             err => {
                 console.log('Couldnt retrieve gag data (' + num + ').')
             }
             );  
  }

  getGags(from: number, count: number) {

    // If there is no start point, use the last gag
    if (from == null) {
      console.log("From is null");
      return this.http.get('http://localhost:8005/gag/search/last')
               .subscribe(
                 (data: number) => { if (data != null) { return this.getGags(data, count); } },
                 (err) => { console.log('Couldnt retrieve last gag number.') }
               );  
    }

    // Retrieve next gags
    return this.http.get('http://localhost:8005/gag/search/lastGags?from=' + from + '&size=' + count);
  }

}