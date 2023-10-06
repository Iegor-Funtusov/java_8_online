import { Component } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {StudentService} from "../../../services/student.service";
import {StudentData} from "../../../models/student.data";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-new',
  standalone: true,
  templateUrl: './student-new.component.html',
  imports: [
    ReactiveFormsModule
  ]
})
export class StudentNewComponent {

  form: FormGroup = this.fb.group({
    firstName: new FormControl(null, [Validators.required]),
    lastName: new FormControl(null, [Validators.required]),
    age: new FormControl(null, [Validators.required]),
  });

  constructor(private fb: FormBuilder, private service: StudentService, private router: Router) {}

  create(): void {
    console.log('this.form.valid', this.form.valid)
    console.log('this.form', this.form.value)
    if (this.form.valid) {
      let data: StudentData = { ...this.form.value };
      this.service.create(data)
        .subscribe(
          () => this.router.navigateByUrl('students'),
          (res) => {
            console.log('error', res)
          }
        );
    }
  }
}
