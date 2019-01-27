import { Component, OnInit, Input, OnChanges, SimpleChange, SimpleChanges } from '@angular/core';
import { Product } from 'src/product';

@Component({
  selector: 'app-cart-calculator',
  templateUrl: './cart-calculator.component.html',
  styleUrls: ['./cart-calculator.component.css']
})
export class CartCalculatorComponent implements OnInit, OnChanges {

  @Input() products: Product[];

	totalValue = 0;
	constructor() {}

	ngOnChanges(changes: SimpleChanges) {
		const dataChanges: SimpleChange = changes.products;

		const products: Product[] = dataChanges.currentValue;
		this.totalValue = 0;
		products.forEach((product) => {
			this.totalValue += product.productMRP;
			console.log(this.totalValue);
		});
	}

	ngOnInit() {}

}
