package com.gau.go.launcherex.gowidget.weather.b;

import android.os.AsyncTask;
import android.os.Handler;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gtp.a.a.b.c;
import com.jiubang.goweather.b.f;
import com.jiubang.goweather.d.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bj
  extends AsyncTask
  implements com.jiubang.goweather.d.a
{
  private final List b;
  private int c;
  private ArrayList d;
  private final int e;
  private final boolean f = false;
  private f g;
  
  public bj(bg parambg, List paramList, int paramInt1, int paramInt2)
  {
    this.b = paramList;
    this.c = paramInt1;
    this.e = paramInt2;
    this.d = new ArrayList();
    parambg = paramList.iterator();
    while (parambg.hasNext())
    {
      paramList = (RequestBean)parambg.next();
      paramList = new com.jiubang.goweather.a.a(paramList.b, paramList.a, paramList.c);
      this.d.add(paramList);
    }
  }
  
  protected Void a(Void... paramVarArgs)
  {
    a();
    return null;
  }
  
  public void a()
  {
    b localb = new b(bg.a(this.a), this.d, this);
    localb.a(false);
    localb.a(this.e);
  }
  
  public void a(List paramList, f paramf)
  {
    c.a("goweatherex", "刷新天气回调 - onErrorGeneral");
    this.g = paramf;
    paramList = bg.c(this.a).obtainMessage();
    paramList.obj = this;
    bg.c(this.a).sendMessage(paramList);
  }
  
  public void b(List paramList, f paramf)
  {
    c.a("goweatherex", "刷新天气回调 - onNetworkUnavailable");
    this.g = paramf;
    paramList = bg.c(this.a).obtainMessage();
    paramList.obj = this;
    bg.c(this.a).sendMessage(paramList);
  }
  
  public void c(List paramList, f paramf)
  {
    c.a("goweatherex", "刷新天气回调 - onSuccess");
    this.g = paramf;
    paramList = bg.c(this.a).obtainMessage();
    paramList.obj = this;
    bg.c(this.a).sendMessage(paramList);
  }
  
  public void d(List paramList, f paramf)
  {
    c.a("goweatherex", "刷新天气回调 - onNoNewData");
    this.g = paramf;
    paramList = bg.c(this.a).obtainMessage();
    paramList.obj = this;
    bg.c(this.a).sendMessage(paramList);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */