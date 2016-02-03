package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;

class LikeActionController$PublishUnlikeRequestWrapper
        extends LikeActionController.AbstractRequestWrapper {
    private String unlikeToken;

    LikeActionController$PublishUnlikeRequestWrapper(LikeActionController paramLikeActionController, String paramString) {
        super(paramLikeActionController, null);
        this.unlikeToken = paramString;
        setRequest(new Request(LikeActionController.access$2700(paramLikeActionController), paramString, null, HttpMethod.DELETE));
    }

    protected void processError(FacebookRequestError paramFacebookRequestError) {
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$1000(), "Error unliking object with unlike token '%s' : %s", new Object[]{this.unlikeToken, paramFacebookRequestError});
        LikeActionController.access$2600(this.this$0, "publish_unlike", paramFacebookRequestError);
    }

    protected void processSuccess(Response paramResponse) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$PublishUnlikeRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */