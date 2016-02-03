package com.gau.go.launcherex.gowidget.weather.a;

import android.content.Context;

public class c
  extends a
{
  private e c;
  private final boolean d;
  
  public c(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.d = paramBoolean;
  }
  
  private void b()
  {
    if (this.c != null)
    {
      this.c.cancel(true);
      this.c = null;
    }
  }
  
  public void a()
  {
    b();
    this.b = null;
  }
  
  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(this.b))) {
      return;
    }
    b();
    this.b = paramString;
    this.c = new e(this, null);
    this.c.execute(new String[] { this.b });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */