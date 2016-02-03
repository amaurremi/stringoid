package com.gau.go.launcherex.goweather.a.a;

import android.text.TextUtils;
import com.gau.go.launcherex.goweather.a.g;
import com.gau.go.launcherex.goweather.a.h;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.gtp.a.a.b.c;
import com.jiubang.goweather.e.a;

public class d
  implements TileProvider
{
  private final e a = new e();
  
  private static g a()
  {
    g localg = new g();
    localg.a("http://gwm.3g.cn:8099/goweatherexMeteor/satellite/v2/image");
    localg.c(256);
    localg.b(256);
    localg.a(h.a);
    return localg;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt3 >= 2) && (paramInt3 <= 8);
  }
  
  private boolean a(LatLngBounds paramLatLngBounds)
  {
    return (paramLatLngBounds.southwest.latitude <= 64.0D) && (paramLatLngBounds.northeast.latitude >= -64.0D);
  }
  
  public Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject3 = null;
    Object localObject1;
    if (!a(paramInt1, paramInt2, paramInt3)) {
      localObject1 = TileProvider.NO_TILE;
    }
    Object localObject2;
    do
    {
      String str;
      do
      {
        return (Tile)localObject1;
        localObject1 = this.a.a(paramInt1, paramInt2, paramInt3);
        if (!a((LatLngBounds)localObject1)) {
          return TileProvider.NO_TILE;
        }
        localObject2 = a();
        ((g)localObject2).a(paramInt3);
        ((g)localObject2).a((LatLngBounds)localObject1);
        str = ((g)localObject2).m();
        c.a("SatelliteTileProvider", "requestUrl:" + str);
        localObject1 = localObject3;
      } while (TextUtils.isEmpty(str));
      paramInt1 = 3;
      for (localObject2 = null; (localObject2 == null) && (paramInt1 > 0); localObject2 = a.a(str)) {
        paramInt1 -= 1;
      }
      localObject1 = localObject3;
    } while (localObject2 == null);
    return new Tile(256, 256, (byte[])localObject2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */