import {Injectable} from '@angular/core';
import * as EventSource from 'eventsource';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class SseService {

    constructor() {
    }

    /**
     * Converts an EventSource (SSE) into an observable
     * @returns {Observable<any>}
     */
    public get(): Observable<any> {
        return Observable.create(observer => {
            const source = new EventSource('http://localhost:8002/v1/flightmonitoring/all');
            source.onmessage = x => observer.next(x.data);
            source.onerror = x => observer.error(x);
            return () => source.close();
        });
    }
}
