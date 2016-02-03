package com.jiubang.pla.internal;

import android.view.View;
import android.widget.ListAdapter;
import java.util.ArrayList;

class h
{
  private i b;
  private int c;
  private View[] d = new View[0];
  private ArrayList[] e;
  private int f;
  private ArrayList g;
  
  h(PLA_AbsListView paramPLA_AbsListView) {}
  
  private void d()
  {
    int m = this.d.length;
    int n = this.f;
    ArrayList[] arrayOfArrayList = this.e;
    int i = 0;
    while (i < n)
    {
      ArrayList localArrayList = arrayOfArrayList[i];
      int i1 = localArrayList.size();
      int j = i1 - 1;
      int k = 0;
      while (k < i1 - m)
      {
        PLA_AbsListView.e(this.a, (View)localArrayList.remove(j), false);
        k += 1;
        j -= 1;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    int i = 0;
    ArrayList localArrayList;
    int j;
    if (this.f == 1)
    {
      localArrayList = this.g;
      j = localArrayList.size();
      while (i < j)
      {
        ((View)localArrayList.get(i)).forceLayout();
        i += 1;
      }
    }
    int k = this.f;
    i = 0;
    while (i < k)
    {
      localArrayList = this.e[i];
      int m = localArrayList.size();
      j = 0;
      while (j < m)
      {
        ((View)localArrayList.get(j)).forceLayout();
        j += 1;
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
    }
    ArrayList[] arrayOfArrayList = new ArrayList[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfArrayList[i] = new ArrayList();
      i += 1;
    }
    this.f = paramInt;
    this.g = arrayOfArrayList[0];
    this.e = arrayOfArrayList;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.d.length < paramInt1) {
      this.d = new View[paramInt1];
    }
    this.c = paramInt2;
    View[] arrayOfView = this.d;
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      View localView = this.a.getChildAt(paramInt2);
      PLA_AbsListView.LayoutParams localLayoutParams = (PLA_AbsListView.LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams != null) && (localLayoutParams.a != -2)) {
        arrayOfView[paramInt2] = localView;
      }
      paramInt2 += 1;
    }
  }
  
  void a(View paramView)
  {
    PLA_AbsListView.LayoutParams localLayoutParams = (PLA_AbsListView.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {}
    for (;;)
    {
      return;
      int i = localLayoutParams.a;
      if (!b(i))
      {
        if (i != -2) {
          PLA_AbsListView.c(this.a, paramView, false);
        }
      }
      else
      {
        if (this.f == 1)
        {
          PLA_AbsListView.a(this.a, paramView);
          this.g.add(paramView);
        }
        while (this.b != null)
        {
          this.b.a(paramView);
          return;
          PLA_AbsListView.a(this.a, paramView);
          this.e[i].add(paramView);
        }
      }
    }
  }
  
  void b()
  {
    ArrayList localArrayList;
    int j;
    if (this.f == 1)
    {
      localArrayList = this.g;
      j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        PLA_AbsListView.a(this.a, (View)localArrayList.remove(j - 1 - i), false);
        i += 1;
      }
    }
    int k = this.f;
    int i = 0;
    while (i < k)
    {
      localArrayList = this.e[i];
      int m = localArrayList.size();
      j = 0;
      while (j < m)
      {
        PLA_AbsListView.b(this.a, (View)localArrayList.remove(m - 1 - j), false);
        j += 1;
      }
      i += 1;
    }
  }
  
  public boolean b(int paramInt)
  {
    return paramInt >= 0;
  }
  
  View c(int paramInt)
  {
    paramInt -= this.c;
    View[] arrayOfView = this.d;
    if ((paramInt >= 0) && (paramInt < arrayOfView.length))
    {
      View localView = arrayOfView[paramInt];
      arrayOfView[paramInt] = null;
      return localView;
    }
    return null;
  }
  
  void c()
  {
    View[] arrayOfView = this.d;
    int i;
    if (this.b != null)
    {
      i = 1;
      if (this.f <= 1) {
        break label124;
      }
    }
    Object localObject1;
    View localView;
    Object localObject2;
    int m;
    label124:
    for (int j = 1;; j = 0)
    {
      localObject1 = this.g;
      int k = arrayOfView.length - 1;
      for (;;)
      {
        if (k < 0) {
          break label181;
        }
        localView = arrayOfView[k];
        localObject2 = localObject1;
        if (localView != null)
        {
          m = ((PLA_AbsListView.LayoutParams)localView.getLayoutParams()).a;
          arrayOfView[k] = null;
          if (b(m)) {
            break;
          }
          localObject2 = localObject1;
          if (m != -2)
          {
            PLA_AbsListView.d(this.a, localView, false);
            localObject2 = localObject1;
          }
        }
        k -= 1;
        localObject1 = localObject2;
      }
      i = 0;
      break;
    }
    if (j != 0) {
      localObject1 = this.e[m];
    }
    for (;;)
    {
      PLA_AbsListView.a(this.a, localView);
      ((ArrayList)localObject1).add(localView);
      if (i != 0) {
        this.b.a(localView);
      }
      localObject2 = localObject1;
      break;
      label181:
      d();
      return;
    }
  }
  
  View d(int paramInt)
  {
    Object localObject2 = null;
    ArrayList localArrayList;
    Object localObject1;
    if (this.f == 1)
    {
      localArrayList = this.g;
      paramInt = localArrayList.size();
      localObject1 = localObject2;
      if (paramInt > 0) {
        localObject1 = (View)localArrayList.remove(paramInt - 1);
      }
    }
    do
    {
      do
      {
        do
        {
          return (View)localObject1;
          paramInt = this.a.c.getItemViewType(paramInt);
          localObject1 = localObject2;
        } while (paramInt < 0);
        localObject1 = localObject2;
      } while (paramInt >= this.e.length);
      localArrayList = this.e[paramInt];
      paramInt = localArrayList.size();
      localObject1 = localObject2;
    } while (paramInt <= 0);
    return (View)localArrayList.remove(paramInt - 1);
  }
  
  void e(int paramInt)
  {
    if (this.f == 1)
    {
      localObject1 = this.g;
      j = ((ArrayList)localObject1).size();
      i = 0;
      while (i < j)
      {
        ((View)((ArrayList)localObject1).get(i)).setDrawingCacheBackgroundColor(paramInt);
        i += 1;
      }
    }
    int k = this.f;
    int i = 0;
    while (i < k)
    {
      localObject1 = this.e[i];
      int m = ((ArrayList)localObject1).size();
      j = 0;
      while (j < m)
      {
        ((View)((ArrayList)localObject1).get(i)).setDrawingCacheBackgroundColor(paramInt);
        j += 1;
      }
      i += 1;
    }
    Object localObject1 = this.d;
    int j = localObject1.length;
    i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        ((View)localObject2).setDrawingCacheBackgroundColor(paramInt);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */