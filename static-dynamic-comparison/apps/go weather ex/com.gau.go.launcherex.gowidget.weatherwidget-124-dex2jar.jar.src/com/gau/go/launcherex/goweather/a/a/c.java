package com.gau.go.launcherex.goweather.a.a;

import android.text.TextUtils;
import com.gau.go.launcherex.goweather.a.f;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.jiubang.goweather.e.a;

public class c
  implements TileProvider
{
  private final e a = new e();
  
  private static f a()
  {
    f localf = new f();
    localf.a("http://gwm.3g.cn:8099/goweatherexMeteor/radar/v2/image");
    localf.c(256);
    localf.b(256);
    return localf;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt3 >= 2) && (paramInt3 <= 8);
  }
  
  public Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    Object localObject1;
    if (!a(paramInt1, paramInt2, paramInt3)) {
      localObject1 = TileProvider.NO_TILE;
    }
    byte[] arrayOfByte;
    do
    {
      String str;
      do
      {
        return (Tile)localObject1;
        localObject1 = a();
        ((f)localObject1).a(paramInt3);
        ((f)localObject1).a(this.a.a(paramInt1, paramInt2, paramInt3));
        str = ((f)localObject1).i();
        localObject1 = localObject2;
      } while (TextUtils.isEmpty(str));
      paramInt1 = 3;
      for (arrayOfByte = null; (arrayOfByte == null) && (paramInt1 > 0); arrayOfByte = a.a(str)) {
        paramInt1 -= 1;
      }
      localObject1 = localObject2;
    } while (arrayOfByte == null);
    return new Tile(256, 256, arrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */