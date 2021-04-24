import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedaProdottoComponent } from './scheda-prodotto.component';

describe('SchedaProdottoComponent', () => {
  let component: SchedaProdottoComponent;
  let fixture: ComponentFixture<SchedaProdottoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SchedaProdottoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedaProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
