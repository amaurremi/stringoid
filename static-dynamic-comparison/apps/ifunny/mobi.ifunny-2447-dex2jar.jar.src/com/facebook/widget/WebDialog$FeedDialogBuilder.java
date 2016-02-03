package com.facebook.widget;

import android.content.Context;
import android.os.Bundle;
import com.facebook.Session;

public class WebDialog$FeedDialogBuilder
        extends WebDialog.BuilderBase<FeedDialogBuilder> {
    private static final String CAPTION_PARAM = "caption";
    private static final String DESCRIPTION_PARAM = "description";
    private static final String FEED_DIALOG = "feed";
    private static final String FROM_PARAM = "from";
    private static final String LINK_PARAM = "link";
    private static final String NAME_PARAM = "name";
    private static final String PICTURE_PARAM = "picture";
    private static final String SOURCE_PARAM = "source";
    private static final String TO_PARAM = "to";

    public WebDialog$FeedDialogBuilder(Context paramContext) {
        super(paramContext, "feed");
    }

    public WebDialog$FeedDialogBuilder(Context paramContext, Session paramSession) {
        super(paramContext, paramSession, "feed", null);
    }

    public WebDialog$FeedDialogBuilder(Context paramContext, Session paramSession, Bundle paramBundle) {
        super(paramContext, paramSession, "feed", paramBundle);
    }

    public WebDialog$FeedDialogBuilder(Context paramContext, String paramString, Bundle paramBundle) {
        super(paramContext, paramString, "feed", paramBundle);
    }

    public FeedDialogBuilder setCaption(String paramString) {
        getParameters().putString("caption", paramString);
        return this;
    }

    public FeedDialogBuilder setDescription(String paramString) {
        getParameters().putString("description", paramString);
        return this;
    }

    public FeedDialogBuilder setFrom(String paramString) {
        getParameters().putString("from", paramString);
        return this;
    }

    public FeedDialogBuilder setLink(String paramString) {
        getParameters().putString("link", paramString);
        return this;
    }

    public FeedDialogBuilder setName(String paramString) {
        getParameters().putString("name", paramString);
        return this;
    }

    public FeedDialogBuilder setPicture(String paramString) {
        getParameters().putString("picture", paramString);
        return this;
    }

    public FeedDialogBuilder setSource(String paramString) {
        getParameters().putString("source", paramString);
        return this;
    }

    public FeedDialogBuilder setTo(String paramString) {
        getParameters().putString("to", paramString);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/WebDialog$FeedDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */