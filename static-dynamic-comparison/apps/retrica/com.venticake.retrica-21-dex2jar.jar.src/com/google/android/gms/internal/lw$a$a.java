package com.google.android.gms.internal;

import java.util.List;

public final class lw$a$a
  extends ma<a>
{
  private static volatile a[] amu;
  public lw.a.a.a amv;
  public int type;
  
  public lw$a$a()
  {
    nz();
  }
  
  public static a[] ny()
  {
    if (amu == null) {}
    synchronized (mc.ana)
    {
      if (amu == null) {
        amu = new a[0];
      }
      return amu;
    }
  }
  
  public void a(lz paramlz)
  {
    paramlz.p(1, this.type);
    if (this.amv != null) {
      paramlz.a(2, this.amv);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int j = super.c() + lz.r(1, this.type);
    int i = j;
    if (this.amv != null) {
      i = j + lz.b(2, this.amv);
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
        bool1 = bool2;
      } while (this.type != ((a)paramObject).type);
      if (this.amv != null) {
        break;
      }
      bool1 = bool2;
    } while (((a)paramObject).amv != null);
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
        if (!this.amv.equals(((a)paramObject).amv)) {
          return false;
        }
      }
    }
    return this.amX.equals(((a)paramObject).amX);
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this.type;
    int i;
    if (this.amv == null)
    {
      i = 0;
      j = k;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label68;
        }
      }
    }
    label68:
    for (int j = k;; j = this.amX.hashCode())
    {
      return (i + (m + 527) * 31) * 31 + j;
      i = this.amv.hashCode();
      break;
    }
  }
  
  public a nz()
  {
    this.type = 1;
    this.amv = null;
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public a s(ly paramly)
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
      case 8: 
        i = paramly.nE();
        switch (i)
        {
        default: 
          break;
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
          this.type = i;
        }
        break;
      case 18: 
        if (this.amv == null) {
          this.amv = new lw.a.a.a();
        }
        paramly.a(this.amv);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lw$a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */