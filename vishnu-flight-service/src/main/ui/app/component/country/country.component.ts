import {Component, Injector, OnInit} from '@angular/core';
import {GenericItemListComponent} from '../generic-item-list/generic-item-list.component';
import {Observable} from 'rxjs/Observable';
import HatoasResource from '../../model/hateoas.entity';
import {Http} from '@angular/http';
import {SharedBackendService} from '../../service/shared-backend.service';
import CountryResource from '../../model/country.entity';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent extends GenericItemListComponent<CountryResource> {

  constructor(http: Http, sharedService: SharedBackendService, injector: Injector) {
    super(http, sharedService, injector);
  }

  subscribe(obs: Observable<HatoasResource>): void {
    obs.subscribe(res => {
      this.resources = res._embedded.countryResourceList.slice();
    });
  }

  concreteUrl(): string {
    return 'country';
  }

}
