import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopComponent } from './shop/shop.component';
import { CoatsComponent } from './shop/coats/coats.component';
import { JacketsComponent } from './shop/jackets/jackets.component';
import { PantsComponent } from './shop/pants/pants.component';
import { SportsComponent } from './shop/sports/sports.component';
import { LoginComponent } from '../entities/user/login/login.component';
import { SignupComponent } from '../entities/user/signup/signup.component';
import { AuthGuard } from '../config/auth.guard';
import { OrderComponent } from './order/order.component';

const dashboardRoutes: Routes = [

  {path: 'shop', component: ShopComponent },
  { path: 'login', component: LoginComponent },
  {path: 'signup', component: SignupComponent},
  {path: 'shop/coats', component: CoatsComponent },
  {path: 'shop/jackets', component: JacketsComponent },
  {path: 'shop/pants', component: PantsComponent },
  {path: 'shop/sports', component: SportsComponent },
  {path: 'order', component: OrderComponent}

];

@NgModule({
  imports: [ RouterModule.forChild(dashboardRoutes)]

})
export class DashboardRoutingModule { }
