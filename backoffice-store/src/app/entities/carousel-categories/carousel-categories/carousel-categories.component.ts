import { Component, Input } from '@angular/core';
import { CarouselCategories } from '../model/carousel-categories.model';

@Component({
  selector: 'app-carousel-categories',
  templateUrl: './carousel-categories.component.html',
  styleUrls: ['./carousel-categories.component.scss']
})
export class CarouselCategoriesComponent {
  @Input() imagenesCategoria!: CarouselCategories[];

}
