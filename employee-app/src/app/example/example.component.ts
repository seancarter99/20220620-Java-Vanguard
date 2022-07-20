import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.css']
})
export class ExampleComponent implements OnInit {

  value :string = 'Hello';
  inactive :boolean = false;
  employees :Array<any> = [{first: 'Dan', last: 'Pickles'}, {first: 'Dan', last: 'Pickles'}, {first: 'Dan', last: 'Pickles'}]

  updateString(param :string) :void{
    this.value = param
  }

  constructor() { 
    // when it's constructed
  }

  ngOnInit(): void {
    // do something when the component initializes
  }

}
