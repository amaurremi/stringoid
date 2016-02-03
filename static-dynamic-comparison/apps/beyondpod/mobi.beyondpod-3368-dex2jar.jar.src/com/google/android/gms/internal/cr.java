package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class cr
  extends cm
{
  private final String iG;
  private final String iH;
  private final Context mContext;
  
  public cr(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.iG = paramString1;
    this.iH = paramString2;
  }
  
  public void ai()
  {
    try
    {
      ct.u("Pinging URL: " + this.iH);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.iH).openConnection();
      try
      {
        co.a(this.mContext, this.iG, true, localHttpURLConnection);
        int i = localHttpURLConnection.getResponseCode();
        if ((i < 200) || (i >= 300)) {
          ct.v("Received non-success response code " + i + " from pinging URL: " + this.iH);
        }
        return;
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
      return;
    }
    catch (IOException localIOException)
    {
      ct.v("Error while pinging URL: " + this.iH + ". " + localIOException.getMessage());
    }
  }
  
  public void onStop() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */