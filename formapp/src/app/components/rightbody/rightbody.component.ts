import { Component, OnInit } from '@angular/core';
import { Text } from 'src/app/models/Text';
@Component({
  selector: 'app-rightbody',
  templateUrl: './rightbody.component.html',
  styleUrls: ['./rightbody.component.css']
})
export class RightbodyComponent implements OnInit {

  text: Text = {
    fgid : 1,
    name: "first name",
    min_length: 2,
    max_length: 30,
    is_required: 0

  };
  constructor() { }

  ngOnInit(): void {
  }
  onCheckboxChange(): void {
    this.text.is_required = this.text.is_required+1;
    this.text.is_required = this.text.is_required%2;
  }
}
