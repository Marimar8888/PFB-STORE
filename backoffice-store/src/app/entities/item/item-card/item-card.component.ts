import { Component, Input, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { registerLocaleData } from '@angular/common';
import localeEs from '@angular/common/locales/es';
import { ItemShop } from '../modelo/itemShop.model';
import { CookieService } from 'ngx-cookie-service';
import { UserService } from '../../user/service/user.service';
import { Router } from '@angular/router';
import { ShopCartService } from '../../shop-cart/service/shopCart.service';
registerLocaleData(localeEs, 'es');


@Component({
  selector: 'app-item-card',
  templateUrl: './item-card.component.html',
  styleUrls: ['./item-card.component.scss']
})
export class ItemCardComponent implements OnInit {

  @Input() article: ItemShop | undefined;
  token?: any;
  userName?: string;
  itemId!: number;
  favorites!: Array<any>;
  favoriteClass?: boolean;
  constructor(private cookieService: CookieService,
              private router: Router,
              private location: Location,
              private userService: UserService,
              private shopCartService: ShopCartService
                ){}

  ngOnInit(): void {

  }

  setFavorite(article: ItemShop ){
    this.token = this.cookieService.get('token');
    if(!this.token){
        alert("Para añadirlo a tus favorites debes loguearte");
        this.router.navigate(['/login']);
    }else{
      if(!article.getFavorite()){
        this.userName = this.cookieService.get('token');
        this.itemId = article.getId();
        this.insertFavorite(this.userName, this.itemId);
      }else{
        this.userName = this.cookieService.get('token');
        this.itemId = article.getId();
        this.removeFavorite(this.userName, this.itemId);
        this.favoriteClass=false;
      }

    }
  }

  private insertFavorite(userName: string, itemId: number) {
   this.userService.insertFavoriteByUserNameAndItemId(userName, itemId).subscribe({
     next: (response) =>{
          console.log(response);
          this.article?.setFavorite(true);
      },
      error: (err) => {this.gestionarError(err);}
    })

  }
  private removeFavorite(userName: string, itemId: number) {
    this.userService.removeFavoriteByUserNameAndItemId(userName, itemId).subscribe({
      next: (response) =>{
           console.log(response);
           this.article?.setFavorite(false);
       },
       error: (err) => {this.gestionarError(err);}
     })

   }

   addToCart(){
      this.shopCartService.insert.emit(this.article);
   }

  private gestionarError(err: any) {
    console.log(err);
  }

}
