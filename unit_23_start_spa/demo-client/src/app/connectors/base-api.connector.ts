import { Injectable } from "@angular/core";
import { ApiResponseData } from "../models/response/api-response.data";
import { ApiRequestData } from "../models/request/api-request.data";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PageResponseData} from "../models/response/page-response.data";

@Injectable({
  providedIn: 'root'
})
export class BaseApiConnector<REQ extends ApiRequestData, RES extends ApiResponseData | PageResponseData<RES>> {

  constructor(private _http: HttpClient) { }

  post(url: string, data: REQ): Observable<any> {
    console.log('url', url)
    return this._http.post(url, data);
  }

  getAll(
    url: string,
    currentPage: number = 1,
    pageSize: number = 10,
    sortBy: string = 'id',
    sortType: string = 'asc'): Observable<RES | PageResponseData<RES>> {
    const buildUrl: string = `${url}?currentPage=${currentPage}&pageSize=${pageSize}&sortBy=${sortBy}&sortType=${sortType}`;
    return this._http.get<RES | PageResponseData<RES>>(buildUrl);
  }

  getById(url: string, id: number): Observable<RES> {
    const buildUrl: string = `${url}/${id}`;
    return this._http.get<RES>(buildUrl);
  }

  update(url: string, id: number, data: REQ): Observable<any> {
    const buildUrl: string = `${url}/${id}`;
    return this._http.put(buildUrl, data);
  }

  delete(url: string, id: number): Observable<any> {
    const buildUrl: string = `${url}/${id}`;
    return this._http.delete(buildUrl);
  }
}
