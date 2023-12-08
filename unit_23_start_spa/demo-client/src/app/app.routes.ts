import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'employees',
    pathMatch: 'full'
  },
  {
    path: 'employees',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/employees/employees.routes').then(r => r.EMPLOYEES_ROUTES)
  },
  {
    path: 'departments',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/departments/departments.routes').then(r => r.DEPARTMENTS_ROUTES)
  }
];
