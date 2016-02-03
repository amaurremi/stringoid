package com.facebook.internal;

import com.facebook.Request.Callback;
import com.facebook.Response;

class LikeActionController$AbstractRequestWrapper$1
        implements Request.Callback {
    LikeActionController$AbstractRequestWrapper$1(LikeActionController.AbstractRequestWrapper paramAbstractRequestWrapper) {
    }

    public void onCompleted(Response paramResponse) {
        this.this$1.error = paramResponse.getError();
        if (this.this$1.error != null) {
            this.this$1.processError(this.this$1.error);
            return;
        }
        this.this$1.processSuccess(paramResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$AbstractRequestWrapper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */