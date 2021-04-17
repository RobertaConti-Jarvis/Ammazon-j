import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestisciColoriComponent } from './gestisci-colori.component';

describe('GestisciColoriComponent', () => {
  let component: GestisciColoriComponent;
  let fixture: ComponentFixture<GestisciColoriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestisciColoriComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestisciColoriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
