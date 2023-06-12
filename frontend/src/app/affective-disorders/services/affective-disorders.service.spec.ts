import { TestBed } from '@angular/core/testing';

import { AffectiveDisordersService } from './affective-disorders.service';

describe('AffectiveDisordersService', () => {
  let service: AffectiveDisordersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AffectiveDisordersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
