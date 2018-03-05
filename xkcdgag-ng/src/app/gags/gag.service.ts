import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

var current_gag_data_url = 'http://localhost:8005/gag?sort=number,desc';

export class Gag {

  data = null;

  constructor(data) {
    this.data = data;
    console.log(data);
  }
}

@Injectable()
export class GagService {

  constructor(private http: HttpClient) {}

  getGag(num: number) {
    return this.http.get('http://localhost:8005/gag/' + num)
             .subscribe(
             data => {
                return new Gag(data['_embedded']['gag']);
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