import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Product } from '../models/Product';
import { HttpClient } from '@angular/common/http';
import { SERVER_URL } from '../config/config';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  url: string = SERVER_URL + '/products';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url);
  }

  createProduct(product : Product): Observable<Product> {
    return this.http.post<Product>(this.url, product);
  }

  updateProduct(product : Product, id:number): Observable<Product> {
    return this.http.put<Product>(`${this.url}/${id}` , product);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`)
  }

}