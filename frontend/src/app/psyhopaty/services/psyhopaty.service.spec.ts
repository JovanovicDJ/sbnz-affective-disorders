import { TestBed } from '@angular/core/testing';

import { PsyhopatyService } from './psyhopaty.service';

describe('PsyhopatyService', () => {
  let service: PsyhopatyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PsyhopatyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
