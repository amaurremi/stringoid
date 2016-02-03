package com.facebook.internal;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.widget.FacebookDialog.Builder;
import com.facebook.widget.FacebookDialog.DialogFeature;
import com.facebook.widget.FacebookDialog.PendingCall;

import java.util.EnumSet;

class LikeActionController$LikeDialogBuilder
        extends FacebookDialog.Builder<LikeDialogBuilder> {
    private String objectId;

    public LikeActionController$LikeDialogBuilder(Activity paramActivity, String paramString) {
        super(paramActivity);
        this.objectId = paramString;
    }

    public FacebookDialog.PendingCall getAppCall() {
        return this.appCall;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    protected EnumSet<? extends FacebookDialog.DialogFeature> getDialogFeatures() {
        return EnumSet.of(LikeActionController.LikeDialogFeature.LIKE_DIALOG);
    }

    protected Bundle getMethodArguments() {
        Bundle localBundle = new Bundle();
        localBundle.putString("object_id", this.objectId);
        return localBundle;
    }

    public String getWebFallbackUrl() {
        return getWebFallbackUrlInternal();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$LikeDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */