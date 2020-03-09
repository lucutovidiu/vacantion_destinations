export class SessionUserInfo {
    token: string;
    isAuthenticated: boolean;
    constructor(token: string, isAuthenticated: boolean) {
        this.token = token;
        this.isAuthenticated = isAuthenticated;
    }
}