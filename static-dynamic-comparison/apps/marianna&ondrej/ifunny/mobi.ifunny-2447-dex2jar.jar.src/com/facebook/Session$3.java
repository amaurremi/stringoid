package com.facebook;

class Session$3
        implements AuthorizationClient.OnCompletedListener {
    Session$3(Session paramSession) {
    }

    public void onCompleted(AuthorizationClient.Result paramResult) {
        if (paramResult.code == AuthorizationClient.Result.Code.CANCEL) {
        }
        for (int i = 0; ; i = -1) {
            Session.access$1100(this.this$0, i, paramResult);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */