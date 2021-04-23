import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GruppoDueReduxComponent } from './gruppo-due-redux.component';

describe('GruppoDueReduxComponent', () => {
  let component: GruppoDueReduxComponent;
  let fixture: ComponentFixture<GruppoDueReduxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GruppoDueReduxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GruppoDueReduxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
