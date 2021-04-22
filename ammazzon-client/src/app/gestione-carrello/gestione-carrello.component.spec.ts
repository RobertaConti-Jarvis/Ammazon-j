import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestioneCarrelloComponent } from './gestione-carrello.component';

describe('GestioneCarrelloComponent', () => {
  let component: GestioneCarrelloComponent;
  let fixture: ComponentFixture<GestioneCarrelloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestioneCarrelloComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestioneCarrelloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
