import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'plp',
    pathMatch: 'full'
  },
  {
    path: 'plp',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/plp/plp.routes').then(r => r.PLP_ROUTES)
  },
  {
    path: 'pdp',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/pdp/pdp.routes').then(r => r.PDP_ROUTES)
  },
  {
    path: 'cart',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/cart/cart.routes').then(r => r.CART_ROUTES)
  },
  {
    path: 'login',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/login/login.routes').then(r => r.LOGIN_ROUTES)
  },
  {
    path: 'register',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/register/register.routes').then(r => r.REGISTER_ROUTES)
  },
];
