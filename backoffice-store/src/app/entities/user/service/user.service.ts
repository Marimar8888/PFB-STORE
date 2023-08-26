import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Observable, tap  } from 'rxjs';
import { IUser } from '../interface/user.interface';
import { ILoginUser } from '../interface/loginUser.interface';
import { IClientUser } from '../interface/clientUser.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private url: string = "http://localhost:8080/store/users";
  private urlLogin: string = 'http://localhost:8080/store/users/login';



  constructor(private httpClient: HttpClient ) { }

  public insertUser(user: IUser): Observable<IUser>{ return this.httpClient.post<IUser>(this.url, user); }
  public logintUser(creds: ILoginUser): Observable<IClientUser>{ return this.httpClient.post<IClientUser>(this.urlLogin, creds).pipe(
  tap((response: IClientUser) =>{
  })
 ); }
  public insertFavoriteByUserNameAndItemId(userName: string, itemId: number) {
    let urlFavorite: string = "http://localhost:8080/store/users/" + userName + "/favorites/" + itemId;
    return this.httpClient.put(urlFavorite, null); }
  public removeFavoriteByUserNameAndItemId(userName: string, itemId: number) {
    let urlFavorite: string = "http://localhost:8080/store/users/" + userName + "/favorites/remove/" + itemId;
    return this.httpClient.delete(urlFavorite);
  }
  public getAllFavoritesByUserName(username: string): Observable<number[]> {
    let urlFavorite: string = "http://localhost:8080/store/users/" + username + "/favorites";
    return this.httpClient.get<number[]>(urlFavorite);  }


}
