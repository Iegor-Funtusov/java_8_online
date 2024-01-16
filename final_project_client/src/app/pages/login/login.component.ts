import {Component, OnDestroy} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {NgIf} from "@angular/common";
import {RegisterData} from "../../models/register-data";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './login.component.html',
})
export class LoginComponent implements OnDestroy {
  private _subscription = new Subscription();

  form: FormGroup = this._fb.group({
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [Validators.required]),
  });

  constructor(private _fb: FormBuilder, private _auth: AuthService, private _router: Router) {
  }

  login(): void {
    if (this.form.valid) {
      console.log(this.form);
      let data: RegisterData = { ...this.form.value };
      this._subscription.add(
        this._auth.login(data).subscribe(
          (auth) => {
            console.log('auth', auth);
            localStorage.setItem('token', JSON.stringify(auth));
            this._auth.setLoggedIn(true);
            this._router.navigateByUrl('/plp')
          },
          (error) => {
            console.log('error', error)
            localStorage.removeItem('token')
            this._auth.setLoggedIn(false);
          }
        )
      );
    }
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
