import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExampleComponent } from './example/example.component';
import { EmployeeTableComponent } from './employee-table/employee-table.component';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { FormsModule } from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {TableModule} from 'primeng/table';

@NgModule({
  declarations: [
    AppComponent,
    ExampleComponent,
    EmployeeTableComponent,
    EmployeeFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    FormsModule,
    ButtonModule, 
    InputTextModule, 
    TableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
