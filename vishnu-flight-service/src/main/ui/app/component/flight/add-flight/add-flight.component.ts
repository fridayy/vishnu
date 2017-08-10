import {Component, Injector, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Http} from '@angular/http';
import {BACKEND_URL} from '../../../app.tokens';
import {forkJoin} from 'rxjs/observable/forkJoin';
import {AirlineBackendService} from '../../../service/airline-backend.service';
import Alert from '../../../model/alert.model';

@Component({
    selector: 'app-add-flight',
    templateUrl: './add-flight.component.html',
    styleUrls: ['./add-flight.component.css'],
    providers: [AirlineBackendService]
})
export class AddFlightComponent implements OnInit {
    formModel: FormGroup;
    hidden: boolean;

    airlineNames: string[] = [];
    airportIataCodes: string[] = [];
    airplaneNames: string[] = [];
    alerts: Alert[] = [];
    departureTimeMoment: string;

    constructor(private fb: FormBuilder, private http: Http, private _injector: Injector, private airlineService: AirlineBackendService) {
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
            this.http.get(this._injector.get(BACKEND_URL) + 'airport?iata=' + this.formModel.get('to').value).map(res => res.json()),
            this.http.get(this._injector.get(BACKEND_URL) + 'airport?iata=' + this.formModel.get('from').value).map(res => res.json())

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
            this.http.post(this._injector.get(BACKEND_URL) + 'flight', flight).map(res => res.json()).subscribe()
        }, onError => {
                this.alerts.push({type: 'danger', message: 'An error occured', show: true});
            },
            () => {
                this.alerts.push({type: 'success', message: 'Flight saved!', show: true});
                this.showForm();
            });
    }

    showForm() {
        this.hidden = !this.hidden;
    }

    ngOnInit() {
        this.http.get(this._injector.get(BACKEND_URL) + 'airline?q=all').map(res => res.json()).subscribe(items => {
            items.forEach(item => {
                this.airlineNames.push(item.name)
            });
        });


        this.http.get(this._injector.get(BACKEND_URL) + 'airport?q=all').map(res => res.json()).subscribe(items => {
            items.forEach(item => {
                this.airportIataCodes.push(item.iataCode + ' (' + item.city + ')');
            })
        });

        this.http.get(this._injector.get(BACKEND_URL) + 'airplane?q=all').map(res => res.json()).subscribe(items => {
            items.forEach(item => {
                this.airplaneNames.push(item.typeDeclaration)
            })
        });
    }

    setDepartureTimeValue(event): void {
        this.departureTimeMoment = event;
    }

}
