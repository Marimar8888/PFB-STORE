export class OrderLine {
    private id?: number;
    private orderId?: number;
    private itemId: number;
    private price: number;
    private quantity: number;
    private subTotal: number;
  
    constructor( itemId: number, price: number, quantity: number, subTotal: number, id?: number, orderId?: number ) {
      this.id = id;
      this.orderId = orderId;
      this.itemId = itemId;
      this.price = price;
      this.quantity = quantity;
      this.subTotal = subTotal;
    }
  
    // Getters
    public getId(): number {
      return this.id!;
    }
  
    public getOrderId(): number {
      return this.orderId!;
    }
  
    public getItemId(): number {
      return this.itemId;
    }
  
    public getPrice(): number {
      return this.price;
    }
  
    public getQuantity(): number {
      return this.quantity;
    }
  
    public getSubTotal(): number {
      return this.subTotal;
    }
  
    // Setters
    public setId(id: number): void {
      this.id = id;
    }
  
    public setOrderId(orderId: number): void {
      this.orderId = orderId;
    }
  
    public setItemId(itemId: number): void {
      this.itemId = itemId;
    }
  
    public setPrice(price: number): void {
      this.price = price;
    }
  
    public setQuantity(quantity: number): void {
      this.quantity = quantity;
    }
  
    public setSubTotal(subTotal: number): void {
      this.subTotal = subTotal;
    }
  }