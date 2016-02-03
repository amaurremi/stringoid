package com.facebook.internal;

import com.facebook.LoggingBehavior;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

final class FileLruCache$StreamHeader {
    private static final int HEADER_VERSION = 0;

    static JSONObject readHeader(InputStream paramInputStream) {
        int k = 0;
        if (paramInputStream.read() != 0) {
            return null;
        }
        int i = 0;
        int j = 0;
        while (i < 3) {
            int m = paramInputStream.read();
            if (m == -1) {
                Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                return null;
            }
            j = (j << 8) + (m & 0xFF);
            i += 1;
        }
        byte[] arrayOfByte = new byte[j];
        i = k;
        while (i < arrayOfByte.length) {
            j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
            if (j < 1) {
                Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + arrayOfByte.length);
                return null;
            }
            i += j;
        }
        paramInputStream = new JSONTokener(new String(arrayOfByte));
        try {
            paramInputStream = paramInputStream.nextValue();
            if (!(paramInputStream instanceof JSONObject)) {
                Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + paramInputStream.getClass().getCanonicalName());
                return null;
            }
            paramInputStream = (JSONObject) paramInputStream;
            return paramInputStream;
        } catch (JSONException paramInputStream) {
            throw new IOException(paramInputStream.getMessage());
        }
    }

    static void writeHeader(OutputStream paramOutputStream, JSONObject paramJSONObject) {
        paramJSONObject = paramJSONObject.toString().getBytes();
        paramOutputStream.write(0);
        paramOutputStream.write(paramJSONObject.length >> 16 & 0xFF);
        paramOutputStream.write(paramJSONObject.length >> 8 & 0xFF);
        paramOutputStream.write(paramJSONObject.length >> 0 & 0xFF);
        paramOutputStream.write(paramJSONObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FileLruCache$StreamHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */