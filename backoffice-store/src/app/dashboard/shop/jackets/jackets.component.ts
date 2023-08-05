import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { ItemShop } from 'src/app/entities/item/modelo/itemShop.model';
import { ItemService } from 'src/app/entities/item/service/item.service';
import { UserService } from 'src/app/entities/user/service/user.service';

@Component({
  selector: 'app-jackets',
  templateUrl: './jackets.component.html',
  styleUrls: ['./jackets.component.scss']
})
export class JacketsComponent implements OnInit {

  articleList: ItemShop[]=[];
  categoryId: number = 12753;
  username?: string;
  token?: any;
  favorites!: number[];

  constructor( private itemService: ItemService,
               private userService: UserService,
               private cookieService: CookieService  ){}

  ngOnInit(): void {
    this.token = this.cookieService.get('token');
    if(!this.token){
      this.getAllJackets();

    }else{
      this.username = this.cookieService.get('user');
      this.getAllItemsWithFavorites(this.username);
    }
  }

  private getAllJackets() {

    this.itemService.getAllItemsByCategoryId(this.categoryId).subscribe({
      next: (articlesRequest) => {
        articlesRequest.forEach( (article) =>{
          const articleNew: ItemShop = new ItemShop(article.id, article.name, article.price, article.reduced, article.image, article.favorite);
          this.articleList.push(articleNew);
        })
      },
      error: (err) => {this.handleError(err);}
    })
  }

  private getAllItemsWithFavorites(userName: string){
    this.getAllFavorites(userName);
    this.itemService.getAllItemsByCategoryId(this.categoryId).subscribe({
      next: (articlesRequest) => {
        articlesRequest.forEach((article) => {

          this.favorites.forEach((favorite) => {

            if (this.checkElementInList(article.id, this.favorites)) {
              article.favorite = true;
            }
          });

          const articleNew: ItemShop = new ItemShop(article.id, article.name, article.price, article.reduced, article.image, article.favorite);
          this.articleList.push(articleNew);
        });
      },
      error: (err) => {
        this.handleError(err);
      }
    });
  }

  private getAllFavorites(userName: string){

    this.userService.getAllFavoritesByUserName(userName).subscribe({
      next: (favoritesRequest: number[]) => {
        this.favorites = favoritesRequest;

        return this.favorites;
    },
        error: (err) => {this.handleError(err);}
    })
  }

  private checkElementInList(element: number, favorite: number[]): boolean {
    return favorite.includes(element);
  }

  private handleError(err: any): void {
    console.log(err);
  }
}
