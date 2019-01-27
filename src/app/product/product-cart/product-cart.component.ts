import { Component, OnInit } from '@angular/core';
import { Product } from '../product';

import { CartService } from '../cart.service';

@Component({
  selector: 'product-cart',
  templateUrl: './product-cart.component.html',
  styleUrls: ['./product-cart.component.css']
})
export class ProductCartComponent implements OnInit {
  cartProducts: Product[];
	showDataNotFound = true;

	// Not Found Message
	messageTitle = 'No Products Found in Cart';
	messageDescription = 'Please, Add Products to Cart';

	constructor(private cartService: CartService) {}

	ngOnInit() {
		this.getCartProduct();
	}

	removeCartProduct(product: Product) {
		this.cartService.removeFromCart(product);

		// Recalling
		this.getCartProduct();
	}

	getCartProduct() {
		this.cartProducts = this.cartService.getLocalCartProducts();
	}
}
