import { Component, OnInit } from '@angular/core';
import { ItemShop } from 'src/app/entities/item/modelo/itemShop.model';
import { ItemCart } from 'src/app/entities/shop-cart/interface/itemCart.interface';
import { ShopCartService } from 'src/app/entities/shop-cart/service/shopCart.service';

@Component({
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrls: ['./shop-cart.component.scss']
})
export class ShopCartComponent implements OnInit {

  carritoVisible = false;
  products: ItemCart[] = [];
  total: number =0;
  pay: number = 0;
  state: boolean = false;

  constructor(private shopCartService: ShopCartService){

  }

  ngOnInit() {


      this.shopCartService.listCart;


      this.shopCartService.insert.subscribe( data => {
        this.state = false;

        if(this.products.length==0){
          this.addProduct(data);
          this.updateSharedVariable(this.products);

        }else{
          this.products.forEach(element => {

            if(data.getId() === element.id ){
              element.quantity++;
              this.state = true;
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

  calculatePay(products: ItemCart[]) : number  {
    this.pay =0;
    products.forEach(element => {
      this.pay += element.quantity * element.price;
      console.log(this.pay);
    });
      return this.pay;
  }

  addProduct(data: ItemShop){
    const newProduct: ItemCart = {
      id: data.getId(),
      name: data.getName(),
      image: data.getImage(),
      price: data.getPrice(),
      reduced: data.getReduced(),
      quantity: 1
      };
      this.products.push(newProduct);
  }

  removeFromCart(product: ItemCart) {
    const index = this.products.indexOf(product);
    this.products.splice(index, 1);
    this.calculatePay(this.products);
    this.updateSharedVariable(this.products);
  }

  getCartItemCount() {
    return this.products.reduce((count, product) => count + product.quantity, 0);
  }

  updateSharedVariable(products: ItemCart[]){
    this.shopCartService.listCart = products;
  }


}
