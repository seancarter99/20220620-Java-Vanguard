import { Component } from '@angular/core';

// @Component decorator - metadata to tell Angular what to do
@Component({
  selector: 'app-root', // custom HTML element (tag) that represents your component
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent { // TS - typesafe JS 
  // :data_type
  title :String = 'helloworld';

  //  :return_type
  dan(param :any) :string { // any
    return param;
  }

}
