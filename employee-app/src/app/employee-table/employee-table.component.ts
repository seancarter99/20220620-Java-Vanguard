import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-table',
  templateUrl: './employee-table.component.html',
  styleUrls: ['./employee-table.component.css']
})
export class EmployeeTableComponent implements OnInit {

  employees :Array<any> = []
  constructor() { 
    // only for property-setting
  }

  // init - called when the component is rendered
  ngOnInit(): void {
    
  }

}
