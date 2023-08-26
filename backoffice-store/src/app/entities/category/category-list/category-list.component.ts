import { Component, OnInit } from '@angular/core';
import { Category } from '../model/category.model';
import { CategoryService } from '../service/category.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/config/authentication.service';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.scss']
})
export class CategoryListComponent implements OnInit {
  headers!: HttpHeaders;
  token?: String;
  categories: Category [] = [];

  constructor( private categoryService: CategoryService,
               private cookieService: CookieService,
               private router: Router,
               private auth: AuthenticationService) {}

  ngOnInit(): void {
    this.token = this.cookieService.get('token');
    if(!this.token){
      alert("Debe loguearse para poder ver esta sección");
      this.router.navigate(['/login']);
    }else{
      this.headers = this.auth.getVerifiUserToken();
      this.getCategories(this.headers);
    }
  }

  private getCategories(headers: HttpHeaders): void{
    this.categoryService.getAllCategories(headers).subscribe ({
      next: (categoriesRequest) => { this.categories = categoriesRequest; },
      error: (err) => { this.handleError(err); }
    })
  }

  private handleError(error: any): void{
    console.log(error);
  }

}
