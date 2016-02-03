package com.jiubang.playsdk.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.a.x;
import com.jiubang.playsdk.e.d;
import com.jiubang.playsdk.f.a;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.g.j;
import com.jiubang.playsdk.i;
import com.jiubang.playsdk.views.MineView;
import com.jiubang.playsdk.views.TabLoadingView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class n
  extends PagerAdapter
{
  public d a;
  private Context b;
  private List c = new ArrayList();
  private List d = new ArrayList();
  private List e = new ArrayList();
  private x f;
  private LayoutInflater g;
  private int h = -1;
  private int i = 0;
  
  public n(Context paramContext, d paramd, x paramx)
  {
    this.b = paramContext;
    this.g = LayoutInflater.from(this.b);
    this.f = paramx;
    this.a = paramd;
    e();
  }
  
  private void e()
  {
    com.jiubang.playsdk.main.c localc = aa.a().b();
    int j = this.a.i();
    ArrayList localArrayList = new ArrayList();
    if (j == 1)
    {
      List localList = this.a.e();
      j = 0;
      if (j < localList.size())
      {
        com.jiubang.playsdk.e.c localc1 = (com.jiubang.playsdk.e.c)localList.get(j);
        if (localc1 != null)
        {
          d locald = this.f.a(localc1.a());
          if ((locald != null) && ((!j.d(this.b)) || (!"com.jb.gosms".equals(locald.l())))) {
            break label117;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label117:
          if (localc1.a(localc.p())) {
            this.h = j;
          }
          if (localc1.c() == 1) {
            this.i = j;
          }
          localArrayList.add(localc1.b());
          this.d.add(Long.valueOf(localc1.a()));
        }
      }
    }
    a(localArrayList);
  }
  
  public String a(int paramInt)
  {
    if (paramInt >= this.c.size()) {
      return "";
    }
    return (String)this.c.get(paramInt);
  }
  
  public void a()
  {
    Iterator localIterator = this.e.iterator();
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
    Iterator localIterator = this.e.iterator();
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
      this.c = paramList;
      this.c.add(this.b.getString(i.l));
      if (aa.a().b().p() == 999) {
        this.h = (this.c.size() - 1);
      }
      int j = 0;
      while (j < this.c.size())
      {
        this.e.add(null);
        j += 1;
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.e.iterator();
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
    if ((this.d == null) || (this.e == null) || (paramInt < 0) || (this.e.size() <= paramInt)) {}
    do
    {
      return;
      if (this.e.get(paramInt) != null) {
        ((o)this.e.get(paramInt)).b();
      }
    } while (this.d.size() <= paramInt);
    int j = aa.a().b().r();
    int k = aa.a().b().o();
    a.a(this.b, k, j, String.valueOf(this.d.get(paramInt)), paramInt);
  }
  
  public void c()
  {
    Iterator localIterator = this.e.iterator();
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
    if (this.h == -1) {
      return this.i;
    }
    return this.h;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView(((o)this.e.get(paramInt)).a());
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (o)this.e.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      if (paramInt != getCount() - 1) {
        break label98;
      }
    }
    for (localObject1 = (MineView)this.g.inflate(g.q, null);; localObject1 = (o)((TabLoadingView)localObject2).a())
    {
      if (paramInt == d())
      {
        ((o)localObject1).a(0);
        ((o)localObject1).b();
      }
      this.e.set(paramInt, localObject1);
      paramViewGroup.addView(((o)localObject1).a());
      return ((o)localObject1).a();
      label98:
      localObject1 = this.f.a(((Long)this.d.get(paramInt)).longValue());
      localObject2 = (TabLoadingView)this.g.inflate(g.v, null);
      ((TabLoadingView)localObject2).a(this.f);
      ((TabLoadingView)localObject2).a((d)localObject1);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */