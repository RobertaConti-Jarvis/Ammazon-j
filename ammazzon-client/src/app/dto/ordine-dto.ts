import {Ordine} from '../entità/ordine';
import { BaseRequestDto } from './base-request-dto';

export class OrdineDto extends BaseRequestDto {
  ordine: Ordine;
  numElem: number;
  totale: number;
}
