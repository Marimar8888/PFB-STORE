import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ICarouselCategories } from '../interface/carousel-categories.interface';

@Injectable({
  providedIn: 'root'
})
export class CarouselCategoriesService {

  constructor( private http: HttpClient  ) { }

  public obternerImagenesCategoriasCarousel(): Observable<ICarouselCategories[]> {
    const url: string = 'http://localhost:8080/store/categoryImages';
    return this.http.get<ICarouselCategories[]>(url);
  }
}
