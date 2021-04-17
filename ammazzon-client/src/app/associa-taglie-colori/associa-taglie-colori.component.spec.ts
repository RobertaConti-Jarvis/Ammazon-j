import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociaTaglieColoriComponent } from './associa-taglie-colori.component';

describe('AssociaTaglieColoriComponent', () => {
  let component: AssociaTaglieColoriComponent;
  let fixture: ComponentFixture<AssociaTaglieColoriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssociaTaglieColoriComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociaTaglieColoriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
