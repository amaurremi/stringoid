package com.gau.go.launcherex.gowidget.weather.a;

import android.content.Context;

public abstract class a
{
  protected final Context a;
  protected String b;
  private b c;
  
  public a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  protected void a(com.gau.go.launcherex.gowidget.weather.a.a.a parama)
  {
    if (this.c != null) {
      this.c.a(this, parama);
    }
  }
  
  public void a(b paramb)
  {
    this.c = paramb;
  }
  
  public void a(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */