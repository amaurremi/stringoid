package com.gau.go.launcherex.goweather.goplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.main.BitmapBean;
import com.jiubang.playsdk.main.i;
import com.jiubang.playsdk.main.j;
import com.jiubang.playsdk.main.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.util.EncodingUtils;

public class q
  extends com.jiubang.playsdk.main.c
{
  private int b = 40;
  private int c = 40;
  private String d;
  private final Map e = new HashMap();
  
  public q()
  {
    this.a = 84;
  }
  
  public static void e(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW_REFRESH");
    localIntent.addCategory(paramContext.getPackageName());
    paramContext.sendBroadcast(localIntent);
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    b localb = (b)this.e.get(paramContext);
    if (localb != null) {
      return localb.a(paramContext, parama);
    }
    return null;
  }
  
  public View a(Context paramContext, com.jiubang.playsdk.a.a parama, i parami)
  {
    b localb = (b)this.e.get(paramContext);
    if (localb != null) {
      return localb.a(paramContext, parama, parami);
    }
    return null;
  }
  
  public View a(Context paramContext, i parami)
  {
    b localb = (b)this.e.get(paramContext);
    if (localb != null) {
      return localb.a(paramContext, parami);
    }
    return null;
  }
  
  public String a(Context paramContext, s params)
  {
    int j = 2131099649;
    int i = j;
    switch (params.b())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      params = paramContext.getResources().openRawResource(i);
      try
      {
        paramContext = new byte[params.available()];
        params.read(paramContext);
        paramContext = EncodingUtils.getString(paramContext, "utf-8");
        if (params != null) {}
        try
        {
          params.close();
          return paramContext;
        }
        catch (IOException params)
        {
          params.printStackTrace();
        }
        i = 2131099680;
        continue;
        i = 2131099648;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = "";
        }
      }
    }
    return paramContext;
  }
  
  public ArrayList a(Context paramContext, int paramInt)
  {
    if (ThemeDataHandler.a(paramContext) != null) {}
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ThemeDataHandler.a(paramContext).b(paramContext);
    case 2: 
      return ThemeDataHandler.a(paramContext).c(paramContext);
    }
    return ThemeDataHandler.a(paramContext).d(paramContext);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(Context paramContext, int paramInt, com.jiubang.playsdk.a.a parama, j paramj)
  {
    if (com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext.getApplicationContext()).e().c()) {
      if (paramj != null) {
        paramj.a();
      }
    }
    do
    {
      return;
      if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.k(parama.a(), paramContext.getApplicationContext())) {
        break;
      }
    } while (paramj == null);
    paramj.a();
    return;
    com.go.weatherex.managegood.a.n localn = com.go.weatherex.managegood.a.n.a();
    localn.a(paramContext, new com.go.weatherex.managegood.b.a(parama.a(), 1, aa.a().g(parama.a())));
    localn.a(paramj);
  }
  
  public void a(Context paramContext, e parame)
  {
    Intent localIntent = new Intent(paramContext, ThemeDetailActivity.class);
    localIntent.putExtra("extra_key_bean", parame);
    localIntent.putExtra("extra_key_type", 1);
    paramContext.startActivity(localIntent);
  }
  
  public void a(b paramb)
  {
    if ((paramb == null) || (this.e.get(paramb.b()) != null)) {
      return;
    }
    this.e.put(paramb.b(), paramb);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean a(Context paramContext)
  {
    if (ThemeDataHandler.a(paramContext) != null) {
      return ThemeDataHandler.a(paramContext).e(paramContext.getApplicationContext());
    }
    return false;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return super.a(paramContext, paramString1, paramString2);
  }
  
  public int b()
  {
    return 2131361878;
  }
  
  public View b(Context paramContext, i parami)
  {
    return null;
  }
  
  public BitmapBean b(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    if (ThemeDataHandler.a(paramContext) != null) {
      return ThemeDataHandler.a(paramContext).a(paramContext.getApplicationContext(), parama);
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.e.remove(paramb.b());
  }
  
  public boolean b(Context paramContext)
  {
    if (ThemeDataHandler.a(paramContext) != null) {
      return ThemeDataHandler.a(paramContext).a();
    }
    return false;
  }
  
  public boolean b(Context paramContext, int paramInt)
  {
    return super.b(paramContext, paramInt);
  }
  
  public int c()
  {
    return 2130839084;
  }
  
  public ArrayList c(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new s(paramContext.getString(2131166403), 40));
    localArrayList.add(new s(paramContext.getString(2131166405), 41));
    localArrayList.add(new s(paramContext.getString(2131166404), 39));
    return localArrayList;
  }
  
  public ArrayList c(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    ArrayList localArrayList = null;
    if (ThemeDataHandler.a(paramContext) != null) {
      localArrayList = ThemeDataHandler.a(paramContext).b(paramContext.getApplicationContext(), parama);
    }
    return localArrayList;
  }
  
  public void c(Context paramContext, int paramInt)
  {
    if (ThemeDataHandler.a(paramContext) != null) {
      ThemeDataHandler.a(paramContext).a(paramContext, paramInt);
    }
  }
  
  public int d()
  {
    return 2131361840;
  }
  
  public String d(Context paramContext)
  {
    return com.gau.go.launcherex.gowidget.statistics.y.w(paramContext);
  }
  
  public boolean d(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    if (ThemeDataHandler.a(paramContext) != null) {
      return ThemeDataHandler.a(paramContext).c(paramContext.getApplicationContext(), parama);
    }
    return false;
  }
  
  public int e()
  {
    return 2131361840;
  }
  
  public boolean e(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    if (ThemeDataHandler.a(paramContext) != null)
    {
      parama = ThemeDataHandler.a(paramContext).a(parama);
      if (parama != null)
      {
        b localb = (b)this.e.get(paramContext);
        if (localb != null) {
          localb.a().a((Activity)paramContext, parama);
        }
      }
    }
    return true;
  }
  
  public int f()
  {
    return 2130839068;
  }
  
  public boolean f(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    n.a(paramContext).a(parama.a(), parama.b(), parama.d(), parama.c());
    return super.f(paramContext, parama);
  }
  
  public int g()
  {
    return 2130838860;
  }
  
  public void g(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    Intent localIntent = new Intent(paramContext, ThemeDetailActivity.class);
    localIntent.putExtra("extra_key_bean", parama);
    localIntent.putExtra("extra_key_type", 2);
    localIntent.putExtra("cityId", this.d);
    paramContext.startActivity(localIntent);
  }
  
  public int h()
  {
    return 2130838873;
  }
  
  public void h(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    if (ThemeDataHandler.a(paramContext) != null) {
      ThemeDataHandler.a(paramContext).d(paramContext, parama);
    }
  }
  
  public int i()
  {
    return 2130838024;
  }
  
  public int j()
  {
    return 2130838887;
  }
  
  public int k()
  {
    return 2131361865;
  }
  
  public int l()
  {
    return 2130838861;
  }
  
  public int m()
  {
    return 2130837723;
  }
  
  public com.jiubang.playsdk.a.a.b n()
  {
    com.jiubang.playsdk.a.a.b localb = new com.jiubang.playsdk.a.a.b();
    localb.b(new int[] { 1, 3, 2 });
    localb.a(new int[] { 40, 41, 39 });
    localb.c(new int[] { 2130837601, 2130837586, 2130837967 });
    localb.d(new int[] { 2130837602, 2130837587, 2130837968 });
    localb.e(new int[] { 2131166403, 2131166405, 2131166404 });
    localb.a(2131361840);
    localb.b(2130838874);
    return localb;
  }
  
  public int o()
  {
    return super.o();
  }
  
  public int p()
  {
    return this.b;
  }
  
  public int q()
  {
    return this.c;
  }
  
  public int r()
  {
    return super.r();
  }
  
  public int s()
  {
    return 2130837730;
  }
  
  public int t()
  {
    return 2131166416;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */