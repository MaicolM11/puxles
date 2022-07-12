import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Product } from '../models/Product';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  url: string = 'https://localhost:8080/products';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url);;
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