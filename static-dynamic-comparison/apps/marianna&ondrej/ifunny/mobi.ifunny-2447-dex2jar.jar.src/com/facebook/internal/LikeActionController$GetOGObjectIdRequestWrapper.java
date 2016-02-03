package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;
import org.json.JSONObject;

class LikeActionController$GetOGObjectIdRequestWrapper
        extends LikeActionController.AbstractRequestWrapper {
    String verifiedObjectId;

    LikeActionController$GetOGObjectIdRequestWrapper(LikeActionController paramLikeActionController, String paramString) {
        super(paramLikeActionController, paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("fields", "og_object.fields(id)");
        localBundle.putString("ids", paramString);
        setRequest(new Request(LikeActionController.access$2700(paramLikeActionController), "", localBundle, HttpMethod.GET));
    }

    protected void processError(FacebookRequestError paramFacebookRequestError) {
        if (paramFacebookRequestError.getErrorMessage().contains("og_object")) {
            this.error = null;
            return;
        }
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$1000(), "Error getting the FB id for object '%s' : %s", new Object[]{this.objectId, paramFacebookRequestError});
    }

    protected void processSuccess(Response paramResponse) {
        paramResponse = Utility.tryGetJSONObjectFromResponse(paramResponse.getGraphObject(), this.objectId);
        if (paramResponse != null) {
            paramResponse = paramResponse.optJSONObject("og_object");
            if (paramResponse != null) {
                this.verifiedObjectId = paramResponse.optString("id");
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$GetOGObjectIdRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */