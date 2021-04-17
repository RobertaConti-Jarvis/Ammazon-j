import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnagraficaProdottoComponent } from './anagrafica-prodotto.component';

describe('AnagraficaProdottoComponent', () => {
  let component: AnagraficaProdottoComponent;
  let fixture: ComponentFixture<AnagraficaProdottoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnagraficaProdottoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnagraficaProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
