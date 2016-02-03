package com.facebook;

import com.facebook.model.GraphUser;

import java.util.ArrayList;

class AuthorizationClient$3
        implements Request.Callback {
    AuthorizationClient$3(AuthorizationClient paramAuthorizationClient, ArrayList paramArrayList) {
    }

    public void onCompleted(Response paramResponse) {
        try {
            paramResponse = (GraphUser) paramResponse.getGraphObjectAs(GraphUser.class);
            if (paramResponse != null) {
                this.val$fbids.add(paramResponse.getId());
            }
            return;
        } catch (Exception paramResponse) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AuthorizationClient$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */