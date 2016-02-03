package com.facebook;

import com.facebook.model.GraphPlace;

final class Request$3
        implements Request.Callback {
    Request$3(Request.GraphPlaceListCallback paramGraphPlaceListCallback) {
    }

    public void onCompleted(Response paramResponse) {
        if (this.val$callback != null) {
            this.val$callback.onCompleted(Request.access$000(paramResponse, GraphPlace.class), paramResponse);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Request$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */