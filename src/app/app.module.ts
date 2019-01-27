import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import {APP_BASE_HREF} from '@angular/common';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UsersListComponent } from './users-list/users-list.component';
import { SearchUsersComponent } from './search-users/search-users.component';
import { UserLoginComponent } from './user-login/user-login.component';


import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductDetailsComponent } from './product/product-details/product-details.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductCartComponent } from './product/product-cart/product-cart.component';
import { CartCalculatorComponent } from './product/cart-calculator/cart-calculator.component';


@NgModule({
  declarations: [
    AppComponent,
      CreateUserComponent,
    UserDetailsComponent,
    UsersListComponent,
    SearchUsersComponent,
    UserLoginComponent,
    ProductListComponent,
    ProductDetailsComponent,
    ProductCreateComponent,
    ProductCartComponent,
    CartCalculatorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
   
  ],
  providers: [{provide: APP_BASE_HREF, useValue: ''}],
  bootstrap: [AppComponent]
})
export class AppModule { }
//providers: [{provide: APP_BASE_HREF, useValue: '/my/app'}],