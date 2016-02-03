package com.pocket.widget.navigation;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import com.ideashower.readitlater.activity.ai;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.ideashower.readitlater.views.toolbars.ToolbarLayout;
import com.pocket.p.k;
import com.pocket.widget.ad;

public class g
  implements i
{
  private static final boolean a = ;
  private final ai b;
  private final o c;
  private int d;
  private boolean e;
  
  public g(ai paramai, o paramo, Bundle paramBundle)
  {
    this.b = paramai;
    this.c = paramo;
    if (paramBundle != null)
    {
      this.d = paramBundle.getInt("state_inbox_count");
      if (this.d <= com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.cf)) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      return;
    }
  }
  
  private void b()
  {
    if (!a) {
      return;
    }
    ToolbarLayout localToolbarLayout = (ToolbarLayout)this.b.ad().getParent();
    ad.a(j.a(7.0F), this.b.n().getDimension(2131296395) / 2.0F, localToolbarLayout, new long[] { 2222L, 200L });
  }
  
  private void b(int paramInt)
  {
    com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.cf, paramInt).a();
  }
  
  public void a()
  {
    b(this.d);
    this.c.setNavigationDrawerAlertEnabled(false);
  }
  
  public void a(int paramInt)
  {
    if (k.a(this.b)) {}
    do
    {
      return;
      if ((this.e) && (paramInt > 0))
      {
        this.e = false;
        this.c.setNavigationDrawerAlertEnabled(true);
      }
    } while (this.d == paramInt);
    int i = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.cf);
    if ((paramInt > this.d) && (paramInt > i))
    {
      this.c.setNavigationDrawerAlertEnabled(true);
      if (this.b.s()) {
        b();
      }
    }
    for (;;)
    {
      this.d = paramInt;
      return;
      com.ideashower.readitlater.a.g.o().post(new Runnable()
      {
        public void run()
        {
          g.a(g.this);
        }
      });
      continue;
      if (paramInt <= i)
      {
        b(paramInt);
        if (paramInt == 0) {
          this.c.setNavigationDrawerAlertEnabled(false);
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("state_inbox_count", this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */