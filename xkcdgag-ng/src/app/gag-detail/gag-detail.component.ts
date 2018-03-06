import { Component } from '@angular/core';
import { NgZone } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Gag, GagService }  from '../gags/gag.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'gag-detail',
  templateUrl: './gag-detail.html',
  styleUrls: ['./gag-detail.css']
})


export class GagDetailComponent {
 
  private headers = {
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': 'GET, POST, DELETE, PUT, OPTIONS',
    'Access-Control-Allow-Headers': 'Origin, Content-Type, Accept, Authorization, X-Request-With',
    'Content-Type': 'application/json'
  };

	gag = {};
  comment_text = "";

	constructor(
      private http: HttpClient,
    	private route: ActivatedRoute,
    	private gagService: GagService
    ) {
		this.route.params.subscribe((params: Params) => {
			  var gag_num = params['gag_num'];
        console.log("Loading detail for gag " + gag_num);
        this.loadGag(gag_num);
      });
    }

    loadGag(gag_num) {
        this.gagService.getGag(gag_num)
                       .subscribe(
                       (data) => { 
                          console.log(gag_num);
                          this.gag = new Gag(this.http, data); 
                          console.log(data);
                       },
                       (err) => { console.log('Couldnt retrieve gag detail data.') });
    }

    saveComment() {
       // TODO [JCG] Put today's date
      console.log(this.gag['data']);
      console.log(this.getId(this.gag));
      this.http.post('http://localhost:8006/comment', 

                    {'text': this.comment_text, 'date': '2018-01-01', 'idGag': this.getId(this.gag)},
                    { headers: this.headers }) 
                .subscribe(response => console.log(response));
      console.log('Comment saved!');
      // Reload gag
      this.loadGag(this.gag['data']['number']);
      this.comment_text = "";
    }

    private getId(gag) {
      var ref = this.gag['data']['_links']['gag']['href'].split('/');
      return ref[ref.length-1];
    }
}
