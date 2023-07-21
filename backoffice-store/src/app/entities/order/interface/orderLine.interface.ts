export interface IOrderLine{
    id?: number;
    orderId?: number;
    itemId: number;
    price: number;
    quantity: number;
    subTotal: number;
}