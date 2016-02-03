package com.facebook.internal;

import com.facebook.RequestBatch;

class LikeActionController$8
        implements LikeActionController.RequestCompletionCallback {
    LikeActionController$8(LikeActionController paramLikeActionController) {
    }

    public void onComplete() {
        LikeActionController.GetOGObjectLikesRequestWrapper localGetOGObjectLikesRequestWrapper = new LikeActionController.GetOGObjectLikesRequestWrapper(this.this$0, LikeActionController.access$1400(this.this$0));
        LikeActionController.GetEngagementRequestWrapper localGetEngagementRequestWrapper = new LikeActionController.GetEngagementRequestWrapper(this.this$0, LikeActionController.access$1400(this.this$0));
        RequestBatch localRequestBatch = new RequestBatch();
        localGetOGObjectLikesRequestWrapper.addToBatch(localRequestBatch);
        localGetEngagementRequestWrapper.addToBatch(localRequestBatch);
        localRequestBatch.addCallback(new LikeActionController .8 .1
        (this, localGetOGObjectLikesRequestWrapper, localGetEngagementRequestWrapper));
        localRequestBatch.executeAsync();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */