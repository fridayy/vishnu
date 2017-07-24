import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from './component/home/home.component';
import {routing} from './app.routing';
import {NavigationComponent} from './component/navigation/navigation.component';
import {AirplaneComponent} from './component/airplane/airplane.component';
import {BACKEND_URL} from './app.tokens';
import {AirlinesComponent} from './component/airlines/airlines.component';
import {HttpModule} from '@angular/http';
import {PagedContentComponent} from './component/paged-content/paged-content.component';
import {PaginationModule} from 'ngx-bootstrap';
import {PagerComponent} from './component/pager/pager.component';
import { GenericItemListComponent } from './component/generic-item-list/generic-item-list.component';
import { CountryComponent } from './component/country/country.component';
import { AirportComponent } from './component/airport/airport.component';
import { FlightComponent } from './component/flight/flight.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavigationComponent,
    AirplaneComponent,
    AirlinesComponent,
    PagedContentComponent,
    PagerComponent,
    CountryComponent,
    AirportComponent,
    FlightComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    PaginationModule.forRoot(),
    routing
  ],
  providers: [
    // provide backend URL as a constant value
    { provide: BACKEND_URL, useValue: 'http://localhost:8001/v1/'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
