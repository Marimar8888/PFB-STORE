import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../modelo/item.model';
import { IItemShop } from '../interface/itemShop.interface';

@Injectable({
  providedIn: 'root'
})
export class ItemService {



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

  //Mockoon

  public obternerArticulos(): Observable<IItemShop[]> {
    const url: string = 'http://localhost:3003/articulos';
    return this.httpClient.get<IItemShop[]>(url);
}
public obternerAbrigos(): Observable<IItemShop[]> {
  const url: string = 'http://localhost:3005/articulos/abrigos';
  return this.httpClient.get<IItemShop[]>(url);
}
public obternerChaquetas(): Observable<IItemShop[]> {
  const url: string = 'http://localhost:3009/articulos/chaquetas';
  return this.httpClient.get<IItemShop[]>(url);
}
public obternerPantalones(): Observable<IItemShop[]> {
  const url: string = 'http://localhost:3006/articulos/pantalones';
  return this.httpClient.get<IItemShop[]>(url);
}
public obternerSports(): Observable<IItemShop[]> {
  const url: string = 'http://localhost:3007/articulos/sports';
  return this.httpClient.get<IItemShop[]>(url);
}
/*public obternerFichas(): Observable<IItemDetails[]> {
  const url: string = 'http://localhost:3011/articulos/fichas';
  return this.httpClient.get<IItemDetails[]>(url);
}
*/


}
