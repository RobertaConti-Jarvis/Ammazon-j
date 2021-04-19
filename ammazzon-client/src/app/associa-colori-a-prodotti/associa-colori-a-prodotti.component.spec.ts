import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociaColoriAProdottiComponent } from './associa-colori-a-prodotti.component';

describe('AssociaColoriAProdottiComponent', () => {
  let component: AssociaColoriAProdottiComponent;
  let fixture: ComponentFixture<AssociaColoriAProdottiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssociaColoriAProdottiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociaColoriAProdottiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
