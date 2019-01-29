import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  product: Product =new Product();
  submitted=false;
  allow=false;
  id:number;
    constructor(private productService: ProductService) { }
  
    ngOnInit() {
    }
  
    newProduct() : void{
      this.submitted=false;
      this.product=new Product();
    }
  
   
  
    save()
    {
      this.productService.createProduct(this.product)
      .subscribe()
    }
  
    onSubmit(){
      console.log(this.product.productName);
      this.submitted=true;
      this.save();
    }
  
    addProduct(){
      this.allow=true;
    }
    removeProduct(){
      this.allow=!this.allow;
    }
    removeItem(){
      this.productService.deleteProduct(this.id)
      .subscribe()
    }
}
