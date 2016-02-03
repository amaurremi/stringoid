package com.facebook.widget;

import android.app.Activity;

import java.util.EnumSet;
import java.util.List;

public class FacebookDialog$MessageDialogBuilder
        extends FacebookDialog.ShareDialogBuilderBase<MessageDialogBuilder> {
    public FacebookDialog$MessageDialogBuilder(Activity paramActivity) {
        super(paramActivity);
    }

    protected EnumSet<? extends FacebookDialog.DialogFeature> getDialogFeatures() {
        return EnumSet.of(FacebookDialog.MessageDialogFeature.MESSAGE_DIALOG);
    }

    public MessageDialogBuilder setFriends(List<String> paramList) {
        return this;
    }

    public MessageDialogBuilder setPlace(String paramString) {
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$MessageDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */