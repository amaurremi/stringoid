package mobi.borken.android.adsupport.impl;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import mobi.borken.android.adsupport.AdSupportedActivity;

public class AdActivity
  extends AdSupportedActivity
{
  public static final String ADMOB_PUBLISHER_ID_KEY = "publisher.admob.id";
  private AdView adMobView;
  private AdRequest adRequest;
  private AdRequest.Builder requestBuilder;
  
  public void addTestDevice(String paramString)
  {
    if (this.adRequest != null) {
      this.requestBuilder.addTestDevice(paramString);
    }
  }
  
  protected void initAdControl(int paramInt)
    throws IOException
  {
    super.initAdControl(paramInt);
    this.adMobView = new AdView(this);
    this.adMobView.setAdUnitId(getProperties().getProperty("publisher.admob.id", ""));
    this.adMobView.setAdSize(AdSize.SMART_BANNER);
    getAdContainer().addView(this.adMobView);
    this.requestBuilder = new AdRequest.Builder();
    Bundle localBundle = new Bundle();
    localBundle.putString("gl", Locale.getDefault().getCountry());
    this.requestBuilder.addNetworkExtras(new AdMobExtras(localBundle));
  }
  
  protected void onDestroy()
  {
    this.adMobView.destroy();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (this.adMobView != null) {}
    try
    {
      this.adMobView.pause();
      super.onPause();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.adRequest == null)
    {
      this.adRequest = this.requestBuilder.build();
      this.adMobView.loadAd(this.adRequest);
      return;
    }
    this.adMobView.resume();
  }
  
  public void param(String paramString1, String paramString2)
  {
    if ("gender".equals(paramString1))
    {
      if ("Male".equals(paramString2)) {
        this.requestBuilder.setGender(1);
      }
    }
    else {
      return;
    }
    if ("Female".equals(paramString2))
    {
      this.requestBuilder.setGender(2);
      return;
    }
    this.requestBuilder.setGender(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/adsupport/impl/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */