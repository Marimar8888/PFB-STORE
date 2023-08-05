import { Injectable } from '@angular/core';
import { UserService } from '../entities/user/service/user.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private usernameSubject: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);
  public username$ = this.usernameSubject.asObservable();

  constructor(
              private router: Router,
              private cookieService: CookieService
            ) { }
         
  setUsername(username: string): void {
      this.usernameSubject.next(username);
  }

  isLoggedIn() {

    if(this.cookieService.get('token')){

      return true;
    }else{

      return false;
    }

  }

  logout(){
    this.cookieService.delete('token');
    this.router.navigate(['/login']);
  }

  public getVerifiUserToken (){
    let token = this.cookieService.get('token') || '';
    console.log("El TOKEN es " + token);
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    console.log("El header es" + headers);
    return headers;
  }

}
