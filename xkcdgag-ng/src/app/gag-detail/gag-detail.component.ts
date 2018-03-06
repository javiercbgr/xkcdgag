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

	gag = {};

	constructor(
      private http: HttpClient,
    	private route: ActivatedRoute,
    	private gagService: GagService
    ) {
		this.route.params.subscribe((params: Params) => {
			  let gag_num = params['gag_num'];
        console.log("Loading detail for gag " + gag_num);
        this.gagService.getGag(gag_num)
                       .subscribe(
                       (data) => { 
                          this.gag = new Gag(this.http, data); 
                       },
                       (err) => { console.log('Couldnt retrieve gag detail data.') });
      });
    }
}
