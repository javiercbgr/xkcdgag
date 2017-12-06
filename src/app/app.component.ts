import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgZone } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  private current_post_data_url = 'http://xkcd.com/info.0.json';
  private load_more_gags_size = 10;

  posts_count = 0;
  gags_loaded = [];
  posts_data  = [];


  constructor(private http: HttpClient) {
  	  http.get(this.current_post_data_url)
  	      .subscribe(
  	      	data => {
              this.posts_count = data['num'];
              this.loadMoreGagsFrom(this.posts_count);
   	        },
   	        err => {
   	        	console.log('Couldnt retrieve current post count!')
   	        }
      );

  	  this.createOnBottomReachLoadGags();
  }

  private createOnBottomReachLoadGags() {
  	 window.onscroll = () => {
         let status = "not reached";
         let windowHeight = "innerHeight" in window ? window.innerHeight
             : document.documentElement.offsetHeight;
         let body = document.body, html = document.documentElement;
         let docHeight = Math.max(body.scrollHeight,
             body.offsetHeight, html.clientHeight,
             html.scrollHeight, html.offsetHeight);
         let windowBottom = windowHeight + window.pageYOffset;
         if (windowBottom >= docHeight) {
           this.loadMoreGags();
         }
      };
  }

  private getPostData(post_data) : void {
	  this.http.get('https://xkcd.com/' + post_data.n + '/info.0.json')
  	           .subscribe(
		  	      	data => {
		  	          post_data.data = data;
		   	        },
		   	        err => {
		   	        	console.log('Couldnt retrieve gag data! (' + post_data.n + ')')
		   	        }
      		   );	
  }

  private getLastGagIdx() : number {
  	if (this.gags_loaded.length > 0)
  		return this.gags_loaded[this.gags_loaded.length-1]
  	else
  		return this.posts_count;
  }

  private loadMoreGags() : void {
  	this.loadMoreGagsFrom(this.getLastGagIdx()-1);
  }

  private loadMoreGagsFrom(last_gag_idx) : void {
  	var gags_idxs = Array.from(Array(last_gag_idx+1).keys());
  	gags_idxs.shift(); 
  	gags_idxs = gags_idxs.reverse();
  	if (this.load_more_gags_size > 0)
  		gags_idxs = gags_idxs.slice(0, this.load_more_gags_size);
  	for (var idx of gags_idxs) {
  		var post_data = {n: idx};
  		this.posts_data.push(post_data);
  		this.gags_loaded.push(idx);
  		// Launch async load
  		this.getPostData(post_data);
  	}
  }
}
