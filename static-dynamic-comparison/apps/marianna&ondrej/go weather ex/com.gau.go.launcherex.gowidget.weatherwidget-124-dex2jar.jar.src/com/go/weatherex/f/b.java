package com.go.weatherex.f;

import android.location.Location;
import android.os.Message;
import com.jiubang.goweather.c.m;
import com.jiubang.goweather.c.p;

class b
  implements p
{
  b(a parama, int paramInt1, int paramInt2) {}
  
  public void a()
  {
    a.d(this.c).sendEmptyMessage(3);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 3)
    {
      a.d(this.c).sendEmptyMessage(2);
      return;
    }
    a.a(this.c, this.a, this.b, 9);
  }
  
  public void a(Location paramLocation)
  {
    a.e(this.c).a(paramLocation);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.b paramb, Location paramLocation)
  {
    paramLocation = Message.obtain();
    paramLocation.obj = paramb;
    paramLocation.what = 4;
    a.d(this.c).sendMessage(paramLocation);
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    a.a(this.c, this.a, this.b, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */