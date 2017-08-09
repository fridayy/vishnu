import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BACKEND_URL} from './app.token';
import { MonitorComponent } from './component/monitor/monitor.component';
import {SseService} from './service/sse.service';

@NgModule({
  declarations: [
    AppComponent,
    MonitorComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [{provide: BACKEND_URL, useValue: 'http://localhost:8002/v1/'},
             SseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
