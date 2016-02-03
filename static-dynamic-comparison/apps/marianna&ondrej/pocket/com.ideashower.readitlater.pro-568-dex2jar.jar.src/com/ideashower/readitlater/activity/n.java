package com.ideashower.readitlater.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.pocket.q.a.d;
import com.pocket.q.a.f;
import com.pocket.q.a.o;

class n
  extends com.pocket.q.a.n
{
  public n(m paramm)
  {
    super(paramm);
  }
  
  public o a(final Context paramContext)
  {
    paramContext = new d(paramContext);
    this.a.a(new g()
    {
      public void a(Fragment paramAnonymousFragment)
      {
        paramContext.a();
      }
    });
    return paramContext;
  }
  
  public void a(o paramo)
  {
    d locald = (d)paramo;
    locald.setLimit(i.a(a.O));
    locald.setOnCacheLimitChangedListener(new f()
    {
      public void a(long paramAnonymousLong)
      {
        i.a(a.O, paramAnonymousLong);
        m.b(n.this.a);
      }
    });
    if (i.a(a.Q) == 1) {}
    for (paramo = this.a.d(2131493643);; paramo = this.a.d(2131493642))
    {
      locald.setItemOrder(paramo);
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return 4;
  }
  
  public void onClick(View paramView) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */