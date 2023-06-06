import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { DashboardRoutingModule } from './dashboard.routing';
import { ItemComponent } from './item/item.component';
import { ShopComponent } from './shop/shop.component';
import { CategoryComponent } from './category/category.component';
import { EntitiesModule } from '../entities/entities.module';
import { CoatsComponent } from './shop/coats/coats.component';
import { JacketsComponent } from './shop/jackets/jackets.component';
import { PantsComponent } from './shop/pants/pants.component';
import { SportsComponent } from './shop/sports/sports.component';
import { NavCategoriesComponent } from '../layouts/nav-categories/nav-categories.component';


@NgModule({
  declarations: [
    HomeComponent,
    ItemComponent,
    ShopComponent,
    CategoryComponent,
    CoatsComponent,
    JacketsComponent,
    PantsComponent,
    SportsComponent,
    NavCategoriesComponent


  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    EntitiesModule,
    RouterModule
  ]
})
export class DashboardModule { }
