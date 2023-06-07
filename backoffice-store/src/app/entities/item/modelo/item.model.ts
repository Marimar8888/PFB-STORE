export class Item{
  id?: number;
  name: string;
  price: number;
  reduced?: number;
  categoryId?: number;
  categoryName?: string;
  description?: string;
  image?: string;



  constructor(name: string, price: number, id?: number, reduced?:number, categoryId?: number, categoryName?:string, description?: string, image?: string){
    this.id = id;
    this.name = name;
    this.price = price;
    this.reduced = reduced;
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.description = description;
    this.image = image;


  }


}
