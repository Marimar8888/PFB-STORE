import { Component, Input } from '@angular/core';

import { registerLocaleData } from '@angular/common';
import localeEs from '@angular/common/locales/es';
import { ItemShop } from '../modelo/itemShop.model';
registerLocaleData(localeEs, 'es');


@Component({
  selector: 'app-item-card',
  templateUrl: './item-card.component.html',
  styleUrls: ['./item-card.component.scss']
})
export class ItemCardComponent {

  @Input() article: ItemShop | undefined;

}
