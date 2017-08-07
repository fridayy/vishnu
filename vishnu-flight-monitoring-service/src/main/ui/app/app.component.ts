import {Component, NgZone, OnInit} from '@angular/core';
import leaflet from 'leaflet';
import {SseService} from "./service/sse.service";
import "rxjs/add/operator/map";
import "rxjs/add/operator/takeLast";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [SseService]
})
export class AppComponent implements OnInit {

    tileLayer: any;
    zone: NgZone;
    l: any;

    constructor(private sseService: SseService) {
        this.l = leaflet;
        this.tileLayer = leaflet.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
        })
        this.zone = new NgZone({enableLongStackTrace: false});
    }

    ngOnInit(): void {
        const map = leaflet.map('mapid').setView([51.505, -0.09], 4);
        map.addLayer(this.tileLayer);
        var geojsonFeature = {
            "type": "Feature",
            "properties": {
                "name": "Vienna Airport",
                "amenity": "Airport",
                "popupContent": "This is the Vienna Airport"
            },
            "geometry": {
                "type": "Point",
                "coordinates": [48.11029816, 16.56970024]
            }
        };

        this.sseService.get().subscribe()

        // leaflet.geoJSON(geojsonFeature).addTo(map);
        this.sseService.get()
            .map(next => JSON.parse(next))
            .subscribe(next => {
            this.zone.run(() => {
                leaflet.circle([next.latLon.lat, next.latLon.lon]).addTo(map);
            });
        });
    }
}
