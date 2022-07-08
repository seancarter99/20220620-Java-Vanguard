import { Component, OnDestroy, OnInit } from '@angular/core';
import { EmployeeApiService } from '../employee-api.service';
import { Employee } from '../models/Employee';

@Component({
  selector: 'app-employee-table',
  templateUrl: './employee-table.component.html',
  styleUrls: ['./employee-table.component.css']
})
export class EmployeeTableComponent implements OnInit, OnDestroy {

  employees :Array<Employee> = []
  employeeApiService :EmployeeApiService; 

  // Angular looks at this constructor and says "hey I have that.. let me get it for you"
  constructor(employeeApiService :EmployeeApiService) { // majicks
    // only for property-setting
    this.employeeApiService = employeeApiService;
  }
  ngOnDestroy(): void {
    console.log('ngOnDestroy')
  }

  // init - called everytime the component is rendered
  ngOnInit(): void {
    console.log('ngOnInit')
   // pub/sub - publisher/subscriber (component will subscribe to the Observable)
   // when response data arrives, the component can receive the information
   this.employeeApiService.findAll().subscribe(data => {
          // callback to process the response
      this.employees = data;
   });
  }
}
