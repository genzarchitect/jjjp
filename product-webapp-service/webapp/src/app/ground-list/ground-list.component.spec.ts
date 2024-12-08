import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroundListComponent } from './ground-list.component';

describe('GroundListComponent', () => {
  let component: GroundListComponent;
  let fixture: ComponentFixture<GroundListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GroundListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GroundListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
