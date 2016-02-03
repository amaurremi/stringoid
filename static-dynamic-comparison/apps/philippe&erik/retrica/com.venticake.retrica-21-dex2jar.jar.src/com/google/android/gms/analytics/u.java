package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class u
{
  private static final u d = new u();
  private SortedSet<u.a> a = new TreeSet();
  private StringBuilder b = new StringBuilder();
  private boolean c = false;
  
  public static u a()
  {
    return d;
  }
  
  public void a(u.a parama)
  {
    try
    {
      if (!this.c)
      {
        this.a.add(parama);
        this.b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parama.ordinal()));
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String b()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      int j = 6;
      int i = 0;
      while (this.a.size() > 0)
      {
        u.a locala = (u.a)this.a.first();
        this.a.remove(locala);
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
      this.a.clear();
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally {}
  }
  
  public String c()
  {
    try
    {
      if (this.b.length() > 0) {
        this.b.insert(0, ".");
      }
      String str = this.b.toString();
      this.b = new StringBuilder();
      return str;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */