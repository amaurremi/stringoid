package com.go.weatherex.themestore;

import android.content.Context;
import com.jiubang.playsdk.main.BitmapBean;
import com.jiubang.playsdk.main.c;

public class e
  extends com.gau.go.launcherex.gowidget.weather.service.a.a
{
  private c a;
  private com.jiubang.playsdk.a.a b;
  private String c;
  private Context d;
  private BitmapBean e;
  
  public e(Context paramContext, c paramc, com.jiubang.playsdk.a.a parama, String paramString)
  {
    this.d = paramContext;
    this.a = paramc;
    this.b = parama;
    this.c = paramString;
  }
  
  protected void a()
  {
    this.e = this.a.b(this.d, this.b);
  }
  
  protected boolean a(com.gau.go.launcherex.gowidget.weather.service.a.a parama)
  {
    if (!e.class.isInstance(parama)) {
      return false;
    }
    parama = (e)parama;
    return this.c.equals(parama.c);
  }
  
  public BitmapBean c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */