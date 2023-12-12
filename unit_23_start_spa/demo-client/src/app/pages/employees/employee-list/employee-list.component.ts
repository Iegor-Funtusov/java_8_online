import { Component } from '@angular/core';
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {Observable} from "rxjs";
import {PageResponseData} from "../../../models/response/page-response.data";
import {EmployeeResponseData} from "../../../models/response/employee-response.data";
import {EmployeeService} from "../../../services/employee.service";

@Component({
  selector: 'app-employee-list',
  standalone: true,
    imports: [
        AsyncPipe,
        NgForOf,
        NgIf
    ],
  templateUrl: './employee-list.component.html',
})
export class EmployeeListComponent {

  employees$: Observable<PageResponseData<EmployeeResponseData>> = this._employeeService.loadEmployees();

  constructor(private _employeeService: EmployeeService) {
  }
}
