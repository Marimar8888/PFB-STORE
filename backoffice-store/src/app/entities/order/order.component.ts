import { Component } from '@angular/core';
import { ItemCart } from '../shop-cart/modelo/itemCart.model';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent {

  cartItems: ItemCart[]=[];

  decreaseQuantity(item: ItemCart){

  }
  increaseQuantity(item: ItemCart){

  }

  removeFromCart(item: ItemCart){

  }
}
