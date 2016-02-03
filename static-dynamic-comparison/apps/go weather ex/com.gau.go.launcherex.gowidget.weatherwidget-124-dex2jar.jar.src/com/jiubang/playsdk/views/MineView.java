package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.adapter.h;
import com.jiubang.playsdk.adapter.o;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.main.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MineView
  extends FrameLayout
  implements AdapterView.OnItemClickListener, o, v
{
  private FrameLayout a;
  private SelectorView b;
  private List c = new ArrayList();
  private LayoutInflater d;
  private int e = 0;
  private RotateView f;
  private int g = 0;
  private List h = new ArrayList();
  private List i = new ArrayList();
  private Resources j;
  private c k;
  private int l = 0;
  private boolean m = false;
  
  public MineView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private ListViewPage a(LayoutInflater paramLayoutInflater)
  {
    Object localObject = getResources();
    paramLayoutInflater = (ListViewPage)paramLayoutInflater.inflate(g.m, null);
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    View localView = new View(getContext());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, ((Resources)localObject).getDimensionPixelSize(d.k)));
    localFrameLayout.addView(localView);
    if (this.l != 0) {
      localFrameLayout.setPadding(0, this.l, 0, 0);
    }
    this.i.add(localFrameLayout);
    paramLayoutInflater.addHeaderView(localFrameLayout, null, false);
    paramLayoutInflater.setOnItemClickListener(this);
    if (this.b.getVisibility() == 0)
    {
      localObject = new View(getContext());
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(d.C)));
      paramLayoutInflater.addFooterView((View)localObject, null, false);
    }
    return paramLayoutInflater;
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() > this.h.size())) {
      return;
    }
    this.c = paramList;
    int n = 0;
    label30:
    Object localObject;
    if (n < this.c.size())
    {
      paramList = (ListViewPage)this.h.get(n);
      localObject = (List)this.c.get(n);
      localObject = new h(getContext(), b((List)localObject), this.k, paramList);
      if (this.j.getConfiguration().orientation != 2) {
        break label195;
      }
      ((h)localObject).d(this.j.getDimensionPixelSize(d.r));
      ((h)localObject).e(this.j.getDimensionPixelSize(d.s));
      ((h)localObject).b(this.j.getDimensionPixelSize(d.x));
      ((h)localObject).c(this.j.getDimensionPixelSize(d.y));
      label163:
      if (this.g != 81) {
        break label254;
      }
      ((h)localObject).a(2);
      ((h)localObject).a(0.8F);
    }
    for (;;)
    {
      paramList.setAdapter((ListAdapter)localObject);
      n += 1;
      break label30;
      break;
      label195:
      ((h)localObject).d(this.j.getDimensionPixelSize(d.t));
      ((h)localObject).e(this.j.getDimensionPixelSize(d.u));
      ((h)localObject).b(this.j.getDimensionPixelSize(d.w));
      ((h)localObject).c(this.j.getDimensionPixelSize(d.y));
      break label163;
      label254:
      if (this.g == 84)
      {
        ((h)localObject).a(2);
        ((h)localObject).a(1.16F);
      }
      else
      {
        ((h)localObject).a(3);
      }
    }
  }
  
  private List b(List paramList)
  {
    if (paramList == null) {}
    label8:
    label93:
    for (;;)
    {
      return paramList;
      int n = 0;
      if (n < paramList.size() - 1) {
        if (!this.k.d(getContext(), (com.jiubang.playsdk.a.a)paramList.get(n))) {}
      }
      for (;;)
      {
        if ((n <= 0) || (n > paramList.size())) {
          break label93;
        }
        com.jiubang.playsdk.a.a locala = (com.jiubang.playsdk.a.a)paramList.remove(n);
        if (locala == null) {
          break;
        }
        paramList.add(0, locala);
        return paramList;
        n += 1;
        break label8;
        n = 0;
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (this.b.a() == 0)
    {
      this.b.setVisibility(8);
      return;
    }
    int n = aa.a().b().q();
    int[] arrayOfInt = this.b.b();
    if (arrayOfInt != null) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < arrayOfInt.length)
      {
        if (arrayOfInt[paramInt] == n) {
          this.e = paramInt;
        }
      }
      else
      {
        this.b.setVisibility(0);
        this.b.a(this.e);
        return;
      }
      paramInt += 1;
    }
  }
  
  private void e(int paramInt)
  {
    int n = paramInt;
    if (paramInt <= 0) {
      n = 1;
    }
    paramInt = 0;
    while (paramInt < n)
    {
      ListViewPage localListViewPage = a(this.d);
      if (this.e != paramInt) {
        localListViewPage.setVisibility(8);
      }
      this.h.add(localListViewPage);
      this.a.addView(localListViewPage);
      paramInt += 1;
    }
  }
  
  private void f(int paramInt)
  {
    int n = 0;
    if (n < this.h.size())
    {
      if (n == paramInt) {
        ((ListViewPage)this.h.get(n)).setVisibility(0);
      }
      for (;;)
      {
        n += 1;
        break;
        ((ListViewPage)this.h.get(n)).setVisibility(8);
      }
    }
    this.e = paramInt;
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator;
    if ((this.i != null) && (this.i.size() > 0)) {
      localIterator = this.i.iterator();
    }
    while (localIterator.hasNext())
    {
      ((FrameLayout)localIterator.next()).setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      continue;
      this.l = paramInt2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d();
      return;
    }
    int n = 0;
    label11:
    ListViewPage localListViewPage;
    ListAdapter localListAdapter;
    Object localObject;
    if (n < this.h.size())
    {
      localListViewPage = (ListViewPage)this.h.get(n);
      if (localListViewPage != null)
      {
        localListAdapter = localListViewPage.getAdapter();
        localObject = null;
        if (!(localListAdapter instanceof HeaderViewListAdapter)) {
          break label144;
        }
        localObject = (HeaderViewListAdapter)localListAdapter;
        if (!(((HeaderViewListAdapter)localObject).getWrappedAdapter() instanceof h)) {
          break label161;
        }
        localObject = (h)((HeaderViewListAdapter)localObject).getWrappedAdapter();
      }
    }
    for (;;)
    {
      if ((localObject != null) && (this.h.size() <= this.c.size()))
      {
        ((h)localObject).a(b((List)this.c.get(n)));
        localListViewPage.setSelection(0);
      }
      n += 1;
      break label11;
      break;
      label144:
      if ((localListAdapter instanceof h))
      {
        localObject = (h)localListAdapter;
        continue;
        label161:
        localObject = null;
      }
    }
  }
  
  public void b()
  {
    if (!this.m)
    {
      b(aa.a().b().o());
      this.m = true;
    }
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
    this.k = aa.a().a(this.g);
    d(this.g);
    e(this.b.a());
    d();
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    f(paramInt);
  }
  
  public void d()
  {
    try
    {
      new t(this, getContext()).execute(new Void[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b.a(this);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a(this.c);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.b.a(null);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = LayoutInflater.from(getContext());
    this.a = ((FrameLayout)findViewById(f.ac));
    this.b = ((SelectorView)findViewById(f.ad));
    this.b.setVisibility(8);
    this.f = ((RotateView)findViewById(f.ae));
    this.j = getResources();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (List)this.c.get(this.e);
    if (paramInt >= paramAdapterView.size() - 1)
    {
      paramInt = com.jiubang.playsdk.g.a.a(this.k.o());
      aa.a().b().c(getContext(), paramInt);
    }
    do
    {
      return;
      paramAdapterView = (com.jiubang.playsdk.a.a)paramAdapterView.get(paramInt);
    } while (paramAdapterView == null);
    this.k.g(getContext(), paramAdapterView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/MineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */