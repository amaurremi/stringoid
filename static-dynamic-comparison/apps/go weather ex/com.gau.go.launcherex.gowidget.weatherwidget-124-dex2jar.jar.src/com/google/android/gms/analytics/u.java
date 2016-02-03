package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class u
{
  private static final u tH = new u();
  private SortedSet<a> tE = new TreeSet();
  private StringBuilder tF = new StringBuilder();
  private boolean tG = false;
  
  public static u cy()
  {
    return tH;
  }
  
  public void a(a parama)
  {
    try
    {
      if (!this.tG)
      {
        this.tE.add(parama);
        this.tF.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parama.ordinal()));
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public String cA()
  {
    try
    {
      if (this.tF.length() > 0) {
        this.tF.insert(0, ".");
      }
      String str = this.tF.toString();
      this.tF = new StringBuilder();
      return str;
    }
    finally {}
  }
  
  public String cz()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      int j = 6;
      int i = 0;
      while (this.tE.size() > 0)
      {
        a locala = (a)this.tE.first();
        this.tE.remove(locala);
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
      this.tE.clear();
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally {}
  }
  
  public void t(boolean paramBoolean)
  {
    try
    {
      this.tG = paramBoolean;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */