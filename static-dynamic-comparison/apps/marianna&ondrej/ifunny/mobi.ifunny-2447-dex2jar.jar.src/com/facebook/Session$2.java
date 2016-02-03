package com.facebook;

class Session$2
        implements Request.Callback {
    Session$2(Session paramSession) {
    }

    public void onCompleted(Response arg1) {
        Session.PermissionsPair localPermissionsPair = Session.handlePermissionResponse( ???);
        if (localPermissionsPair != null) {
            synchronized (Session.access$200(this.this$0)) {
                Session.access$302(this.this$0, AccessToken.createFromTokenWithRefreshedPermissions(Session.access$300(this.this$0), localPermissionsPair.getGrantedPermissions(), localPermissionsPair.getDeclinedPermissions()));
                this.this$0.postStateChange(Session.access$400(this.this$0), SessionState.OPENED_TOKEN_UPDATED, null);
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */