import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginRoutingModule } from "./login-routing.module"
import { LoginComponent } from "./login-component/login.component"

@NgModule({
    declarations: [
        LoginComponent
    ],
    imports: [
        CommonModule,
        LoginRoutingModule,
        MatInputModule,
        MatButtonModule,
        ReactiveFormsModule
    ],
    exports: [
    ]
})
export class LoginPageModule { }