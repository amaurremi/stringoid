package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class u
{
  private static final u oC = new u();
  private StringBuilder oA = new StringBuilder();
  private boolean oB = false;
  private SortedSet<a> oz = new TreeSet();
  
  public static u lF()
  {
    return oC;
  }
  
  public void a(a parama)
  {
    try
    {
      if (!this.oB)
      {
        this.oz.add(parama);
        this.oA.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parama.ordinal()));
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public String lG()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      int j = 6;
      int i = 0;
      while (this.oz.size() > 0)
      {
        a locala = (a)this.oz.first();
        this.oz.remove(locala);
        int k = locala.ordinal();
        while (k >= j)
        {
          ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
          j += 6;
          i = 0;
        }
        i += (1 << locala.ordinal() % 6);
      }
      if ((i > 0) || (((StringBuilder)localObject1).length() == 0)) {
        ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
      }
      this.oz.clear();
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally {}
  }
  
  public String lH()
  {
    try
    {
      if (this.oA.length() > 0) {
        this.oA.insert(0, ".");
      }
      String str = this.oA.toString();
      this.oA = new StringBuilder();
      return str;
    }
    finally {}
  }
  
  public void u(boolean paramBoolean)
  {
    try
    {
      this.oB = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */