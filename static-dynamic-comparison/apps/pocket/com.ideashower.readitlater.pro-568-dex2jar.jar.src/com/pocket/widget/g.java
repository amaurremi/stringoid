package com.pocket.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.ideashower.readitlater.e.y;
import com.pocket.b.d;

public abstract class g
  extends BaseAdapter
{
  public static final String b = (String)null;
  private int a = 0;
  protected final com.ideashower.readitlater.activity.f c;
  protected final Context d;
  protected final ListView e;
  protected final com.pocket.b.c f;
  private int g;
  private int h;
  private boolean i;
  private int j;
  private Object k;
  private com.pocket.list.g l;
  
  public g(com.ideashower.readitlater.activity.f paramf, com.pocket.list.g paramg, ListView paramListView, Context paramContext)
  {
    this.c = paramf;
    this.d = paramContext;
    this.e = paramListView;
    a(paramg);
    this.f = new com.pocket.b.c(this.e, new d()
    {
      public void a(ListView paramAnonymousListView, int[] paramAnonymousArrayOfInt)
      {
        int j = paramAnonymousArrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = paramAnonymousArrayOfInt[i];
          g.this.b(k);
          i += 1;
        }
        g.a(g.this);
        g.this.notifyDataSetChanged();
        g.this.c();
      }
    });
  }
  
  private void a()
  {
    if ((this.k != null) && (!this.f.a()))
    {
      Object localObject = this.k;
      this.k = null;
      b(localObject);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.c.Q()) {}
    boolean bool;
    do
    {
      return;
      bool = d();
    } while ((paramBoolean) && (bool));
    this.i = paramBoolean;
    if (paramBoolean)
    {
      if (this.l != null) {
        this.l.C();
      }
      this.j = 1;
      return;
    }
    if (bool)
    {
      if (this.l != null) {
        this.l.D();
      }
      this.j = 2;
      return;
    }
    if (this.l != null) {
      this.l.E();
    }
    this.j = 3;
  }
  
  protected abstract int a(int paramInt);
  
  protected abstract h a(View paramView, int paramInt);
  
  public void a(int paramInt, h paramh, com.pocket.b.f paramf)
  {
    this.f.a(paramh.b, paramInt, paramf);
  }
  
  public void a(com.pocket.list.g paramg)
  {
    this.l = paramg;
  }
  
  protected abstract void a(Object paramObject);
  
  public Context b()
  {
    return this.d;
  }
  
  protected abstract void b(int paramInt);
  
  public void b(int paramInt, h paramh, com.pocket.b.f paramf)
  {
    this.f.b(paramh.b, paramInt, paramf);
  }
  
  public void b(Object paramObject)
  {
    if (this.f.a())
    {
      this.k = paramObject;
      return;
    }
    a(paramObject);
    notifyDataSetChanged();
    if (this.g != 0)
    {
      final int m = this.g;
      final int n = this.h;
      this.g = 0;
      this.e.setSelectionFromTop(m, n);
      this.e.post(new Runnable()
      {
        public void run()
        {
          g.this.e.setSelectionFromTop(m, n);
        }
      });
    }
    a(false);
  }
  
  public void c()
  {
    a(this.i);
  }
  
  protected boolean d()
  {
    return getCount() > 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    com.ideashower.readitlater.e.c localc = (com.ideashower.readitlater.e.c)getItem(paramInt);
    if ((localc != null) && ((localc instanceof y))) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      h localh = (h)paramView.getTag();
      paramView.refreshDrawableState();
      paramViewGroup = paramView;
      paramView = localh;
    }
    for (;;)
    {
      paramView.a(paramInt);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(b()).inflate(a(paramInt), paramViewGroup, false);
      paramView = a(paramViewGroup, paramInt);
      paramViewGroup.setTag(paramView);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */