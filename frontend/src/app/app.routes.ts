import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';

export const routes: Routes = [
  // 1. If the user goes to localhost:4200/login, show the Login screen
  { path: 'login', component: LoginComponent },

  // 2. If the user types nothing (localhost:4200), redirect them to /login
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];
