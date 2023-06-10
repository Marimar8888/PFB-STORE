import { EventEmitter, Injectable, Output } from '@angular/core';
import { ItemCart } from '../../shop-cart/modelo/itemCart.model';
import { ItemOrder } from '../model/order.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  @Output() update: EventEmitter<ItemCart[]> = new EventEmitter<ItemCart[]>();
  listOrder?: ItemOrder[];
  constructor(private httpClient: HttpClient) { }

  public insertOrder(products: ItemCart[]): Observable<ItemCart[]> {
    let urlEndpoint: string = "http://localhost:8080/store/orders/";
    return this.httpClient.post<ItemCart[]>(urlEndpoint, products);
  }
}
