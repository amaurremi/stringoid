package com.mapbar.android.maps;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

public class MapActivity
  extends Activity
{
  private MapView a;
  private int b = 0;
  private int c = 0;
  
  private void createMap()
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.c = localDisplayMetrics.widthPixels;
      this.b = localDisplayMetrics.heightPixels;
      D.a(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected boolean isRouteDisplayed()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2)
    {
      if ((D.g >= 8) && (D.f < 0))
      {
        D.e = 270;
        return;
      }
      D.e = 90;
      return;
    }
    D.e = 0;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    A.b("Android");
    A.c("Maplet");
    A.d("V4.5.70573");
    createMap();
    D.d = super.getPackageName();
    D.b = F.a(super.getPackageManager(), D.d);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.destory();
    }
  }
  
  protected void onPause()
  {
    if (this.a != null)
    {
      x.t = x.a(this.a, this.a.b, this.a.c, false);
      x.a(this);
    }
    super.onPause();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.onRestoreInstanceState(paramBundle);
    }
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          if (TextUtils.isEmpty(x.a))
          {
            TelephonyManager localTelephonyManager = (TelephonyManager)MapActivity.this.getSystemService("phone");
            x.a = localTelephonyManager.getDeviceId();
            x.b = localTelephonyManager.getSimSerialNumber();
          }
          if (MapActivity.this.a != null)
          {
            x.a(MapActivity.this.a);
            x.t = x.a(MapActivity.this.a, MapActivity.this.a.b, MapActivity.this.a.c, true);
            x.a(MapActivity.this);
          }
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }).start();
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.onSaveInstanceState(paramBundle);
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.onTrackballEvent(paramMotionEvent);
    }
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  void setupMapView(MapView paramMapView)
  {
    this.a = paramMapView;
    this.a.setup();
    this.a.initMapView(this.c, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/MapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */