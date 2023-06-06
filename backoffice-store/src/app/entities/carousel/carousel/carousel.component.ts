import { Component, Input, OnInit } from '@angular/core';
import { Carousel } from '../model/carousel.model';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {

  @Input() imagenesList!: Carousel[];

  constructor(
      private config: NgbCarouselConfig
  ){}

  ngOnInit(): void {

  }

}

