package com.gtp.go.weather.sharephoto.takephoto;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ad
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private Activity a;
  private View b;
  private ViewGroup c;
  private HorizontalScrollView d;
  private List e;
  private int f;
  private boolean g;
  private ag h;
  
  public ad(Activity paramActivity, View paramView)
  {
    this.a = paramActivity;
    this.b = paramView;
    this.c = ((ViewGroup)a(2131231931));
    this.d = ((HorizontalScrollView)a(2131231913));
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(this);
    b();
    if (this.e.size() > 0) {
      ((ah)this.e.get(0)).d = true;
    }
  }
  
  private View a(int paramInt1, int paramInt2)
  {
    ah localah = (ah)this.e.get(paramInt1);
    af localaf = new af(this, paramInt2);
    localaf.a(localah);
    return localaf.a;
  }
  
  private void a(ah paramah)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      ah localah = (ah)localIterator.next();
      if (localah.d) {
        localah.d = false;
      }
    }
    paramah.d = true;
    c();
    d(paramah.a);
  }
  
  private void b()
  {
    this.e = new ArrayList();
    ah localah = new ah(this, null);
    localah.a = 0;
    localah.d = false;
    localah.b = 2131166334;
    localah.c = 2130838520;
    this.e.add(localah);
    localah = new ah(this, null);
    localah.a = 5;
    localah.d = false;
    localah.b = 2131166339;
    localah.c = 2130838519;
    this.e.add(localah);
    localah = new ah(this, null);
    localah.a = 1;
    localah.d = false;
    localah.b = 2131166335;
    localah.c = 2130838515;
    this.e.add(localah);
    localah = new ah(this, null);
    localah.a = 2;
    localah.d = false;
    localah.b = 2131166336;
    localah.c = 2130838516;
    this.e.add(localah);
    localah = new ah(this, null);
    localah.a = 3;
    localah.d = false;
    localah.b = 2131166337;
    localah.c = 2130838517;
    this.e.add(localah);
    localah = new ah(this, null);
    localah.a = 4;
    localah.d = false;
    localah.b = 2131166338;
    localah.c = 2130838518;
    this.e.add(localah);
  }
  
  private void c()
  {
    if (!this.g) {
      return;
    }
    int j = this.d.getScrollX();
    int k = this.d.getScrollY();
    this.c.removeAllViews();
    int m = this.e.size();
    int i = 0;
    while (i < m)
    {
      View localView = a(i, this.f);
      this.c.addView(localView);
      i += 1;
    }
    this.d.scrollTo(j, k);
  }
  
  private void d(int paramInt)
  {
    if (this.h != null) {
      this.h.a(paramInt);
    }
  }
  
  protected View a(int paramInt)
  {
    return this.b.findViewById(paramInt);
  }
  
  public void a() {}
  
  public void a(ag paramag)
  {
    this.h = paramag;
  }
  
  public void b(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void c(int paramInt)
  {
    if ((this.e.size() > 0) && (paramInt >= 0) && (paramInt < this.e.size())) {
      a((ah)this.e.get(paramInt));
    }
  }
  
  public void onGlobalLayout()
  {
    if (!this.g)
    {
      this.f = ((int)(this.d.getWidth() / 4.5F));
      this.g = true;
      c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */