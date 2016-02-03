package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Response;
import org.json.JSONObject;

class LikeActionController$GetEngagementRequestWrapper
        extends LikeActionController.AbstractRequestWrapper {
    String likeCountStringWithLike;
    String likeCountStringWithoutLike;
    String socialSentenceStringWithLike;
    String socialSentenceStringWithoutLike;

    LikeActionController$GetEngagementRequestWrapper(LikeActionController paramLikeActionController, String paramString) {
        super(paramLikeActionController, paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
        setRequest(new Request(LikeActionController.access$2700(paramLikeActionController), paramString, localBundle, HttpMethod.GET));
    }

    protected void processError(FacebookRequestError paramFacebookRequestError) {
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$1000(), "Error fetching engagement for object '%s' : %s", new Object[]{this.objectId, paramFacebookRequestError});
        LikeActionController.access$2600(this.this$0, "get_engagement", paramFacebookRequestError);
    }

    protected void processSuccess(Response paramResponse) {
        paramResponse = Utility.tryGetJSONObjectFromResponse(paramResponse.getGraphObject(), "engagement");
        if (paramResponse != null) {
            this.likeCountStringWithLike = paramResponse.optString("count_string_with_like");
            this.likeCountStringWithoutLike = paramResponse.optString("count_string_without_like");
            this.socialSentenceStringWithLike = paramResponse.optString("social_sentence_with_like");
            this.socialSentenceStringWithoutLike = paramResponse.optString("social_sentence_without_like");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$GetEngagementRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */