import { Component, OnInit } from '@angular/core';
import { Textfield } from 'src/app/models/Text';
import {ListItem} from 'src/app/models/ListItem';

import { Service } from 'src/app/service/service';
@Component({
  selector: 'app-rightbody',
  templateUrl: './rightbody.component.html',
  styleUrls: ['./rightbody.component.css']
})
export class RightbodyComponent implements OnInit {


  listItems: ListItem[] = [];
  liststatus: boolean = false;
//   text: Text = {
//     fgid : 1,
//     name: "first name",
//     min_length: 2,
//     max_length: 30,
//     is_required: 0
// >>>>>>> 620a553a63155a0795e1bd59f7d44e9d86e2907e

  // };
  text:Textfield=new Textfield();
  constructor(private service:Service) { }

  ngOnInit(): void {
    this.listItems.push(new ListItem("",""));
  }
  onCheckboxChange(): void {
    this.text.is_required = this.text.is_required+1;
    this.text.is_required = this.text.is_required%2;
  }
  addtext(): void{
    this.service.postTEXTf(this.text);
  }
  cleartext(): void{
    this.text.max_length = 0;
    this.text.min_length = 0;
    this.text.name = "";
  }
  onOptionsSelected(val: string){
    if(val=="chechboxlist")
    {
      this.liststatus=true;
    }
    else
    {
      this.liststatus=false;
    }
  }
  addListItem(){
    this.listItems.push(new ListItem("",""));
  }
  removeListItem(){
    this.listItems.pop();
  }
}
