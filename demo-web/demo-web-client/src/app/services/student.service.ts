import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {StudentData} from "../models/student.data";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private apiUrl: string = 'http://localhost:8080/api/students';

  constructor(private http: HttpClient) { }

  loadAll(): Observable<StudentData[]> {
    return this.http.get<StudentData[]>(this.apiUrl);
  }

  loadById(id: number): Observable<StudentData> {
    return this.http.get<StudentData>(`${this.apiUrl}/${id}`);
  }

  create(data: StudentData): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }

  update(data: StudentData, id: number): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, data);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
