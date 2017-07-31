import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, Response} from "@angular/http";
import AirlineResource from "../model/airline.entity";

@Injectable()
export class AirlineBackendService {

  constructor(private http: Http) { }

  provideAirlines(): Observable<AirlineResource[]> {
    return this.http.get("http://localhost:8001/v1/airline?q=all").map(res => res.json());
  }

}
