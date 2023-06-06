export class LoginUser {


  private userName: string;
  private password: string;

  constructor( userName:string, password:string){

    this.userName = userName;
    this.password = password
  }
  public getUserName(): string {
    return this.userName;
  }
  public setUserName(userName: string) {
    this.userName = userName;
  }
  public getOassword(): string {
    return this.password;
  }
  public setPassword(password: string) {
    this.password = password;
  }
}
