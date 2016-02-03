package com.gau.go.launcherex.goweather.a.a;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class e
{
  private final a a = new a();
  
  private LatLng a(b paramb, int paramInt)
  {
    paramInt = 1 << paramInt;
    paramb = new b(paramb.b / paramInt, paramb.a / paramInt);
    return this.a.a(paramb);
  }
  
  protected final LatLngBounds a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new LatLngBounds(a(new b(paramInt1 * 256, (paramInt2 + 1) * 256), paramInt3), a(new b((paramInt1 + 1) * 256, paramInt2 * 256), paramInt3));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */