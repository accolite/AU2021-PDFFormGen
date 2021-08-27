import { Injectable, Input } from '@angular/core';
import{HttpClient, HttpHeaders, HttpParams}from '@angular/common/http'
import { Textfield } from '../models/Text';
import {FG} from '../models/FG';
import { FgId } from '../models/FgId';

@Injectable({
  providedIn: 'root'
})
export class Service {
   
  
 

  constructor(private httpClient:HttpClient) { }
 
 postTEXTf(t:Textfield){
     console.log("postttt");
     
  this.httpClient.post<Text>("http://localhost:8080/api/addtext",t).subscribe();
  }

  getfgs(){
    return this.httpClient.get<FG[]>("http://localhost:8080/api/getfgs");
  }
  getfg(id: FgId){
    return this.httpClient.post<Textfield[]>("http://localhost:8080/api/getfg",id);
  }
}
