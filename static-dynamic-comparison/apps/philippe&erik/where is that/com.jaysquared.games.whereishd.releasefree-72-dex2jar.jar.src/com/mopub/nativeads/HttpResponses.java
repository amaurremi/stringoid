package com.mopub.nativeads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import org.json.JSONObject;
import org.json.JSONTokener;

class HttpResponses
{
  static Bitmap asBitmap(DownloadResponse paramDownloadResponse)
  {
    if (paramDownloadResponse == null) {
      return null;
    }
    return BitmapFactory.decodeByteArray(paramDownloadResponse.getByteArray(), 0, (int)paramDownloadResponse.getContentLength());
  }
  
  static JSONObject asJsonObject(DownloadResponse paramDownloadResponse)
  {
    if (paramDownloadResponse == null) {
      return null;
    }
    try
    {
      paramDownloadResponse = new JSONObject(new JSONTokener(asResponseString(paramDownloadResponse)));
      return paramDownloadResponse;
    }
    catch (Exception paramDownloadResponse) {}
    return null;
  }
  
  static String asResponseString(DownloadResponse paramDownloadResponse)
  {
    if (paramDownloadResponse == null) {
      return null;
    }
    try
    {
      paramDownloadResponse = new String(paramDownloadResponse.getByteArray(), "UTF-8");
      return paramDownloadResponse;
    }
    catch (Exception paramDownloadResponse) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/HttpResponses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */