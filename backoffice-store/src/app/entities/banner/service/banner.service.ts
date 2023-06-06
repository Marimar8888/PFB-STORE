import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IBanner } from '../interface/banner.interface';

@Injectable({
  providedIn: 'root'
})
export class BannerService {

  constructor( private http: HttpClient ) { }

  public obternerImagenesBanner(): Observable<IBanner[]> {
    const url: string = 'http://localhost:3012/banner';
    return this.http.get<IBanner[]>(url);

}
}
