package com.pocket.list.widget.a;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.aa;
import android.support.v4.view.bn;
import android.view.View;
import android.view.View.OnClickListener;
import com.ideashower.readitlater.activity.PocketActivity;
import com.ideashower.readitlater.activity.ReaderActivity;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.e;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.adapter.data.l;
import com.pocket.widget.ba;
import java.util.Iterator;

public class c
  extends aa
  implements View.OnClickListener
{
  private static int a = 5;
  private final Context b;
  private final com.pocket.list.d c;
  private final ba d;
  private final f e;
  private final com.ideashower.readitlater.objects.h f = new com.ideashower.readitlater.objects.h();
  private g g;
  private h h;
  
  public c(Context paramContext)
  {
    this.b = paramContext;
    this.d = new d(this, null);
    this.c = new com.pocket.list.d(new com.pocket.list.f()
    {
      public void a(com.ideashower.readitlater.objects.h paramAnonymoush)
      {
        c.a(c.this, paramAnonymoush);
      }
    });
    this.e = new f(this, null);
    com.ideashower.readitlater.i.c.a(this.e);
    this.c.a().a().d(Integer.valueOf(a)).c(Integer.valueOf(0)).a(true).a();
    this.c.b();
  }
  
  private void a(o paramo)
  {
    int i = this.f.indexOf(paramo);
    if (i < 0) {
      return;
    }
    this.f.e(i);
  }
  
  private void a(com.ideashower.readitlater.objects.h paramh)
  {
    com.ideashower.readitlater.objects.h localh = this.f;
    int i = localh.size();
    if (localh.size() >= a) {}
    label97:
    int j;
    do
    {
      do
      {
        return;
        paramh = paramh.iterator();
        do
        {
          o localo;
          for (;;)
          {
            if (!paramh.hasNext()) {
              break label97;
            }
            localo = (o)paramh.next();
            if (!localh.f(localo.f()))
            {
              if (localo.A() != null) {
                break;
              }
              e.a("no carousel info");
            }
          }
          localh.a(localo);
        } while (localh.size() < a);
        j = this.f.size();
      } while (i == j);
      c();
    } while (this.g == null);
    this.g.c(j);
  }
  
  public int a()
  {
    return this.f.size();
  }
  
  public int a(Object paramObject)
  {
    int i = this.f.indexOf(paramObject);
    if (i >= 0) {
      return i;
    }
    return -2;
  }
  
  public bn a(bn parambn)
  {
    if (this.h == null) {
      this.h = new h(this, null);
    }
    h.a(this.h, parambn);
    return this.h;
  }
  
  public Object a(View paramView, int paramInt)
  {
    i locali = (i)this.d.b(paramView);
    locali.setOnClickListener(this);
    locali.setItem((o)this.f.get(paramInt));
    ((ViewPager)paramView).addView(locali);
    return locali;
  }
  
  public void a(View paramView, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    ((ViewPager)paramView).removeView((View)paramObject);
    this.d.c((View)paramObject);
  }
  
  public void a(g paramg)
  {
    this.g = paramg;
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(View paramView, Object paramObject)
  {
    return paramView == (View)paramObject;
  }
  
  public o b(int paramInt)
  {
    return (o)this.f.get(paramInt);
  }
  
  public void c()
  {
    if (this.h != null)
    {
      int i = h.a(this.h);
      int j = h.b(this.h);
      this.h.a = false;
      super.c();
      if ((!this.h.a) && (a() > 0) && (b(i).f() != j)) {
        this.h.a(i);
      }
      return;
    }
    super.c();
  }
  
  public Context d()
  {
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    paramView = ((i)paramView).getItem();
    int i = a(paramView);
    ReaderActivity.b((PocketActivity)d(), paramView, UiContext.a(paramView.A().a().a(), i));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */