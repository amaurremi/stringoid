package com.appbrain.a;

import android.content.Context;
import android.os.SystemClock;
import cmn.h;
import cmn.p;
import com.appbrain.e.j.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public final class ar
{
  private static final Random a = new Random();
  private static j.b b = null;
  private static long c = Long.MIN_VALUE;
  private static String d = null;
  
  public static int a(Context paramContext, j.b paramb)
  {
    int j = 0;
    Object localObject = new HashSet();
    int i = 0;
    while (i < paramb.g())
    {
      String str = paramb.a(i);
      if ((!str.equals(d)) && (!h.a(paramContext, str))) {
        ((Set)localObject).add(Integer.valueOf(i));
      }
      i += 1;
    }
    if (!((Set)localObject).isEmpty())
    {
      paramContext = ((Set)localObject).iterator();
      i = j;
      while (paramContext.hasNext()) {
        i += paramb.g(((Integer)paramContext.next()).intValue());
      }
      i = a.nextInt(i);
      paramContext = ((Set)localObject).iterator();
      while (paramContext.hasNext())
      {
        localObject = (Integer)paramContext.next();
        j = i - paramb.g(((Integer)localObject).intValue());
        i = j;
        if (j < 0)
        {
          d = paramb.a(((Integer)localObject).intValue());
          return ((Integer)localObject).intValue();
        }
      }
    }
    return -1;
  }
  
  public static void a(Context paramContext, p paramp)
  {
    if (c < SystemClock.elapsedRealtime() - 900000L)
    {
      new as(paramContext, paramp).a(new Void[0]);
      return;
    }
    paramp.a(b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */