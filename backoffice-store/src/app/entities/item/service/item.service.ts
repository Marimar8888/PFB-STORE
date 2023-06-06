import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../modelo/item.model';
import { IItemShop } from '../interface/itemShop.interface';
import { ItemShop } from '../modelo/itemShop.model';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private urlShop: string = "http://localhost:8080/store/categories/";

  constructor(private httpClient: HttpClient   ) { }

  public getAllItems(page: number, size: number, sort: string, filters?:string): Observable<Item[]>{
    let urlEndpoint: string = "http://localhost:8080/store/items?page=" + page + "&size=" + size + "&sort=" + sort;
    if(filters){
      urlEndpoint = urlEndpoint + "&filter=" + filters;
    }
    return this.httpClient.get<Item[]>(urlEndpoint);
  }

  public getAllItemsShop(): Observable<Item[]>{
    let urlEndpoint: string = "http://localhost:8080/store/items";
    return this.httpClient.get<Item[]>(urlEndpoint);
  }

  public getAllItemsByCategoryId(categoryId: number): Observable<IItemShop[]>{
    let urlShopCoats : string =  this.urlShop + categoryId + "/items";
    return this.httpClient.get<IItemShop[]>(urlShopCoats);
  }

  public deleteItem(itemIdToDelete: number): Observable<any> {
    let urlEndpoint: string = "http://localhost:8080/store/items/" + itemIdToDelete;
    return this.httpClient.delete<any>(urlEndpoint);
  }

  public getItemById(itemId: number): Observable<Item> {
    let urlEndpoint: string = "http://localhost:8080/store/items/" + itemId;
    return this.httpClient.get<Item>(urlEndpoint);
  }

  public insertItem(item: Item): Observable<Item> {
    let urlEndpoint: string = "http://localhost:8080/store/items/";
    return this.httpClient.post<Item>(urlEndpoint, item);
  }

  public updatetItem(item: Item): Observable<Item> {
    let urlEndpoint: string = "http://localhost:8080/store/items/";
    return this.httpClient.patch<Item>(urlEndpoint, item);
  }



}
