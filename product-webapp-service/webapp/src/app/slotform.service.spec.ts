import { TestBed } from '@angular/core/testing';

import { SlotformService } from './slotform.service';

describe('SlotformService', () => {
  let service: SlotformService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SlotformService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
