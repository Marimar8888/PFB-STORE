import { Injectable } from '@angular/core';
import { UserService } from '../entities/user/service/user.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {


  constructor(
              private router: Router,
              private userService: UserService,
              private cookieService: CookieService
            ) { }

  userSession(token:string):void{

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

}
