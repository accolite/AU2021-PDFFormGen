import { Component, OnInit } from '@angular/core';
import { Text } from 'src/app/models/Text';
import {ListItem} from 'src/app/models/ListItem';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-rightbody',
  templateUrl: './rightbody.component.html',
  styleUrls: ['./rightbody.component.css']
})
export class RightbodyComponent implements OnInit {

  listItems: ListItem[] = [];
  liststatus: boolean = false;
  text: Text = {
    fgid : 1,
    name: "first name",
    min_length: 2,
    max_length: 30,
    is_required: 0

  };
  constructor() { }

  ngOnInit(): void {
    this.listItems.push(new ListItem("",""));
  }
  onCheckboxChange(): void {
    this.text.is_required = this.text.is_required+1;
    this.text.is_required = this.text.is_required%2;
  }
  addtext(): void{
    
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
