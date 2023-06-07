import { Component } from '@angular/core';
import { product } from '../model/product';
import { ProductServiceService } from '../Service/product-service.service';


@Component({
  selector: 'app-retrieve',
  templateUrl: './retrieve.component.html',
  styleUrls: ['./retrieve.component.css']
})
export class RetrieveComponent {
  constructor(private service:ProductServiceService)
  {
    
  }
  products: product[]=[];
  ngOnInit(): void {
    this.products = this.getProducts();
  }

  getProducts():any{
    this.service.getProducts().subscribe((products: product[])=>{
    this.products = products;
  });

  }
}

