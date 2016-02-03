package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class u
{
  private static final u uS = new u();
  private SortedSet<a> uP = new TreeSet();
  private StringBuilder uQ = new StringBuilder();
  private boolean uR = false;
  
  public static u cP()
  {
    return uS;
  }
  
  public void a(a parama)
  {
    try
    {
      if (!this.uR)
      {
        this.uP.add(parama);
        this.uQ.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parama.ordinal()));
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public String cQ()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      int j = 6;
      int i = 0;
      while (this.uP.size() > 0)
      {
        a locala = (a)this.uP.first();
        this.uP.remove(locala);
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
      this.uP.clear();
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally {}
  }
  
  public String cR()
  {
    try
    {
      if (this.uQ.length() > 0) {
        this.uQ.insert(0, ".");
      }
      String str = this.uQ.toString();
      this.uQ = new StringBuilder();
      return str;
    }
    finally {}
  }
  
  public void u(boolean paramBoolean)
  {
    try
    {
      this.uR = paramBoolean;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */