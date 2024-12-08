import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroundOwnerComponent } from './ground-owner.component';

describe('GroundOwnerComponent', () => {
  let component: GroundOwnerComponent;
  let fixture: ComponentFixture<GroundOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GroundOwnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GroundOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
