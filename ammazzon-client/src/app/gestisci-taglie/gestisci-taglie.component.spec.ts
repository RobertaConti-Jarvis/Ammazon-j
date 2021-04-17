import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestisciTaglieComponent } from './gestisci-taglie.component';

describe('GestisciTaglieComponent', () => {
  let component: GestisciTaglieComponent;
  let fixture: ComponentFixture<GestisciTaglieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestisciTaglieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestisciTaglieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
