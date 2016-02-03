package com.gau.go.launcherex.gowidget.weather.a;

import android.content.Context;
import android.text.TextUtils;
import com.jiubang.goweather.b.e;

public class f
  extends a
{
  private h c;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b()
  {
    if (this.c != null)
    {
      this.c.cancel(true);
      this.c = null;
    }
  }
  
  private e c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("http://").append("goweatherex.3g.cn").append("/goweatherex/city/search");
    localObject = new e(((StringBuilder)localObject).toString(), 5000, 5000);
    ((e)localObject).a("k", paramString);
    ((e)localObject).a(this.a);
    return (e)localObject;
  }
  
  private e d(String paramString)
  {
    return new e(paramString, 5000, 5000);
  }
  
  public void a()
  {
    b();
    this.b = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b();
    this.c = new h(this, null);
    this.c.execute(new e[] { d(paramString) });
  }
  
  public void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.b))) {
      return;
    }
    b();
    this.b = paramString;
    this.c = new h(this, null);
    this.c.execute(new e[] { c(this.b) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */