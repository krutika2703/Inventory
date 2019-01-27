import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
/*import { CustomersListComponent } from './customers-list/customers-list.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';*/
import {UsersListComponent} from './users-list/users-list.component';
import {CreateUserComponent} from './create-user/create-user.component';
import {SearchUsersComponent} from './search-users/search-users.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ProductDetailsComponent } from './product/product-details/product-details.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductCartComponent } from './product/product-cart/product-cart.component';

/*
const routes: Routes = [
    { path: '', redirectTo: 'customer', pathMatch: 'full' },
    { path: 'customer', component: CustomersListComponent },
    { path: 'add', component: CreateCustomerComponent },
    { path: 'findbyid', component: SearchCustomersComponent },
];
*/
const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component:UserLoginComponent },
    { path: 'user', component: UsersListComponent },
    { path: 'add', component: CreateUserComponent },
    { path: 'findbyid', component: SearchUsersComponent },
    { path: 'productList', component: ProductListComponent },
    { path: 'addProduct', component: ProductCreateComponent },
    { path: 'productList/myCart', component: ProductCartComponent},
    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
