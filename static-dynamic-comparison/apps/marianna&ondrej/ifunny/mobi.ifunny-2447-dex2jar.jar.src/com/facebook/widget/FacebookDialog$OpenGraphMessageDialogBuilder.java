package com.facebook.widget;

import android.app.Activity;
import com.facebook.model.OpenGraphAction;

import java.util.EnumSet;

public class FacebookDialog$OpenGraphMessageDialogBuilder
        extends FacebookDialog.OpenGraphDialogBuilderBase<OpenGraphMessageDialogBuilder> {
    public FacebookDialog$OpenGraphMessageDialogBuilder(Activity paramActivity, OpenGraphAction paramOpenGraphAction, String paramString) {
        super(paramActivity, paramOpenGraphAction, paramString);
    }

    protected EnumSet<? extends FacebookDialog.DialogFeature> getDialogFeatures() {
        return EnumSet.of(FacebookDialog.OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$OpenGraphMessageDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */