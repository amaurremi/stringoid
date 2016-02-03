package com.pocket.list.widget.a;

import android.support.v4.view.ViewPager;
import android.support.v4.view.bn;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ideashower.readitlater.activity.ai;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.z;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.b;
import com.pocket.widget.ViewPagerIndicator;

public class j
  implements bn, com.pocket.list.adapter.f, b, g
{
  private final ViewGroup a;
  private final ViewPager b;
  private final c c;
  private final ViewPagerIndicator d;
  private final com.pocket.list.adapter.a e;
  private final ai f;
  private int g;
  private boolean h;
  
  public j(ai paramai)
  {
    this.a = ((ViewGroup)LayoutInflater.from(paramai.m()).inflate(2130903123, null, false));
    this.e = paramai.ae();
    this.f = paramai;
    this.b = ((ViewPager)this.a.findViewById(2131230989));
    this.c = new c(paramai.m());
    this.b.setAdapter(this.c);
    this.d = ((ViewPagerIndicator)this.a.findViewById(2131230990));
    this.h = true;
    this.b.setOnPageChangeListener(this.c.a(this));
    this.c.a(this);
    this.e.a(this);
    paramai.ab().a(this);
  }
  
  private void d(int paramInt)
  {
    if ((!this.h) || (!this.f.s())) {
      return;
    }
    o localo = this.c.b(paramInt);
    new com.ideashower.readitlater.db.operation.action.j(localo, UiContext.a(localo.A().a().a(), paramInt)).j();
  }
  
  private void e()
  {
    if ((this.e.c().J()) && (!this.f.ab().d()) && (this.c.a() != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = this.h;
      this.h = bool1;
      if ((bool1) && (!bool2)) {
        d(this.g);
      }
      this.c.a(this.h);
      z.c(this.a, this.h);
      return;
    }
  }
  
  public void a()
  {
    e();
  }
  
  public void a(int paramInt)
  {
    this.d.a(this.c.a(), this.g, paramInt);
    this.g = paramInt;
    d(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(com.pocket.list.adapter.a parama)
  {
    e();
  }
  
  public void b()
  {
    e();
  }
  
  public void b(int paramInt) {}
  
  public ViewGroup c()
  {
    return this.a;
  }
  
  public void c(int paramInt)
  {
    e();
    this.d.a(this.c.a(), this.b.getCurrentItem(), this.b.getCurrentItem());
  }
  
  public void d()
  {
    if ((this.h) && (this.c.a() > 0)) {
      d(this.g);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */