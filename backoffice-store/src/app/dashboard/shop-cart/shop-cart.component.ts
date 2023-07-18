import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ItemShop } from 'src/app/entities/item/modelo/itemShop.model';
import { ItemOrder } from 'src/app/entities/order/model/order.model';
import { IItemCart } from 'src/app/entities/shop-cart/interface/itemCart.interface';
import { ShopCartService } from 'src/app/entities/shop-cart/service/shopCart.service';

@Component({
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrls: ['./shop-cart.component.scss']
})
export class ShopCartComponent implements OnInit {

  @Input() listOrder: IItemCart[]=[];
  carritoVisible = false;
  products: IItemCart[]=[];
  productsOrder: ItemOrder[]=[];
  total: number =0;
  pay: number = 0;
  state: boolean = false;

  constructor( private shopCartService: ShopCartService){   }

  ngOnInit() {
      if (this.shopCartService.listCart){
        this.shopCartService.listCart.forEach( data =>{
          this.addCart(data);
          this.updateSharedVariable(this.products);
          this.calculatePay(this.products);
        })
       }

    this.shopCartService.insert.subscribe( data => {
        this.state = false;
        if(this.products.length==0){
          this.addProduct(data);
          this.updateSharedVariable(this.products);
          this.calculatePay(this.products);
        }else{
          this.products.forEach(element => {
            if(data.id === element.id ){
              element.quantity++;
              this.state = true;
              element.subtotal = element.quantity * element.price;
              this.updateSharedVariable(this.products);
            }
           });
        if(!this.state){
          this.addProduct(data);
          this.updateSharedVariable(this.products);
        }

        }
        this.calculatePay(this.products);
      })
  }


  toggleCarrito() {
    this.carritoVisible = !this.carritoVisible;
  }

  calculatePay(products: IItemCart[]) : number  {
    this.pay =0;
    products.forEach(element => {
      this.pay += element.quantity * element.price;
    });
      return this.pay;
  }

  addProduct(data: IItemCart){
    const newProduct: IItemCart = {
      id: data.id,
      name: data.name,
      image: data.image,
      price: data.price,
      reduced: data.reduced,
      quantity: 1,
      subtotal: data.price * 1
      };
      this.products.push(newProduct);
  }


  addCart(data: IItemCart){
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
  }

  removeFromCart(product: IItemCart) {
    const index = this.products.indexOf(product);
    this.products.splice(index, 1);
    this.calculatePay(this.products);
    this.updateSharedVariable(this.products);
  }

  getCartItemCount() {
    return this.products.reduce((count, product) => count + product.quantity, 0);
  }

  updateSharedVariable(products: IItemCart[]){
    this.shopCartService.listCart = products;
  }

  addToOrder(){
    if(this.shopCartService.listCart){
      this.shopCartService.listCart = this.products;
    }else{
      this.shopCartService.listCart = this.products;
    }
  }

  updateListOrder(list: IItemCart[]): void {
    this.listOrder = list;

  }

}
