import { Injectable } from '@angular/core';

import { Product } from './product';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  navbarCartCount = 0;
  addToCart(data: Product): void {
		let a: Product[];

		a = JSON.parse(localStorage.getItem('item')) || [];

		a.push(data);
		
		setTimeout(() => {
			localStorage.setItem('item', JSON.stringify(a));
			this.calculateLocalCartProdCounts();
		}, 500);
	}
// Fetching Locat CartsProducts
getLocalCartProducts(): Product[] {
  const products: Product[] = JSON.parse(localStorage.getItem('item')) || [];

  return products;
}

// returning LocalCarts Product Count
calculateLocalCartProdCounts() {
  this.navbarCartCount = this.getLocalCartProducts().length;
  console.log(this.navbarCartCount);
}

// Removing cart from local
removeFromCart(product: Product) {
  const products: Product[] = JSON.parse(localStorage.getItem('item'));

  for (let i = 0; i < products.length; i++) {
    if (products[i].productId === product.productId) {
      products.splice(i, 1);
      break;
    }
  }
  // ReAdding the products after remove
  localStorage.setItem('item', JSON.stringify(products));

  this.calculateLocalCartProdCounts();
}
  
}
