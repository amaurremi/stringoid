package com.pocket.list.adapter;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.u;
import com.ideashower.readitlater.util.j;
import com.pocket.list.adapter.data.ItemQuery;
import java.util.ArrayList;
import java.util.Iterator;

public class a
  extends BaseAdapter
  implements AbsListView.OnScrollListener, com.ideashower.readitlater.i.e
{
  private int A;
  private int B;
  private boolean C;
  private final Context a;
  private final b b;
  private final d c;
  private final boolean d = j.d();
  private final com.pocket.list.adapter.a.b e;
  private final com.pocket.list.widget.b f;
  private final ArrayList g = new ArrayList();
  private final SparseArray h = new SparseArray();
  private final ArrayList i = new ArrayList();
  private final ArrayList j = new ArrayList();
  private final SparseIntArray k = new SparseIntArray();
  private final ArrayList l = new ArrayList();
  private final ArrayList m = new ArrayList();
  private final ArrayList n = new ArrayList();
  private final ArrayList o = new ArrayList();
  private final SparseIntArray p = new SparseIntArray();
  private g q;
  private i r;
  private final com.pocket.list.adapter.data.a s;
  private com.pocket.list.a t;
  private final int u = 0;
  private int v = -1;
  private boolean w;
  private int x;
  private boolean y;
  private int z;
  
  public a(com.pocket.list.widget.b paramb)
  {
    this.f = paramb;
    this.a = paramb.getContext();
    this.e = new com.pocket.list.adapter.a.b(paramb);
    this.b = new b(this, null);
    this.s = new com.pocket.list.adapter.data.a(this.b);
    this.s.a(false);
    this.y = com.ideashower.readitlater.a.g.k();
    com.ideashower.readitlater.i.c.a(this);
    this.c = new d(this, null);
    a(com.ideashower.readitlater.h.a.aC.a());
    if ((this.a instanceof com.ideashower.readitlater.activity.a))
    {
      ((com.ideashower.readitlater.activity.a)this.a).a(new com.ideashower.readitlater.activity.e()
      {
        public void c()
        {
          a.a(a.this, false);
          a.this.a(com.ideashower.readitlater.a.g.k());
        }
        
        public void f()
        {
          a.this.a();
        }
      });
      return;
    }
    com.ideashower.readitlater.util.e.a("context should be an activity.");
  }
  
  private int a(int paramInt1, int paramInt2, com.pocket.list.adapter.a.a parama, int paramInt3)
  {
    o localo = c(paramInt1);
    Object localObject = b().c(paramInt1);
    parama = parama.a(localo, this.v, paramInt3, j(), paramInt2, this.d, paramInt1, (u)localObject);
    this.h.put(paramInt1, parama);
    localObject = this.p;
    if (localo.M()) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      ((SparseIntArray)localObject).put(paramInt1, paramInt3);
      if (!parama.a()) {
        break;
      }
      return paramInt2;
    }
    return parama.T();
  }
  
  private int a(o paramo)
  {
    return this.s.b(paramo);
  }
  
  private com.pocket.list.widget.b.a a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = paramViewGroup.getChildAt(paramInt);
    if ((paramViewGroup instanceof com.pocket.list.widget.b.a.c)) {
      return ((com.pocket.list.widget.b.a.c)paramViewGroup).c();
    }
    return (com.pocket.list.widget.b.a)paramViewGroup;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.C == paramBoolean) {}
    do
    {
      return;
      this.C = paramBoolean;
    } while (this.r == null);
    this.r.a(paramBoolean);
  }
  
  private void e(int paramInt)
  {
    if ((!this.s.l()) || (this.C)) {}
    do
    {
      return;
      int i1 = paramInt - this.f.getNumHeaderRows();
      paramInt = i1;
      if (i1 > 0)
      {
        paramInt = i1;
        if (i1 >= this.x) {
          paramInt = this.x - 1;
        }
      }
    } while ((paramInt <= 0) || (g(paramInt) < this.s.h() - this.s.k()));
    this.s.c();
  }
  
  private void f(int paramInt)
  {
    int i1 = 0;
    if (paramInt == -1) {
      return;
    }
    int i4 = this.f.getSpacesPerRow();
    int i5 = this.s.h();
    int i6 = this.g.size();
    com.pocket.list.adapter.a.a locala = this.f.getCellLayouts();
    if (this.s.j().C() != null) {}
    for (int i2 = this.s.j().C().intValue(); (i4 == 0) || (i5 == 0); i2 = 0)
    {
      this.x = 0;
      return;
    }
    Object localObject1;
    int i3;
    if ((paramInt == 0) || (this.g.isEmpty()))
    {
      localObject1 = null;
      locala.a(paramInt);
      i3 = paramInt;
      paramInt = i1;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      i1 = i3;
      if (localObject1 == null)
      {
        if (paramInt >= i6) {
          break label306;
        }
        localObject2 = (com.pocket.list.adapter.a.c)this.g.get(paramInt);
        ((com.pocket.list.adapter.a.c)localObject2).a(i4, i3);
        i1 = i3;
      }
      for (;;)
      {
        if ((((com.pocket.list.adapter.a.c)localObject2).c <= 0) || (i1 >= i5)) {
          break label335;
        }
        this.k.put(i1, paramInt);
        ((com.pocket.list.adapter.a.c)localObject2).a(a(i1, ((com.pocket.list.adapter.a.c)localObject2).c, locala, i2));
        i1 += 1;
        continue;
        i1 = this.k.get(paramInt, -1);
        if ((i1 >= this.x) || (i1 == -1))
        {
          i1 = this.k.get(paramInt - 1);
          localObject2 = (com.pocket.list.adapter.a.c)this.g.get(i1);
          localObject1 = localObject2;
          if (((com.pocket.list.adapter.a.c)localObject2).c > 0) {
            break;
          }
          i1 = this.x;
          localObject1 = null;
          break;
        }
        localObject1 = (com.pocket.list.adapter.a.c)this.g.get(i1);
        ((com.pocket.list.adapter.a.c)localObject1).b(paramInt, i4);
        break;
        label306:
        localObject2 = new com.pocket.list.adapter.a.c(i4, i3);
        this.g.add(localObject2);
        i1 = i3;
      }
      label335:
      paramInt += 1;
      if (i1 >= i5)
      {
        this.x = paramInt;
        return;
      }
      localObject1 = null;
      i3 = i1;
    }
  }
  
  private int g(int paramInt)
  {
    paramInt -= this.f.getNumHeaderRows();
    if (paramInt <= 0) {
      return paramInt;
    }
    if (this.g.isEmpty()) {}
    for (com.pocket.list.adapter.a.c localc = null; localc == null; localc = (com.pocket.list.adapter.a.c)this.g.get(paramInt)) {
      return 0;
    }
    return localc.a;
  }
  
  private void h(int paramInt)
  {
    paramInt = this.k.get(paramInt);
    int i1 = this.f.getNumHeaderRows();
    this.f.setSelection(paramInt + i1);
  }
  
  private boolean j()
  {
    return this.s.j().n() != 0;
  }
  
  private int k()
  {
    return g(this.f.getFirstVisiblePosition());
  }
  
  private void l()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(this);
    }
  }
  
  public UiContext a(UiTrigger paramUiTrigger, o paramo)
  {
    return UiContext.a(paramUiTrigger, d(), a(paramo), paramo.y(), c().c());
  }
  
  protected void a()
  {
    this.s.m();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.v) {
      return;
    }
    int i1 = this.f.getFirstVisiblePosition();
    int i2 = k();
    switch (paramInt)
    {
    default: 
      throw new RuntimeException("Invalid view type");
    }
    this.v = paramInt;
    com.ideashower.readitlater.h.a.aC.a(paramInt);
    b(0);
    if (i1 >= this.f.getNumHeaderRows()) {
      h(i2);
    }
    for (;;)
    {
      l();
      return;
      this.f.setSelection(i1);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int i1 = 0;
    paramBundle.putInt("adatper_state_count", this.s.h());
    paramBundle.putInt("adapter_state_position", this.f.getFirstVisiblePosition());
    View localView = this.f.getChildAt(0);
    if (localView == null) {}
    for (;;)
    {
      paramBundle.putInt("adapter_state_position_top", i1);
      return;
      i1 = localView.getTop();
    }
  }
  
  public void a(com.pocket.list.a parama)
  {
    this.t = parama;
  }
  
  public void a(e parame)
  {
    this.m.add(parame);
  }
  
  public void a(f paramf)
  {
    this.l.add(paramf);
  }
  
  public void a(g paramg)
  {
    this.q = paramg;
  }
  
  public void a(h paramh)
  {
    this.n.add(paramh);
  }
  
  public void a(i parami)
  {
    this.r = parami;
  }
  
  public void a(com.pocket.list.g paramg)
  {
    this.o.add(paramg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.y) {
      return;
    }
    this.y = paramBoolean;
    f();
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public com.pocket.list.adapter.data.a b()
  {
    return this.s;
  }
  
  public void b(int paramInt)
  {
    f(paramInt);
    notifyDataSetChanged();
  }
  
  public void b(Bundle paramBundle)
  {
    this.z = paramBundle.getInt("adapter_state_position");
    this.A = paramBundle.getInt("adapter_state_position_top");
    this.B = paramBundle.getInt("adatper_state_count");
  }
  
  public void b(h paramh)
  {
    this.n.remove(paramh);
  }
  
  public void b(com.pocket.list.g paramg)
  {
    this.o.remove(paramg);
  }
  
  public void b(boolean paramBoolean)
  {
    this.s.a(paramBoolean);
    if (this.B > 0) {
      this.s.a(this.B);
    }
    for (;;)
    {
      l();
      return;
      this.s.b();
    }
  }
  
  public o c(int paramInt)
  {
    return this.s.b(paramInt);
  }
  
  public ItemQuery c()
  {
    return this.s.j();
  }
  
  public void c(com.pocket.list.g paramg)
  {
    this.b.a(paramg);
  }
  
  public int d()
  {
    return this.v;
  }
  
  public View d(int paramInt)
  {
    int i2 = this.k.get(paramInt);
    int i1 = this.f.getNumHeaderRows() + i2 - this.f.getFirstVisiblePosition();
    if ((i1 < 0) || (i1 >= this.f.getChildCount())) {
      return null;
    }
    i2 = ((com.pocket.list.adapter.a.c)this.g.get(i2)).a;
    return ((ViewGroup)this.f.getChildAt(i1)).getChildAt(paramInt - i2);
  }
  
  public boolean e()
  {
    if (j.c()) {
      if (this.v != 0) {}
    }
    while (j())
    {
      return true;
      return false;
    }
    if (this.s.j().C() != null) {}
    for (int i1 = this.s.j().C().intValue();; i1 = 0)
    {
      switch (i1)
      {
      }
      return false;
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((com.pocket.list.widget.b.a)localIterator.next()).refreshDrawableState();
    }
  }
  
  public void g()
  {
    this.e.a();
    b(0);
  }
  
  public int getCount()
  {
    return this.x;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.v;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i3 = 0;
    if (paramView != null) {}
    com.pocket.list.adapter.a.c localc;
    int i4;
    for (paramViewGroup = (RelativeLayout)paramView;; paramViewGroup = new RelativeLayout(this.a))
    {
      localc = (com.pocket.list.adapter.a.c)this.g.get(paramInt);
      i4 = paramViewGroup.getChildCount();
      if (i4 <= localc.b) {
        break;
      }
      i1 = i4 - 1;
      while (i1 >= localc.b)
      {
        this.i.add(a(paramViewGroup, i1));
        paramViewGroup.removeViewAt(i1);
        i1 -= 1;
      }
    }
    int i2 = 0;
    int i1 = 0;
    int i5;
    com.pocket.list.widget.b.b.a locala;
    o localo;
    if (i2 < localc.b)
    {
      i5 = localc.a + i2;
      locala = (com.pocket.list.widget.b.b.a)this.h.get(i5);
      localo = c(i5);
      if (!locala.a()) {
        break label444;
      }
      i1 = 1;
    }
    label352:
    label435:
    label444:
    for (;;)
    {
      if (i2 < i4)
      {
        paramView = a(paramViewGroup, i2);
        RelativeLayout.LayoutParams localLayoutParams = this.e.a(locala, localc.b(i2));
        if (paramView.getLayoutParams() != localLayoutParams) {
          paramView.setLayoutParams(localLayoutParams);
        }
        if (j()) {
          break label352;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramView.a(localo, locala, bool, b().c(i5));
        if (this.t != null) {
          paramView.setSelected(this.t.a(this.s.a(localo)));
        }
        i2 += 1;
        break;
        if (this.i.isEmpty())
        {
          paramView = new com.pocket.list.widget.b.a(this.a, this.c);
          paramView.setLayoutParams(this.e.a(locala, localc.b(i2)));
          this.j.add(paramView);
        }
        for (;;)
        {
          paramViewGroup.addView(paramView);
          break;
          paramView = (com.pocket.list.widget.b.a)this.i.remove(0);
        }
      }
      paramView = this.f.getTileSpacing();
      if (i1 != 0)
      {
        paramInt = 0;
        i2 = this.f.getGutterLeft();
        i4 = this.f.getGutterRight();
        if (i1 == 0) {
          break label435;
        }
      }
      for (i1 = i3;; i1 = paramView.y)
      {
        paramViewGroup.setPadding(i2, paramInt, i4, i1);
        return paramViewGroup;
        if (paramInt == 0)
        {
          paramInt = paramView.y * 2;
          break;
        }
        paramInt = paramView.y;
        break;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public int h()
  {
    return this.s.h();
  }
  
  public float i()
  {
    return 1.0F;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    e(paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */