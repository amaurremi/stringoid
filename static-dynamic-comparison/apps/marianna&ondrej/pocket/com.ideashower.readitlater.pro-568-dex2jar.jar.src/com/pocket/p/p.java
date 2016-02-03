package com.pocket.p;

import java.util.List;

public abstract class p
{
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public static int b(List paramList)
  {
    if (paramList == null) {
      return 0;
    }
    return paramList.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */