package com.google.android.gms.internal;

import java.util.List;

public final class c$a
  extends ma<a>
{
  public int eE;
  public int eF;
  public int level;
  
  public c$a()
  {
    b();
  }
  
  public a a(ly paramly)
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
          this.level = i;
        }
        break;
      case 16: 
        this.eE = paramly.nE();
        break;
      case 24: 
        this.eF = paramly.nE();
      }
    }
  }
  
  public void a(lz paramlz)
  {
    if (this.level != 1) {
      paramlz.p(1, this.level);
    }
    if (this.eE != 0) {
      paramlz.p(2, this.eE);
    }
    if (this.eF != 0) {
      paramlz.p(3, this.eF);
    }
    super.a(paramlz);
  }
  
  public a b()
  {
    this.level = 1;
    this.eE = 0;
    this.eF = 0;
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  protected int c()
  {
    int j = super.c();
    int i = j;
    if (this.level != 1) {
      i = j + lz.r(1, this.level);
    }
    j = i;
    if (this.eE != 0) {
      j = i + lz.r(2, this.eE);
    }
    i = j;
    if (this.eF != 0) {
      i = j + lz.r(3, this.eF);
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
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof a));
            paramObject = (a)paramObject;
            bool1 = bool2;
          } while (this.level != ((a)paramObject).level);
          bool1 = bool2;
        } while (this.eE != ((a)paramObject).eE);
        bool1 = bool2;
      } while (this.eF != ((a)paramObject).eF);
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label106;
      }
      if (((a)paramObject).amX == null) {
        break;
      }
      bool1 = bool2;
    } while (!((a)paramObject).amX.isEmpty());
    return true;
    label106:
    return this.amX.equals(((a)paramObject).amX);
  }
  
  public int hashCode()
  {
    int j = this.level;
    int k = this.eE;
    int m = this.eF;
    if ((this.amX == null) || (this.amX.isEmpty())) {}
    for (int i = 0;; i = this.amX.hashCode()) {
      return i + (((j + 527) * 31 + k) * 31 + m) * 31;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */