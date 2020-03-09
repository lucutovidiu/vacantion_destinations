import { Injectable } from '@angular/core';
import { SessionUserInfo } from './SessionUserInfo';
import { SiteConfig } from 'shared_services/websiteSettings/SiteConfig';

@Injectable({
    providedIn: "root"
})
export class AuthRepo {
    private _authInfo: SessionUserInfo;

    public get authInfo() {
        if (window) {
            let auth: SessionUserInfo = JSON.parse(window.sessionStorage.getItem(SiteConfig.sessionStorageKey));
            if (auth) {
                return this._authInfo;
            } else
                return new SessionUserInfo("default", false);
        }
        return new SessionUserInfo("default", false);
    }

    public set authInfo(authInfo: SessionUserInfo) {
        if (window) {
            window.sessionStorage.setItem(SiteConfig.sessionStorageKey, JSON.stringify(authInfo));
        }
        this._authInfo = authInfo;
    }

    public clearSession(): void {
        if (window)
            window.sessionStorage.setItem(SiteConfig.sessionStorageKey, JSON.stringify(new SessionUserInfo("default", false)));
    }
}

