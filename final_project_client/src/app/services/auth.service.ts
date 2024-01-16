import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, map, Observable, tap} from "rxjs";
import {RegisterData} from "../models/register-data";
import {httpConfig} from "../app.config";
import {AuthData} from "../models/auth-data";

@Injectable({
  providedIn: "root"
})
export class AuthService {
  private _isLoggedInSub$ = new BehaviorSubject<boolean>(false);
  private _apiUrl: string = `${httpConfig.apiUrl}/auth`;

  constructor(private _http: HttpClient) {}

  login(data: RegisterData): Observable<AuthData> {
    return this._http.post<AuthData>(`${this._apiUrl}/login`, data);
  }

  register(data: RegisterData): Observable<AuthData> {
    return this._http.post<AuthData>(`${this._apiUrl}/register`, data);
  }

  setLoggedIn(isLoggedIn: boolean): void {
    this._isLoggedInSub$.next(isLoggedIn);
  }

  getToken(): string | null {
    let token = localStorage.getItem('token');
    if (token) {
      let authData: AuthData = JSON.parse(token);
      return authData.token;
    }
    return null;
  }

  isLoggedIn(): Observable<boolean> {
    return this._isLoggedInSub$.asObservable()
      .pipe(
        map(isLoggedIn => {
          if (!isLoggedIn) {
            let token = localStorage.getItem('token');
            if (token) {
              let authData: AuthData = JSON.parse(token);
              return !!authData?.token;
            } else {
              return false;
            }
          }
          return isLoggedIn;
        })
      );
  }
}
