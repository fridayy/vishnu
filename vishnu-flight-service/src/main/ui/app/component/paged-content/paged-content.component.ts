import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import HatoasResource from '../../model/hateoas.entity';
import {SharedBackendService} from '../../service/shared-backend.service';
import LinkResource from '../../model/link.entity';
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-paged-content',
  templateUrl: './paged-content.component.html',
  styleUrls: ['./paged-content.component.css'],
  providers: [SharedBackendService]
})
export class PagedContentComponent implements OnInit, OnDestroy {
  datasource: Observable<HatoasResource>;
  pageMetadata: PageResource;
  links: LinkResource;

  subscription: Subscription;

  constructor(private sharedService: SharedBackendService) {
    this.subscription = this.sharedService.datasourceChangeEmitted$.subscribe(
      res => this.datasource = res);
  }

  ngOnInit() {
    this.datasource.subscribe(res => {
      this.pageMetadata = res.page;
      this.links = res._links;
    });
  }

  pageChangedEvent(event: number) {
    this.sharedService.emitPageNumberChange(event);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
