import { Component } from '@angular/core';
import {EmployeeApiService} from "../../services/employee-api.service";
import {Observable} from "rxjs";
import {PageResponseData} from "../../models/page-response.data";
import {EmployeeData} from "../../models/employee.data";
import {AsyncPipe, JsonPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [
    NgIf,
    AsyncPipe,
    JsonPipe
  ],
  templateUrl: './employees.component.html',
})
export class EmployeesComponent {

  employees$: Observable<PageResponseData<EmployeeData>> = this._employeeApiService.loadEmployees();

  constructor(private _employeeApiService: EmployeeApiService) {
  }
}
