package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class es
  extends em
{
  private final String lr;
  private final Context mContext;
  private final String qY;
  
  public es(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.lr = paramString1;
    this.qY = paramString2;
  }
  
  public void bh()
  {
    try
    {
      eu.C("Pinging URL: " + this.qY);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.qY).openConnection();
      try
      {
        eo.a(this.mContext, this.lr, true, localHttpURLConnection);
        int i = localHttpURLConnection.getResponseCode();
        if ((i < 200) || (i >= 300)) {
          eu.D("Received non-success response code " + i + " from pinging URL: " + this.qY);
        }
        return;
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      eu.D("Error while parsing ping URL: " + this.qY + ". " + localIndexOutOfBoundsException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      eu.D("Error while pinging URL: " + this.qY + ". " + localIOException.getMessage());
    }
  }
  
  public void onStop() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */