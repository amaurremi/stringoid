package com.everimaging.fotorsdk.uil.core.download;

import java.io.IOException;
import java.io.InputStream;

public class b
        implements ImageDownloader {
    private final ImageDownloader a;

    public b(ImageDownloader paramImageDownloader) {
        this.a = paramImageDownloader;
    }

    public InputStream a(String paramString, Object paramObject)
            throws IOException {
        switch (1. a[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
        {
            default:
                return this.a.a(paramString, paramObject);
        }
        throw new IllegalStateException();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/download/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */