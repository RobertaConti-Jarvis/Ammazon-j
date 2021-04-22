import { TestBed } from '@angular/core/testing';

import { CriterioRicercaService } from './criterio-ricerca.service';

describe('CriterioRicercaService', () => {
  let service: CriterioRicercaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CriterioRicercaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
