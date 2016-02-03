package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.RequestBatch;
import com.facebook.Response;

abstract class LikeActionController$AbstractRequestWrapper {
    FacebookRequestError error;
    protected String objectId;
    private Request request;

    protected LikeActionController$AbstractRequestWrapper(LikeActionController paramLikeActionController, String paramString) {
        this.objectId = paramString;
    }

    void addToBatch(RequestBatch paramRequestBatch) {
        paramRequestBatch.add(this.request);
    }

    protected void processError(FacebookRequestError paramFacebookRequestError) {
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$1000(), "Error running request for object '%s' : %s", new Object[]{this.objectId, paramFacebookRequestError});
    }

    protected abstract void processSuccess(Response paramResponse);

    protected void setRequest(Request paramRequest) {
        this.request = paramRequest;
        paramRequest.setVersion("v2.1");
        paramRequest.setCallback(new LikeActionController.AbstractRequestWrapper .1 (this));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$AbstractRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */