export class Client {

  private id?: number;
  private userName: string;


  constructor(id:number, userName:string){
    this.id = id;
    this.userName = userName;

  }

  public getId(): number {
    return this.id!;
  }
  public setId(id: number): void {
    this.id = id;
  }
  public getUserName(): string {
    return this.userName;
  }
  public setUserName(userName: string) {
    this.userName = userName;
  }

}
