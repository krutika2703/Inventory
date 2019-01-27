import { Component, OnInit } from '@angular/core';

import {User} from '../User';
import { UserService } from '../user.service';
import { Address } from '../address';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
   
    fullName:string;
    userName:string;
    password:string;
    userEmail:string;
    userPhone:number;
    userRole:string;


    street:string;
    city:string;
    state:string;
    country:string;
    pincode:number;

    address:Address;
    //address1=new Address(this.street,this.city,this.state,this.country,this.pincode);
   
  user:User;

submitted=false;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.user=new User();
  }

  newUser() : void{
    this.submitted=false;
   // this.address.push(this.address1);
   

   // this.user=new User(this.fullName,this.userName,this.password,this.userEmail,this.userPhone,this.userRole,this.address);
  }

  newAddress():void{
    
  }

  save()
  {
    this.userService.createUser(this.user)
    .subscribe()
  }

  onSubmit(form: NgForm){
    console.log(form.value);
   // this.user=new User();

this.user.fullName=form.value.name;
this.user.userName=form.value.uname;
this.user.password=form.value.password;
this.user.userEmail=form.value.email;
this.user.userPhone=form.value.phone;
this.user.userRole=form.value.role;

this.address=new Address();
this.address.city=form.value.city;
this.address.street=form.value.street;
this.address.country=form.value.country;
this.address.pincode=form.value.pincode;
this.address.state=form.value.state;


      
this.user.address.push(this.address);
    this.submitted=true;
    this.save();
  }

}
