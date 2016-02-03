package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class ca
  extends br
{
  private final String Fu;
  private final String Fv;
  private final Context mContext;
  
  public ca(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.Fu = paramString1;
    this.Fv = paramString2;
  }
  
  public void onStop() {}
  
  public void py()
  {
    try
    {
      ce.C("Pinging URL: " + this.Fv);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.Fv).openConnection();
      try
      {
        bw.a(this.mContext, this.Fu, true, localHttpURLConnection);
        int i = localHttpURLConnection.getResponseCode();
        if ((i < 200) || (i >= 300)) {
          ce.D("Received non-success response code " + i + " from pinging URL: " + this.Fv);
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
      ce.D("Error while pinging URL: " + this.Fv + ". " + localIOException.getMessage());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */