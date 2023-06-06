import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ICarousel } from '../interface/carousel.interface';

@Injectable({
  providedIn: 'root'
})
export class CarouselService {
  constructor(
    private http: HttpClient
  ) { }

  public obternerImagenesCarousel(): Observable<ICarousel[]> {
    const url: string = 'http://localhost:3002';
    return this.http.get<ICarousel[]>(url);

}
}
