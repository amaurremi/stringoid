package com.jiubang.goweather.c;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.weather.model.b;

class h
  implements p
{
  h(g paramg, int paramInt1, int paramInt2) {}
  
  public void a()
  {
    g.a(this.c).sendEmptyMessage(3);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 3)
    {
      g.a(this.c).sendEmptyMessage(2);
      return;
    }
    g.a(this.c, this.a, this.b, 9);
  }
  
  public void a(Location paramLocation)
  {
    Message localMessage = Message.obtain();
    localMessage.obj = paramLocation;
    localMessage.what = 1;
    g.a(this.c).sendMessage(localMessage);
    if (g.b(this.c))
    {
      g.a(this.c, false);
      this.c.a(paramLocation);
    }
  }
  
  public void a(b paramb, Location paramLocation)
  {
    paramLocation = Message.obtain();
    paramLocation.obj = paramb;
    paramLocation.what = 4;
    g.a(this.c).sendMessage(paramLocation);
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    g.a(this.c, this.a, this.b, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */