import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotFoundComponent } from "shared-components/not-found/not-found.component"

const routes: Routes = [
  {
    path: "",
    loadChildren: "page-modules/home-page/home.page.module#HomePageModule",
    pathMatch: "full"
  },
  {
    path: "login",
    loadChildren: "page-modules/login-page/login.page.module#LoginPageModule"
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
