import {Component, Injector, OnInit} from '@angular/core';
import {GenericItemListComponent} from '../generic-item-list/generic-item-list.component';
import FlightResource from '../../model/flight.entity';
import {Http} from '@angular/http';
import {SharedBackendService} from '../../service/shared-backend.service';
import {Observable} from 'rxjs/Observable';
import HatoasResource from '../../model/hateoas.entity';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent extends GenericItemListComponent<FlightResource> {

  constructor(http: Http, sharedService: SharedBackendService, injector: Injector) {
    super(http, sharedService, injector);
  }

  subscribe(obs: Observable<HatoasResource>): void {
    obs.subscribe(res => {
      this.resources = res._embedded.flightResourceList.slice();
      this.resources.forEach(item => {
        // get departure airport from backend and assign to obj
        this.http.get(item._links.from.href).map(airportRes => airportRes.json()).subscribe(airport => {
          item.from = airport;
        });
        // arrival airport
        this.http.get(item._links.to.href).map(airportRes => airportRes.json()).subscribe(airport => {
          item.to = airport;
        });
        // airplane
        this.http.get(item._links.airplane.href).map(airplaneRes => airplaneRes.json()).subscribe(airplane => {
          item.airplane = airplane;
        });
        // airline
        this.http.get(item._links.airline.href).map(airlineRes => airlineRes.json()).subscribe(airline => {
          item.airline = airline;
        });
      })
    });
  }

  concreteUrl(): string {
    return 'flight';
  }
}
