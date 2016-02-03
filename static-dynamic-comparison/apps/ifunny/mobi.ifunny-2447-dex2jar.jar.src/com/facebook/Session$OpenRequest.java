package com.facebook;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.util.List;

public final class Session$OpenRequest
        extends Session.AuthorizationRequest {
    private static final long serialVersionUID = 1L;

    public Session$OpenRequest(Activity paramActivity) {
        super(paramActivity);
    }

    public Session$OpenRequest(Fragment paramFragment) {
        super(paramFragment);
    }

    public final OpenRequest setCallback(Session.StatusCallback paramStatusCallback) {
        super.setCallback(paramStatusCallback);
        return this;
    }

    public final OpenRequest setDefaultAudience(SessionDefaultAudience paramSessionDefaultAudience) {
        super.setDefaultAudience(paramSessionDefaultAudience);
        return this;
    }

    public final OpenRequest setLoginBehavior(SessionLoginBehavior paramSessionLoginBehavior) {
        super.setLoginBehavior(paramSessionLoginBehavior);
        return this;
    }

    public final OpenRequest setPermissions(List<String> paramList) {
        super.setPermissions(paramList);
        return this;
    }

    public final OpenRequest setPermissions(String... paramVarArgs) {
        super.setPermissions(paramVarArgs);
        return this;
    }

    public final OpenRequest setRequestCode(int paramInt) {
        super.setRequestCode(paramInt);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$OpenRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */