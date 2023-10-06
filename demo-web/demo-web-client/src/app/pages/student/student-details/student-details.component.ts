import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { AsyncPipe, NgIf } from "@angular/common";
import { BehaviorSubject, Observable, Subscription, switchMap, take } from "rxjs";

import { StudentData } from "../../../models/student.data";
import { StudentService } from "../../../services/student.service";

@Component({
  selector: 'app-student-details',
  standalone: true,
  templateUrl: './student-details.component.html',
  imports: [
    NgIf,
    AsyncPipe
  ]
})
export class StudentDetailsComponent implements OnInit, OnDestroy {

  private subscription = new Subscription();
  private subject = new BehaviorSubject<number>(0);

  readonly student$: Observable<StudentData> = this.subject.asObservable()
    .pipe(
      take(1),
      switchMap(id => this.service.loadById(id))
    );

  constructor(private router: Router, private service: StudentService) {
  }

  ngOnInit(): void {
    let url = this.router.routerState.snapshot.url;
    let splits = url.split('/');
    let id = splits[splits.length - 1];
    this.subject.next(Number.parseInt(id));
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
    this.subject.complete();
  }
}
