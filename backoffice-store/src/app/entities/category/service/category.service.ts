import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService implements OnInit {
  urlEndpoint: string = "http://localhost:8080/store/categories";

  constructor(private httpClient: HttpClient   ) { }

  ngOnInit(): void {
    
  }

  public getAllCategoriesPartial(headers: HttpHeaders, partialName?: string): Observable<Category[]>{
   
    if(partialName){
      this.urlEndpoint = this.urlEndpoint + "?partialName=" + partialName;
    }
    return this.httpClient.get<Category[]>(this.urlEndpoint, { headers: headers });
  }
  public getAllCategories(headers: HttpHeaders): Observable<Category[]>{

    return this.httpClient.get<Category[]>(this.urlEndpoint, { headers: headers });
  }
}
