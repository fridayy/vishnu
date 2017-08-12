import {Injectable, Injector} from '@angular/core';
import * as EventSource from 'eventsource';
import {Observable} from 'rxjs/Observable';
import {BACKEND_URL} from "../app.token";

@Injectable()
export class SseService {

    constructor(private injector: Injector) {
    }

    /**
     * Converts an EventSource (SSE) into an observable
     * @returns {Observable<any>}
     */
    public get(): Observable<any> {

        const URL = this.injector.get(BACKEND_URL);
        return Observable.create(observer => {
            const source = new EventSource(URL + 'flightmonitoring/all');
            source.onmessage = x => observer.next(x.data);
            source.onerror = x => observer.error(x);
            return () => source.close();
        });
    }
}
