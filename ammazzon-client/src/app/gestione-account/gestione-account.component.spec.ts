import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestioneAccountComponent } from './gestione-account.component';

describe('GestioneAccountComponent', () => {
  let component: GestioneAccountComponent;
  let fixture: ComponentFixture<GestioneAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestioneAccountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestioneAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
