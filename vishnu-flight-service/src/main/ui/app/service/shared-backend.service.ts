import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';

@Injectable()
/**
 * A shared service used by parent / child components which cannot communicate by conventional means (input bindings).
 * eg: a parent component and  multiple router-outlet children
 */
export class SharedBackendService {

  private datasourceSource = new Subject<any>();
  private pageNumberSource = new Subject<number>();

  datasourceChangeEmitted$ = this.datasourceSource.asObservable();
  pageNumberEmitted$ = this.pageNumberSource.asObservable();

  emitDatasourceChange(change: any) {
    this.datasourceSource.next(change);
  }

  emitPageNumberChange(change: number) {
    this.pageNumberSource.next(change);
  }
}
