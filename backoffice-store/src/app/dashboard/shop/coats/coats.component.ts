import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Item } from 'src/app/entities/item/modelo/item.model';
import { ItemShop } from 'src/app/entities/item/modelo/itemShop.model';
import { ItemService } from 'src/app/entities/item/service/item.service';

@Component({
  selector: 'app-coats',
  templateUrl: './coats.component.html',
  styleUrls: ['./coats.component.scss']
})
export class CoatsComponent implements OnInit {

  articleList: ItemShop[]=[];
  categoryId: number = 12752;

  constructor( private itemService: ItemService  ){}

  ngOnInit(): void {
    this.getAllCoats();
  }
/*  private getCoats() {
    this.itemService.obternerAbrigos().subscribe({
      next: (articlesRequest) => {
        articlesRequest.forEach( (article) =>{ //recibo los artículos y a través de la interfaz recupero los datos
          const articleNew: ItemShop = new ItemShop(article.id, article.titulo, article.image?, article.precio, article.rebaja?,article.favorite);
          this.articleList.push(articleNew);
        })
      },
      error: (err) => {this.gestionarError(err);}
    })
  }*/

  private getAllCoats() {
    this.itemService.getAllItemsByCategoryId(this.categoryId).subscribe({
      next: (articlesRequest) => {
        articlesRequest.forEach( (article) =>{ //recibo los artículos y a través de la interfaz recupero los datos
          const articleNew: ItemShop = new ItemShop(article.id, article.name, article.price, article.reduced, article.image, article.favorite);
          this.articleList.push(articleNew);
        })
      },
      error: (err) => {this.gestionarError(err);}
    })
  }

  private gestionarError(err: any) {
    console.log(err);
  }


}
