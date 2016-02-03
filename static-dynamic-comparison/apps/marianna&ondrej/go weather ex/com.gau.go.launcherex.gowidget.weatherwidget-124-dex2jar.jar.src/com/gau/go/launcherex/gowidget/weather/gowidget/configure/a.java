package com.gau.go.launcherex.gowidget.weather.gowidget.configure;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.gau.go.launcherex.gowidget.messagecenter.util.g;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.d;
import java.util.ArrayList;
import java.util.Iterator;

public class a
  implements View.OnClickListener, g
{
  private Context a;
  private LayoutInflater b;
  private View c;
  private LinearLayout d;
  private ProgressBar e;
  private View f;
  private int g;
  private int h;
  private int i;
  private AlphaAnimation j;
  private AlphaAnimation k;
  private ArrayList l;
  private c m;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.c.a n;
  private boolean o;
  private com.gau.go.launcherex.gowidget.messagecenter.util.c p;
  private boolean q = false;
  private boolean r = false;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.j = new AlphaAnimation(0.0F, 1.0F);
    this.j.setDuration(300L);
    this.k = new AlphaAnimation(1.0F, 0.0F);
    this.k.setDuration(350L);
    this.p = new com.gau.go.launcherex.gowidget.messagecenter.util.c(this.a);
    this.p.a(this);
    this.m = new c(this);
    this.l = new ArrayList();
    this.n = new com.gau.go.launcherex.gowidget.weather.globaltheme.c.a();
    a();
  }
  
  private void d()
  {
    int i2 = this.l.size();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.d.getChildAt(i1);
      label42:
      LinearLayout.LayoutParams localLayoutParams;
      if (localView != null)
      {
        this.m.getView(i1, localView, this.d);
        localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.width = this.g;
        localLayoutParams.height = this.h;
        localView.setLayoutParams(localLayoutParams);
        if (i1 >= i2 - 1) {
          break label127;
        }
        localLayoutParams.setMargins(0, 0, this.i, 0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localView = this.m.getView(i1, null, this.d);
        this.d.addView(localView, i1);
        break label42;
        label127:
        localLayoutParams.setMargins(0, 0, 0, 0);
      }
    }
    for (;;)
    {
      if (i1 < this.d.getChildCount())
      {
        this.d.removeViewAt(i1);
        i1 += 1;
      }
      else
      {
        return;
      }
    }
  }
  
  private void e(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.l.clear();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        d locald = (d)paramArrayList.next();
        if (this.l.size() >= 8) {
          break;
        }
        this.l.add(locald);
      }
    }
  }
  
  public View a()
  {
    if (this.c == null)
    {
      this.c = this.b.inflate(2130903303, null);
      this.d = ((LinearLayout)this.c.findViewById(2131231951));
      this.e = ((ProgressBar)this.c.findViewById(2131231252));
      this.f = this.c.findViewById(2131231952);
    }
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i5 = (int)this.a.getResources().getDimension(2131427510);
    int i6 = (int)this.a.getResources().getDimension(2131427511);
    int i3 = (int)this.a.getResources().getDimension(2131427512);
    int i4 = (int)this.a.getResources().getDimension(2131427513);
    int i1 = paramInt2 - i3 * 2;
    int i2 = i1 * i5 / i6;
    paramInt2 = i2;
    if ((paramInt1 + i4) / (i3 * 2 + i2 + i4) < 3)
    {
      paramInt2 = (paramInt1 + i4) / 3 - i4 - i3 * 2;
      i1 = paramInt2 * i6 / i5;
    }
    this.g = (paramInt2 + i3 * 2);
    this.h = (i3 * 2 + i1);
    this.i = i4;
  }
  
  public void a(String paramString)
  {
    if (this.l != null)
    {
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((d)localIterator.next()).x())) {
          localIterator.remove();
        }
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
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.o = true;
      d();
    }
  }
  
  public void b(ArrayList paramArrayList) {}
  
  public boolean b()
  {
    return this.r;
  }
  
  public void c()
  {
    this.q = true;
    this.n.a();
    if ((this.l != null) && (!this.l.isEmpty()))
    {
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).d();
      }
      this.l.clear();
    }
  }
  
  public void c(ArrayList paramArrayList) {}
  
  public void d(ArrayList paramArrayList)
  {
    this.e.setVisibility(4);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      e(paramArrayList);
      d();
      this.f.setVisibility(4);
    }
    for (;;)
    {
      this.r = true;
      return;
      this.f.setVisibility(0);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/gowidget/configure/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */