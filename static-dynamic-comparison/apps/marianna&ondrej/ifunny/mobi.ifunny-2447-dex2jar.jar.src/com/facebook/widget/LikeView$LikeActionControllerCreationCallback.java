package com.facebook.widget;

import com.facebook.internal.LikeActionController;
import com.facebook.internal.LikeActionController.CreationCallback;

class LikeView$LikeActionControllerCreationCallback
        implements LikeActionController.CreationCallback {
    private boolean isCancelled;

    private LikeView$LikeActionControllerCreationCallback(LikeView paramLikeView) {
    }

    public void cancel() {
        this.isCancelled = true;
    }

    public void onComplete(LikeActionController paramLikeActionController) {
        if (this.isCancelled) {
            return;
        }
        LikeView.access$1000(this.this$0, paramLikeActionController);
        LikeView.access$700(this.this$0);
        LikeView.access$1102(this.this$0, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/LikeView$LikeActionControllerCreationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */