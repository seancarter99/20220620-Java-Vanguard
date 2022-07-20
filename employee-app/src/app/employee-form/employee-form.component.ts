import { Component, OnInit } from '@angular/core';
import { EmployeeApiService } from '../employee-api.service';
import { Employee } from '../models/Employee';
import { Button } from 'primeng/button';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {

  // two-data binding - changes on the HTML will update state in the component
  employeeFormData :Employee;
  service :EmployeeApiService;
  imageUrl :string = 'https://angular.io/assets/images/logos/angular/logo-nav@2x.png'
  
  constructor(service :EmployeeApiService) {  //Dependency injection (majick)
    // must initialize this object
    this.employeeFormData = new Employee()
    this.service = service
  }

  ngOnInit(): void {
  }

  onBlur(e :any) :void{
    console.log(e.target.value)
  }

  onFocus(e :any) :void {
    console.log(e.target.value)
  }

  submit(employee :Employee) :void {
    // Observable -    []    subscribe 
    this.service.save(employee).subscribe(data => {
      console.log(data)
    });
  }

}
