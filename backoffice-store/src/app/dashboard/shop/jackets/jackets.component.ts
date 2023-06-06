import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ItemShop } from 'src/app/entities/item/modelo/itemShop.model';
import { ItemService } from 'src/app/entities/item/service/item.service';

@Component({
  selector: 'app-jackets',
  templateUrl: './jackets.component.html',
  styleUrls: ['./jackets.component.scss']
})
export class JacketsComponent implements OnInit {

  articleList: ItemShop[]=[];

  constructor( private itemService: ItemService  ){}

  ngOnInit(): void {
    this.getJackets();
  }
  private getJackets() {
    this.itemService.obternerChaquetas().subscribe({
      next: (articlesRequest) => {
        articlesRequest.forEach( (article) =>{ //recibo los artículos y a través de la interfaz recupero los datos
          const articleNew: ItemShop = new ItemShop(article.id, article.titulo, article.image, article.precio, article.rebaja, article.favorite);
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
