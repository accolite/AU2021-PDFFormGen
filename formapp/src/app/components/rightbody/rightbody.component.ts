import { Component, OnInit } from '@angular/core';
import { Textfield } from 'src/app/models/Text';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Service } from 'src/app/service/service';
@Component({
  selector: 'app-rightbody',
  templateUrl: './rightbody.component.html',
  styleUrls: ['./rightbody.component.css']
})
export class RightbodyComponent implements OnInit {

  // text: Text = {
  //   fgid : 1,
  //   name: "first name",
  //   min_length: 2,
  //   max_length: 30,
  //   is_required: 0

  // };
  text:Textfield=new Textfield();
  constructor(private service:Service) { }

  ngOnInit(): void {
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
}
