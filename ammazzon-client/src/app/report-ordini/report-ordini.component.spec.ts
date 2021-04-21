import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportOrdiniComponent } from './report-ordini.component';

describe('ReportOrdiniComponent', () => {
  let component: ReportOrdiniComponent;
  let fixture: ComponentFixture<ReportOrdiniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportOrdiniComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportOrdiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
