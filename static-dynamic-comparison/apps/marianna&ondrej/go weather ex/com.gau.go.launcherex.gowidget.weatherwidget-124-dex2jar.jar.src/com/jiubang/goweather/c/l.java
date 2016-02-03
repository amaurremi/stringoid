package com.jiubang.goweather.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

class l
  implements LocationListener
{
  l(j paramj) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
    {
      this.a.c.a();
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      j.b(this.a).sendMessage(localMessage);
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */