import { Product } from '../product/product';
import { Address } from '../address';

export class Order{
    orderId:number;
    orderDate:Date;
    amount:number;
    quantity:number;
    product:Product[] = [];
    address:Address;
}
