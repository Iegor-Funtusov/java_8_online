import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {PageResponseData} from "../models/response/page-response.data";
import {EmployeeConnector} from "../connectors/employee.connector";
import {EmployeeResponseData} from "../models/response/employee-response.data";
import {EmployeeRequestData} from "../models/request/employee-request.data";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private _employeeConnector: EmployeeConnector) { }

  loadEmployees(): Observable<PageResponseData<EmployeeResponseData>> {
    return this._employeeConnector.findAll();
  }

  create(data: EmployeeRequestData): Observable<any> {
    console.log('data', data)
    return this._employeeConnector.create(data);
  }
}
