import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { ReduxService } from '../redux.service';

@Component({
  selector: 'app-gruppo-due-redux',
  templateUrl: './gruppo-due-redux.component.html',
  styleUrls: ['./gruppo-due-redux.component.css']
})
export class GruppoDueReduxComponent implements OnInit {
  i = 0;

  constructor(private reduxService: ReduxService) {
    reduxService.reduxNumeroDue$.subscribe;
  }

  notificaNumero() {
    this.reduxService.notificaNumeroDue(this.i++);
  }

  ngOnInit(): void {
  }


}
