export class Banner {
  private _id: number;
  private _image: string;
  private _titulo: string;

  constructor(id: number, image: string, titulo: string) {
      this._id = id;
      this._image = image;
      this._titulo = titulo;
  }
  public getId(): number {
      return this._id;
  }

  public getImage(): string {
      return this._image;
  }
  public getTitulo(): string {
    return this._titulo;
}

  public setId(id: number) {
      this._id = id;
  }

  public setImage(image: string) {
      this._image = image;
  }

  public setTitulo(titulo: string) {
    this._titulo = titulo;
}




}
