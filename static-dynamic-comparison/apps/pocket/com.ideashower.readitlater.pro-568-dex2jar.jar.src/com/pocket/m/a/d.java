package com.pocket.m.a;

import android.util.SparseArray;
import org.apache.a.c.k;

public class d
{
  private static final d c = new d("temp", false);
  private static final d d = new d("permanent", false);
  private static final SparseArray e = new SparseArray();
  private static final Object f = new Object();
  public final String a;
  public final boolean b;
  
  private d(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }
  
  public static d a()
  {
    return c;
  }
  
  public static d a(int paramInt)
  {
    synchronized (f)
    {
      d locald = (d)e.get(paramInt);
      if (locald != null) {
        return locald;
      }
      locald = new d(String.valueOf(paramInt), false);
      e.put(paramInt, locald);
      return locald;
    }
  }
  
  public static d a(a parama)
  {
    return a(parama.c());
  }
  
  public static d a(String paramString)
  {
    return new d(com.ideashower.readitlater.objects.d.a(paramString), true);
  }
  
  public static d b()
  {
    return d;
  }
  
  public boolean c()
  {
    return c.a.equals(this.a);
  }
  
  public String toString()
  {
    return "AssetUser [key=" + k.b(this.a, "null") + ", isAsset=" + this.b + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/m/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */