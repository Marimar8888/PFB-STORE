import { Component, OnInit } from '@angular/core';
import { ItemCart  } from '../../entities/shop-cart/modelo/itemCart.model';
import { ShopCartService } from 'src/app/entities/shop-cart/service/shopCart.service';
import { ItemOrder } from 'src/app/entities/order/model/order.model';
import { OrderService } from 'src/app/entities/order/service/order.service';
import { Item } from 'src/app/entities/item/modelo/item.model';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

 products: ItemCart[]=[];
 item?: ItemCart;
 subtotal?: number;
 total?: number = 0;
 pay?: number = 0;
  constructor(private shopService: ShopCartService){

  }
  ngOnInit(): void {
    if (this.shopService.listCart){
       this.shopService.listCart.forEach(data => {
       const newProduct: ItemCart =  new ItemCart(data.id, data.name, data.price, data.reduced, data.image, data.quantity, data.subtotal);
       this.products.push(newProduct);
      } )
      this.calculatePay(this.products);

    }
 }
    process(){

    }

    removeFromOrder(item: ItemCart){
      const index = this.products.indexOf(item);
      this.products.splice(index, 1);
      this.calculatePay(this.products);
      //this.updateSharedVariable(this.products);

    }
    calculatePay(products: ItemCart[]) : number  {
      this.total =0;
      products.forEach(item => {
        this.total! += item.getSubtotal();
      });
        return this.total;
    }


  }






