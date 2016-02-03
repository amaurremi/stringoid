package com.facebook.android;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

@Deprecated
public abstract interface AsyncFacebookRunner$RequestListener {
    public abstract void onComplete(String paramString, Object paramObject);

    public abstract void onFacebookError(FacebookError paramFacebookError, Object paramObject);

    public abstract void onFileNotFoundException(FileNotFoundException paramFileNotFoundException, Object paramObject);

    public abstract void onIOException(IOException paramIOException, Object paramObject);

    public abstract void onMalformedURLException(MalformedURLException paramMalformedURLException, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/AsyncFacebookRunner$RequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */