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
import {AlertModule, PaginationModule, TypeaheadModule} from 'ngx-bootstrap';
import {PagerComponent} from './component/pager/pager.component';
import {CountryComponent} from './component/country/country.component';
import {AirportComponent} from './component/airport/airport.component';
import {FlightComponent} from './component/flight/flight.component';
import {AddFlightComponent} from './component/flight/add-flight/add-flight.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DateTimePickerModule} from "ng-pick-datetime";

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
        FlightComponent,
        AddFlightComponent
    ],
    imports: [
        BrowserModule,
        HttpModule,
        PaginationModule.forRoot(),
        TypeaheadModule.forRoot(),
        AlertModule.forRoot(),
        FormsModule,
        DateTimePickerModule,
        ReactiveFormsModule,
        routing
    ],
    providers: [
        // provide backend URL as a constant value
        {provide: BACKEND_URL, useValue: 'http://localhost:8001/v1/'}
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
