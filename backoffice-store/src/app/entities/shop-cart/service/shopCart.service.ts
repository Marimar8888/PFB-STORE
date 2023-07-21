import { EventEmitter, Injectable, Output } from '@angular/core';
import { ItemShop } from '../../item/modelo/itemShop.model';
import { IItemCart } from '../interface/itemCart.interface';

@Injectable({
  providedIn: 'root'
})
export class ShopCartService {
  @Output() insertCart: EventEmitter<ItemShop> = new EventEmitter<ItemShop>();

  @Output() insert: EventEmitter<IItemCart> = new EventEmitter<IItemCart>();
  public listCart?: IItemCart[];

  constructor() {    }

  getList(): IItemCart[] {
    return this.listCart!;
  }

  updateList(newList : IItemCart[]): void {
    this.listCart = newList;
  }

}
