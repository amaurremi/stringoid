package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.GpsHelperListener;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.mobileads.factories.HttpClientFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class MoPubConversionTracker
{
  private static final String TRACK_HANDLER = "/m/open";
  private static final String TRACK_HOST = "ads.mopub.com";
  private Context mContext;
  private ConversionTrackerGpsHelperListener mConversionTrackerGpsHelperListener = new ConversionTrackerGpsHelperListener();
  private String mIsTrackedKey;
  private String mPackageName;
  private SharedPreferences mSharedPreferences;
  
  private boolean isAlreadyTracked()
  {
    return this.mSharedPreferences.getBoolean(this.mIsTrackedKey, false);
  }
  
  public void reportAppOpen(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.mContext = paramContext;
    this.mPackageName = this.mContext.getPackageName();
    this.mIsTrackedKey = (this.mPackageName + " tracked");
    this.mSharedPreferences = SharedPreferencesHelper.getSharedPreferences(this.mContext);
    if (!isAlreadyTracked())
    {
      GpsHelper.asyncFetchAdvertisingInfo(this.mContext, this.mConversionTrackerGpsHelperListener);
      return;
    }
    Log.d("MoPub", "Conversion already tracked");
  }
  
  class ConversionTrackerGpsHelperListener
    implements GpsHelper.GpsHelperListener
  {
    ConversionTrackerGpsHelperListener() {}
    
    public void onFetchAdInfoCompleted()
    {
      new Thread(new MoPubConversionTracker.TrackOpen(MoPubConversionTracker.this, null)).start();
    }
  }
  
  private class ConversionUrlGenerator
    extends BaseUrlGenerator
  {
    private ConversionUrlGenerator() {}
    
    private void setPackageId(String paramString)
    {
      addParam("id", paramString);
    }
    
    public String generateUrlString(String paramString)
    {
      initUrlString(paramString, "/m/open");
      setApiVersion("6");
      setPackageId(MoPubConversionTracker.this.mPackageName);
      setUdid(getUdidFromContext(MoPubConversionTracker.this.mContext));
      setDoNotTrack(GpsHelper.isLimitAdTrackingEnabled(MoPubConversionTracker.this.mContext));
      setAppVersion(getAppVersionFromContext(MoPubConversionTracker.this.mContext));
      return getFinalUrlString();
    }
  }
  
  private class TrackOpen
    implements Runnable
  {
    private TrackOpen() {}
    
    public void run()
    {
      Object localObject1 = new MoPubConversionTracker.ConversionUrlGenerator(MoPubConversionTracker.this, null).generateUrlString("ads.mopub.com");
      Log.d("MoPub", "Conversion track: " + (String)localObject1);
      Object localObject2 = HttpClientFactory.create();
      try
      {
        localObject2 = ((DefaultHttpClient)localObject2).execute(new HttpGet((String)localObject1));
        if (((HttpResponse)localObject2).getStatusLine().getStatusCode() != 200)
        {
          Log.d("MoPub", "Conversion track failed: Status code != 200.");
          return;
        }
      }
      catch (Exception localException)
      {
        Log.d("MoPub", "Conversion track failed [" + localException.getClass().getSimpleName() + "]: " + (String)localObject1);
        return;
      }
      localObject1 = localException.getEntity();
      if ((localObject1 == null) || (((HttpEntity)localObject1).getContentLength() == 0L))
      {
        Log.d("MoPub", "Conversion track failed: Response was empty.");
        return;
      }
      Log.d("MoPub", "Conversion track successful.");
      MoPubConversionTracker.this.mSharedPreferences.edit().putBoolean(MoPubConversionTracker.this.mIsTrackedKey, true).commit();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MoPubConversionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */