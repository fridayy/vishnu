import {Component, Injector} from '@angular/core';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import HatoasResource from '../../model/hateoas.entity';
import AirlineResource from '../../model/airline.entity';
import {GenericItemListComponent} from '../generic-item-list/generic-item-list.component';
import {Http} from '@angular/http';
import {SharedBackendService} from '../../service/shared-backend.service';


@Component({
  selector: 'app-airlines',
  templateUrl: './airlines.component.html',
  styleUrls: ['./airlines.component.css']
})
export class AirlinesComponent extends GenericItemListComponent<AirlineResource> {

  constructor(http: Http, sharedService: SharedBackendService, injector: Injector) {
    super(http, sharedService, injector);
  }

  concreteUrl(): string {
    return 'airline';
  }

  subscribe(obs: Observable<HatoasResource>): void {
    obs.subscribe(res => {
      this.resources = res._embedded.airlineResourceList.slice();
    });
  }
}
