import { TestBed, inject } from '@angular/core/testing';

import { AirlineBackendService } from './airline-backend.service';

describe('AirlineBackendService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AirlineBackendService]
    });
  });

  it('should be created', inject([AirlineBackendService], (service: AirlineBackendService) => {
    expect(service).toBeTruthy();
  }));
});
