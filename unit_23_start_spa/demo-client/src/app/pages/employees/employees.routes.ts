import {Routes} from "@angular/router";
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {EmployeeNewComponent} from "./employee-new/employee-new.component";

export const EMPLOYEES_ROUTES: Routes = [
  {
    path: '',
    component: EmployeeListComponent,
  },
  {
    path: 'new',
    component: EmployeeNewComponent,
  }
];
