package com.gtp.go.weather.sharephoto.award;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.a.b;
import com.gau.go.launcherex.gowidget.weather.service.a.g;
import com.gtp.go.weather.sharephoto.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class k
{
  private Context a;
  private n b;
  private final List c = new ArrayList();
  private SharedPreferences d;
  private final g e = new l(this);
  
  public k(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new n(this.a.getContentResolver(), this);
    this.d = GoWidgetApplication.c(this.a.getApplicationContext()).a();
    b.a(this.e);
  }
  
  private void a(int paramInt, boolean paramBoolean, String paramString)
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).a(paramInt, paramBoolean, paramString);
    }
  }
  
  public static void a(Context paramContext)
  {
    b.a(new w(paramContext));
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2)
  {
    b.a(new t(paramContext, paramLong1, paramLong2));
  }
  
  public static void a(Context paramContext, d paramd)
  {
    b.a(new u(paramContext, paramd));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    b.a(new a(paramContext, paramString));
  }
  
  private void a(d paramd)
  {
    long l = paramd.a();
    this.b.a(2, paramd, WeatherContentProvider.z, null, "user_award_id=?", new String[] { String.valueOf(l) }, "_id");
  }
  
  private void a(d paramd, List paramList)
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).a(paramd, paramList);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).a(paramBoolean, paramInt);
    }
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).a(paramBoolean, paramLong1, paramLong2);
    }
  }
  
  public static void b(Context paramContext)
  {
    b.a(new v(paramContext));
  }
  
  private void b(List paramList)
  {
    new q(this).execute(new List[] { paramList });
  }
  
  private void c()
  {
    this.b.a(1, null, WeatherContentProvider.y, null, null, null, "award_time");
  }
  
  private void c(List paramList)
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).a(paramList);
    }
  }
  
  private void d()
  {
    this.b.a(3, null, WeatherContentProvider.A, null, null, null, "_id");
  }
  
  private void d(List paramList)
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).b(paramList);
    }
  }
  
  public void a()
  {
    this.c.clear();
    b.b(this.e);
  }
  
  public void a(o paramo)
  {
    if (this.c.contains(paramo)) {
      return;
    }
    this.c.add(paramo);
  }
  
  public void a(com.gtp.go.weather.sharephoto.b.k paramk)
  {
    paramk.a(false);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("need_show", Integer.valueOf(0));
    int i = paramk.b();
    this.b.a(-1, paramk, WeatherContentProvider.A, localContentValues, "prompt_id=?", new String[] { String.valueOf(i) });
  }
  
  public void a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Long.valueOf(((d)paramList.next()).a()));
    }
    b.a(new m(this, localArrayList));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(this.a);
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean, d paramd)
  {
    if (paramBoolean)
    {
      a(this.a, paramd);
      return;
    }
    a(paramd);
  }
  
  public void b()
  {
    new p(this, null).execute(new Void[0]);
  }
  
  public void b(o paramo)
  {
    this.c.remove(paramo);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(this.a);
      return;
    }
    d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */