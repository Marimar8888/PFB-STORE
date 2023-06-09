import { EventEmitter, Injectable, Output } from '@angular/core';
import { ItemCart } from '../../shop-cart/modelo/itemCart.model';
import { ItemOrder } from '../model/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  @Output() update: EventEmitter<ItemCart[]> = new EventEmitter<ItemCart[]>();
  listOrder?: ItemOrder[];
  constructor() { }
}
