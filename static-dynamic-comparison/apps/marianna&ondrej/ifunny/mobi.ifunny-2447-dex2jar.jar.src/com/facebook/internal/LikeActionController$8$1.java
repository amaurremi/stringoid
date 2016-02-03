package com.facebook.internal;

import com.facebook.LoggingBehavior;
import com.facebook.RequestBatch;
import com.facebook.RequestBatch.Callback;

class LikeActionController$8$1
        implements RequestBatch.Callback {
    LikeActionController$8$1(LikeActionController.8param8, LikeActionController.GetOGObjectLikesRequestWrapper paramGetOGObjectLikesRequestWrapper, LikeActionController.GetEngagementRequestWrapper paramGetEngagementRequestWrapper) {
    }

    public void onBatchCompleted(RequestBatch paramRequestBatch) {
        if ((this.val$objectLikesRequest.error != null) || (this.val$engagementRequest.error != null)) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.access$1000(), "Unable to refresh like state for id: '%s'", new Object[]{LikeActionController.access$2400(this.this$1.this$0)});
            return;
        }
        LikeActionController.access$900(this.this$1.this$0, this.val$objectLikesRequest.objectIsLiked, this.val$engagementRequest.likeCountStringWithLike, this.val$engagementRequest.likeCountStringWithoutLike, this.val$engagementRequest.socialSentenceStringWithLike, this.val$engagementRequest.socialSentenceStringWithoutLike, this.val$objectLikesRequest.unlikeToken);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$8$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */