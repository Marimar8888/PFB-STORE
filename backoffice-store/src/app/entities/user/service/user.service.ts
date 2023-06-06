import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { IUser } from '../interface/user.interface';
import { ILoginUser } from '../interface/loginUser.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string = 'http://localhost:8080/store/users';
  private urlLogin: string = 'http://localhost:8080/store/users/login';
  //private urlMockoon: string = 'http://localhost:3013/store/users/';
  //private urlMockoonLogin: string = 'http://localhost:3014/store/login'



  constructor(private httpCliente: HttpClient ) { }

  public insertUser(user: IUser): Observable<IUser>{ return this.httpCliente.post<IUser>(this.url, user); }
  public logintUser(creds: ILoginUser){ return this.httpCliente.post<IUser>(this.urlLogin, creds); }
  /*public logintUser(creds: ILoginUser){
    return this.httpCliente.post(this.url, creds, {
      observe: 'response'
    }).pipe(map((response: HttpResponse<any>) => {
      const body = response.body;
      const headers = response.headers;

      const bearerToken = headers.get('Authorization')!;
      const token = bearerToken.replace('Bearer ', '');

      localStorage.setItem('token', token);

      return body;
    }))
  }*/

  public getToken() {
    return localStorage.getItem('token');
  }

}
