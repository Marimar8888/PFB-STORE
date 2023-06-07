import { User } from "./user.model";

export class Favorite{

  private _itemId: number;

  constructor( itemId: number){

    this._itemId = itemId;
  }

  public getItemId(): number {
    return this._itemId;
  }
  public setItemId(itemId: number): void {
    this._itemId = itemId;
  }
}
