import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedComponentsModule } from "shared-components/shared-components-module.module"
import { HomePageModule } from "page-modules/home-page/home.page.module";
import { LoginPageModule } from "page-modules/login-page/login.page.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { SharedServicesModule } from "shared_services/shared-services.module"

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HomePageModule,
    SharedComponentsModule,
    LoginPageModule,
    BrowserAnimationsModule,
    SharedServicesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
