package com.pocket.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.ideashower.readitlater.a.ai;
import com.ideashower.readitlater.a.aj;
import com.ideashower.readitlater.a.ak;
import com.ideashower.readitlater.activity.ReaderActivity;
import com.ideashower.readitlater.activity.aa;
import com.ideashower.readitlater.activity.ab;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.e.x;
import java.util.ArrayList;
import java.util.Collections;

public class r
  extends af
  implements ak
{
  protected aj a;
  private boolean k;
  private final View.OnClickListener l;
  private final View.OnClickListener m;
  private aa n;
  private ab o;
  
  public r(aa paramaa, com.pocket.list.g paramg, ListView paramListView, Context paramContext, ab paramab)
  {
    super(paramaa, paramg, paramListView, paramContext, UiTrigger.y, "inbox");
    this.n = paramaa;
    this.o = paramab;
    this.m = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ag localag = (ag)paramAnonymousView.getTag();
        r.this.c(localag, paramAnonymousView);
      }
    };
    this.l = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (r.a(r.this)) {
          return;
        }
        paramAnonymousView = (s)paramAnonymousView.getTag();
        r.a(r.this, true);
        ReaderActivity.b(r.b(r.this), paramAnonymousView.a(), r.this.d(r.this.a(paramAnonymousView.b())));
      }
    };
    b(com.ideashower.readitlater.a.g.v().a(this));
  }
  
  protected int a(int paramInt)
  {
    return 2130903179;
  }
  
  protected h a(View paramView, int paramInt)
  {
    return new s(this, paramView, null);
  }
  
  public final void a(aj paramaj)
  {
    b(paramaj);
  }
  
  protected void a(ag paramag, View paramView)
  {
    g();
    new com.ideashower.readitlater.db.operation.action.r((x)paramag.b(), paramag.a(), d(paramag.y)).j();
    a(this.h.indexOf(paramag.v), paramag, null);
    x.k();
  }
  
  public boolean a()
  {
    return this.n.s();
  }
  
  protected void b(aj paramaj)
  {
    this.o.a(paramaj);
    if ((!paramaj.b.isEmpty()) || (!paramaj.c.isEmpty()))
    {
      this.g = paramaj.d;
      this.h = new ArrayList(paramaj.b);
      Collections.sort(this.h, x.a);
      if (!this.n.Q())
      {
        if (this.n.s()) {
          ai.a(paramaj);
        }
      }
      else {
        return;
      }
      this.a = paramaj;
      return;
    }
    this.g.clear();
    this.h.clear();
  }
  
  protected void b(ag paramag, View paramView)
  {
    super.b(paramag, paramView);
    b(this.h.indexOf(paramag.v), paramag, null);
  }
  
  protected void c(ag paramag, View paramView) {}
  
  protected boolean d()
  {
    return (this.o.getCount() > 0) || (super.d());
  }
  
  public void e()
  {
    this.k = false;
    if (this.a != null)
    {
      ai.a(this.a);
      this.a = null;
    }
  }
  
  public void f()
  {
    com.ideashower.readitlater.a.g.v().b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */