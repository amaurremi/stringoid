package com.pocket.list.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.f;
import android.widget.Toast;
import com.ideashower.readitlater.activity.ReaderActivity;
import com.ideashower.readitlater.db.operation.action.UiTrigger;
import com.ideashower.readitlater.db.operation.action.al;
import com.ideashower.readitlater.db.operation.action.am;
import com.ideashower.readitlater.db.operation.action.i;
import com.ideashower.readitlater.db.operation.action.k;
import com.ideashower.readitlater.db.operation.action.m;
import com.ideashower.readitlater.e.o;
import com.pocket.list.adapter.data.ItemQuery;
import com.pocket.list.widget.b.a.c;
import com.pocket.list.widget.b.b;

class d
  implements b
{
  private d(a parama) {}
  
  public void a(o paramo, c paramc, com.pocket.list.widget.b.a parama)
  {
    paramo = com.ideashower.readitlater.activity.ad.a(paramo.i(), paramo.c(), paramo.w(), this.a.a(UiTrigger.f, paramo));
    com.ideashower.readitlater.activity.ad.a((f)a.c(this.a), paramo);
    paramc.a();
  }
  
  public void a(com.pocket.list.widget.b.a parama, o paramo, com.pocket.list.widget.b.b.a parama1)
  {
    com.pocket.widget.undobar.a.a(a.c(this.a));
    if ((a.a(this.a) != null) && (a.a(this.a).d()))
    {
      a(parama, paramo, parama.isSelected());
      return;
    }
    new c(a.c(this.a), parama1.al()).a(parama);
  }
  
  public void a(com.pocket.list.widget.b.a parama, o paramo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((a.a(this.a) != null) && (a.a(this.a).d())) {
      if (!paramBoolean)
      {
        paramBoolean = bool;
        parama.setSelected(paramBoolean);
        a.a(this.a).a(a.b(this.a).a(paramo), paramo, paramBoolean);
      }
    }
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        com.pocket.widget.undobar.a.a(a.c(this.a));
      } while (a.d(this.a));
      a.a(this.a, true);
      ReaderActivity.b((Activity)a.c(this.a), paramo, this.a.a(null, paramo));
    } while (a.e(this.a) == null);
    a.e(this.a).b(paramo);
  }
  
  public boolean a()
  {
    return a.f(this.a);
  }
  
  public void b(o paramo, c paramc, com.pocket.list.widget.b.a parama)
  {
    if (a.b(this.a).d()) {}
    for (;;)
    {
      new i(paramo, this.a.a(UiTrigger.f, paramo)).j();
      if (a.e(this.a) != null) {
        a.e(this.a).a(paramo);
      }
      com.pocket.widget.undobar.a.a(a.c(this.a), new al(paramo, this.a.a(UiTrigger.h, paramo)));
      return;
      paramc.a();
    }
  }
  
  public void c(o paramo, c paramc, com.pocket.list.widget.b.a parama)
  {
    if (!this.a.c().l()) {}
    for (;;)
    {
      new com.ideashower.readitlater.db.operation.action.d(true, paramo, this.a.a(UiTrigger.f, paramo)).j();
      Toast.makeText(a.c(this.a), 2131493758, 0).show();
      return;
      paramc.a();
    }
  }
  
  public void d(o paramo, c paramc, com.pocket.list.widget.b.a parama)
  {
    boolean bool;
    if (!this.a.c().l())
    {
      if (paramo.ae()) {
        break label82;
      }
      bool = true;
      label23:
      new m(bool, paramo, this.a.a(UiTrigger.f, paramo)).j();
      if (!paramo.ae()) {
        break label88;
      }
    }
    label82:
    label88:
    for (int i = 2131493757;; i = 2131493760)
    {
      Toast.makeText(a.c(this.a), i, 0).show();
      return;
      paramc.a();
      break;
      bool = false;
      break label23;
    }
  }
  
  public void e(o paramo, c paramc, com.pocket.list.widget.b.a parama)
  {
    int i = paramo.al();
    new k(paramo, this.a.a(UiTrigger.f, paramo)).j();
    com.pocket.widget.undobar.a.a(a.c(this.a), new am(paramo, this.a.a(UiTrigger.h, paramo), i));
  }
  
  public void f(o paramo, c paramc, com.pocket.list.widget.b.a parama)
  {
    parama = paramo.ab();
    Context localContext = a.c(this.a);
    String str1 = paramo.i();
    String str2 = paramo.q();
    int i = paramo.f();
    if (parama != null) {}
    for (parama = parama.e();; parama = null)
    {
      com.ideashower.readitlater.views.ad.a(localContext, str1, str2, i, parama, null, this.a.a(UiTrigger.f, paramo));
      paramc.a();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */