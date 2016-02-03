package com.pocket.q.a;

import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.h;
import com.ideashower.readitlater.h.b;
import com.ideashower.readitlater.h.d;

public abstract class p
{
  public static j a(h paramh, int paramInt)
  {
    return a(paramh, b(paramInt));
  }
  
  public static j a(h paramh, String paramString)
  {
    return new j(paramh, paramString);
  }
  
  public static r a(h paramh, b paramb, int paramInt)
  {
    return a(paramh, paramb, b(paramInt));
  }
  
  public static r a(h paramh, b paramb, String paramString)
  {
    return new r(paramh, paramString, paramb, null);
  }
  
  public static t a(h paramh, d paramd, int paramInt)
  {
    return a(paramh, paramd, b(paramInt));
  }
  
  public static t a(h paramh, d paramd, String paramString)
  {
    return new t(paramh, paramString, paramd, null);
  }
  
  public static q b(h paramh, int paramInt)
  {
    return b(paramh, b(paramInt));
  }
  
  public static q b(h paramh, String paramString)
  {
    return new q(paramh, paramString, null);
  }
  
  private static String b(int paramInt)
  {
    return g.a(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/q/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */