import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

var current_gag_data_url = 'http://localhost:8005/gag?sort=number,desc';
var headers = {
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Methods': 'GET, POST, DELETE, PUT, OPTIONS',
  'Access-Control-Allow-Headers': 'Origin, Content-Type, Accept, Authorization, X-Request-With',
  'Access-Control-Allow-Credentials': 'true'
};

export class Gag {

  data = null;
  private likeToggled = false;
  private dislikeToggled = false;

  constructor(private http: HttpClient, data) {
    this.data = data;
  }

  toggleLike() {
    console.log("Like clicked on gag " + this.data['number']);
    if (this.dislikeToggled) {
       this.dislikeToggled = false;
       this.http.get('http://localhost:8005/gag/search/addLike?number=' + this.data['number'], {headers: headers}).subscribe(response => console.log(response));
       this.data['likes']++;  
       console.log("Dislike removed");
    }
    if (this.likeToggled) {
       this.http.get('http://localhost:8005/gag/search/rmLike?number=' + this.data['number'], {headers: headers}).subscribe(response => console.log(response));
       this.data['likes']--; 
       console.log("Like removed");
    } else {
       this.http.get('http://localhost:8005/gag/search/addLike?number=' + this.data['number'], {headers: headers}).subscribe(response => console.log(response));
       this.data['likes']++;  
       console.log("Like added");
    }
    this.likeToggled = !this.likeToggled;
  }

  toggleDislike() {
    console.log("Dislike clicked on gag " + this.data['number']);
    if (this.likeToggled) {
       this.likeToggled = false;
       this.http.get('http://localhost:8005/gag/search/rmLike?number=' + this.data['number'], {headers: headers}).subscribe(response => console.log(response));
       this.data['likes']--;  
       console.log("Like removed");
    }
    if (this.dislikeToggled) {
       this.http.get('http://localhost:8005/gag/search/addLike?number=' + this.data['number'], {headers: headers}).subscribe(response => console.log(response));
       this.data['likes']++;  
       console.log("Dislike removed");
    } else {
       this.http.get('http://localhost:8005/gag/search/rmLike?number=' + this.data['number'], {headers: headers}).subscribe(response => console.log(response)); 
       this.data['likes']--;  
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