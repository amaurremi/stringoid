package com.pocket.stats;

import com.pocket.p.c;

public class a
{
  public static final k a = new b("view_page", null);
  private static final k b = new b("change_limit", 3, null);
  private static final k c = new b("change_priority", 3, null);
  
  public static void a(int paramInt)
  {
    if (paramInt == 1) {}
    for (String str = "oldest";; str = "newest")
    {
      c.a(str);
      return;
    }
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L) {}
    for (String str = "0";; str = String.valueOf((int)c.a(paramLong)))
    {
      b.a(str);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/stats/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */