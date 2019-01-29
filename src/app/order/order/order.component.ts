import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { OrderListComponent } from '../order-list/order-list.component';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  @Input() order : Order;
  constructor(private orderService: OrderService,private listComponent :OrderListComponent) { }

  ngOnInit() {
  }

  deleteOrder(){
    this.orderService.deleteOrder(this.order.orderId)
    .subscribe(
      data=>{
        console.log(data);
        this.listComponent.reloadData();
      },
    error => console.log(error));
  }

}
