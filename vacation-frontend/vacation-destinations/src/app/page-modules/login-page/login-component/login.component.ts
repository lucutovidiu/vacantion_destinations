import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthService } from 'shared_services/services/auth-service/auth.service';
import { User } from 'app/shared-dtos/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  hasLoginFailed: boolean = false;
  hasLoginSucced: boolean = false;

  constructor(private fb: FormBuilder, public authService: AuthService, private router: Router) { }

  ngOnInit() {
    console.log(this.authService.isUserAuthenticated)
    this.loginForm = this.fb.group({
      username: ['', [
        Validators.required,
        Validators.minLength(3)
      ]],
      password: ['', [
        Validators.required
      ]]
    })
  }

  private setLoginStatus(succeded: boolean) {
    if (succeded) {
      this.hasLoginFailed = false;
      this.hasLoginSucced = true;
    } else {
      this.hasLoginFailed = true;
      this.hasLoginSucced = false;
    }
  }

  public subbmitLogin() {
    if (this.loginForm.valid) {
      let user: User = this.loginForm.value;
      this.authService.login(new User(user.username, user.password))
        .then((response: boolean) => {
          this.setLoginStatus(response);
          setTimeout(() => {
            this.router.navigate(["/"]);
          }, 1000);
        })
        .catch((error: boolean) => {
          this.setLoginStatus(error);
        });
    }
  }
}
