import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {PageResponseData} from "../models/page-response.data";
import {EmployeeData} from "../models/employee.data";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployeeApiService {

  constructor(private _http: HttpClient) { }

  loadEmployees(): Observable<PageResponseData<EmployeeData>> {
    return this._http.get('http://localhost:8080/employees') as Observable<PageResponseData<EmployeeData>>;
  }
}
