import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  private current_post_data_url = 'http://xkcd.com/info.0.json';
  private initial_gag_count = 10;

  posts_count = 0;
  gags_loaded = [];
  posts_data  = [];


  constructor(private http: HttpClient) {
  	  http.get(this.current_post_data_url)
  	      .subscribe(
  	      	data => {
              this.posts_count = data['num'];
              this.loadInitialGags(this.posts_count);
   	        },
   	        err => {
   	        	console.log('Couldnt retrieve current post count!')
   	        }
      );
  }

  private loadInitialGags(current_count) : void {
  	var gags_idxs = Array.from(Array(current_count).keys());
  	gags_idxs = gags_idxs.reverse();
  	this.gags_loaded = gags_idxs.slice(0, this.initial_gag_count);
  	for (var idx of this.gags_loaded) {
  		console.log(idx);
  		var post_data = {n: idx};
  		this.posts_data.push(post_data);
  		// Launch async load
  		this.getPostData(post_data);
  	}
  }

  private getPostData(post_data):void {
	  this.http.get('https://xkcd.com/' + post_data.n + '/info.0.json')
  	           .subscribe(
		  	      	data => {
		  	          post_data.data = data;
		  	          console.log(data);
		   	        },
		   	        err => {
		   	        	console.log('Couldnt retrieve gag data! (' + post_data.n + ')')
		   	        }
      		   );	
    	
  }
}
