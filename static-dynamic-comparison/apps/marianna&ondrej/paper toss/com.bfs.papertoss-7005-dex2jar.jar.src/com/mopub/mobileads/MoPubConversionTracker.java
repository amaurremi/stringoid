package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import android.util.Log;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class MoPubConversionTracker
{
  private static String TRACK_HANDLER = "/m/open";
  private static String TRACK_HOST = "ads.mopub.com";
  private Context mContext;
  private String mPackageName;
  Runnable mTrackOpen = new Runnable()
  {
    public void run()
    {
      Object localObject = new StringBuilder("http://" + MoPubConversionTracker.TRACK_HOST + MoPubConversionTracker.TRACK_HANDLER);
      ((StringBuilder)localObject).append("?v=6&id=" + MoPubConversionTracker.this.mPackageName);
      String str = Settings.Secure.getString(MoPubConversionTracker.this.mContext.getContentResolver(), "android_id");
      if (str == null) {}
      for (str = "";; str = Utils.sha1(str))
      {
        ((StringBuilder)localObject).append("&udid=sha:" + str);
        str = ((StringBuilder)localObject).toString();
        Log.d("MoPub", "Conversion track: " + str);
        localObject = new DefaultHttpClient();
        try
        {
          localObject = ((DefaultHttpClient)localObject).execute(new HttpGet(str));
          if (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200) {
            break;
          }
          Log.d("MoPub", "Conversion track failed: Status code != 200");
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.d("MoPub", "Conversion track failed (IllegalArgumentException): " + str);
          return;
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          Log.d("MoPub", "Conversion track failed: ClientProtocolException (no signal?)");
          return;
        }
        catch (IOException localIOException)
        {
          Log.d("MoPub", "Conversion track failed: IOException (no signal?)");
          return;
        }
      }
      HttpEntity localHttpEntity = localIllegalArgumentException.getEntity();
      if ((localHttpEntity == null) || (localHttpEntity.getContentLength() == 0L))
      {
        Log.d("MoPub", "Conversion track failed: Response was empty");
        return;
      }
      Log.d("MoPub", "Conversion track successful");
      MoPubConversionTracker.this.mContext.getSharedPreferences("mopubSettings", 0).edit().putBoolean(MoPubConversionTracker.this.mPackageName + " tracked", true).commit();
    }
  };
  
  public void reportAppOpen(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.mContext = paramContext;
    this.mPackageName = this.mContext.getPackageName();
    if (!this.mContext.getSharedPreferences("mopubSettings", 0).getBoolean(this.mPackageName + " tracked", false))
    {
      new Thread(this.mTrackOpen).start();
      return;
    }
    Log.d("MoPub", "Conversion already tracked");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/mopub/mobileads/MoPubConversionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */