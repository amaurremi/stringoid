package com.gau.go.launcherex.gowidget.weather.c;

import android.content.Context;
import android.content.IntentFilter;
import android.text.format.Time;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.o;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.Calendar;

public class g
  extends b
{
  private static final String[] f = { "%Y/%m/%d", "%m/%d/%Y", "%d/%m/%Y" };
  private static final String[] g = { "%m/%d", "%m/%d", "%d/%m" };
  private static final int[] h = { 2131165326, 2131165327, 2131165328, 2131165329, 2131165330, 2131165331, 2131165332 };
  private Context a;
  private q b;
  private i c;
  private Time d = new Time();
  private boolean e = false;
  private String i = f[0];
  private com.jiubang.b.b.b j = null;
  private com.jiubang.b.b.c k = null;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
    this.c = new i(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.TIMEZONE_CHANGED");
    this.a.registerReceiver(this.c, paramContext);
  }
  
  public String a(Time paramTime)
  {
    return paramTime.format(this.i);
  }
  
  public void a()
  {
    this.d = new Time();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    if (paramInt1 == 0) {
      if ((paramInt2 >= 0) && (paramInt2 < f.length)) {
        this.i = f[paramInt2];
      }
    }
    while ((paramInt1 != 1) || (paramInt2 < 0) || (paramInt2 >= g.length)) {
      return;
    }
    this.i = g[paramInt2];
  }
  
  protected void a(o paramo)
  {
    boolean bool2 = true;
    super.a(paramo);
    this.b = c.a(this.a).f().a();
    if (this.b.h == 1)
    {
      bool1 = true;
      b(bool1);
      d(this.b.i);
      a(1, this.b.k);
      if (this.b.r != 1) {
        break label95;
      }
    }
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(bool1);
      a(6);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public Time b(int paramInt)
  {
    this.d.setToNow();
    if ((this.e) && (paramInt != 55536)) {
      this.d.set(this.d.toMillis(true) - (this.d.gmtoff * 1000L - paramInt));
    }
    return this.d;
  }
  
  public String b(Time paramTime)
  {
    int n = 1;
    if ("zh".equalsIgnoreCase(d.a(this.a).b())) {}
    for (int m = 1;; m = 0)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      boolean bool = r.b(this.a);
      String str = paramTime.format(this.i);
      int i1 = paramTime.hour;
      if ((i1 >= 0) && (i1 < 12))
      {
        if (m == 0) {
          break label204;
        }
        localStringBuffer.append(str);
        localStringBuffer.append("，");
        m = Integer.parseInt(paramTime.format("%w"));
        localStringBuffer.append(this.a.getText(h[m]));
        localStringBuffer.append("，");
        if (bool) {
          break label189;
        }
        if (n == 0) {
          break label171;
        }
        localStringBuffer.append(this.a.getText(2131165339));
        label148:
        localStringBuffer.append(paramTime.format("%I:%M"));
      }
      for (;;)
      {
        return localStringBuffer.toString();
        n = 0;
        break;
        label171:
        localStringBuffer.append(this.a.getText(2131165340));
        break label148;
        label189:
        localStringBuffer.append(paramTime.format("%H:%M"));
        continue;
        label204:
        m = Integer.parseInt(paramTime.format("%w"));
        localStringBuffer.append(this.a.getText(h[m]));
        localStringBuffer.append(" ");
        localStringBuffer.append(str);
        localStringBuffer.append(" ");
        if (!bool)
        {
          localStringBuffer.append(paramTime.format("%I:%M "));
          if (n != 0) {
            localStringBuffer.append(this.a.getText(2131165339));
          } else {
            localStringBuffer.append(this.a.getText(2131165340));
          }
        }
        else
        {
          localStringBuffer.append(paramTime.format("%H:%M"));
        }
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.a.unregisterReceiver(this.c);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.k = new com.jiubang.b.b.c(this.a);
      return;
    }
    this.k = null;
  }
  
  public Time c()
  {
    this.d.setToNow();
    return this.d;
  }
  
  public Time c(int paramInt)
  {
    this.d.setToNow();
    if (paramInt != 55536) {
      this.d.set(this.d.toMillis(true) - (this.d.gmtoff * 1000L - paramInt));
    }
    return this.d;
  }
  
  public String c(Time paramTime)
  {
    Object localObject = "";
    if (this.j != null)
    {
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(paramTime.toMillis(false));
      localObject = this.j.a((Calendar)localObject);
    }
    return (String)localObject;
  }
  
  public String d(Time paramTime)
  {
    Object localObject = "";
    if (this.k != null)
    {
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(paramTime.toMillis(false));
      localObject = this.k.a((Calendar)localObject, true);
    }
    return (String)localObject;
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 0)
    {
      this.j = null;
      return;
    }
    int m = 1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.j = new com.jiubang.b.b.b(this.a, paramInt, m);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      m = 2131034120;
      continue;
      m = 2131034119;
      continue;
      m = 2131034118;
    }
  }
  
  public boolean d()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */