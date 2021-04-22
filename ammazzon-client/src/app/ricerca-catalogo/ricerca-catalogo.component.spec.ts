import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RicercaCatalogoComponent } from './ricerca-catalogo.component';

describe('RicercaCatalogoComponent', () => {
  let component: RicercaCatalogoComponent;
  let fixture: ComponentFixture<RicercaCatalogoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RicercaCatalogoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RicercaCatalogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
