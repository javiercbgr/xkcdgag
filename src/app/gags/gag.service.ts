import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

export class Gag {

  n = -1;
  data;

  constructor(private http: HttpClient,
  			  public num: number) {

  	this.n = num;
	this.http.get('https://xkcd.com/' + num + '/info.0.json')
  	         .subscribe(
		  	    data => {
		  	        this.data = data;
		   	    },
		   	    err => {
		   	        console.log('Couldnt retrieve gag data! (' + num + ')')
		   	    }
      		   );	
  		 };
}

@Injectable()
export class GagService {
  constructor(private http: HttpClient){}
  getGag(id: number | Gag) {
    return new Gag(this.http, +id);
  }
}