package com.facebook;

import com.facebook.model.GraphUser;

final class Request$1
        implements Request.Callback {
    Request$1(Request.GraphUserCallback paramGraphUserCallback) {
    }

    public void onCompleted(Response paramResponse) {
        if (this.val$callback != null) {
            this.val$callback.onCompleted((GraphUser) paramResponse.getGraphObjectAs(GraphUser.class), paramResponse);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Request$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */