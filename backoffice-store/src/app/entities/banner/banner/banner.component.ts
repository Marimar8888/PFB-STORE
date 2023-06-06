import { Component, Input } from '@angular/core';
import { Banner } from '../model/banner.model';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss']
})
export class BannerComponent {

  @Input() imagenesBanner!: Banner[];

}
