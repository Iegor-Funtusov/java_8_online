import {Component, OnDestroy} from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { EmployeeService } from "../../../services/employee.service";
import { EmployeeRequestData } from "../../../models/request/employee-request.data";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-new',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './employee-new.component.html',
})
export class EmployeeNewComponent implements OnDestroy {

  private _subscription = new Subscription();

  form: FormGroup = this._fb.group({
    firstName: new FormControl(null, [Validators.required]),
    lastName: new FormControl(null, [Validators.required]),
    age: new FormControl(null, [Validators.required]),
  });

  constructor(
    private _fb: FormBuilder,
    private _employeeService: EmployeeService,
    private _router: Router) {
  }

  create(): void {
    if (this.form.valid) {
      const data: EmployeeRequestData = { ...this.form.value };
      this._subscription.add(
        this._employeeService.create(data)
          .subscribe(
            (res) => {
              this._router.navigateByUrl('/employees')
            },
            (error) => { console.log('error', error) }
          )
      );
    }
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
