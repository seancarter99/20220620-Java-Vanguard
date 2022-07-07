import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './models/Employee';

// Dependency Injection - tells Angular to create and store an instance of this object
// then we can "Inject" that instances where we need it
@Injectable({
  providedIn: 'root'
})
export class EmployeeApiService {

  http :HttpClient;
  baseUrl :string = 'https://my-json-server.typicode.com/skillstorm-walsh/employees-v1/employees/';

  constructor(http :HttpClient) { // Angular calls this guy and gives the HttpClient object
    this.http = http;
  }

  findAll() :Observable<any> {
    return this.http.get(this.baseUrl);
  }

}
