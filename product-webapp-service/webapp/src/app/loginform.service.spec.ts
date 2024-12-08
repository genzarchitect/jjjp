import { TestBed } from '@angular/core/testing';

import { LoginformService } from './loginform.service';

describe('LoginformService', () => {
  let service: LoginformService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginformService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
