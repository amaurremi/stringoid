package com.gau.go.launcherex.goweather.goplay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.widget.Toast;
import com.gau.go.launcherex.goweather.goplay.a.b;
import com.gau.go.launcherex.gowidget.messagecenter.util.c;
import com.gau.go.launcherex.gowidget.messagecenter.util.g;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globaltheme.h;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.common.PackageEventReceiver;
import com.jiubang.playsdk.main.BitmapBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThemeDataHandler
  implements g
{
  private static volatile ThemeDataHandler a = null;
  private Context b;
  private b c;
  private final com.gau.go.launcherex.gowidget.weather.globaltheme.d d;
  private c e;
  private final ArrayList f = new ArrayList();
  private final List g = new ArrayList();
  private ThemeDataHandler.EventReceiver h;
  private final PackageEventReceiver i = new PackageEventReceiver();
  private final com.go.weatherex.common.a j = new e(this);
  
  private ThemeDataHandler(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    this.b = paramContext;
    this.c = new b();
    this.d = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(paramContext);
    this.e = new c(paramContext);
    this.e.a(this);
    b();
    this.i.a(paramContext);
    this.i.a(this.j);
    this.h = new ThemeDataHandler.EventReceiver(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USED_COUPON_ID");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_THEME_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GOWIDGET_THEME_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APP_THEME_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_THEME_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
    paramContext.registerReceiver(this.h, localIntentFilter);
  }
  
  public static ThemeDataHandler a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ThemeDataHandler(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = this.c.a(paramString);
    if (locale != null)
    {
      if (!locale.D()) {
        break label61;
      }
      if (locale.m()) {
        this.d.a(0, this.c.a(this.b, 1));
      }
      this.c.c(locale);
    }
    for (;;)
    {
      e(paramString);
      return;
      label61:
      if ((locale.s()) && (locale.t()))
      {
        if (locale.m()) {
          this.d.a(1, this.c.a(this.b, 3));
        }
        this.c.i(locale);
      }
      else if (locale.C())
      {
        if (locale.m()) {
          this.d.a(2, this.c.a(this.b, 2));
        }
        this.c.f(locale);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Iterator localIterator = new ArrayList(this.g).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(paramString, paramInt);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Iterator localIterator = new ArrayList(this.g).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(paramBoolean);
    }
  }
  
  private void b()
  {
    this.f.clear();
    this.e.a();
  }
  
  private void b(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    if (parame != null)
    {
      parame.a(this.f);
      if (!parame.D()) {
        break label28;
      }
      this.c.a(parame);
    }
    label28:
    do
    {
      return;
      if ((parame.s()) && (parame.t()))
      {
        this.c.g(parame);
        return;
      }
    } while (!parame.C());
    this.c.d(parame);
  }
  
  private void b(String paramString)
  {
    b(this.d.a(paramString));
    d(paramString);
  }
  
  private void c()
  {
    Iterator localIterator = new ArrayList(this.g).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a_();
    }
  }
  
  private void c(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    if (parame != null)
    {
      parame.a(this.f);
      if (!parame.D()) {
        break label28;
      }
      this.c.b(parame);
    }
    label28:
    do
    {
      return;
      if ((parame.s()) && (parame.t()))
      {
        this.c.h(parame);
        return;
      }
    } while (!parame.C());
    this.c.e(parame);
  }
  
  private void c(String paramString)
  {
    c(this.d.a(paramString));
    f(paramString);
  }
  
  private void d(String paramString)
  {
    Iterator localIterator = new ArrayList(this.g).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(paramString);
    }
  }
  
  private void e(String paramString)
  {
    Iterator localIterator = new ArrayList(this.g).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).b(paramString);
    }
  }
  
  private void f(String paramString)
  {
    Iterator localIterator = new ArrayList(this.g).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).c(paramString);
    }
  }
  
  public com.gau.go.launcherex.gowidget.weather.globaltheme.b.e a(com.jiubang.playsdk.a.a parama)
  {
    return this.c.a(parama);
  }
  
  public BitmapBean a(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    BitmapBean localBitmapBean = new BitmapBean();
    parama = a(parama);
    if (parama != null)
    {
      paramContext = parama.a(paramContext);
      if ((paramContext != null) && ((paramContext instanceof BitmapDrawable))) {
        localBitmapBean.a(((BitmapDrawable)paramContext).getBitmap());
      }
    }
    return localBitmapBean;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (r.a(paramContext, "com.kittyplay.ex"))
    {
      Intent localIntent = new Intent("com.jiubang.go.gomarket.appgame_MAIN.kittyplay");
      localIntent.putExtra("APPS_MANAGEMENT_ENTRANCE_KEY", 24);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    r.b(paramContext, "market://details?id=com.kittyplay.ex&referrer=utm_source%3Dweather%26utm_medium%3DHyperlink%26utm_campaign%3Dgetmorethemes", "com.kittyplay.ex");
  }
  
  public void a(f paramf)
  {
    if ((paramf == null) || (this.g.contains(paramf))) {
      return;
    }
    this.g.add(paramf);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      SparseArray localSparseArray = new SparseArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.b.a locala = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.a)paramArrayList.next();
        if ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.a)localSparseArray.get(locala.b()) == null) {
          localSparseArray.append(locala.b(), locala);
        }
      }
      int m = localSparseArray.size();
      int k = 0;
      while (k < m)
      {
        this.f.add(localSparseArray.valueAt(k));
        k += 1;
      }
    }
    a(a());
  }
  
  public boolean a()
  {
    return (this.f != null) && (!this.f.isEmpty());
  }
  
  public boolean a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    return this.c.j(parame);
  }
  
  public ArrayList b(Context paramContext)
  {
    if (!this.c.b())
    {
      paramContext = this.d.d();
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext()) {
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next()).a(this.f);
      }
      this.c.a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e.a(paramContext));
    }
    return this.c.c();
  }
  
  public ArrayList b(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    Object localObject = h.a(paramContext, a(parama));
    parama = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parama.add(new BitmapBean((Bitmap)((Iterator)localObject).next(), ""));
    }
    if (parama.size() == 0) {
      parama.add(new BitmapBean(BitmapFactory.decodeResource(paramContext.getResources(), 2130838862), ""));
    }
    return parama;
  }
  
  public void b(f paramf)
  {
    if ((paramf == null) || (!this.g.contains(paramf))) {
      return;
    }
    this.g.remove(paramf);
  }
  
  public void b(ArrayList paramArrayList) {}
  
  public ArrayList c(Context paramContext)
  {
    if (!this.c.d())
    {
      ArrayList localArrayList = this.d.c();
      if (!y.p(paramContext.getApplicationContext())) {
        localArrayList.add(com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.c(paramContext.getApplicationContext().getResources()));
      }
      paramContext = localArrayList.iterator();
      while (paramContext.hasNext()) {
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)paramContext.next()).a(this.f);
      }
      this.c.b(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e.a(localArrayList));
    }
    return this.c.e();
  }
  
  public void c(ArrayList paramArrayList) {}
  
  public boolean c(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    paramContext = a(parama);
    if (paramContext != null) {
      return paramContext.m();
    }
    return false;
  }
  
  public ArrayList d(Context paramContext)
  {
    if (!this.c.f())
    {
      paramContext = this.d.b();
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext()) {
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next()).a(this.f);
      }
      this.c.c(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e.a(paramContext));
    }
    return this.c.g();
  }
  
  public void d(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    parama = a(parama);
    Intent localIntent;
    if (parama != null)
    {
      localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("text/plain");
      localIntent.putExtra("android.intent.extra.SUBJECT", paramContext.getString(2131165826));
      localIntent.putExtra("android.intent.extra.TEXT", paramContext.getString(2131165827, new Object[] { parama.w() }));
    }
    try
    {
      paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(2131165347)));
      return;
    }
    catch (ActivityNotFoundException parama)
    {
      Toast.makeText(paramContext, 2131165348, 0).show();
    }
  }
  
  public boolean e(Context paramContext)
  {
    return com.gau.go.launcherex.gowidget.weather.d.f.a(paramContext).c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/ThemeDataHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */