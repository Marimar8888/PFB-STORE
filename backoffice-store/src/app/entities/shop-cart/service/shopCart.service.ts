import { EventEmitter, Injectable, Output } from '@angular/core';
import { ItemShop } from '../../item/modelo/itemShop.model';
import { ItemCart } from '../interface/itemCart.interface';

@Injectable({
  providedIn: 'root'
})
export class ShopCartService {
  @Output() insertCart: EventEmitter<ItemShop> = new EventEmitter<ItemShop>();

  @Output() insert: EventEmitter<ItemCart> = new EventEmitter<ItemCart>();
  public listCart?: ItemCart[];

  constructor() {    }

  getList(): ItemCart[] {
    return this.listCart!;
  }

  updateList(newList : ItemCart[]): void {
    this.listCart = newList;
  }

}
