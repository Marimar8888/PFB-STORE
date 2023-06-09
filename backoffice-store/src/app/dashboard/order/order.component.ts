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

 orderList: ItemOrder[] = [];
 listCart: ItemCart[] = [];
 item?: ItemCart;
 subtotal?: number;
 total?: number = 0;
 pay?: number = 0;
  constructor(private shopService: ShopCartService, private orderService : OrderService){

  }
  ngOnInit(): void {
    if (this.shopService.listCart){
      console.log(this.shopService.listCart);
       this.shopService.listCart.forEach(data => {
       this.subtotal = 0;
       this.subtotal = data.price * data.quantity;
       const newProduct: ItemOrder =  new ItemOrder(data.id, data.name, data.price, data.reduced, data.image, data.quantity, this.subtotal);
       this.total! += this.subtotal;
       this.orderList.push(newProduct);
       this.updateSharedVariable(this.orderList);

      } )
    }
 }
    process(){

    }

    removeFromOrder(item: ItemOrder){
      const index = this.orderList.indexOf(item);
      this.orderList.splice(index, 1);
      this.calculatePay(this.orderList);
      this.updateSharedVariable(this.orderList);

    }
    calculatePay(orderList: ItemOrder[]) : number  {
      this.total =0;
      orderList.forEach(item => {
        this.subtotal=0;
        this.subtotal = item.getQuantity() * item.getPrice();
        this.total! += this.subtotal;
      });
        return this.total;
    }
    updateSharedVariable(orderList: ItemOrder[]){
      this.orderService.listOrder = this.orderList;

    }


  }






