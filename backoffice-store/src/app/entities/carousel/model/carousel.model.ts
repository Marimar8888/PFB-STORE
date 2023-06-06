export class Carousel {
  private _id: number;
  private _image: string;
  private _active: boolean;

  constructor(id: number, image: string, active: boolean) {
      this._id = id;
      this._image = image;
      this._active = active;
  }
  public getId(): number {
      return this._id;
  }

  public getImage(): string {
      return this._image;
  }
  public getActive(): boolean {
    return this._active;
}

  public setId(id: number) {
      this._id = id;
  }

  public setImage(image: string) {
      this._image = image;
  }

  public setActive(active: boolean) {
    this._active = active;
}




}
