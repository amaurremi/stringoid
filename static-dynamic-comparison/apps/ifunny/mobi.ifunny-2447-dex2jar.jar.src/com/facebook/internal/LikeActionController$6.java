package com.facebook.internal;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.RequestBatch;

class LikeActionController$6
        implements LikeActionController.RequestCompletionCallback {
    LikeActionController$6(LikeActionController paramLikeActionController, Activity paramActivity, Bundle paramBundle) {
    }

    public void onComplete() {
        if (Utility.isNullOrEmpty(LikeActionController.access$1400(this.this$0))) {
            localObject = new Bundle();
            ((Bundle) localObject).putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
            LikeActionController.access$1300(LikeActionController.access$1200(this.this$0), this.this$0, "com.facebook.sdk.LikeActionController.DID_ERROR", (Bundle) localObject);
            return;
        }
        Object localObject = new RequestBatch();
        LikeActionController.PublishLikeRequestWrapper localPublishLikeRequestWrapper = new LikeActionController.PublishLikeRequestWrapper(this.this$0, LikeActionController.access$1400(this.this$0));
        localPublishLikeRequestWrapper.addToBatch((RequestBatch) localObject);
        ((RequestBatch) localObject).addCallback(new LikeActionController .6 .1 (this, localPublishLikeRequestWrapper));
        ((RequestBatch) localObject).executeAsync();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */