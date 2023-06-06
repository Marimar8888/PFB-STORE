import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import {  CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [NgbCarouselConfig]
})
export class AppComponent implements OnInit{

  constructor(private cookieService: CookieService){}
  ngOnInit(): void {
      const token = this.cookieService.get('token');
      if(token){

      }
  }
  title = 'backoffice-store';

}
