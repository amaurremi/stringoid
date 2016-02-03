package com.mopub.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class HttpResponses {
    public static Bitmap asBitmap(DownloadResponse paramDownloadResponse) {
        if (paramDownloadResponse == null) {
            return null;
        }
        paramDownloadResponse = paramDownloadResponse.getByteArray();
        return BitmapFactory.decodeByteArray(paramDownloadResponse, 0, paramDownloadResponse.length);
    }

    public static JSONObject asJsonObject(DownloadResponse paramDownloadResponse) {
        if (paramDownloadResponse == null) {
            return null;
        }
        try {
            paramDownloadResponse = new JSONObject(new JSONTokener(asResponseString(paramDownloadResponse)));
            return paramDownloadResponse;
        } catch (Exception paramDownloadResponse) {
        }
        return null;
    }

    public static String asResponseString(DownloadResponse paramDownloadResponse) {
        if (paramDownloadResponse == null) {
            return null;
        }
        try {
            paramDownloadResponse = new String(paramDownloadResponse.getByteArray(), "UTF-8");
            return paramDownloadResponse;
        } catch (Exception paramDownloadResponse) {
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/HttpResponses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */