package com.facebook.internal;

import com.facebook.widget.FacebookDialog.DialogFeature;

enum LikeActionController$LikeDialogFeature
        implements FacebookDialog.DialogFeature {
    LIKE_DIALOG(20140701);

    private int minVersion;

    private LikeActionController$LikeDialogFeature(int paramInt) {
        this.minVersion = paramInt;
    }

    public String getAction() {
        return "com.facebook.platform.action.request.LIKE_DIALOG";
    }

    public int getMinVersion() {
        return this.minVersion;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$LikeDialogFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */