import {Component, Injector} from '@angular/core';
import {GenericItemListComponent} from '../generic-item-list/generic-item-list.component';
import {Observable} from 'rxjs/Observable';
import HatoasResource from '../../model/hateoas.entity';
import {Http} from '@angular/http';
import {SharedBackendService} from 'app/service/shared-backend.service';
import AirplaneResource from '../../model/airplane.entity';

@Component({
  selector: 'app-airplane',
  templateUrl: './airplane.component.html',
  styleUrls: ['./airplane.component.css']
})
export class AirplaneComponent extends GenericItemListComponent<AirplaneResource> {


  constructor(http: Http, sharedService: SharedBackendService, injector: Injector) {
    super(http, sharedService, injector);
  }

  subscribe(obs: Observable<HatoasResource>): void {
    obs.subscribe(res => {
      this.resources = res._embedded.airplaneResourceList.slice();
    });
  }

  concreteUrl(): string {
    return 'airplane';
  }

}
