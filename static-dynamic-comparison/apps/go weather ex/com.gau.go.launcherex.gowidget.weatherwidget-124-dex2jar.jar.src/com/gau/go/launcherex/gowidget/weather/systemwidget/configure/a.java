package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

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
import com.gau.go.launcherex.gowidget.messagecenter.util.c;
import com.gau.go.launcherex.gowidget.messagecenter.util.g;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.d;
import java.util.ArrayList;
import java.util.Iterator;

public class a
  implements View.OnClickListener, g
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
  private View j;
  private AlphaAnimation k;
  private AlphaAnimation l;
  private ArrayList m;
  private b n;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.c.a o;
  private boolean p;
  private c q;
  private boolean r = false;
  private boolean s = false;
  
  public a(Context paramContext)
  {
    this.f = paramContext;
    this.g = LayoutInflater.from(paramContext);
    this.k = new AlphaAnimation(0.0F, 1.0F);
    this.k.setDuration(300L);
    this.l = new AlphaAnimation(1.0F, 0.0F);
    this.l.setDuration(350L);
    this.q = new c(this.f);
    this.q.a(this);
    this.n = new b(this);
    this.m = new ArrayList();
    this.o = new com.gau.go.launcherex.gowidget.weather.globaltheme.c.a();
    a();
  }
  
  private void d()
  {
    int i2 = this.m.size();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.b.getChildAt(i1);
      label42:
      LinearLayout.LayoutParams localLayoutParams;
      if (localView != null)
      {
        this.n.getView(i1, localView, this.b);
        localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.width = this.c;
        localLayoutParams.height = this.d;
        localView.setLayoutParams(localLayoutParams);
        if (i1 >= i2 - 1) {
          break label127;
        }
        localLayoutParams.setMargins(0, 0, this.e, 0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localView = this.n.getView(i1, null, this.b);
        this.b.addView(localView, i1);
        break label42;
        label127:
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
  
  private void e(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.m.clear();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        d locald = (d)paramArrayList.next();
        if (this.m.size() >= 8) {
          break;
        }
        this.m.add(locald);
      }
    }
  }
  
  public View a()
  {
    if (this.h == null)
    {
      this.h = this.g.inflate(2130903303, null);
      this.b = ((LinearLayout)this.h.findViewById(2131231951));
      this.i = ((ProgressBar)this.h.findViewById(2131231252));
      this.j = this.h.findViewById(2131231952);
      this.a = ((HorizontalScrollView)this.h.findViewById(2131231950));
    }
    return this.h;
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
  
  public void a(String paramString)
  {
    if (this.m != null)
    {
      Iterator localIterator = this.m.iterator();
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
      this.p = true;
      d();
    }
  }
  
  public void b(ArrayList paramArrayList) {}
  
  public boolean b()
  {
    return this.s;
  }
  
  public void c()
  {
    this.r = true;
    this.o.a();
    if ((this.m != null) && (!this.m.isEmpty()))
    {
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).d();
      }
      this.m.clear();
    }
  }
  
  public void c(ArrayList paramArrayList) {}
  
  public void d(ArrayList paramArrayList)
  {
    this.i.setVisibility(4);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      e(paramArrayList);
      d();
      this.j.setVisibility(4);
    }
    for (;;)
    {
      this.s = true;
      return;
      this.j.setVisibility(0);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */