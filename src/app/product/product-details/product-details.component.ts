import { Component, OnInit,Input } from '@angular/core';
import {  Product} from "../product";
import { ProductService } from '../product.service';
import {ProductListComponent  } from "../product-list/product-list.component";
import { CartService } from '../cart.service';
@Component({
  selector: 'product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  @Input() product : Product;
  constructor(private productService: ProductService,private listComponent :ProductListComponent,private cartService:CartService) { }

  ngOnInit() {
  }

  showLDetails(){
    this.productService.getProductList()
    .subscribe(
      data=>{
        console.log(data);
        this.listComponent.reloadData();
      },
    error => console.log(error));
  }
  addToCart(product: Product) {
		this.cartService.addToCart(product);
	}
  removeFromCart(product: Product){
    this.cartService.removeFromCart(product);
  }
}
