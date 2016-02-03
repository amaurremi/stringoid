package com.facebook.internal;

import android.content.Intent;

import java.util.UUID;

final class LikeActionController$1
        implements LikeActionController.CreationCallback {
    LikeActionController$1(int paramInt1, int paramInt2, Intent paramIntent, UUID paramUUID) {
    }

    public void onComplete(LikeActionController paramLikeActionController) {
        LikeActionController.access$000(paramLikeActionController, this.val$requestCode, this.val$resultCode, this.val$data, this.val$callId);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */