import { Component } from '@angular/core';
import { NgZone } from '@angular/core';
import { GagService } from '../gags/gag.service';
import { Gag } from '../gags/gag.service';

@Component({
  selector: 'timeline',
  templateUrl: './timeline.html',
  styleUrls: ['./timeline.css']
})

export class TimelineComponent {

  private load_more_gags_size = 10;
  public gags_data  = [];

  constructor(private gagService: GagService) {  
      gagService.getGags(1960, this.load_more_gags_size) // TODO [JCG] Change to last gag num
                .subscribe(
                 (data) => { 
                    var gag_data = data['_embedded']['gag'];
                    for (var gd_key in gag_data) {
                      this.gags_data.push(new Gag(gag_data[gd_key])); 
                    }
                 },
                 (err) => { console.log('Couldnt retrieve last gags data.') }
               ); 
  	  this.setupOnBottomReachLoadGags();
  }

  private setupOnBottomReachLoadGags() {
  	 window.onscroll = () => {
         let status = "not reached";
         let windowHeight = "innerHeight" in window ? window.innerHeight : document.documentElement.offsetHeight;
         let body = document.body, html = document.documentElement;
         let docHeight = Math.max(body.scrollHeight, body.offsetHeight, 
                                  html.clientHeight, html.scrollHeight, 
                                  html.offsetHeight);
         let windowBottom = windowHeight + window.pageYOffset;
         if (windowBottom >= docHeight) {
           this.loadMoreGags();
         }
      };
  }

  private loadMoreGags() : void {
    var lastNum = this.gags_data[this.gags_data.length-1].number;
    var gags = this.gagService.getGags(lastNum!=null?lastNum-1:null, this.load_more_gags_size);
    for (var g in gags) {
      this.gags_data.push(g);
    }
  }
}
