import { Injectable } from '@angular/core';

import { IOrder } from '../interface/order.interface';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

  public insertOrder(order: IOrder): Observable<IOrder> {
    let urlEndpoint: string = "http://localhost:8080/store/orders/";
    return this.httpClient.post<IOrder>(urlEndpoint, order);
  }
}
