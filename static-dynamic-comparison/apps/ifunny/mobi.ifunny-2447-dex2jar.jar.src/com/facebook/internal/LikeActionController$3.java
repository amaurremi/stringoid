package com.facebook.internal;

final class LikeActionController$3
        implements Runnable {
    LikeActionController$3(LikeActionController.CreationCallback paramCreationCallback, LikeActionController paramLikeActionController) {
    }

    public void run() {
        this.val$callback.onComplete(this.val$controller);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */