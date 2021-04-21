import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrazionePageComponent } from './registrazione-page.component';

describe('RegistrazionePageComponent', () => {
  let component: RegistrazionePageComponent;
  let fixture: ComponentFixture<RegistrazionePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrazionePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrazionePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
