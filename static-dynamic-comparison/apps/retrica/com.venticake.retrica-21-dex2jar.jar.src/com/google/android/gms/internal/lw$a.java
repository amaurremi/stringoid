package com.google.android.gms.internal;

import java.util.List;

public final class lw$a
  extends ma<a>
{
  private static volatile a[] ams;
  public lw.a.a amt;
  public String name;
  
  public lw$a()
  {
    nx();
  }
  
  public static a[] nw()
  {
    if (ams == null) {}
    synchronized (mc.ana)
    {
      if (ams == null) {
        ams = new a[0];
      }
      return ams;
    }
  }
  
  public void a(lz paramlz)
  {
    paramlz.b(1, this.name);
    if (this.amt != null) {
      paramlz.a(2, this.amt);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int j = super.c() + lz.h(1, this.name);
    int i = j;
    if (this.amt != null) {
      i = j + lz.b(2, this.amt);
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    label41:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof a));
        paramObject = (a)paramObject;
        if (this.name != null) {
          break;
        }
        bool1 = bool2;
      } while (((a)paramObject).name != null);
      if (this.amt != null) {
        break label115;
      }
      bool1 = bool2;
    } while (((a)paramObject).amt != null);
    for (;;)
    {
      if ((this.amX == null) || (this.amX.isEmpty()))
      {
        if (((a)paramObject).amX != null)
        {
          bool1 = bool2;
          if (!((a)paramObject).amX.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.name.equals(((a)paramObject).name)) {
          break label41;
        }
        return false;
        label115:
        if (!this.amt.equals(((a)paramObject).amt)) {
          return false;
        }
      }
    }
    return this.amX.equals(((a)paramObject).amX);
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int j;
    if (this.name == null)
    {
      i = 0;
      if (this.amt != null) {
        break label73;
      }
      j = 0;
      label21:
      k = m;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label84;
        }
      }
    }
    label73:
    label84:
    for (int k = m;; k = this.amX.hashCode())
    {
      return (j + (i + 527) * 31) * 31 + k;
      i = this.name.hashCode();
      break;
      j = this.amt.hashCode();
      break label21;
    }
  }
  
  public a nx()
  {
    this.name = "";
    this.amt = null;
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public a r(ly paramly)
  {
    for (;;)
    {
      int i = paramly.nB();
      switch (i)
      {
      default: 
        if (a(paramly, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        this.name = paramly.readString();
        break;
      case 18: 
        if (this.amt == null) {
          this.amt = new lw.a.a();
        }
        paramly.a(this.amt);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lw$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */