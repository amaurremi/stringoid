package com.facebook.widget;

import android.app.Activity;

import java.util.EnumSet;

public class FacebookDialog$ShareDialogBuilder
        extends FacebookDialog.ShareDialogBuilderBase<ShareDialogBuilder> {
    public FacebookDialog$ShareDialogBuilder(Activity paramActivity) {
        super(paramActivity);
    }

    protected EnumSet<? extends FacebookDialog.DialogFeature> getDialogFeatures() {
        return EnumSet.of(FacebookDialog.ShareDialogFeature.SHARE_DIALOG);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$ShareDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */