export interface IItemCart {
  id: number;
  name: string;
  price: number;
  reduced: number;
  image: string;
  quantity: number;
  subtotal?: number;
}
