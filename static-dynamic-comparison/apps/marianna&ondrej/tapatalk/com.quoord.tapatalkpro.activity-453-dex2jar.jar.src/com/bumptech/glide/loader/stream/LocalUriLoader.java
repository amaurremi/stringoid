package com.bumptech.glide.loader.stream;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

public class LocalUriLoader
        implements StreamLoader {
    private final WeakReference<Context> contextRef;
    private final Uri uri;

    public LocalUriLoader(Context paramContext, Uri paramUri) {
        this.contextRef = new WeakReference(paramContext);
        this.uri = paramUri;
    }

    public void cancel() {
    }

    public void loadStream(StreamLoader.StreamReadyCallback paramStreamReadyCallback) {
        Object localObject = (Context) this.contextRef.get();
        if (localObject != null) {
            localObject = ((Context) localObject).getContentResolver();
        }
        try {
            paramStreamReadyCallback.onStreamReady(((ContentResolver) localObject).openInputStream(this.uri));
            return;
        } catch (FileNotFoundException localFileNotFoundException) {
            paramStreamReadyCallback.onException(localFileNotFoundException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/stream/LocalUriLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */