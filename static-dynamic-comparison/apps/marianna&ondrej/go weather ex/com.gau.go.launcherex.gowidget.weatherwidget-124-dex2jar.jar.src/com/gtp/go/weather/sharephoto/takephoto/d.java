package com.gtp.go.weather.sharephoto.takephoto;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import com.gtp.a.a.c.a;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterParameter;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private Activity a;
  private View b;
  private ViewGroup c;
  private HorizontalScrollView d;
  private FilterService e;
  private List f;
  private Bitmap g;
  private int h;
  private boolean i;
  private i j;
  private final SparseArray k = new SparseArray();
  
  public d(Activity paramActivity, View paramView, FilterService paramFilterService)
  {
    this.a = paramActivity;
    this.b = paramView;
    this.c = ((ViewGroup)a(2131231914));
    this.d = ((HorizontalScrollView)a(2131231913));
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.e = paramFilterService;
    paramActivity = this.e.getAllFilter(0);
    this.f = new ArrayList();
    int m = a.a();
    paramActivity = paramActivity.iterator();
    while (paramActivity.hasNext())
    {
      paramView = (FilterParameter)paramActivity.next();
      if ((m == 3) || (m == 2))
      {
        int n = paramView.getTypeId();
        if ((n == 131072) || (n == 32768) || (n == 16384) || (n == 65536)) {}
      }
      else
      {
        paramFilterService = new h(this, null);
        paramFilterService.b = false;
        paramFilterService.a = paramView;
        this.f.add(paramFilterService);
      }
    }
    if (this.f.size() > 0) {
      ((h)this.f.get(0)).b = true;
    }
  }
  
  private View a(int paramInt1, int paramInt2)
  {
    h localh = (h)this.f.get(paramInt1);
    f localf = new f(this, paramInt2);
    localf.a(localh);
    return localf.a;
  }
  
  private void a(h paramh)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.b) {
        localh.b = false;
      }
    }
    paramh.b = true;
    d();
    a(paramh.a);
  }
  
  private void a(FilterParameter paramFilterParameter)
  {
    if (this.j != null) {
      this.j.a(paramFilterParameter);
    }
  }
  
  private void d()
  {
    if (!this.i) {
      return;
    }
    int n = this.d.getScrollX();
    int i1 = this.d.getScrollY();
    this.c.removeAllViews();
    int i2 = this.f.size();
    int m = 0;
    while (m < i2)
    {
      View localView = a(m, this.h);
      this.c.addView(localView);
      m += 1;
    }
    this.d.scrollTo(n, i1);
  }
  
  protected View a(int paramInt)
  {
    return this.b.findViewById(paramInt);
  }
  
  public void a()
  {
    d();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.g = paramBitmap;
    this.k.clear();
  }
  
  public void a(i parami)
  {
    this.j = parami;
  }
  
  public FilterParameter b()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.b) {
        return localh.a;
      }
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void c()
  {
    this.k.clear();
  }
  
  public void c(int paramInt)
  {
    if ((this.f.size() > 0) && (paramInt >= 0) && (paramInt < this.f.size())) {
      a((h)this.f.get(paramInt));
    }
  }
  
  public void onGlobalLayout()
  {
    if (!this.i)
    {
      this.h = ((int)(this.d.getWidth() / 4.5F));
      this.i = true;
      d();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */