import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { CategoryListComponent } from './entities/category/category-list/category-list.component';
import { CategoryFormComponent } from './entities/category/category-form/category-form.component';
import { ItemListComponent } from './entities/item/item-list/item-list.component';
import { ItemFormComponent } from './entities/item/item-form/item-form.component';
import { HeaderComponent } from './layouts/header/header.component';

import { HttpRequestIntercept } from './config/interceptors/http-request-interceptor.interceptor';

//Modulos de terceros
import { AutoCompleteModule } from 'primeng/autocomplete';
import { ItemReactiveFormComponent } from './entities/item/item-reactive-form/item-reactive-form.component';
import { DashboardModule } from './dashboard/dashboard.module';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HeaderComponent,
    CategoryListComponent,
    CategoryFormComponent,
    ItemListComponent,
    ItemFormComponent,
    ItemReactiveFormComponent,
    FooterComponent,
    FooterComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AutoCompleteModule,
    DashboardModule


  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpRequestIntercept,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
