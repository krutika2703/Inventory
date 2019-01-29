import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UsersListComponent} from './users-list/users-list.component';
import {CreateUserComponent} from './create-user/create-user.component';
import {SearchUsersComponent} from './search-users/search-users.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ProductDetailsComponent } from './product/product-details/product-details.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductCartComponent } from './product/product-cart/product-cart.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { AdminComponent } from './admin/admin/admin.component';

import { OrderListComponent } from './order/order-list/order-list.component';
import { LogoutComponent } from './logout/logout.component';





const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component:UserLoginComponent },
    { path: 'user', component: UsersListComponent },
    { path: 'add', component: CreateUserComponent },
    { path: 'findbyid', component: SearchUsersComponent },

    { path: 'productList', component: ProductListComponent },
    { path: 'addProduct', component: ProductCreateComponent },
    { path: 'cart', component: ProductCartComponent},

    { path: 'order', component: OrderListComponent},
    { path: 'logout', component:LogoutComponent},

    { path: 'admin', component: AdminComponent},
    { path: 'manageOrder', component: ProductCartComponent},
   
    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
