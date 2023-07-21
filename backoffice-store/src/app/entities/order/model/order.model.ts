import { OrderLine } from "./orderLine.model"; 

export class Order {
 
  private userId: number;
  private orderLines: OrderLine[];
  private id?: number;

  constructor(
    userId: number,
    orderLines: OrderLine[],
    id?: number
  ) {
    this.id = id;
    this.userId = userId;
    this.orderLines = orderLines;
  }

  // Setters
  public setId(id: number) {
    this.id = id;
  }

  public setUserId(userId: number) {
    this.userId = userId;
  }

  public setOrderLines(orderLines: OrderLine[]) {
    this.orderLines = orderLines;
  }

  // Getters
  public getId(): number {
    return this.id!;
  }

  public getUserId(): number {
    return this.userId;
  }

  public getOrderLines(): OrderLine[] {
    return this.orderLines;
  }
}
