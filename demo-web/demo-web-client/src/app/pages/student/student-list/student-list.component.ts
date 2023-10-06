import { Component } from '@angular/core';
import { Router } from "@angular/router";
import { AsyncPipe, NgForOf } from "@angular/common";
import { Observable } from "rxjs";

import { StudentService } from "../../../services/student.service";
import { StudentData } from "../../../models/student.data";

@Component({
  selector: 'app-student-list',
  standalone: true,
  templateUrl: './student-list.component.html',
  imports: [
    AsyncPipe,
    NgForOf
  ]
})
export class StudentListComponent {

  students$: Observable<StudentData[]> = this.service.loadAll();

  constructor(private service: StudentService, private router: Router) {}

  delete(id?: number): void {
    if (id) {
      this.service.delete(id)
        .subscribe(
          () => {
            this.students$ = this.service.loadAll();
          },
          (res) => {
            console.log('error', res)
          }
        );
    }
  }

  details(id?: number): void {
    if (id) {
      this.router.navigateByUrl(`students/${id}`)
    }
  }
}
