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
  username: string | null | undefined;
  session: boolean = false;


  constructor(private authService: AuthenticationService, private cookieService: CookieService, private router: Router){

  }
  ngOnInit() {
    this.authService.username$.subscribe(userName => {
      this.username = userName;
      const token = this.cookieService.get('token');

    if(token){
      this.session = true;
    
    }else{
      this.session=false;
    }

    });

  }
  logOut(){
    this.cookieService.delete('token');
    this.cookieService.delete('Id');
    this.cookieService.delete('user');
    this.session = false;
    this.router.navigate(['/login']);
  }

}
