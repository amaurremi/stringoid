package com.facebook;

import android.text.TextUtils;
import com.facebook.internal.Utility;

import java.io.Serializable;
import java.util.Map;

class AuthorizationClient$Result
        implements Serializable {
    private static final long serialVersionUID = 1L;
    final AuthorizationClient.Result.Code code;
    final String errorCode;
    final String errorMessage;
    Map<String, String> loggingExtras;
    final AuthorizationClient.AuthorizationRequest request;
    final AccessToken token;

    private AuthorizationClient$Result(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, AuthorizationClient.Result.Code paramCode, AccessToken paramAccessToken, String paramString1, String paramString2) {
        this.request = paramAuthorizationRequest;
        this.token = paramAccessToken;
        this.errorMessage = paramString1;
        this.code = paramCode;
        this.errorCode = paramString2;
    }

    static Result createCancelResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString) {
        return new Result(paramAuthorizationRequest, AuthorizationClient.Result.Code.CANCEL, null, paramString, null);
    }

    static Result createErrorResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString1, String paramString2) {
        return createErrorResult(paramAuthorizationRequest, paramString1, paramString2, null);
    }

    static Result createErrorResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString1, String paramString2, String paramString3) {
        paramString1 = TextUtils.join(": ", Utility.asListNoNulls(new String[]{paramString1, paramString2}));
        return new Result(paramAuthorizationRequest, AuthorizationClient.Result.Code.ERROR, null, paramString1, paramString3);
    }

    static Result createTokenResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, AccessToken paramAccessToken) {
        return new Result(paramAuthorizationRequest, AuthorizationClient.Result.Code.SUCCESS, paramAccessToken, null, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */