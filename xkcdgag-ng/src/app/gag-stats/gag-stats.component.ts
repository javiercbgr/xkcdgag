import { Component, Input } from '@angular/core';

@Component({
  selector: 'gag-stats',
  templateUrl: './gag-stats.html',
  styleUrls: ['./gag-stats.css']
})

export class GagStatsComponent {

  @Input() gag;

	constructor() {}
}
