package android.support.v4.app;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;

class ae
  implements z
{
  public Notification a(x paramx)
  {
    aj localaj = new aj(paramx.a, paramx.r, paramx.b, paramx.c, paramx.h, paramx.f, paramx.i, paramx.d, paramx.e, paramx.g, paramx.n, paramx.o, paramx.p, paramx.k, paramx.j, paramx.m);
    Iterator localIterator = paramx.q.iterator();
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      localaj.a(localu.a, localu.b, localu.c);
    }
    if (paramx.l != null)
    {
      if (!(paramx.l instanceof w)) {
        break label172;
      }
      paramx = (w)paramx.l;
      localaj.a(paramx.e, paramx.g, paramx.f, paramx.a);
    }
    for (;;)
    {
      return localaj.a();
      label172:
      if ((paramx.l instanceof y))
      {
        paramx = (y)paramx.l;
        localaj.a(paramx.e, paramx.g, paramx.f, paramx.a);
      }
      else if ((paramx.l instanceof v))
      {
        paramx = (v)paramx.l;
        localaj.a(paramx.e, paramx.g, paramx.f, paramx.a, paramx.b, paramx.c);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */