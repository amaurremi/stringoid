package com.everimaging.fotorsdk.uil.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class a
        implements ImageDownloader {
    protected final Context a;
    protected final int b;
    protected final int c;

    public a(Context paramContext) {
        this.a = paramContext.getApplicationContext();
        this.b = 5000;
        this.c = 20000;
    }

    public InputStream a(String paramString, Object paramObject)
            throws IOException {
        switch (1. a[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
        {
            default:
                return h(paramString, paramObject);
            case 1:
            case 2:
                return b(paramString, paramObject);
            case 3:
                return d(paramString, paramObject);
            case 4:
                return e(paramString, paramObject);
            case 5:
                return f(paramString, paramObject);
        }
        return g(paramString, paramObject);
    }

    protected InputStream b(String paramString, Object paramObject)
            throws IOException {
        paramString = c(paramString, paramObject);
        int i = 0;
        while ((paramString.getResponseCode() / 100 == 3) && (i < 5)) {
            paramString = c(paramString.getHeaderField("Location"), paramObject);
            i += 1;
        }
        return new com.everimaging.fotorsdk.uil.core.assist.a(new BufferedInputStream(paramString.getInputStream(), 32768), paramString.getContentLength());
    }

    protected HttpURLConnection c(String paramString, Object paramObject)
            throws IOException {
        paramString = (HttpURLConnection) new URL(Uri.encode(paramString, "@#&=*+-_.,:!?()/~'%")).openConnection();
        paramString.setConnectTimeout(this.b);
        paramString.setReadTimeout(this.c);
        return paramString;
    }

    protected InputStream d(String paramString, Object paramObject)
            throws IOException {
        paramString = ImageDownloader.Scheme.FILE.crop(paramString);
        return new com.everimaging.fotorsdk.uil.core.assist.a(new BufferedInputStream(new FileInputStream(paramString), 32768), new File(paramString).length());
    }

    protected InputStream e(String paramString, Object paramObject)
            throws FileNotFoundException {
        return this.a.getContentResolver().openInputStream(Uri.parse(paramString));
    }

    protected InputStream f(String paramString, Object paramObject)
            throws IOException {
        paramString = ImageDownloader.Scheme.ASSETS.crop(paramString);
        return this.a.getAssets().open(paramString);
    }

    protected InputStream g(String paramString, Object paramObject) {
        int i = Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(paramString));
        paramString = ((BitmapDrawable) this.a.getResources().getDrawable(i)).getBitmap();
        paramObject = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.PNG, 0, (OutputStream) paramObject);
        return new ByteArrayInputStream(((ByteArrayOutputStream) paramObject).toByteArray());
    }

    protected InputStream h(String paramString, Object paramObject)
            throws IOException {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[]{paramString}));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/download/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */