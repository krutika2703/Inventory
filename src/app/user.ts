import {Address} from './address';
export class User{
    userId:number;
    fullName:string;
    userName:string;
    password:string;
    userEmail:string;
    userPhone:number;
    userRole:string;
    address: Address[] = [];
    
   // address: Address;

}