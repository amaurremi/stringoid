package com.facebook;

import java.util.ArrayList;

class AuthorizationClient$4
        implements Request.Callback {
    AuthorizationClient$4(AuthorizationClient paramAuthorizationClient, ArrayList paramArrayList1, ArrayList paramArrayList2) {
    }

    public void onCompleted(Response paramResponse) {
        try {
            paramResponse = Session.handlePermissionResponse(paramResponse);
            if (paramResponse != null) {
                this.val$grantedPermissions.addAll(paramResponse.getGrantedPermissions());
                this.val$declinedPermissions.addAll(paramResponse.getDeclinedPermissions());
            }
            return;
        } catch (Exception paramResponse) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */