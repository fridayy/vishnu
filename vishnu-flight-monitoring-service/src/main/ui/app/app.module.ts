import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BACKEND_URL} from './app.token';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [{provide: BACKEND_URL, useValue: 'http://localhost:8002/v1/'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
