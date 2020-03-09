import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpEvent, HttpErrorResponse, HttpResponse } from '@angular/common/http';

import { AuthRepo } from 'shared_services/repositories/Auth/AuthRepo';
import { SessionUserInfo } from 'shared_services/repositories/Auth/SessionUserInfo';
import { environment } from "environments/environment"
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { User } from 'app/shared-dtos/User';

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    constructor(private router: Router, private http: HttpClient, private authRepo: AuthRepo) { }

    public get isUserAuthenticated(): boolean {
        let auth: SessionUserInfo = this.authRepo.authInfo;
        if (auth && auth.isAuthenticated && auth.token) {
            return true;
        } else
            return false;
    }

    public login(user: User): Promise<boolean> {
        let token = window.btoa(user.username + ":" + user.password);
        this.authRepo.authInfo = new SessionUserInfo(token, false);

        return new Promise((resolve, reject) => {
            this.http.get(environment.auth.LOGIN_ENPOINT, {
                observe: 'response'
            })
                .pipe(
                    catchError((error: HttpErrorResponse) => {
                        this.logout();
                        reject(false);
                        return throwError(error);
                    })
                )
                .subscribe((res: HttpResponse<any>) => {
                    if (res.status === 200 && res.body.status === "Authenticated") {
                        this.authRepo.authInfo = new SessionUserInfo(token, true);
                        resolve(true);
                    }
                })
        });
    }

    public logout() {
        this.authRepo.clearSession();
    }

    public getStoredSessionToken(): string {
        return this.authRepo.authInfo.token;
    }
}