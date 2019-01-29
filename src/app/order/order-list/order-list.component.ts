import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order';
import { OrderService } from '../order.service';
@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  
  orders : Observable<Order[]>;
 //@Input() user:User;
 //user: User =new User();

 id:number;
  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.reloadData();
  }


  reloadData(){
    this.orders=this.orderService.getOrdersList();
    console.log(this.orders);
  }

}
