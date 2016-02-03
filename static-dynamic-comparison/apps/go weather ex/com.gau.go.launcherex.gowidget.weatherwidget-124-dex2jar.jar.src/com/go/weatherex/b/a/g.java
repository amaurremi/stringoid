package com.go.weatherex.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.go.weatherex.d.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class g
{
  public static boolean a;
  private static g b = null;
  private static final boolean c;
  private Context d;
  private int e;
  private boolean f = false;
  private HashMap g = new HashMap();
  private a h;
  
  static
  {
    if (Build.VERSION.SDK_INT > 8) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      a = false;
      return;
    }
  }
  
  private g(Context paramContext)
  {
    this.d = paramContext;
    this.h = new a();
  }
  
  private int a(Context paramContext, ArrayList paramArrayList)
  {
    int i;
    int j;
    if (b(paramContext) + 1 >= paramArrayList.size())
    {
      i = 0;
      j = i;
    }
    for (;;)
    {
      com.go.weatherex.d.a locala = (com.go.weatherex.d.a)paramArrayList.get(j);
      if ((!d.b(paramContext, locala.g())) && (locala.h().equals("Z")))
      {
        return j;
        i = b(paramContext) + 1;
        break;
      }
      locala.a(false);
      int k = j + 1;
      j = k;
      if (k == paramArrayList.size()) {
        j = 0;
      }
      if (j == i) {
        return i;
      }
    }
  }
  
  public static g a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new g(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private i a(Activity paramActivity, com.go.weatherex.d.a parama)
  {
    i locali = new i(paramActivity);
    locali.a(parama);
    locali.setOnClickListener(new l(this, paramActivity, parama));
    return locali;
  }
  
  private void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("go_ad_share_prefs", 0).edit();
    paramContext.putInt("go_ad_share_banner_index", paramInt);
    paramContext.commit();
  }
  
  private void a(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences.edit().putInt("key_adid_enter_1", this.e).commit();
  }
  
  private int b(Context paramContext)
  {
    return paramContext.getSharedPreferences("go_ad_share_prefs", 0).getInt("go_ad_share_banner_index", -1);
  }
  
  private View b(Activity paramActivity)
  {
    return a(paramActivity);
  }
  
  private static void b(FrameLayout paramFrameLayout, Context paramContext)
  {
    paramContext = new com.go.weatherex.home.dayforecast.j(paramFrameLayout, (int)paramContext.getResources().getDimension(2131427799), 0);
    paramContext.setDuration(300L);
    paramFrameLayout.startAnimation(paramContext);
  }
  
  private com.go.weatherex.d.j c(Activity paramActivity)
  {
    com.go.weatherex.d.j localj = new com.go.weatherex.d.j(paramActivity);
    localj.setOnClickListener(new j(this, paramActivity, localj));
    return localj;
  }
  
  public View a(Activity paramActivity)
  {
    ArrayList localArrayList = com.go.weatherex.d.f.b(paramActivity.getApplicationContext());
    if (localArrayList.size() == 0) {
      return c(paramActivity);
    }
    int i = a(paramActivity.getApplicationContext(), localArrayList);
    if (!((com.go.weatherex.d.a)localArrayList.get(i)).b()) {
      return c(paramActivity);
    }
    a(paramActivity.getApplicationContext(), i);
    return a(paramActivity, (com.go.weatherex.d.a)localArrayList.get(i));
  }
  
  public void a()
  {
    this.h.a();
  }
  
  public void a(Activity paramActivity, FrameLayout paramFrameLayout)
  {
    a(paramActivity, paramFrameLayout, false);
  }
  
  public void a(Activity paramActivity, FrameLayout paramFrameLayout, boolean paramBoolean)
  {
    if (a) {
      paramFrameLayout.setVisibility(8);
    }
    label437:
    label455:
    do
    {
      return;
      Object localObject1 = GoWidgetApplication.c(paramActivity.getApplicationContext()).a();
      this.e = ((SharedPreferences)localObject1).getInt("key_adid_enter_1", 1);
      Object localObject2 = ((SharedPreferences)localObject1).getString("key_adid_location_1", "");
      Object localObject3 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a((String)localObject2, 3);
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals("1"))) {}
      for (;;)
      {
        try
        {
          i = Integer.valueOf(com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.a.a((String)localObject2, 4)).intValue();
          int j = i;
          if (i == 0) {
            j = 1;
          }
          localObject2 = c.a(paramActivity.getApplicationContext()).e();
          if ((((com.gau.go.launcherex.gowidget.weather.d.f)localObject2).a(2)) || (((com.gau.go.launcherex.gowidget.weather.d.f)localObject2).a(1)) || (((com.gau.go.launcherex.gowidget.weather.d.f)localObject2).a(32)) || (((com.gau.go.launcherex.gowidget.weather.d.f)localObject2).a(128)))
          {
            i = 1;
            if ((this.e % j != 0) || (i != 0)) {
              continue;
            }
            this.f = false;
            this.e += 1;
            a((SharedPreferences)localObject1);
            if (this.f) {
              break label455;
            }
            localObject1 = paramActivity.getResources().getDisplayMetrics();
            localObject2 = new FrameLayout(paramActivity.getApplicationContext());
            localObject3 = new FrameLayout.LayoutParams((int)(320.0F * ((DisplayMetrics)localObject1).density), -2, 17);
            ((FrameLayout)localObject2).addView(b(paramActivity), (ViewGroup.LayoutParams)localObject3);
            paramFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-2, -2, 81));
            this.g.put(paramFrameLayout, localObject2);
            if (c) {
              this.h.a(paramActivity.getApplicationContext());
            }
            if (!paramBoolean)
            {
              localObject3 = new ImageView(paramActivity.getApplicationContext());
              ((ImageView)localObject3).setImageResource(2130837514);
              if (Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels) < 720) {
                break label437;
              }
              localObject1 = new FrameLayout.LayoutParams(-2, -2, 53);
              paramFrameLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
              ((ImageView)localObject3).setOnClickListener(new h(this, paramFrameLayout, (ImageView)localObject3));
            }
            if (!c) {
              break;
            }
            this.h.a(paramActivity, (ViewGroup)localObject2);
            return;
          }
        }
        catch (Exception localException)
        {
          int i = 1;
          continue;
          i = 0;
          continue;
          this.f = true;
          continue;
        }
        this.f = true;
        continue;
        localObject1 = new FrameLayout.LayoutParams(-2, -2, 51);
      }
      paramFrameLayout.setVisibility(8);
    } while (!c);
    this.h.d();
  }
  
  public void a(FrameLayout paramFrameLayout)
  {
    int j = 0;
    if ((c) && (paramFrameLayout != null))
    {
      int i = 0;
      while (i < paramFrameLayout.getChildCount())
      {
        paramFrameLayout.getChildAt(i).setOnClickListener(null);
        i += 1;
      }
      paramFrameLayout.setOnClickListener(null);
      ViewGroup localViewGroup = (ViewGroup)this.g.get(paramFrameLayout);
      if (localViewGroup != null)
      {
        i = j;
        while (i < localViewGroup.getChildCount())
        {
          localViewGroup.getChildAt(i).setOnClickListener(null);
          i += 1;
        }
        localViewGroup.setOnClickListener(null);
        this.h.a(localViewGroup);
      }
      this.g.remove(paramFrameLayout);
      if (this.g.isEmpty()) {
        c();
      }
    }
  }
  
  public void b()
  {
    this.h.b();
  }
  
  public void c()
  {
    this.f = true;
    if (c) {
      this.h.d();
    }
    Iterator localIterator = this.g.keySet().iterator();
    while (localIterator.hasNext())
    {
      FrameLayout localFrameLayout = (FrameLayout)localIterator.next();
      if (localFrameLayout != null)
      {
        localFrameLayout.setVisibility(8);
        ViewGroup localViewGroup = (ViewGroup)this.g.get(localFrameLayout);
        if (localViewGroup != null)
        {
          i = 0;
          while (i < localViewGroup.getChildCount())
          {
            localViewGroup.getChildAt(i).setOnClickListener(null);
            i += 1;
          }
          localViewGroup.setOnClickListener(null);
        }
        int i = 0;
        while (i < localFrameLayout.getChildCount())
        {
          localFrameLayout.getChildAt(i).setOnClickListener(null);
          i += 1;
        }
        localFrameLayout.setOnClickListener(null);
      }
    }
    this.g.clear();
    b = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */