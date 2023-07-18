import { Injectable } from '@angular/core';

import { IItemCart } from '../../shop-cart/interface/itemCart.interface';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

  public insertOrder(products: IItemCart[]): Observable<IItemCart[]> {
    let urlEndpoint: string = "http://localhost:8080/store/orders/";
    return this.httpClient.post<IItemCart[]>(urlEndpoint, products);
  }
}
