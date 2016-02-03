package com.facebook.internal;

import android.content.Context;

class LikeActionController$CreateLikeActionControllerWorkItem
        implements Runnable {
    private LikeActionController.CreationCallback callback;
    private Context context;
    private String objectId;

    LikeActionController$CreateLikeActionControllerWorkItem(Context paramContext, String paramString, LikeActionController.CreationCallback paramCreationCallback) {
        this.context = paramContext;
        this.objectId = paramString;
        this.callback = paramCreationCallback;
    }

    public void run() {
        LikeActionController.access$2900(this.context, this.objectId, this.callback);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$CreateLikeActionControllerWorkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */