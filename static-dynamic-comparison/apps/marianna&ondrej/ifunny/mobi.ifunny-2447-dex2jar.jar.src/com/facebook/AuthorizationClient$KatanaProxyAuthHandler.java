package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;

import java.util.Collection;

class AuthorizationClient$KatanaProxyAuthHandler
        extends AuthorizationClient.KatanaAuthHandler {
    private static final long serialVersionUID = 1L;
    private String applicationId;

    AuthorizationClient$KatanaProxyAuthHandler(AuthorizationClient paramAuthorizationClient) {
        super(paramAuthorizationClient);
    }

    private AuthorizationClient.Result handleResultOk(Intent paramIntent) {
        Bundle localBundle = paramIntent.getExtras();
        Object localObject = localBundle.getString("error");
        paramIntent = (Intent) localObject;
        if (localObject == null) {
            paramIntent = localBundle.getString("error_type");
        }
        String str2 = localBundle.getString("error_code");
        String str1 = localBundle.getString("error_message");
        localObject = str1;
        if (str1 == null) {
            localObject = localBundle.getString("error_description");
        }
        str1 = localBundle.getString("e2e");
        if (!Utility.isNullOrEmpty(str1)) {
            AuthorizationClient.access$200(this.this$0, this.applicationId, str1);
        }
        if ((paramIntent == null) && (str2 == null) && (localObject == null)) {
            paramIntent = AccessToken.createFromWebBundle(this.this$0.pendingRequest.getPermissions(), localBundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB);
            return AuthorizationClient.Result.createTokenResult(this.this$0.pendingRequest, paramIntent);
        }
        if (ServerProtocol.errorsProxyAuthDisabled.contains(paramIntent)) {
            return null;
        }
        if (ServerProtocol.errorsUserCanceled.contains(paramIntent)) {
            return AuthorizationClient.Result.createCancelResult(this.this$0.pendingRequest, null);
        }
        return AuthorizationClient.Result.createErrorResult(this.this$0.pendingRequest, paramIntent, (String) localObject, str2);
    }

    String getNameForLogging() {
        return "katana_proxy_auth";
    }

    boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramIntent == null) {
            paramIntent = AuthorizationClient.Result.createCancelResult(this.this$0.pendingRequest, "Operation canceled");
            if (paramIntent == null) {
                break label86;
            }
            this.this$0.completeAndValidate(paramIntent);
        }
        for (; ; ) {
            return true;
            if (paramInt2 == 0) {
                paramIntent = AuthorizationClient.Result.createCancelResult(this.this$0.pendingRequest, paramIntent.getStringExtra("error"));
                break;
            }
            if (paramInt2 != -1) {
                paramIntent = AuthorizationClient.Result.createErrorResult(this.this$0.pendingRequest, "Unexpected resultCode from authorization.", null);
                break;
            }
            paramIntent = handleResultOk(paramIntent);
            break;
            label86:
            this.this$0.tryNextHandler();
        }
    }

    boolean tryAuthorize(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest) {
        this.applicationId = paramAuthorizationRequest.getApplicationId();
        String str = AuthorizationClient.access$100();
        Intent localIntent = NativeProtocol.createProxyAuthIntent(this.this$0.context, paramAuthorizationRequest.getApplicationId(), paramAuthorizationRequest.getPermissions(), str, paramAuthorizationRequest.isRerequest(), paramAuthorizationRequest.getDefaultAudience());
        addLoggingExtra("e2e", str);
        return tryIntent(localIntent, paramAuthorizationRequest.getRequestCode());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$KatanaProxyAuthHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */