import {Component, Injector, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Http, Response} from '@angular/http';
import {BACKEND_URL} from '../../../app.tokens';
import {Observable} from 'rxjs/Observable';
import {forkJoin} from 'rxjs/observable/forkJoin';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  formModel: FormGroup;
  hidden: boolean;

  constructor(private fb: FormBuilder, private http: Http, private _injector: Injector) {
    this.formModel = this.fb.group({
      flightNumber: [''],
      airline: [''],
      from: [''],
      to: [''],
      airplane: [''],
      status: [''],
      arrivalTime: [''],
      departureTime: ['']
    });

    this.hidden = true;
  }

  send() {
    forkJoin([
      this.http.get(this._injector.get(BACKEND_URL) + 'airline?name=' + this.formModel.get('airline').value).map(res => res.json()),
      this.http.get(this._injector.get(BACKEND_URL) + 'airplane?type=' + this.formModel.get('airplane').value).map(res => res.json()),
      this.http.get(this._injector.get(BACKEND_URL) + 'airport?iata=' + this.formModel.get('from').value).map(res => res.json()),
      this.http.get(this._injector.get(BACKEND_URL) + 'airport?iata=' + this.formModel.get('to').value).map(res => res.json())
    ]).subscribe(data => {
      const flight = {
        flightNumber: this.formModel.get('flightNumber').value,
        status: this.formModel.get('status').value,
        arrivalTime: this.formModel.get('arrivalTime').value,
        departureTime: this.formModel.get('departureTime').value,
        operator: data[0],
        airplane: data[1],
        from: data[2],
        to: data[3]
      };
      console.log('sending: ' + flight);
      this.http.post(this._injector.get(BACKEND_URL) + 'flight', flight).map(res => res.json()).subscribe()
    });
  }

  showForm() {
    this.hidden = !this.hidden;
  }

  ngOnInit() {
  }

}
