package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.gau.go.launcherex.goweather.livewallpaper.a.a;
import com.gau.go.launcherex.goweather.livewallpaper.a.b;
import com.gau.go.launcherex.goweather.livewallpaper.a.e;
import com.gau.go.launcherex.goweather.livewallpaper.a.f;
import com.gau.go.launcherex.goweather.livewallpaper.a.g;
import com.gau.go.launcherex.goweather.livewallpaper.b.h;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;
import java.util.List;

public class p
{
  private List a;
  private boolean b;
  private Context c;
  
  public p(Context paramContext)
  {
    this.c = paramContext;
    this.a = new ArrayList();
    int i = 0;
    while (i < 9)
    {
      paramContext = new f();
      this.a.add(paramContext);
      i += 1;
    }
    this.b = true;
  }
  
  private float a(Paint paramPaint, float paramFloat)
  {
    paramPaint.setTextSize(paramFloat);
    paramPaint = paramPaint.getFontMetrics();
    return (float)Math.ceil(paramPaint.descent - paramPaint.ascent);
  }
  
  private float a(Paint paramPaint, String paramString)
  {
    float f = 0.0F;
    if (!TextUtils.isEmpty(paramString)) {
      f = paramPaint.measureText(paramString);
    }
    return f;
  }
  
  private float a(String paramString, float paramFloat1, Paint paramPaint, float paramFloat2)
  {
    paramPaint.setTextSize(paramFloat2);
    return a(paramPaint, paramString) + paramFloat1;
  }
  
  private Resources a(Context paramContext, String paramString)
  {
    try
    {
      paramString = paramContext.createPackageContext(paramString, 3);
      if (paramString == null) {
        return paramContext.getResources();
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
        continue;
        paramContext = paramString;
      }
    }
  }
  
  private String a(int paramInt, float paramFloat, String paramString)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.c.getString(2131165880) + " : " + paramFloat + " " + this.c.getString(2131165334) + " , " + paramString;
    case 1: 
      return this.c.getString(2131165880) + " : " + q.c(paramFloat, 1) + " " + this.c.getString(2131165333) + " , " + paramString;
    case 4: 
      return this.c.getString(2131165880) + " : " + q.e(paramFloat, 1) + " " + this.c.getString(2131165336) + " , " + paramString;
    case 3: 
      return this.c.getString(2131165880) + " : " + q.d(paramFloat, 1) + " " + this.c.getString(2131165335) + " , " + paramString;
    case 6: 
      return this.c.getString(2131165880) + " : " + q.f(paramFloat, 1) + " " + this.c.getString(2131165338) + " , " + paramString;
    }
    return this.c.getString(2131165343, new Object[] { paramString, Integer.valueOf(q.a(paramFloat)) });
  }
  
  private String a(g paramg, e parame, Resources paramResources)
  {
    int i = paramg.d();
    paramg = parame.g();
    float f = parame.h();
    boolean bool1 = r.a(paramg);
    boolean bool2 = r.b(f);
    if ((bool1) || (bool2))
    {
      if (bool2)
      {
        if (bool1) {
          return a(i, f, paramg);
        }
        return "--";
      }
      return "" + paramResources.getString(2131165880) + " : " + paramg;
    }
    return "--";
  }
  
  private String a(String paramString, int paramInt)
  {
    if (!r.b(paramInt)) {
      return "--";
    }
    return paramInt + paramString;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean != this.b)
    {
      this.b = paramBoolean;
      bool = true;
    }
    return bool;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(paramString)) {}
    for (Resources localResources = this.c.getResources();; localResources = a(this.c, paramString))
    {
      com.gau.go.launcherex.goweather.livewallpaper.a.d locald = new com.gau.go.launcherex.goweather.livewallpaper.a.d();
      locald.a(paramInt, paramBoolean, localResources, paramString, this.c.getResources());
      paramString = (f)this.a.get(0);
      paramString.a(locald.a());
      paramString.b(locald.h());
      paramString = (f)this.a.get(1);
      paramString.a(locald.a());
      paramString.b(locald.h());
      paramString = (f)this.a.get(2);
      paramString.a(locald.a());
      paramString.b(locald.h());
      paramString = (f)this.a.get(3);
      paramString.a(locald.e());
      paramString.b(locald.h());
      paramString = (f)this.a.get(4);
      paramString.a(locald.d());
      paramString.b(locald.h());
      paramString = (f)this.a.get(5);
      paramString.a(locald.b());
      paramString.b(locald.f());
      paramString = (f)this.a.get(6);
      paramString.a(locald.d());
      paramString.b(locald.h());
      paramString = (f)this.a.get(7);
      paramString.a(locald.c());
      paramString.b(locald.g());
      paramString = (f)this.a.get(8);
      paramString.a(locald.d());
      paramString.b(locald.h());
      return;
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (this.b)
    {
      int j = this.a.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.a.get(i);
        if (localf.d())
        {
          paramPaint.setTextSize(localf.e());
          paramPaint.setColor(localf.f());
          paramPaint.setShadowLayer(1.0F, 0.0F, 1.0F, localf.g());
          paramCanvas.drawText(localf.a(), localf.b(), localf.c(), paramPaint);
        }
        i += 1;
      }
      paramPaint.clearShadowLayer();
    }
  }
  
  public void a(e parame, g paramg, com.gau.go.launcherex.goweather.livewallpaper.a.c paramc, boolean paramBoolean, Resources paramResources)
  {
    this.b = paramc.c();
    com.gtp.a.a.b.c.a("wallpaper", "wallpaperSettingBean.isDisplayInfo(): -- mIsVisible: " + this.b);
    if (this.b)
    {
      paramBoolean = h.d(this.c);
      com.gtp.a.a.b.c.a("wallpaper", "WeatherInfoPanel.init(): -- isScreenLockEnabled: " + paramBoolean);
      i = paramc.b();
      com.gtp.a.a.b.c.a("wallpaper", "WeatherInfoPanel.init(): -- displayTiming: " + i);
      if (((paramBoolean) && (i == 1)) || ((!paramBoolean) && (i == 2))) {
        this.b = false;
      }
    }
    com.gtp.a.a.b.c.a("wallpaper", "wallpaperSettingBean.isDisplayInfo()-- after: -- mIsVisible: " + this.b);
    Object localObject2 = this.c.getResources();
    Object localObject1 = paramResources;
    if (paramResources == null) {
      localObject1 = localObject2;
    }
    paramResources = paramc.b((Resources)localObject2);
    float f4 = paramResources.a();
    float f1 = paramResources.b();
    Object localObject3 = (f)this.a.get(0);
    if (!parame.a())
    {
      f2 = paramResources.n();
      f3 = a(new Paint(), f2);
      ((f)localObject3).a(f4, paramc.a((Resources)localObject2) + f3 + f1, f2, ((Resources)localObject1).getString(2131165819), true);
      int j = this.a.size();
      i = 1;
      while (i < j)
      {
        ((f)this.a.get(i)).a(false);
        i += 1;
      }
    }
    float f3 = paramResources.c();
    Paint localPaint = new Paint();
    float f2 = a(localPaint, f3);
    f1 = paramc.a((Resources)localObject2) + f2 + f1;
    ((f)localObject3).a(f4, f1, f3, parame.d(), true);
    localObject3 = paramg.b();
    int i = paramg.c();
    f2 = parame.a(i);
    boolean bool1 = parame.c(f2);
    f1 += paramResources.d();
    float f5;
    boolean bool2;
    if (bool1)
    {
      localf = (f)this.a.get(1);
      f3 = paramResources.e();
      f5 = a(localPaint, f3);
      f1 += f5;
      localObject2 = String.valueOf(q.a(f2));
      localf.a(f4, f1, f3, (String)localObject2, true);
      localf = (f)this.a.get(2);
      f3 = paramResources.f();
      localf.a(f4 + a(localPaint, (String)localObject2), a(localPaint, f3) + paramResources.l() + (f1 - f5), f3, (String)localObject3, true);
      localObject2 = paramc.a();
      localf = (f)this.a.get(3);
      bool2 = parame.f();
      if (!bool2) {
        break label845;
      }
      paramc = parame.e();
      label601:
      paramBoolean = ((a)localObject2).a();
      localf.a(paramBoolean);
      if (!paramBoolean) {
        break label857;
      }
      f2 = paramResources.i();
      f1 += a(localPaint, f2) + paramResources.g();
      localf.a(f4, f1, f2, paramc, paramBoolean);
    }
    for (;;)
    {
      if ((bool2) || (bool1)) {
        break label898;
      }
      f2 = paramResources.n();
      f1 = a(localPaint, f2) + f1;
      localf.b(f1);
      localf.a(f4, f1, f2, ((Resources)localObject1).getString(2131165818), true);
      ((f)this.a.get(4)).a(false);
      ((f)this.a.get(5)).a(false);
      ((f)this.a.get(6)).a(false);
      ((f)this.a.get(7)).a(false);
      ((f)this.a.get(8)).a(false);
      return;
      ((f)this.a.get(1)).a(false);
      ((f)this.a.get(2)).a(false);
      break;
      label845:
      paramc = ((Resources)localObject1).getString(2131165323);
      break label601;
      label857:
      f2 = f1;
      if (bool1) {
        f2 = f1 + paramResources.g();
      }
      localf.a(f4, f2, f3, paramc, paramBoolean);
      f1 = f2;
    }
    label898:
    f localf = (f)this.a.get(4);
    bool1 = ((a)localObject2).b();
    f2 = paramResources.j();
    if (bool1)
    {
      f3 = a(localPaint, f2);
      if (paramBoolean)
      {
        f1 += f3 + paramResources.h();
        paramc = ((Resources)localObject1).getString(2131165341);
        localf.a(f4, f1, f2, paramc, bool1);
        localf = (f)this.a.get(5);
        f3 = parame.c(i);
        f5 = f4 + a(localPaint, paramc);
        if (!parame.c(f3)) {
          break label1282;
        }
        paramc = a((String)localObject3, q.a(f3));
        label1040:
        localf.a(f5, f1, f2, paramc, bool1);
        localf = (f)this.a.get(6);
        f3 = f5 + a(localPaint, paramc);
        paramc = " " + ((Resources)localObject1).getString(2131165342);
        localf.a(f3, f1, f2, paramc, bool1);
        localf = (f)this.a.get(7);
        f5 = a(localPaint, paramc);
        float f6 = parame.b(i);
        if (!parame.c(f6)) {
          break label1296;
        }
        paramc = a((String)localObject3, q.a(f6));
        label1179:
        localf.a(f3 + f5, f1, f2, paramc, bool1);
        f2 = f1;
        label1201:
        paramc = (f)this.a.get(8);
        if (!bool1) {
          break label1374;
        }
        f1 = f2 + paramResources.m();
      }
    }
    for (;;)
    {
      f2 = paramResources.k();
      f3 = a(localPaint, f2);
      parame = a(paramg, parame, (Resources)localObject1);
      if (!parame.equals("--")) {
        break label1396;
      }
      paramc.a(false);
      return;
      f1 += f3;
      break;
      label1282:
      paramc = this.c.getString(2131165323);
      break label1040;
      label1296:
      paramc = ((Resources)localObject1).getString(2131165323);
      break label1179;
      localf.a(false);
      ((f)this.a.get(5)).a(false);
      ((f)this.a.get(6)).a(false);
      ((f)this.a.get(7)).a(false);
      f2 = f1;
      break label1201;
      label1374:
      f1 = f2;
      if (paramBoolean) {
        f1 = f2 + paramResources.h();
      }
    }
    label1396:
    paramc.a(f4, f3 + f1, f2, parame, ((a)localObject2).c());
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      if (paramInt != 1) {
        break label23;
      }
      bool1 = a(true);
    }
    label23:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramInt != 2);
    return a(false);
  }
  
  public boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        break label45;
      }
      if (paramInt != 1) {
        break label30;
      }
      bool1 = a(false);
    }
    label30:
    label45:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramInt != 2);
      return a(true);
      if (paramInt == 1) {
        return a(true);
      }
      bool1 = bool2;
    } while (paramInt != 2);
    return a(false);
  }
  
  public boolean a(e parame, g paramg, Resources paramResources)
  {
    boolean bool1 = true;
    Resources localResources = paramResources;
    if (paramResources == null) {
      localResources = this.c.getResources();
    }
    paramResources = new Paint();
    String str1 = paramg.b();
    int j = paramg.c();
    Object localObject = (f)this.a.get(1);
    float f1;
    float f2;
    int i;
    if (((f)localObject).d())
    {
      paramg = String.valueOf(q.a(parame.a(j)));
      f1 = ((f)localObject).b();
      ((f)localObject).a(paramg);
      f2 = ((f)localObject).e();
      localObject = (f)this.a.get(2);
      ((f)localObject).a(a(paramg, f1, paramResources, f2));
      ((f)localObject).a(str1);
      i = 2;
    }
    for (;;)
    {
      i += 3;
      localObject = (f)this.a.get(i);
      boolean bool2 = bool1;
      float f3;
      if (((f)localObject).d())
      {
        paramResources.setTextSize(((f)localObject).e());
        f1 = ((f)localObject).b();
        f2 = parame.c(j);
        if (!parame.c(f2)) {
          break label353;
        }
        paramg = a(str1, q.a(f2));
        ((f)localObject).a(paramg);
        localObject = this.a;
        i += 1;
        localObject = (f)((List)localObject).get(i);
        f2 = a(paramResources, paramg);
        String str2 = ((f)localObject).a();
        f1 = f2 + f1;
        ((f)localObject).a(f1);
        paramg = (f)this.a.get(i + 1);
        f2 = a(paramResources, str2);
        f3 = parame.b(j);
        if (!parame.c(f3)) {
          break label365;
        }
      }
      label353:
      label365:
      for (parame = a(str1, q.a(f3));; parame = localResources.getString(2131165323))
      {
        paramg.a(f2 + f1);
        paramg.a(parame);
        bool2 = bool1 | true;
        return bool2;
        paramg = localResources.getString(2131165323);
        break;
      }
      i = 1;
      bool1 = false;
    }
  }
  
  public boolean b(e parame, g paramg, Resources paramResources)
  {
    int i = this.a.size();
    f localf = (f)this.a.get(i - 1);
    if (localf.d())
    {
      parame = a(paramg, parame, paramResources);
      if ("--".equals(parame)) {
        localf.a(false);
      }
      for (;;)
      {
        return true;
        localf.a(parame);
      }
    }
    return false;
  }
  
  public void c(e parame, g paramg, Resources paramResources)
  {
    f localf = (f)this.a.get(4);
    String str = paramResources.getString(2131165341);
    float f1 = localf.b();
    localf.a(str);
    Paint localPaint = new Paint();
    localPaint.setTextSize(localf.e());
    float f2 = a(localPaint, str);
    localf = (f)this.a.get(5);
    str = localf.a();
    f1 = f2 + f1;
    localf.a(f1);
    f1 += a(localPaint, str);
    localf = (f)this.a.get(6);
    str = " " + paramResources.getString(2131165342);
    localf.a(str);
    localf.a(f1);
    f2 = a(localPaint, str);
    ((f)this.a.get(7)).a(f1 + f2);
    ((f)this.a.get(8)).a(a(paramg, parame, paramResources));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */