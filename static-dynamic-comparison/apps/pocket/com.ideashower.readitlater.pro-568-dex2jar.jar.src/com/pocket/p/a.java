package com.pocket.p;

import android.os.SystemClock;

public class a
{
  public static void a(b paramb, long paramLong1, long paramLong2)
  {
    paramb.a = (SystemClock.uptimeMillis() - paramLong1);
    paramb.b = ((int)Math.floor(paramb.a / paramLong2));
    paramb.c = (paramb.a - paramb.b * paramLong2);
    paramb.d = ((float)paramb.c / (float)paramLong2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */