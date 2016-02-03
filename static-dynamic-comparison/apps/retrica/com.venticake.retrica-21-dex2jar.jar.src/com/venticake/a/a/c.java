package com.venticake.a.a;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.util.Date;
import org.json.JSONArray;

public class c
  extends a
{
  public static String a = null;
  public static int b = 2;
  public static Date c = null;
  public static boolean d = false;
  private int e = 2;
  private AdView f = null;
  private ViewGroup g = null;
  
  public c(JSONArray paramJSONArray)
  {
    super(2, paramJSONArray);
  }
  
  public c(JSONArray paramJSONArray, int paramInt) {}
  
  private AdView a(Context paramContext)
  {
    if (a == null) {
      Log.e("spad", "unitID is null!!!");
    }
    Log.d("spad", "createAdView with unitID: " + a);
    paramContext = new AdView(paramContext);
    paramContext.setAdSize(AdSize.SMART_BANNER);
    paramContext.setAdUnitId(a);
    return paramContext;
  }
  
  private void b(Context paramContext)
  {
    Log.d("spad", "requestAdView");
    if (this.f != null)
    {
      f();
      g();
      return;
    }
    this.f = a(paramContext);
    Log.d("spad", "createAdView: " + this.f);
    this.f.setAdListener(new AdListener()
    {
      public void onAdClosed()
      {
        Log.d("spad", "admob.onAdClosed");
      }
      
      public void onAdFailedToLoad(int paramAnonymousInt)
      {
        Log.d("spad", "admob.onAdFailedToLoad: " + paramAnonymousInt);
      }
      
      public void onAdLeftApplication()
      {
        Log.d("spad", "admob.onAdLeftApplication");
      }
      
      public void onAdLoaded()
      {
        Log.d("spad", "admob.onAdLoaded");
        c.a(c.this);
        c.b(c.this);
      }
      
      public void onAdOpened()
      {
        Log.d("spad", "admob.onAdOpened");
      }
    });
    this.f.loadAd(e());
  }
  
  private AdRequest e()
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    localBuilder.setGender(b);
    if (c != null) {
      localBuilder.setBirthday(c);
    }
    Location localLocation = com.venticake.a.a.a().b();
    if (localLocation != null) {
      localBuilder.setLocation(localLocation);
    }
    return localBuilder.build();
  }
  
  private void f()
  {
    if (this.f == null) {}
    ViewGroup localViewGroup;
    do
    {
      return;
      localViewGroup = (ViewGroup)this.f.getParent();
    } while (localViewGroup == null);
    localViewGroup.removeView(this.f);
  }
  
  private void g()
  {
    if ((this.g == null) || (this.f == null)) {
      return;
    }
    this.g.addView(this.f);
  }
  
  private void h()
  {
    if (this.f == null) {
      return;
    }
    f();
    this.f.setAdListener(null);
    this.f = null;
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, com.venticake.a.a parama) {}
  
  public boolean a(int paramInt)
  {
    return (paramInt & 0x1) > 0;
  }
  
  public boolean a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.g = paramViewGroup;
    b(paramActivity);
    return true;
  }
  
  public void b(Activity paramActivity) {}
  
  public void b(Activity paramActivity, com.venticake.a.a parama)
  {
    h();
    this.g = null;
  }
  
  public boolean b(Activity paramActivity, ViewGroup paramViewGroup)
  {
    h();
    this.g = paramViewGroup;
    b(paramActivity);
    return true;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public String toString()
  {
    if (d) {
      return super.toString() + " (Alt)";
    }
    return super.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */