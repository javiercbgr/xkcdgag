import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TimelineComponent } from './timeline/timeline.component';
import { GagDetailComponent } from './gag-detail/gag-detail.component';
import { GagStatsComponent } from './gag-stats/gag-stats.component';
import { PageNotFoundComponent } from './not-found/not-found.component';

import { GagService } from './gags/gag.service';

const appRoutes: Routes = [
  { path: '', redirectTo: '/timeline', pathMatch: 'full' },
  { path: 'timeline', component: TimelineComponent },
  { path: 'gag/:gag_num', component: GagDetailComponent },
  { path: '**', component: PageNotFoundComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    TimelineComponent,
    GagDetailComponent,
    PageNotFoundComponent,
    GagStatsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {enableTracing: true}),
    FormsModule
  ],
  providers: [GagService],
  bootstrap: [AppComponent],
})

export class AppModule { }
