import { Injectable } from '@angular/core';
import {  CanActivate, Router, UrlTree } from '@angular/router';

import { AuthenticationService } from './authentication.service';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard  {
/*  constructor(
              private router: Router,
              private authService: AuthenticationService,
              private cookieService:CookieService
  ){}
  canActivate(){
    const token = this.cookieService.get('token');

    if(token !=null){
      return true
    }
    this.router.navigate(['/login']);
    return true;
  }*/


    constructor(private authService: AuthenticationService, private router: Router) { }
    canActivate():
      | Observable<boolean | UrlTree>
      | Promise<boolean | UrlTree>
      | boolean
      | UrlTree {
      if (!this.authService.isLoggedIn()) {
       this.router.navigate(['/login']);
        return false;
      }
      // logged in, so return true
      this.authService.isLoggedIn();
      return true;
    }
  }


