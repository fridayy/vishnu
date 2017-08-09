import {Component, NgZone, OnInit} from '@angular/core';
import leaflet from 'leaflet';
import {SseService} from "./service/sse.service";
import "rxjs/add/operator/map";
import "rxjs/add/operator/takeLast";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

}
