import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { EmployeeTableComponent } from './employee-table/employee-table.component';

// 2. we configure routes
const routes: Routes = [{
  path : 'add-employee',    //    /add-employee   ->   EmployeeFormComponent
  component: EmployeeFormComponent
}, {
  path: 'list-employees', 
  component: EmployeeTableComponent
}];  

@NgModule({
  // 1. import RouterModule
  imports: [RouterModule.forRoot(routes)],
  // 3. export back to Angular
  exports: [RouterModule]
})
export class AppRoutingModule { }
