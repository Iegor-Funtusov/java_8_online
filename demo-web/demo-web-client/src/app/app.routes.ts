import { Routes } from "@angular/router";

export const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'students',
    pathMatch: 'full',
  },
  {
    path: 'students',
    pathMatch: 'prefix',
    loadChildren: () => import('./pages/student/student.routes').then(r => r.studentRoutes)
  }
];
