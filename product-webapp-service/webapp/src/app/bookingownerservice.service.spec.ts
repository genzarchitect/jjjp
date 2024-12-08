import { TestBed } from '@angular/core/testing';

import { BookingownerserviceService } from './bookingownerservice.service';

describe('BookingownerserviceService', () => {
  let service: BookingownerserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookingownerserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
