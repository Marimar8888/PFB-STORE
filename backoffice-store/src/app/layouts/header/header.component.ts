import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { AuthenticationService } from 'src/app/config/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  session: boolean | undefined;
  userName?: string;

  constructor(private authService: AuthenticationService, private cookieService: CookieService, private router: Router){


  }
  ngOnInit(): void {
    const token = this.cookieService.get('token');
    if(token){
      this.session = true;
      this.userName = this.cookieService.get('token');
    }else{
      this.session=false;
    }
  }

  logOut(){
     this.cookieService.deleteAll();
     localStorage.removeItem('token');
     this.session = false;
     this.router.navigate(['/login']);
  }

}
