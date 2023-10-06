import { Routes } from "@angular/router";
import { StudentListComponent } from "./student-list/student-list.component";
import { StudentNewComponent } from "./student-new/student-new.component";
import { StudentDetailsComponent } from "./student-details/student-details.component";

export const studentRoutes: Routes = [
  {
    path: '',
    component: StudentListComponent
  },
  {
    path: 'new',
    component: StudentNewComponent
  },
  {
    path: ':id',
    component: StudentDetailsComponent
  }
];
