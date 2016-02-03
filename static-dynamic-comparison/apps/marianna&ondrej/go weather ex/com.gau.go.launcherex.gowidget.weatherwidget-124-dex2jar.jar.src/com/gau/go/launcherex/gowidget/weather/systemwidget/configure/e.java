package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.a;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.b;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
  implements View.OnClickListener, b
{
  HorizontalScrollView a;
  LinearLayout b;
  int c;
  int d;
  int e;
  private Context f;
  private LayoutInflater g;
  private View h;
  private ProgressBar i;
  private TextView j;
  private AlphaAnimation k;
  private AlphaAnimation l;
  private ArrayList m;
  private a n;
  private List o;
  private f p;
  private boolean q = false;
  private q r;
  
  public e(Context paramContext)
  {
    this.f = paramContext;
    this.g = LayoutInflater.from(paramContext);
    this.k = new AlphaAnimation(0.0F, 1.0F);
    this.k.setDuration(300L);
    this.l = new AlphaAnimation(1.0F, 0.0F);
    this.l.setDuration(300L);
    this.p = new f(this);
    this.o = new ArrayList();
    b();
  }
  
  private void c(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.o.clear();
      paramArrayList = com.gau.go.launcherex.gowidget.weather.globaltheme.b.e.a(paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)paramArrayList.next();
        this.o.add(locale);
        if (locale.m()) {
          switch (this.r.b())
          {
          default: 
            break;
          case 4: 
            if (!locale.k())
            {
              locale.i(false);
              ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)this.o.get(0)).i(true);
              this.r.b((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)this.o.get(0));
            }
            break;
          case 5: 
            if (!locale.j())
            {
              locale.i(false);
              ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)this.o.get(0)).i(true);
              this.r.b((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)this.o.get(0));
            }
            break;
          }
        }
      }
    }
  }
  
  private void d()
  {
    int i2 = this.o.size();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.b.getChildAt(i1);
      label44:
      LinearLayout.LayoutParams localLayoutParams;
      if (localView != null)
      {
        this.p.getView(i1, localView, this.b);
        localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.width = this.c;
        localLayoutParams.height = this.d;
        localView.setLayoutParams(localLayoutParams);
        if (i1 >= i2 - 1) {
          break label129;
        }
        localLayoutParams.setMargins(0, 0, this.e, 0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localView = this.p.getView(i1, null, this.b);
        this.b.addView(localView, i1);
        break label44;
        label129:
        localLayoutParams.setMargins(0, 0, 0, 0);
      }
    }
    for (;;)
    {
      if (i1 < this.b.getChildCount())
      {
        this.b.removeViewAt(i1);
        i1 += 1;
      }
      else
      {
        return;
      }
    }
  }
  
  public void a()
  {
    if (this.n != null) {
      this.n.b();
    }
    if ((this.o != null) && (!this.o.isEmpty()))
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next()).p();
      }
      this.o.clear();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i5 = (int)this.f.getResources().getDimension(2131427510);
    int i6 = (int)this.f.getResources().getDimension(2131427511);
    int i3 = (int)this.f.getResources().getDimension(2131427512);
    int i4 = (int)this.f.getResources().getDimension(2131427513);
    int i1 = paramInt2 - i3 * 2;
    int i2 = i1 * i5 / i6;
    paramInt2 = i2;
    if ((paramInt1 + i4) / (i3 * 2 + i2 + i4) < 3)
    {
      paramInt2 = (paramInt1 + i4) / 3 - i4 - i3 * 2;
      i1 = paramInt2 * i6 / i5;
    }
    this.c = (paramInt2 + i3 * 2);
    this.d = (i3 * 2 + i1);
    this.e = i4;
  }
  
  public void a(Activity paramActivity)
  {
    this.n = new m(paramActivity);
    this.n.a();
    this.n.a(this);
    this.n.a(false);
    this.n.b(false);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    if (parame != null) {
      a(parame.x());
    }
  }
  
  public void a(q paramq)
  {
    this.r = paramq;
  }
  
  public void a(String paramString)
  {
    if ((this.o != null) && (!this.o.isEmpty()))
    {
      Iterator localIterator = this.o.iterator();
      com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale;
      while (localIterator.hasNext())
      {
        locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next();
        if (locale.m()) {
          locale.i(false);
        }
      }
      localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next();
        if (locale.x().equals(paramString))
        {
          locale.i(true);
          this.r.b(locale);
        }
      }
      d();
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.i.setVisibility(4);
    com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale1;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale2 = null;
      Iterator localIterator = paramArrayList.iterator();
      do
      {
        locale1 = locale2;
        if (!localIterator.hasNext()) {
          break;
        }
        locale1 = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next();
      } while (!locale1.m());
      if (locale1 != null) {
        break label145;
      }
      localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        locale2 = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next();
        if ("app_widget_theme_white".equals(locale2.x())) {
          locale1 = locale2;
        }
      }
    }
    label145:
    for (;;)
    {
      this.r.a(locale1);
      c(paramArrayList);
      d();
      this.j.setVisibility(4);
      for (;;)
      {
        this.q = true;
        return;
        this.j.setVisibility(0);
      }
    }
  }
  
  public View b()
  {
    if (this.h == null)
    {
      this.h = this.g.inflate(2130903303, null);
      this.b = ((LinearLayout)this.h.findViewById(2131231951));
      this.i = ((ProgressBar)this.h.findViewById(2131231252));
      this.j = ((TextView)this.h.findViewById(2131231952));
      this.a = ((HorizontalScrollView)this.h.findViewById(2131231950));
    }
    return this.h;
  }
  
  public void b(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    this.o.add(parame);
    c(new ArrayList(this.o));
    d();
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next()).x())) {
        localIterator.remove();
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        d();
      }
      return;
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.m = paramArrayList;
    if ((c()) && (this.p != null)) {
      d();
    }
  }
  
  public void c(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      com.gau.go.launcherex.gowidget.weather.globaltheme.b.e locale = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localIterator.next();
      if (parame.x().equals(locale.x()))
      {
        parame.i(locale.m());
        localIterator.remove();
      }
    }
    this.o.add(parame);
    c(new ArrayList(this.o));
    d();
  }
  
  public boolean c()
  {
    return this.q;
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */