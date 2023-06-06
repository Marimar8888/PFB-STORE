import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

//tarjetas de itemShop
import { MatCardModule } from '@angular/material/card';

import { BannerComponent } from './banner/banner/banner.component';
import { CarouselComponent } from './carousel/carousel/carousel.component';
import { CarouselCategoriesComponent } from './carousel-categories/carousel-categories/carousel-categories.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ItemShopListComponent } from './item/item-shop-list/item-shop-list.component';
import { CarouselService } from './carousel/service/carousel.service';
import { CarouselCategoriesService } from './carousel-categories/service/carousel-categories.service';
import { BannerService } from './banner/service/banner.service';
import { ItemCardComponent } from './item/item-card/item-card.component';


import { LoginComponent } from './user/login/login.component';
import { SignupComponent } from './user/signup/signup.component';
import { UserCardComponent } from './user/user-card/user-card.component';
import { UserService } from './user/service/user.service';



@NgModule({
  declarations: [
    CarouselComponent,
    CarouselCategoriesComponent,
    BannerComponent,
    ItemShopListComponent,
    ItemCardComponent,
    LoginComponent,
    SignupComponent,
    UserCardComponent,

  ],
  exports:[
    CarouselComponent,
    CarouselCategoriesComponent,
    BannerComponent,
    ItemShopListComponent,
    ItemCardComponent,
    UserCardComponent,
    LoginComponent,
    SignupComponent,
    MatCardModule
  ],
  imports: [
    CommonModule,
    NgbModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule
  ],
  providers: [
    UserService,
    CarouselService,
    CarouselCategoriesService,
    BannerService
  ]
})
export class EntitiesModule { }
