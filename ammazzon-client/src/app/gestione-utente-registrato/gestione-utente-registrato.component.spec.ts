import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestioneUtenteRegistratoComponent } from './gestione-utente-registrato.component';

describe('GestioneUtenteRegistratoComponent', () => {
  let component: GestioneUtenteRegistratoComponent;
  let fixture: ComponentFixture<GestioneUtenteRegistratoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestioneUtenteRegistratoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestioneUtenteRegistratoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
