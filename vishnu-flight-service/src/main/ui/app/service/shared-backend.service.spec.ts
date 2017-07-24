import { TestBed, inject } from '@angular/core/testing';

import { SharedBackendService } from './shared-backend.service';

describe('SharedBackendService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SharedBackendService]
    });
  });

  it('should be created', inject([SharedBackendService], (service: SharedBackendService) => {
    expect(service).toBeTruthy();
  }));
});
