import { Component, OnInit } from '@angular/core';
import { product } from '../model/product';
import { ProductServiceService } from '../Service/product-service.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit{
  product:product=new product();
 
  constructor(private productService:ProductServiceService){}
  ngOnInit():void{}
  onSubmit(){
    this.saveProduct();
     console.log(this.product);
  }
  saveProduct(){
    this.productService.saveProduct(this.product).subscribe((data)=>{
      console.log(data);
    },
    
      (error)=>console.log(error)
    );
  }
}
