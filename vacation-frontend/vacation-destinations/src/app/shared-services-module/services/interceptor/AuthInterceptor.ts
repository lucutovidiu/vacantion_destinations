// httpSetHeaders.interceptor.ts
import { Injectable } from '@angular/core';
import {
    HttpInterceptor,
    HttpRequest,
    HttpHandler,
    HttpEvent,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { AuthService } from '../auth-service/auth.service';

@Injectable({
    providedIn: "root"
})
export class AuthInterceptor implements HttpInterceptor {

    constructor(private authService: AuthService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let basicAuth: string = `Basic ${this.authService.getStoredSessionToken()}`;
        request = request.clone({ headers: request.headers.set("Authorization", basicAuth).set("X-Requested-With", "XMLHttpRequest") });
        return next.handle(request)
            .pipe(
                // map((event: HttpEvent<any>) => {
                //     if (event instanceof HttpResponse) {
                //         // console.log("Http Response event: ", event);
                //     }
                //     return event;
                // }),
                catchError(error => {
                    console.log("Error response status: ", error.status);
                    if (error.status === 401) {
                        this.authService.logout();
                    }
                    return throwError(error);
                }));
    }
}
