import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ItemCart  } from '../../entities/shop-cart/modelo/itemCart.model';
import { ShopCartService } from 'src/app/entities/shop-cart/service/shopCart.service';
import { OrderService } from 'src/app/entities/order/service/order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})

export class OrderComponent implements OnInit {

 @Output() listOrder: EventEmitter<ItemCart[]> = new EventEmitter<ItemCart[]>();
  products: ItemCart[]=[];
 item?: ItemCart;
 subtotal?: number;
 total?: number = 0;
 pay?: number = 0;

  constructor(private shopService: ShopCartService,
              private orderService: OrderService,
              private route: Router){  }

  ngOnInit(): void {
    if (this.shopService.listCart){
       this.shopService.listCart.forEach(data => {
       const newProduct: ItemCart =  new ItemCart(data.id, data.name, data.price, data.reduced, data.image, data.quantity, data.subtotal);
       this.products.push(newProduct);
      } )
      this.updateSharedVariable(this.products)
      this.calculatePay(this.products);
    }
  }
    process(products: ItemCart[]){
      this.orderService.insertOrder(products).subscribe({
        next: (orderInserted) => {
          alert("insertado correctamente");
          this.route.navigate(['']);
        },
        error: (err) => {this.handleError(err);}
      });
    }
    removeFromOrder(item: ItemCart){
      const index = this.products.indexOf(item);
      this.products.splice(index, 1);
      this.calculatePay(this.products);
      this.updateServiceVariable(this.products);

    }
    updateServiceVariable(products: ItemCart[]) {
      this.listOrder.emit(products);
     }
    calculatePay(products: ItemCart[]) : number  {
      this.total =0;
      products.forEach(item => {
        this.total! += item.getSubtotal();
      });
        return this.total;
    }
    updateSharedVariable(products: ItemCart[]){
     // this.shopService.listCart = products;
    }
    private handleError(err: any): void{
      //Lo que queramos que vea el usuario un alert....
    }

  }






