import { Component, OnInit } from '@angular/core';
import { IItemCart } from 'src/app/entities/shop-cart/interface/itemCart.interface';
import { ShopCartService } from 'src/app/entities/shop-cart/service/shopCart.service';
import { OrderService } from 'src/app/entities/order/service/order.service';
import { Router } from '@angular/router';
import { IOrderLine } from 'src/app/entities/order/interface/orderLine.interface';
import { IOrder } from 'src/app/entities/order/interface/order.interface';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})

export class OrderComponent implements OnInit {

 orderLines : IOrderLine[]=[];
 products: IItemCart[]=[];
 order!: IOrder;
 subtotal?: number;
 total?: number = 0;
 pay?: number = 0;
 userId!: number;
 listEmpty: IItemCart[]=[];

  constructor(private shopService: ShopCartService,
              private cookieService: CookieService,
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
    process(products: IItemCart[]): void{
      this.userId = parseInt(this.cookieService.get('Id'));
      const newOrderLines : IOrderLine[] = this.createOrderLines(products);
      if(newOrderLines.length>0){
        this.order = this.createOrder(this.userId, newOrderLines);
      }
       this.insertOrder(this.order);
       this.removeOrderCar();
    }

    removeFromOrder(item: IItemCart){
      const index = this.products.indexOf(item);
      this.products.splice(index, 1);
      this.calculatePay(this.products);
      this.updateSharedVariable(this.products);

    }
  
    calculatePay(products: IItemCart[]) : number {
      this.total =0;
      products.forEach(item => {
        this.total! += item.subtotal!;
      });
        return this.total; 
    }
    updateSharedVariable(products: IItemCart[]){
      this.shopService.listCart = products;
    }
    createOrderLines(products: IItemCart[]) : IOrderLine[]{
      products.forEach(data =>{
        const line : IOrderLine= {
          itemId: data.id,
          price: data.price,
          quantity: data.quantity,
          subTotal: data.price * data.quantity
        };
        this.orderLines.push(line);
      })
      return this.orderLines;
    }

    createOrder(userId: number, newOrderLines: IOrderLine[]): IOrder {
      const order: IOrder = {
        userId: userId,
        orderLines: newOrderLines       
      };       
      return order;
    }
    
    insertOrder(order: IOrder) {
      this.orderService.insertOrder(order).subscribe({
        next: (orderInserted) => {
          alert("insertado correctamente");
         
          this.route.navigate(['']);
        },
        error: (err) => {this.handleError(err);}
      });
    }

    removeOrderCar() {
      this.shopService.listCart = this.listEmpty;
    }
    
    private handleError(err: any): void{
      //Lo que queramos que vea el usuario un alert....
    }

  }






