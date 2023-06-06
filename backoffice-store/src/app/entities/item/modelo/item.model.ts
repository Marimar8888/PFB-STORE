export class Item{
  id: number | undefined;
  name: string;
  price: number;
  favorite: boolean = false;
  reduced?: number;
  categoryId?: number;
  categoryName?: string;
  description?: string;
  image?: string;


  constructor(id: number | undefined, name: string, price: number, favorite: boolean, reduced?:number, categoryId?: number, categoryName?:string, description?: string, image?: string){
    this.id = id;
    this.name = name;
    this.price = price;
    this.favorite = false;
    this.reduced = reduced;
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.description = description;
    this.image = image;
  }
}
