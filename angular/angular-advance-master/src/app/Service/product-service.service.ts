import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { product } from '../model/product';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http: HttpClient) { }

  getProducts(){
    return this.http.get<product[]>("http://localhost:8090/product/api.2.0/retrieve/all")
  }

  saveProduct(product:product):Observable<Object>{
    return this.http.post("http://localhost:8090/product/api.2.0/create",product);
  }

 
  getProductById(id: number): Observable<product> {
    return this.http.get<product>(`http://localhost:8090/product/api.2.0/retrieve/${id}`);
  }

  updateProduct(product: product): Observable<Object> {
    return this.http.put(`http://localhost:8090/product/api.2.0/update/${product.productId}`, product);
  }

  deleteProduct(id: number):Observable<product>{
    return this.http.delete<product>(`http://localhost:8090/product/api.2.0/delete/${id}`);
  }
}
