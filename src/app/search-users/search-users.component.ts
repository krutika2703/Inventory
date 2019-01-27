import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-search-users',
  templateUrl: './search-users.component.html',
  styleUrls: ['./search-users.component.css']
})
export class SearchUsersComponent implements OnInit {

  id:number;
  user:User=null;
  mesg:string;

  constructor(private dataservice : UserService) { }

  ngOnInit() {
    this.id=0 ;
  }

  onSubmit(){
    this.searchUsers();
  }

  private searchUsers(){
    this.mesg="";
    this.user=null;
    console.log("........");
    this.dataservice.getUsersById(this.id)
    .subscribe(
      user=>this.user=user,
      error=>{console.log(error.error);
                this.mesg=error.error}
    );
  }
 
}
