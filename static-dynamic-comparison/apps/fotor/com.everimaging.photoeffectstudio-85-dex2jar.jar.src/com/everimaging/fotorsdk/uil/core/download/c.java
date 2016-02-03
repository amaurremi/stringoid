package com.everimaging.fotorsdk.uil.core.download;

import com.everimaging.fotorsdk.uil.core.assist.b;

import java.io.IOException;
import java.io.InputStream;

public class c
        implements ImageDownloader {
    private final ImageDownloader a;

    public c(ImageDownloader paramImageDownloader) {
        this.a = paramImageDownloader;
    }

    public InputStream a(String paramString, Object paramObject)
            throws IOException {
        paramObject = this.a.a(paramString, paramObject);
        switch (1. a[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
        {
            default:
                return (InputStream) paramObject;
        }
        return new b((InputStream) paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/download/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */