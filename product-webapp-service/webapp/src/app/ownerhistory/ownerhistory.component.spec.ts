import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerhistoryComponent } from './ownerhistory.component';

describe('OwnerhistoryComponent', () => {
  let component: OwnerhistoryComponent;
  let fixture: ComponentFixture<OwnerhistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerhistoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OwnerhistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
