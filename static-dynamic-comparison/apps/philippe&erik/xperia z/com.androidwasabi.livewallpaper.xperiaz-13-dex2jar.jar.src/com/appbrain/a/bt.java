package com.appbrain.a;

import android.content.Context;
import android.os.SystemClock;
import cmn.ai;
import cmn.x;
import com.appbrain.e.ag;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public final class bt
{
  private static final Random a = new Random();
  private static ag b = null;
  private static long c = Long.MIN_VALUE;
  private static String d = null;
  
  public static int a(Context paramContext, ag paramag)
  {
    int j = 0;
    Object localObject = new HashSet();
    int i = 0;
    while (i < paramag.g())
    {
      String str = paramag.a(i);
      if ((!str.equals(d)) && (!x.a(paramContext, str))) {
        ((Set)localObject).add(Integer.valueOf(i));
      }
      i += 1;
    }
    if (!((Set)localObject).isEmpty())
    {
      paramContext = ((Set)localObject).iterator();
      i = j;
      while (paramContext.hasNext()) {
        i += paramag.g(((Integer)paramContext.next()).intValue());
      }
      i = a.nextInt(i);
      paramContext = ((Set)localObject).iterator();
      while (paramContext.hasNext())
      {
        localObject = (Integer)paramContext.next();
        j = i - paramag.g(((Integer)localObject).intValue());
        i = j;
        if (j < 0)
        {
          d = paramag.a(((Integer)localObject).intValue());
          return ((Integer)localObject).intValue();
        }
      }
    }
    return -1;
  }
  
  public static void a(Context paramContext, ai paramai)
  {
    if (c < SystemClock.elapsedRealtime() - 900000L)
    {
      new bu(paramContext, paramai).a(new Void[0]);
      return;
    }
    paramai.a(b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */