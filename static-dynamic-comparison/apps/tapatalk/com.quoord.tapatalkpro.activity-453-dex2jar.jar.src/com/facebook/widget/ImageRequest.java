package com.facebook.widget;

import android.content.Context;
import android.net.Uri.Builder;
import com.facebook.internal.Validate;

import java.net.MalformedURLException;
import java.net.URL;

class ImageRequest {
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PROFILEPIC_URL_FORMAT = "https://graph.facebook.com/%s/picture";
    static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private boolean allowCachedRedirects;
    private Callback callback;
    private Object callerTag;
    private Context context;
    private URL imageUrl;

    private ImageRequest(Builder paramBuilder) {
        this.context = paramBuilder.context;
        this.imageUrl = paramBuilder.imageUrl;
        this.callback = paramBuilder.callback;
        this.allowCachedRedirects = paramBuilder.allowCachedRedirects;
        if (paramBuilder.callerTag == null) {
        }
        for (paramBuilder = new Object(); ; paramBuilder = paramBuilder.callerTag) {
            this.callerTag = paramBuilder;
            return;
        }
    }

    static URL getProfilePictureUrl(String paramString, int paramInt1, int paramInt2)
            throws MalformedURLException {
        Validate.notNullOrEmpty(paramString, "userId");
        paramInt1 = Math.max(paramInt1, 0);
        paramInt2 = Math.max(paramInt2, 0);
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
            throw new IllegalArgumentException("Either width or height must be greater than 0");
        }
        paramString = new Uri.Builder().encodedPath(String.format("https://graph.facebook.com/%s/picture", new Object[]{paramString}));
        if (paramInt2 != 0) {
            paramString.appendQueryParameter("height", String.valueOf(paramInt2));
        }
        if (paramInt1 != 0) {
            paramString.appendQueryParameter("width", String.valueOf(paramInt1));
        }
        paramString.appendQueryParameter("migration_overrides", "{october_2012:true}");
        return new URL(paramString.toString());
    }

    Callback getCallback() {
        return this.callback;
    }

    Object getCallerTag() {
        return this.callerTag;
    }

    Context getContext() {
        return this.context;
    }

    URL getImageUrl() {
        return this.imageUrl;
    }

    boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    static class Builder {
        private boolean allowCachedRedirects;
        private ImageRequest.Callback callback;
        private Object callerTag;
        private Context context;
        private URL imageUrl;

        Builder(Context paramContext, URL paramURL) {
            Validate.notNull(paramURL, "imageUrl");
            this.context = paramContext;
            this.imageUrl = paramURL;
        }

        ImageRequest build() {
            return new ImageRequest(this, null);
        }

        Builder setAllowCachedRedirects(boolean paramBoolean) {
            this.allowCachedRedirects = paramBoolean;
            return this;
        }

        Builder setCallback(ImageRequest.Callback paramCallback) {
            this.callback = paramCallback;
            return this;
        }

        Builder setCallerTag(Object paramObject) {
            this.callerTag = paramObject;
            return this;
        }
    }

    static abstract interface Callback {
        public abstract void onCompleted(ImageResponse paramImageResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/ImageRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */