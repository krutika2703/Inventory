import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Observable } from 'rxjs';
import { ProductService } from '../product.service';
import { ActivatedRoute } from '@angular/router';
import { Item } from '../product-cart/item.entity';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products : Observable<Product[]>;
allow:boolean=true;
 
prod:Product;
count:number=0;
 images=[];
 mesg:string;
amount:number=0;
displayAmount:boolean=false;
item= [];


  constructor(private productService: ProductService,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.reloadData();
    this.allow=false;
    
    this.images=[{photo:"laptop.jpg"},{photo:"tv.jpg"},{photo:"mobile.jpg"}];
     
}
onCheck(prod1:Product)
{
  console.log(prod1);
  this.item.push(prod1);
this.count=this.count+1;

this.amount=this.amount+prod1.productMRP;
  
}
onClick(){
  this.allow=true;
}
showProductList(){
  this.allow=false;
}
onUnCheck(prod1:Product){
  console.log(prod1);
  for (var i = 0; i < this.item.length; i++) {
   
    if (this.item[i].productId === prod1.productId) {
      this.amount=this.amount-this.item[i].productMRP;
      this.item.splice(i, 1);
      this.count=this.count-1;
      break;
    }
  }
}

confirmOrder(){
  this.displayAmount=true;
  
  }


  reloadData(){
    this.products=this.productService.getProductList();
  }

}
