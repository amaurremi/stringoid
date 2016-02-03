package com.facebook.android;

import android.content.Context;
import android.os.Bundle;

@Deprecated
public class AsyncFacebookRunner {
    Facebook fb;

    public AsyncFacebookRunner(Facebook paramFacebook) {
        this.fb = paramFacebook;
    }

    @Deprecated
    public void logout(Context paramContext, AsyncFacebookRunner.RequestListener paramRequestListener) {
        logout(paramContext, paramRequestListener, null);
    }

    @Deprecated
    public void logout(Context paramContext, AsyncFacebookRunner.RequestListener paramRequestListener, Object paramObject) {
        new AsyncFacebookRunner .1 (this, paramContext, paramRequestListener, paramObject).start();
    }

    @Deprecated
    public void request(Bundle paramBundle, AsyncFacebookRunner.RequestListener paramRequestListener) {
        request(null, paramBundle, "GET", paramRequestListener, null);
    }

    @Deprecated
    public void request(Bundle paramBundle, AsyncFacebookRunner.RequestListener paramRequestListener, Object paramObject) {
        request(null, paramBundle, "GET", paramRequestListener, paramObject);
    }

    @Deprecated
    public void request(String paramString, Bundle paramBundle, AsyncFacebookRunner.RequestListener paramRequestListener) {
        request(paramString, paramBundle, "GET", paramRequestListener, null);
    }

    @Deprecated
    public void request(String paramString, Bundle paramBundle, AsyncFacebookRunner.RequestListener paramRequestListener, Object paramObject) {
        request(paramString, paramBundle, "GET", paramRequestListener, paramObject);
    }

    @Deprecated
    public void request(String paramString1, Bundle paramBundle, String paramString2, AsyncFacebookRunner.RequestListener paramRequestListener, Object paramObject) {
        new AsyncFacebookRunner .2 (this, paramString1, paramBundle, paramString2, paramRequestListener, paramObject).
        start();
    }

    @Deprecated
    public void request(String paramString, AsyncFacebookRunner.RequestListener paramRequestListener) {
        request(paramString, new Bundle(), "GET", paramRequestListener, null);
    }

    @Deprecated
    public void request(String paramString, AsyncFacebookRunner.RequestListener paramRequestListener, Object paramObject) {
        request(paramString, new Bundle(), "GET", paramRequestListener, paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/AsyncFacebookRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */