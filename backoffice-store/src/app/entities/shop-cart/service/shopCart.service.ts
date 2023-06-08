import { EventEmitter, Injectable, Output } from '@angular/core';
import { ItemShop } from '../../item/modelo/itemShop.model';
import { ItemCart } from '../interface/itemCart.interface';

@Injectable({
  providedIn: 'root'
})
export class ShopCartService {

  @Output() insert: EventEmitter<ItemShop> = new EventEmitter<ItemShop>();
  listCart?: ItemCart[];

  constructor() {

  }
}
