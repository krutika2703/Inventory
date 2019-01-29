import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl='http://localhost:8080/api/orders';

  constructor(private http:HttpClient) { }

  getOrder(id: number):Observable<Object>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createOrder(Order: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`,Order);
  }

  updateOrder(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteOrder(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getOrdersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getOrdersById(id: number): Observable<any> {
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
