import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  users : Observable<User[]>;
 //@Input() user:User;
 //user: User =new User();

 id:number;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.reloadData();
  }


  reloadData(){
    this.users=this.userService.getUsersList();
  }

}
