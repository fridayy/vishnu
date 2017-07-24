import {Injector, OnDestroy, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import HatoasResource from '../../model/hateoas.entity';
import {SharedBackendService} from 'app/service/shared-backend.service';
import {Http} from '@angular/http';
import {BACKEND_URL} from '../../app.tokens';
import {Subscription} from 'rxjs/Subscription';

export abstract class GenericItemListComponent<T> implements OnInit, OnDestroy {
  dataSource: Observable<HatoasResource>;
  private _resources: T[];
  subscription: Subscription;

  constructor(private _http: Http, private _sharedService: SharedBackendService, private _injector: Injector) {
    this.dataSource = this._http.get(this._injector.get(BACKEND_URL) + this.concreteUrl()).map(res => res.json());
    this._sharedService.emitDatasourceChange(this.dataSource);

    this.subscription = this._sharedService.pageNumberEmitted$.subscribe(pageNumber => {
      this.dataSource = this._http.get(this._injector.get(BACKEND_URL) + this.concreteUrl() + '?page=' + pageNumber).map(res => res.json());
      this.subscribe(this.dataSource);
    });
  }

  get resources(): T[] {
    return this._resources;
  }

  set resources(value: T[]) {
    this._resources = value;
  }

  get http(): Http {
    return this._http;
  }

  get sharedService(): SharedBackendService {
    return this._sharedService;
  }

  get injector(): Injector {
    return this._injector;
  }

  abstract subscribe(obs: Observable<HatoasResource>): void;
  abstract concreteUrl(): string;

  ngOnInit() {
    this.subscribe(this.dataSource);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
