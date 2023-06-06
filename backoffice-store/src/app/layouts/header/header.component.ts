import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { AuthenticationService } from 'src/app/config/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  session: boolean;
  userName?: string;

  constructor(private authService: AuthenticationService, private cookieService: CookieService, private router: Router){

    const token = cookieService.get('token');
    if(token){
      this.session = true;
      this.userName = this.cookieService.get('token');
    }else{
      this.session=false;

    }
  }

  /*checkLogin(){
    const token = this.cookieService.get('token');
    if(token != null ){
      this.session = true;
      return true;
    }else{
      this.session=false;
      return false;
    }


  }*/

  logOut(){
     this.cookieService.delete('token');
    // this.checkLogin();
     this.router.navigate(['/login']);
    //this.authService.logout();
  }

}
