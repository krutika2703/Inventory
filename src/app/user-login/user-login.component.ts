import { Component, OnInit } from '@angular/core';
import {User} from '../User';
import { UserService } from '../user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
 uname:string;
 password:string;
  user:User=null;
  mesg:string;

  constructor(private dataservice : UserService,private router:Router) { }

  ngOnInit() {
   
  }

  onSubmit(){
    this.loginUsers();
  }

  private loginUsers(){
    this.mesg="";
    this.user=null;
    console.log("........");
    this.dataservice.login(this.uname,this.password)
    .subscribe(
      user=>{this.user=user;
        if(this.user.userRole=="ADMIN"){
                    this.router.navigate(['/admin']);
              };
        if(this.user.userRole=="CUSTOMER"){
          this.router.navigate(['/productList']);
          }
      },
      error=>{console.log(error.error);
                this.mesg="Invalid username or password"}
                    );
                     
  }
 
}
