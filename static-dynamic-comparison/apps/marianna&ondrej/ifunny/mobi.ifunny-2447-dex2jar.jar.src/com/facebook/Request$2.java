package com.facebook;

import com.facebook.model.GraphUser;

final class Request$2
        implements Request.Callback {
    Request$2(Request.GraphUserListCallback paramGraphUserListCallback) {
    }

    public void onCompleted(Response paramResponse) {
        if (this.val$callback != null) {
            this.val$callback.onCompleted(Request.access$000(paramResponse, GraphUser.class), paramResponse);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Request$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */