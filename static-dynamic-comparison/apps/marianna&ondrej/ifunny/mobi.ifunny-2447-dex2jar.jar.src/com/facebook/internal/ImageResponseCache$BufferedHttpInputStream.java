package com.facebook.internal;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

class ImageResponseCache$BufferedHttpInputStream
        extends BufferedInputStream {
    HttpURLConnection connection;

    ImageResponseCache$BufferedHttpInputStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection) {
        super(paramInputStream, 8192);
        this.connection = paramHttpURLConnection;
    }

    public void close() {
        super.close();
        Utility.disconnectQuietly(this.connection);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/ImageResponseCache$BufferedHttpInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */