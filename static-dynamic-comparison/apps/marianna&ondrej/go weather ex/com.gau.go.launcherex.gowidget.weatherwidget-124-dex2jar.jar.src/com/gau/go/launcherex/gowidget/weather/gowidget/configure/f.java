package com.gau.go.launcherex.gowidget.weather.gowidget.configure;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.d;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.b;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
  implements View.OnClickListener, b
{
  private Context a;
  private LayoutInflater b;
  private View c;
  private LinearLayout d;
  private ProgressBar e;
  private TextView f;
  private int g;
  private int h;
  private int i;
  private AlphaAnimation j;
  private AlphaAnimation k;
  private ArrayList l;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.a m;
  private e n;
  private List o;
  private h p;
  private d q;
  private boolean r = false;
  private ImageView s;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.j = new AlphaAnimation(0.0F, 1.0F);
    this.j.setDuration(300L);
    this.k = new AlphaAnimation(1.0F, 0.0F);
    this.k.setDuration(300L);
    this.p = new h(this);
    this.o = new ArrayList();
    this.n = null;
    d();
  }
  
  private void c(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.o.clear();
      this.n = null;
      paramArrayList = e.a(paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        e locale = (e)paramArrayList.next();
        this.o.add(locale);
        if (locale.m())
        {
          this.n = locale;
          if ((!d(locale)) || (!e(locale)))
          {
            locale.i(false);
            ((e)this.o.get(0)).i(true);
          }
        }
      }
      if (this.n == null) {
        ((e)this.o.get(0)).i(true);
      }
    }
  }
  
  private boolean d(e parame)
  {
    return ((m)this.s.getTag() != m.f) || (parame.h());
  }
  
  private boolean e(e parame)
  {
    return ((m)this.s.getTag() != m.c) || (parame.i());
  }
  
  private void f()
  {
    int i2 = this.o.size();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.d.getChildAt(i1);
      label44:
      LinearLayout.LayoutParams localLayoutParams;
      if (localView != null)
      {
        this.p.getView(i1, localView, this.d);
        localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.width = this.g;
        localLayoutParams.height = this.h;
        localView.setLayoutParams(localLayoutParams);
        if (i1 >= i2 - 1) {
          break label129;
        }
        localLayoutParams.setMargins(0, 0, this.i, 0);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localView = this.p.getView(i1, null, this.d);
        this.d.addView(localView, i1);
        break label44;
        label129:
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
  
  private void f(e parame)
  {
    Object localObject = (m)this.s.getTag();
    int i1;
    int i2;
    switch (g.a[localObject.ordinal()])
    {
    default: 
      localObject = m.a;
      i1 = 0;
      i2 = 2130838038;
      if (parame.A()) {
        this.s.setImageResource(i2);
      }
      break;
    }
    do
    {
      return;
      i1 = 0;
      i2 = 2130838038;
      break;
      i2 = 2130838036;
      i1 = 1;
      break;
      i2 = 2130838037;
      i1 = 5;
      break;
      i2 = 2130838034;
      i1 = 3;
      break;
      i2 = 2130838033;
      i1 = 2;
      break;
      i2 = 2130838035;
      i1 = 4;
      break;
      localObject = parame.c(i1);
      if (localObject != null)
      {
        this.s.setImageDrawable(com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, parame.x(), (String)localObject));
        return;
      }
      localObject = parame.d(i1);
    } while (localObject == null);
    this.s.setImageDrawable(com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a, parame.x(), (String)localObject));
  }
  
  public void a()
  {
    if (this.m != null) {
      this.m.b();
    }
    if ((this.o != null) && (!this.o.isEmpty()))
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        ((e)localIterator.next()).p();
      }
      this.o.clear();
      this.n = null;
    }
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
  
  public void a(Activity paramActivity)
  {
    this.m = new s(paramActivity);
    this.m.a();
    this.m.a(this);
    this.m.c(false);
    this.m.b(false);
  }
  
  public void a(ImageView paramImageView)
  {
    this.s = paramImageView;
  }
  
  public void a(e parame)
  {
    if (parame != null) {
      a(parame.x());
    }
  }
  
  public void a(d paramd)
  {
    this.q = paramd;
  }
  
  public void a(String paramString)
  {
    if ((this.o != null) && (!this.o.isEmpty()))
    {
      Iterator localIterator = this.o.iterator();
      e locale;
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (locale.m()) {
          locale.i(false);
        }
      }
      localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (locale.x().equals(paramString)) {
          locale.i(true);
        }
      }
      f();
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.e.setVisibility(4);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      c(paramArrayList);
      f();
      this.f.setVisibility(4);
    }
    for (;;)
    {
      this.r = true;
      return;
      this.f.setVisibility(0);
    }
  }
  
  public void b()
  {
    if ((this.o != null) && (!this.o.isEmpty()))
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.m())
        {
          this.n = locale;
          this.q.a(2, this.n);
        }
      }
    }
  }
  
  public void b(e parame)
  {
    this.o.add(parame);
    c(new ArrayList(this.o));
    f();
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((e)localIterator.next()).x())) {
        localIterator.remove();
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        f();
      }
      return;
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.l = paramArrayList;
    if ((e()) && (this.p != null)) {
      f();
    }
  }
  
  public void c()
  {
    if (this.n != null)
    {
      this.n.i(true);
      this.q.a(2, this.n);
    }
  }
  
  public void c(e parame)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (parame.x().equals(locale.x()))
      {
        parame.i(locale.m());
        localIterator.remove();
      }
    }
    this.o.add(parame);
    c(new ArrayList(this.o));
    f();
  }
  
  public View d()
  {
    if (this.c == null)
    {
      this.c = this.b.inflate(2130903303, null);
      this.d = ((LinearLayout)this.c.findViewById(2131231951));
      this.e = ((ProgressBar)this.c.findViewById(2131231252));
      this.f = ((TextView)this.c.findViewById(2131231952));
    }
    return this.c;
  }
  
  public boolean e()
  {
    return this.r;
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/gowidget/configure/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */