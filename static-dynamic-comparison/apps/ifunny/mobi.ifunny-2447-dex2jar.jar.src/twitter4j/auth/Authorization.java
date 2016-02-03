package twitter4j.auth;

import java.io.Serializable;

import twitter4j.HttpRequest;

public abstract interface Authorization
        extends Serializable {
    public abstract String getAuthorizationHeader(HttpRequest paramHttpRequest);

    public abstract boolean isEnabled();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/auth/Authorization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */