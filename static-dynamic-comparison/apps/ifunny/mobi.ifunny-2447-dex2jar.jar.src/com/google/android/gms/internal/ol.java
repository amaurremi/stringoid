package com.google.android.gms.internal;

public enum ol {
    public static String T="Error";
    public static String U = "status";
    private final String V;

    static {
        A = new ol("ALREADY_HAS_GMAIL", 26, "ALREADY_HAS_GMAIL");
        B = new ol("BAD_REQUEST", 27, "BadRequest");
        C = new ol("BAD_USERNAME", 28, "BadUsername");
        D = new ol("LOGIN_FAIL", 29, "LoginFail");
        E = new ol("NOT_LOGGED_IN", 30, "NotLoggedIn");
        F = new ol("NO_GMAIL", 31, "NoGmail");
        G = new ol("REQUEST_DENIED", 32, "RequestDenied");
        H = new ol("SERVER_ERROR", 33, "ServerError");
        I = new ol("USERNAME_UNAVAILABLE", 34, "UsernameUnavailable");
        J = new ol("DELETED_GMAIL", 35, "DeletedGmail");
        K = new ol("SOCKET_TIMEOUT", 36, "SocketTimeout");
        L = new ol("EXISTING_USERNAME", 37, "ExistingUsername");
        M = new ol("NEEDS_BROWSER", 38, "NeedsBrowser");
        N = new ol("GPLUS_OTHER", 39, "GPlusOther");
        O = new ol("GPLUS_NICKNAME", 40, "GPlusNickname");
        P = new ol("GPLUS_INVALID_CHAR", 41, "GPlusInvalidChar");
        Q = new ol("GPLUS_INTERSTITIAL", 42, "GPlusInterstitial");
        R = new ol("GPLUS_PROFILE_ERROR", 43, "ProfileUpgradeError");
        S = new ol("INVALID_SCOPE", 44, "INVALID_SCOPE");
        W = new ol[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S};
    }

    private ol(String paramString) {
        this.V = paramString;
    }

    public String a() {
        return this.V;
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */