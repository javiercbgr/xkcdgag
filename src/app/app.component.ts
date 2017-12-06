import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  xkcd_post_json;
  title = 'app';	
  post_nums = [{n:1925}, 
  			   {n:1924}, 
  			   {n:1923}, 
  			   {n:1922}, 
  			   {n:1921}, 
  			   {n:1920}, 
  			   {n:1919}
  			   ];

  constructor(private http: HttpClient) {
  	  console.log('hEYYYELY')
  	  http.get('https://xkcd.com/614/info.0.json')
  	      .subscribe(
  	      	data => {
  	          console.log(data)
              this.xkcd_post_json = data;
   	        },
   	        err => {
   	        	console.log('Something went bad!')
   	        }
      );
  	  for (var post_num of this.post_nums) {
  	  	this.getImageURL(post_num);
  	  }
  }

  public getImageURL(post_num):void {
	  this.http.get('https://xkcd.com/' + post_num.n + '/info.0.json')
  	           .subscribe(
		  	      	data => {
		  	          post_num.data = data;
		   	        },
		   	        err => {
		   	        	console.log('Something went bad! (' + post_num.n + ')')
		   	        }
      		   );	
    	
  }
}
