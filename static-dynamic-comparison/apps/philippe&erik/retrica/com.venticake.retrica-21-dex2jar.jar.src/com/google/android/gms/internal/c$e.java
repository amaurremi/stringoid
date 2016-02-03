package com.google.android.gms.internal;

import java.util.List;

public final class c$e
  extends ma<e>
{
  private static volatile e[] eU;
  public int key;
  public int value;
  
  public c$e()
  {
    j();
  }
  
  public static e[] i()
  {
    if (eU == null) {}
    synchronized (mc.ana)
    {
      if (eU == null) {
        eU = new e[0];
      }
      return eU;
    }
  }
  
  public void a(lz paramlz)
  {
    paramlz.p(1, this.key);
    paramlz.p(2, this.value);
    super.a(paramlz);
  }
  
  protected int c()
  {
    return super.c() + lz.r(1, this.key) + lz.r(2, this.value);
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
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof e));
          paramObject = (e)paramObject;
          bool1 = bool2;
        } while (this.key != ((e)paramObject).key);
        bool1 = bool2;
      } while (this.value != ((e)paramObject).value);
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label93;
      }
      if (((e)paramObject).amX == null) {
        break;
      }
      bool1 = bool2;
    } while (!((e)paramObject).amX.isEmpty());
    return true;
    label93:
    return this.amX.equals(((e)paramObject).amX);
  }
  
  public e f(ly paramly)
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
        this.key = paramly.nE();
        break;
      case 16: 
        this.value = paramly.nE();
      }
    }
  }
  
  public int hashCode()
  {
    int j = this.key;
    int k = this.value;
    if ((this.amX == null) || (this.amX.isEmpty())) {}
    for (int i = 0;; i = this.amX.hashCode()) {
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  public e j()
  {
    this.key = 0;
    this.value = 0;
    this.amX = null;
    this.anb = -1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */