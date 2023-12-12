import {Injectable} from "@angular/core";
import {BaseApiConnector} from "./base-api.connector";
import {EmployeeRequestData} from "../models/request/employee-request.data";
import {EmployeeResponseData} from "../models/response/employee-response.data";
import {PageResponseData} from "../models/response/page-response.data";
import {map, Observable} from "rxjs";
import {httpConfig} from "../app.config";

@Injectable({
  providedIn: 'root'
})
export class EmployeeConnector {

  private _apiUrl: string = `${httpConfig.apiUrl}/employees`;

  constructor(private _connector: BaseApiConnector<EmployeeRequestData, EmployeeResponseData | PageResponseData<EmployeeResponseData>>) {}

  create(data: EmployeeRequestData): Observable<any> {
    console.log('data', data)
    return this._connector.post(this._apiUrl, data);
  }

  findAll(
    currentPage: number = 1,
    pageSize: number = 10,
    sortBy: string = 'id',
    sortType: string = 'asc'
  ): Observable<PageResponseData<EmployeeResponseData>> {
    return this._connector.getAll(this._apiUrl, currentPage, pageSize, sortBy, sortType)
      .pipe(
        map(res => res as PageResponseData<EmployeeResponseData>)
      );
  }

  findById(id: number): Observable<EmployeeResponseData> {
    return this._connector.getById(this._apiUrl, id)
      .pipe(
        map(res => res as EmployeeResponseData)
      );
  }

  update(id: number, data: EmployeeRequestData): Observable<any> {
    return this._connector.update(this._apiUrl, id, data);
  }

  delete(id: number): Observable<any> {
    return this._connector.delete(this._apiUrl, id);
  }
}
