import { Component, OnInit } from '@angular/core';
import { ItemShop } from 'src/app/entities/item/modelo/itemShop.model';
import { ItemService } from 'src/app/entities/item/service/item.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit{

  articleList: ItemShop[]=[];

  constructor( private itemService: ItemService  ){}

  ngOnInit(): void {
          this.getArticles();
  }

 private getArticles() {
   this.itemService.obternerArticulos().subscribe({
    next: (articlesRequest) => {
      articlesRequest.forEach( (article) =>{ //recibo los artículos y a través de la interfaz recupero los datos
        const articleNew: ItemShop = new ItemShop(article.id, article.titulo, article.image, article.precio, article.rebaja, article.favorite);
        this.articleList.push(articleNew);
      })
    },
    error: (err) => {this.gestionarError(err);}
   })

  }
  gestionarError(err: any) {
    console.log(err);
  }

}
