package com.jiubang.a.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.a.a.d;
import com.a.a.s;
import junit.framework.Assert;

public abstract class a
  extends c
{
  private SparseArray b = new SparseArray();
  private long c = -1L;
  private int d = -1;
  private boolean e;
  private int f = 0;
  
  public a(BaseAdapter paramBaseAdapter)
  {
    super(paramBaseAdapter);
    if ((paramBaseAdapter instanceof a)) {
      ((a)paramBaseAdapter).a(true);
    }
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt > this.d) && (!this.e))
    {
      a(paramInt, paramViewGroup, paramView);
      this.d = paramInt;
    }
  }
  
  private void a(int paramInt, ViewGroup paramViewGroup, View paramView)
  {
    if (this.c == -1L) {
      this.c = System.currentTimeMillis();
    }
    if (this.f < 12)
    {
      a(paramView);
      if (!(this.a instanceof a)) {
        break label162;
      }
    }
    label162:
    for (com.a.a.a[] arrayOfa = ((a)this.a).a(paramViewGroup, paramView);; arrayOfa = new com.a.a.a[0])
    {
      paramViewGroup = a(paramViewGroup, paramView);
      s locals = s.a(paramView, "alpha", new float[] { 0.0F, 1.0F });
      d locald = new d();
      locald.a(a(arrayOfa, paramViewGroup, locals));
      locald.b(f());
      locald.c(b());
      locald.a();
      this.b.put(paramView.hashCode(), new b(this, paramInt, locald));
      this.f += 1;
      return;
    }
  }
  
  private void a(View paramView)
  {
    paramView = s.a(paramView, "alpha", new float[] { 0.0F });
    d locald = new d();
    locald.a(paramView);
    locald.c(0L);
    locald.a();
  }
  
  private com.a.a.a[] a(com.a.a.a[] paramArrayOfa1, com.a.a.a[] paramArrayOfa2, com.a.a.a parama)
  {
    int m = 0;
    com.a.a.a[] arrayOfa = new com.a.a.a[paramArrayOfa1.length + paramArrayOfa2.length + 1];
    int i = 0;
    int j;
    int k;
    for (;;)
    {
      j = i;
      k = m;
      if (i >= paramArrayOfa2.length) {
        break;
      }
      arrayOfa[i] = paramArrayOfa2[i];
      i += 1;
    }
    while (k < paramArrayOfa1.length)
    {
      arrayOfa[j] = paramArrayOfa1[k];
      j += 1;
      k += 1;
    }
    arrayOfa[(arrayOfa.length - 1)] = parama;
    return arrayOfa;
  }
  
  private long f()
  {
    if (d().getLastVisiblePosition() - d().getFirstVisiblePosition() + 1 < this.d) {}
    for (long l = a();; l = (this.d + 1) * a() + (this.c + c()) - System.currentTimeMillis()) {
      return Math.max(0L, l);
    }
  }
  
  protected abstract long a();
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public abstract com.a.a.a[] a(ViewGroup paramViewGroup, View paramView);
  
  protected abstract long b();
  
  protected abstract long c();
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (!this.e)
    {
      Assert.assertNotNull("Call setListView() on this AnimationAdapter before setAdapter()!", d());
      if (paramView != null)
      {
        i = paramView.hashCode();
        b localb = (b)this.b.get(i);
        if (localb != null) {
          if (localb.a != paramInt)
          {
            localb.b.c();
            this.b.remove(i);
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      if ((!this.e) && (i == 0)) {
        a(paramInt, paramView, paramViewGroup);
      }
      return paramView;
      i = 1;
      continue;
      i = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */