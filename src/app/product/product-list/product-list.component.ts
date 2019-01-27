import { Component, OnInit } from '@angular/core';
import { Product } from 'src/product';
import { Observable } from 'rxjs';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products : Observable<Product[]>;
 //@Input() user:User;
 product: Product =new Product();

 id:number;
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.reloadData();
  }


  reloadData(){
    this.products=this.productService.getProductList();
  }

}
