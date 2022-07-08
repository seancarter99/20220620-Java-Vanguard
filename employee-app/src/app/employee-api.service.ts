import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from './models/Employee';

// Dependency Injection - tells Angular to create and store an instance of this object
// then we can "Inject" that instances where we need it
@Injectable({
  providedIn: 'root'
})
export class EmployeeApiService {

  http :HttpClient;
  baseUrl :string = environment.apiUrl

  constructor(http :HttpClient) { // Angular calls this guy and gives the HttpClient object
    this.http = http;
  }

  findAll() :Observable<any> {
    return this.http.get(this.baseUrl);
  }
  
  // rxjs 
  save(employee :Employee){                 // register an error handler
    return this.http.post(this.baseUrl, employee).pipe(catchError(this.handleError));
  }

  private handleError(error :HttpErrorResponse){
    // translate the HTTP error code into a Stacktrace
    console.log(error);
    return throwError(() => {
      throw new Error(); // create a stacktrace
    }); // return empty Observable
  }

}
