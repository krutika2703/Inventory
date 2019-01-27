import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl='http://localhost:8080/api/products';
  constructor(private http:HttpClient) { }

  getProduct(id: number):Observable<Object>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getProductList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getProductById(id: number): Observable<any> {
    //console.log('cust details'+this.http.get(`${this.baseUrl}/${id}`));
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  createProduct(product: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`,product);
  }
  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  updateProduct(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

}
