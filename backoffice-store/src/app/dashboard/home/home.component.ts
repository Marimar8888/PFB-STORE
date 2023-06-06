import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Banner } from 'src/app/entities/banner/model/banner.model';
import { BannerService } from 'src/app/entities/banner/service/banner.service';
import { CarouselCategories } from 'src/app/entities/carousel-categories/model/carousel-categories.model';
import { CarouselCategoriesService } from 'src/app/entities/carousel-categories/service/carousel-categories.service';
import { Carousel } from 'src/app/entities/carousel/model/carousel.model';
import { CarouselService } from 'src/app/entities/carousel/service/carousel.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
  imagenesList: Carousel []=[];
  imagenesCategoria: CarouselCategories []=[];
  imagenesBanner: Banner []=[];
  idArticulo?: string;

  constructor(
    private carouselService: CarouselService,
    private categoriesService: CarouselCategoriesService,
    private bannerService: BannerService,
    private activeRoute: ActivatedRoute
  ){   }
  ngOnInit(): void {

    this.obternerImagenesCarousel();
    this.obternerImagenesCategoriasCarousel();
    this.obternerParametros();
    this.obtenerImagenesBanner();
  }
  private obtenerImagenesBanner() {
    this.bannerService.obternerImagenesBanner().subscribe(
      (data) =>{
        data.forEach( (imagen) =>{ //recibo los artículos y a través de la interfaz recupero los datos
          const imagenNew: Banner = new Banner(imagen.id, imagen.image, imagen.titulo);
            this.imagenesBanner.push(imagenNew);
        })
      }
    )
  }
  //recupera el parámetro recibido en la url en este caso el idArticulo y lo guarda en la variable mismo nombre
  private obternerParametros():void {
    this.idArticulo= this.activeRoute.snapshot.queryParamMap.get('id') ?? undefined;
  }

 private obternerImagenesCategoriasCarousel() {
      this.categoriesService.obternerImagenesCategoriasCarousel().subscribe(
      (data) =>{
        data.forEach( (imagen) =>{ //recibo los artículos y a través de la interfaz recupero los datos
          const imagenNew: CarouselCategories = new CarouselCategories(imagen.id, imagen.image, imagen.titulo);
            this.imagenesCategoria.push(imagenNew);
        })
      }
    )
  }

  private obternerImagenesCarousel() {
    this.carouselService.obternerImagenesCarousel().subscribe(
       (data) =>{
         data.forEach( (imagen) =>{ //recibo los artículos y a través de la interfaz recupero los datos
           const imagenNew: Carousel = new Carousel(imagen.id, imagen.image, imagen.active);
           this.imagenesList.push(imagenNew);
         })
       }
     )
   }

}
