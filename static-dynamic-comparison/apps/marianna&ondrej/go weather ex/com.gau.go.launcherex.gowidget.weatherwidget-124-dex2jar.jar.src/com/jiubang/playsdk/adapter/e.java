package com.jiubang.playsdk.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.g.j;
import com.jiubang.playsdk.i;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.s;
import com.jiubang.playsdk.views.DefaultTabLoadingView;
import com.jiubang.playsdk.views.MineView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class e
  extends PagerAdapter
{
  private Context a;
  private List b = new ArrayList();
  private List c = new ArrayList();
  private LayoutInflater d;
  private ArrayList e = new ArrayList();
  private int f = -1;
  
  public e(Context paramContext)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(this.a);
    e();
  }
  
  private void e()
  {
    c localc = aa.a().b();
    Object localObject = localc.c(this.a);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.e.addAll((Collection)localObject);
      int i = 0;
      if (i < this.e.size())
      {
        localObject = (s)this.e.get(i);
        if ((localObject == null) || ((j.d(this.a)) && ((((s)localObject).b() == 31) || (((s)localObject).b() == 32)))) {}
        for (;;)
        {
          i += 1;
          break;
          if (((s)localObject).b() == localc.p()) {
            this.f = i;
          }
          localArrayList.add(((s)localObject).a());
        }
      }
    }
    a(localArrayList);
  }
  
  public String a(int paramInt)
  {
    if (paramInt >= this.b.size()) {
      return "";
    }
    return (String)this.b.get(paramInt);
  }
  
  public void a()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo != null) {
        localo.a(false);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo != null) {
        localo.a(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.b = paramList;
      this.b.add(this.a.getString(i.l));
      int i = 0;
      while (i < this.b.size())
      {
        this.c.add(null);
        i += 1;
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo != null) {
        localo.a(true);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.c == null) || (paramInt < 0) || (this.c.size() <= paramInt)) {}
    while (this.c.get(paramInt) == null) {
      return;
    }
    ((o)this.c.get(paramInt)).b();
  }
  
  public void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo != null) {
        localo.c();
      }
    }
  }
  
  public int d()
  {
    if (this.f == -1) {
      return getCount() - 1;
    }
    return this.f;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView(((o)this.c.get(paramInt)).a());
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    o localo = (o)this.c.get(paramInt);
    Object localObject = localo;
    if (localo == null)
    {
      if (paramInt != getCount() - 1) {
        break label91;
      }
      localObject = (MineView)this.d.inflate(g.q, null);
    }
    for (;;)
    {
      if (paramInt == d()) {
        ((o)localObject).b();
      }
      this.c.set(paramInt, localObject);
      paramViewGroup.addView(((o)localObject).a());
      return ((o)localObject).a();
      label91:
      localObject = (DefaultTabLoadingView)this.d.inflate(g.e, null);
      ((DefaultTabLoadingView)localObject).a((s)this.e.get(paramInt));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */