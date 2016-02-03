package com.facebook.internal;

import com.facebook.AppEventsLogger;
import com.facebook.RequestBatch;
import com.facebook.RequestBatch.Callback;

class LikeActionController$6$1
        implements RequestBatch.Callback {
    LikeActionController$6$1(LikeActionController.6param6, LikeActionController.PublishLikeRequestWrapper paramPublishLikeRequestWrapper) {
    }

    public void onBatchCompleted(RequestBatch paramRequestBatch) {
        LikeActionController.access$1502(this.this$1.this$0, false);
        if (this.val$likeRequest.error != null) {
            LikeActionController.access$900(this.this$1.this$0, false, LikeActionController.access$1600(this.this$1.this$0), LikeActionController.access$1700(this.this$1.this$0), LikeActionController.access$1800(this.this$1.this$0), LikeActionController.access$1900(this.this$1.this$0), LikeActionController.access$2000(this.this$1.this$0));
            LikeActionController.access$2100(this.this$1.this$0, this.this$1.val$activity, this.this$1.val$analyticsParameters);
            return;
        }
        LikeActionController.access$2002(this.this$1.this$0, Utility.coerceValueIfNullOrEmpty(this.val$likeRequest.unlikeToken, null));
        LikeActionController.access$2202(this.this$1.this$0, true);
        LikeActionController.access$800(this.this$1.this$0).logSdkEvent("fb_like_control_did_like", null, this.this$1.val$analyticsParameters);
        LikeActionController.access$2300(this.this$1.this$0, this.this$1.val$activity, this.this$1.val$analyticsParameters);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$6$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */