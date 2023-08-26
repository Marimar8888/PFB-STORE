export class Client {

  private id?: number;
  private userName: string;
  private token: string;

  constructor(id:number, userName:string, token: string){
    this.id = id;
    this.userName = userName;
    this.token = token;

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
  public getToken(): string{
    return this.token;
  }
  public setToken(token: string){
    this.token = token
  }
}
