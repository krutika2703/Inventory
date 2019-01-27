import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl='http://localhost:8080/api/users';

  constructor(private http:HttpClient) { }

  getUser(id: number):Observable<Object>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createUser(user: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`,user);
  }

  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getUsersById(id: number): Observable<any> {
    //console.log('cust details'+this.http.get(`${this.baseUrl}/${id}`));
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  login(uname:string,pass:string): Observable<any>{
    return this.http.get(`${this.baseUrl}/${uname}/${pass}`);
  }
}
