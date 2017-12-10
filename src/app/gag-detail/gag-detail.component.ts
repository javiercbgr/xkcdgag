import { Component } from '@angular/core';
import { NgZone } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Gag, GagService }  from '../gags/gag.service';

@Component({
  selector: 'gag-detail',
  templateUrl: './gag-detail.html',
  styleUrls: ['./gag-detail.css']
})

export class GagDetailComponent {

	gag = {};

	constructor(
    	private route: ActivatedRoute,
    	private gagService: GagService
    ) {
		this.gag['data'] = {n: 1, title: "Test"};	
		this.route.params.subscribe((params: Params) => {
			let gag_num = params['gag_num']
        	this.gag = this.gagService.getGag(gag_num);
        });
    }
}
