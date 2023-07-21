import { IOrderLine } from "./orderLine.interface";

export interface IOrder {
  id?: number;
  userId: number;
  orderLines: IOrderLine[];
}