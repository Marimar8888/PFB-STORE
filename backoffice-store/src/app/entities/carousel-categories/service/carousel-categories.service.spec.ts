import { TestBed } from '@angular/core/testing';

import { CarouselCategoriesService } from './carousel-categories.service';

describe('CarouselCategoriesService', () => {
  let service: CarouselCategoriesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarouselCategoriesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
