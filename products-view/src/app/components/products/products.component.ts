import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/Product';
import { ProductsService } from '../../services/products.service';
import { SortEvent } from 'primeng/api';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  product: any = {};

  productDialog: boolean = false;
  submitted: boolean = false;

  constructor(private service : ProductsService) { }

  ngOnInit(): void {
    this.service.getProducts().subscribe(data => {
      this.products = data;
    });
  }

  saveProduct() {
    this.submitted = true;
    if(this.product.nombre.trim() && this.product.precio>=0 && this.product.stock >= 0 ){
      if(this.product.id) {
        this.service.updateProduct(this.product, this.product.id).subscribe(data => {
          this.ngOnInit();
          alert("Producto modificado!")
        })
      } else {
        this.service.createProduct(this.product).subscribe(data => {
          this.ngOnInit();
          alert("Producto agregado!")
        })
      }
      this.productDialog = false;
      this.product = {};
    }
  }

  deleteProduct(product : Product) {
    this.service.deleteProduct(product.id).subscribe(()=> {
      this.ngOnInit();
      alert("Producto eliminado!")
    })   
  }
  
  openNew() {
    this.productDialog = true;
    this.submitted = false;
  }
  
  openEdit(product : Product) {
    this.product = {...product};
    this.productDialog = true;
  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  customSort(event: SortEvent) {
    event.data!.sort((data1, data2) => {
        let value1 = data1[event.field!];
        let value2 = data2[event.field!];
        let result = null;

        if (value1 == null && value2 != null)
            result = -1;
        else if (value1 != null && value2 == null)
            result = 1;
        else if (value1 == null && value2 == null)
            result = 0;
        else if (typeof value1 === 'string' && typeof value2 === 'string')
            result = value1.localeCompare(value2);
        else
            result = (value1 < value2) ? -1 : (value1 > value2) ? 1 : 0;

        return (event.order! * result);
    });
}


}
