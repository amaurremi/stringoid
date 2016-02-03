package com.venticake.a.a;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import com.venticake.retrica.MainActivity;
import org.json.JSONArray;

public class d
  extends a
{
  private InterstitialAd a;
  
  public d(JSONArray paramJSONArray)
  {
    super(82, paramJSONArray);
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, com.venticake.a.a parama)
  {
    Log.d("spad", "configure.GoogleAdInsterstitial: " + paramActivity);
    this.a = new InterstitialAd(paramActivity);
    this.a.setAdUnitId(com.venticake.retrica.setting.a.f);
    this.a.setAdListener(new AdListener()
    {
      public void onAdClosed()
      {
        Log.d("spad", "onAdClosed");
        d.a(d.this, null);
        d.this.a((Activity)MainActivity.a, null);
      }
      
      public void onAdLoaded()
      {
        Log.d("spad", "onAdLoaded");
      }
    });
    paramActivity = new AdRequest.Builder().build();
    this.a.loadAd(paramActivity);
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt & 0x10) > 0;
  }
  
  public boolean a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      Log.d("spad", "display.interstitial is null: " + paramActivity);
      a(paramActivity, null);
    }
    if (this.a.isLoaded())
    {
      Log.d("spad", "display.GoogleAdInsterstitial: " + paramActivity);
      this.a.show();
      return true;
    }
    Log.d("spad", "display.GoogleAdInsterstitial: - NOT LOADED " + paramActivity);
    return false;
  }
  
  public void b(Activity paramActivity) {}
  
  public void b(Activity paramActivity, com.venticake.a.a parama) {}
  
  public boolean b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    return false;
  }
  
  public int d()
  {
    return 82;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */