export class Banner {
  private _id: number;
  private _image: string;
  private _title: string;

  constructor(id: number, image: string, title: string) {
      this._id = id;
      this._image = image;
      this._title = title;
  }
  public getId(): number {
      return this._id;
  }

  public getImage(): string {
      return this._image;
  }
  public getTitle(): string {
    return this._title;
}

  public setId(id: number) {
      this._id = id;
  }

  public setImage(image: string) {
      this._image = image;
  }

  public setTitle(title: string) {
    this._title = title;
}




}
