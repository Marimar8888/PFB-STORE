export class ItemCart  {

  private _id: number;
  private _name: string;
  private _price: number;
  private _reduced?: number;
  private _image?: string;
  private _quantity?: number;
  private _subtotal?: number;


  constructor(id: number, name:string, price: number, reduced?: number, image?: string, quantity?: number, subtotal?: number) {
      this._id = id;
      this._image = image;
      this._name = name;
      this._price = price;
      this._reduced = reduced;
      this._quantity = quantity;
      this._subtotal =subtotal;
  }

  public getId(): number{
    return this._id;
  }

  public getImage(): string{
    return this._image!;
  }
  public getName(): string{
    return this._name;
  }

  public getPrice(): number{
    return this._price;
  }
  public getReduced(): number{
    return this._reduced!;
  }
  public getQuantity(): number{
    return this._quantity!;
  }
  public getSubtotal(): number{
    return this._subtotal!;
  }

  public setId(id: number){
    this._id = id;
  }

  public setImage(image: string){
    this._image = image;
  }
  public setName(name: string){
    this._name = name;
  }

  public setPrecio(price: number){
    this._price = price;
  }

  public setRebaja(reduced: number){
    this._reduced = reduced;
  }

  public setQuantity(quantity: number){
    this._quantity = quantity;
  }
  public setSutotal(subtotal: number){
    this._subtotal = subtotal;
  }


}
