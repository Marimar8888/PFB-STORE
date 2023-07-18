import { Component, OnInit } from '@angular/core';
import { IItemCart } from 'src/app/entities/shop-cart/interface/itemCart.interface';
import { ShopCartService } from 'src/app/entities/shop-cart/service/shopCart.service';
import { OrderService } from 'src/app/entities/order/service/order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})

export class OrderComponent implements OnInit {


 products: IItemCart[]=[];
 subtotal?: number;
 total?: number = 0;
 pay?: number = 0;

  constructor(private shopService: ShopCartService,
              private orderService: OrderService,
              private route: Router){  }

  ngOnInit(): void {
    if (this.shopService.listCart){
       this.shopService.listCart.forEach(data => {
       const newProduct: IItemCart = {
        id: data.id,
        name: data.name,
        image: data.image,
        price: data.price,
        reduced: data.reduced,
        quantity: data.quantity,
        subtotal: data.price * data.quantity
       };
      this.products.push(newProduct);
      
      } )
  
      this.calculatePay(this.products);
    }
  }
    process(products: IItemCart[]){
      this.orderService.insertOrder(products).subscribe({
        next: (orderInserted) => {
          alert("insertado correctamente");
          this.route.navigate(['']);
        },
        error: (err) => {this.handleError(err);}
      });
    }
    removeFromOrder(item: IItemCart){
      const index = this.products.indexOf(item);
      this.products.splice(index, 1);
      this.calculatePay(this.products);
      this.updateSharedVariable(this.products);

    }

    calculatePay(products: IItemCart[]) : number  {
      this.total =0;
      products.forEach(item => {
        this.total! += item.subtotal!;
      });
        return this.total;
    }
    updateSharedVariable(products: IItemCart[]){
      this.shopService.listCart = products;
    }
    private handleError(err: any): void{
      //Lo que queramos que vea el usuario un alert....
    }

  }






