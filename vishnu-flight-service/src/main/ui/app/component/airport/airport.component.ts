import {Component, Injector} from '@angular/core';
import {GenericItemListComponent} from '../generic-item-list/generic-item-list.component';
import {Http} from '@angular/http';
import {SharedBackendService} from '../../service/shared-backend.service';
import {Observable} from 'rxjs/Observable';
import HatoasResource from '../../model/hateoas.entity';
import AirportResource from '../../model/airport.entity';

@Component({
  selector: 'app-airport',
  templateUrl: './airport.component.html',
  styleUrls: ['./airport.component.css']
})
export class AirportComponent extends GenericItemListComponent<AirportResource> {

  constructor(http: Http, sharedService: SharedBackendService, injector: Injector) {
    super(http, sharedService, injector);
  }

  subscribe(obs: Observable<HatoasResource>): void {
    obs.subscribe(res => {
      this.resources = res._embedded.airportResourceList.slice();
      this.resources.forEach(item => {
        console.log(item);
        this.http.get(item._links.country.href).map(countryRes => countryRes.json()).subscribe(country => {
          item.concreteCountry = country;
        });
      })
    });
  }

  concreteUrl(): string {
    return 'airport';
  }

}
