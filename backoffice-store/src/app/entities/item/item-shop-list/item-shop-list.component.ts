import { Component, Input } from '@angular/core';
import { ItemShop } from '../modelo/itemShop.model';

@Component({
  selector: 'app-item-shop-list',
  templateUrl: './item-shop-list.component.html',
  styleUrls: ['./item-shop-list.component.scss']
})
export class ItemShopListComponent {
  @Input() articleList!: ItemShop [];
}
