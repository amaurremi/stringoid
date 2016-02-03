package com.ideashower.readitlater.activity.a;

import android.content.Context;
import com.ideashower.readitlater.a.am;
import com.ideashower.readitlater.a.ap;
import com.ideashower.readitlater.a.aq;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.d.f;
import com.ideashower.readitlater.db.operation.action.UiTrigger;

public class i
{
  public static void a(int paramInt, f paramf, final Context paramContext)
  {
    ap localap = am.c();
    if (paramInt == 0)
    {
      if (localap != null)
      {
        if (g.k())
        {
          final l locall = l.a(2131493055, false);
          locall.N();
          locall.h(false);
          localap.a(paramContext, new aq()
          {
            public void a(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              if (!paramAnonymousBoolean) {
                if (paramAnonymousString != null)
                {
                  b.a(2131493053, paramAnonymousString).N();
                  i.this.a(false);
                }
              }
              for (;;)
              {
                g.a(new Runnable()
                {
                  public void run()
                  {
                    i.1.this.c.b();
                  }
                });
                return;
                b.b(2131493053, 2131493052).N();
                break;
                com.ideashower.readitlater.service.b.a(paramContext, 0, UiTrigger.z);
                i.this.a(true);
              }
            }
          }, UiTrigger.z);
          return;
        }
        b.b(2131493053, 2131493054).N();
        paramf.a(false);
        return;
      }
      b.b(2131493057, 2131493056).N();
      paramf.a(false);
      return;
    }
    if ((com.ideashower.readitlater.service.b.a(paramInt)) && (g.d()))
    {
      b.b(2131493172, 2131493171).N();
      return;
    }
    com.ideashower.readitlater.service.b.a(paramContext, paramInt, UiTrigger.z);
    paramf.a(true);
  }
  
  public static void a(boolean paramBoolean, a parama)
  {
    if (paramBoolean)
    {
      if (!com.pocket.m.a.l.e())
      {
        b.b(2131493150, 2131493149).a(parama);
        return;
      }
      j.a(2131493069, 2131493145, true).a(parama);
      return;
    }
    j.a(2131493069, 2131493145, false).a(parama);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */