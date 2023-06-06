export class User {

  private id?: number;
  private userName: string;
  private name: string;
  private surNames: string;
  private phone: string;
  private email: string;
  private password: string;
  private rol: string;

  constructor(id:number, userName:string, name:string, surNames:string, phone:string, email:string, password:string, rol:string){
    this.id = id;
    this.userName = userName;
    this.name = name;
    this.surNames = surNames;
    this.phone = phone;
    this.email = email;
    this.password = password;
    this.rol = rol;

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
  public getName(): string {
    return this.name!;
  }
  public setName(name: string) {
    this.name = name;
  }
  public getSurNames(): string {
    return this.surNames!;
  }
  public setSurNames(surNames: string) {
    this.surNames = surNames;
  }
  public getPhone(): string {
    return this.phone!;
  }
  public setPhone(phone: string) {
    this.phone = phone;
  }
  public getEmail(): string {
    return this.email!;
  }
  public setEmail(email: string) {
    this.email = email;
  }
  public getOassword(): string {
    return this.password;
  }
  public setPassword(password: string) {
    this.password = password;
  }
  public getRol(rol: string){
    this.rol = rol;
  }
  public setRol(rol: string){
    return rol;
  }
}
