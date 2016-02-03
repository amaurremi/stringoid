package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class et
  extends en
{
  private final String lp;
  private final Context mContext;
  private final String qV;
  
  public et(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.lp = paramString1;
    this.qV = paramString2;
  }
  
  public void bc()
  {
    try
    {
      ev.C("Pinging URL: " + this.qV);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.qV).openConnection();
      try
      {
        ep.a(this.mContext, this.lp, true, localHttpURLConnection);
        int i = localHttpURLConnection.getResponseCode();
        if ((i < 200) || (i >= 300)) {
          ev.D("Received non-success response code " + i + " from pinging URL: " + this.qV);
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
      ev.D("Error while parsing ping URL: " + this.qV + ". " + localIndexOutOfBoundsException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      ev.D("Error while pinging URL: " + this.qV + ". " + localIOException.getMessage());
    }
  }
  
  public void onStop() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */