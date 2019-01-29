import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute } from '@angular/router';
import { CartService } from '../cart.service';
import {ProductService} from '../product.service';
import { Item } from './item.entity';
import { Observable } from 'rxjs';

@Component({
  selector: 'product-cart',
  templateUrl: './product-cart.component.html',
  styleUrls: ['./product-cart.component.css']
})
export class ProductCartComponent implements OnInit {
	private items: Item[] = [];
	private total: number = 0;
	 id:number;
	 mesg:string;
//	product:Product;
	product:Product;
	name:string;
	price:number;
	item= [];
	constructor(
		private activatedRoute: ActivatedRoute,
		private productService: ProductService
	) { }



	
	ngOnInit() {
		this.activatedRoute.params.subscribe(params => {
			 this.id = params['id'];}),
			this.searchProduct();
		
			
}
private searchProduct(){
	
	this.mesg="";
    this.product=null;
    console.log("........");
    this.productService.getProductById(this.id)
    .subscribe(
			user=>{this.product=user,this.name=this.product.productName,this.price=this.product.productMRP,
				this.item.push({"productName":this.name,"productMRP":this.price});},
      error=>{console.log(error.error);
                this.mesg=error.error}
    );
  }
	}