import { Injectable, Input } from '@angular/core';
import{HttpClient, HttpHeaders, HttpParams}from '@angular/common/http'
import { Textfield } from '../models/Text';
@Injectable({
  providedIn: 'root'
})
export class Service {
   
  
 

  constructor(private httpClient:HttpClient) { }
 
 postTEXTf(t:Textfield){
     console.log("postttt");
     
  this.httpClient.post<Text>("http://localhost:8080/api/addtext",t).subscribe();
  }

}
