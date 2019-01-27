import { Component, OnInit } from '@angular/core';
import {User} from '../User';
import { UserService } from '../user.service';

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

  constructor(private dataservice : UserService) { }

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
      user=>this.user=user,
      error=>{console.log(error.error);
                this.mesg="Invalid username or password"}
    );
  }
 
}
