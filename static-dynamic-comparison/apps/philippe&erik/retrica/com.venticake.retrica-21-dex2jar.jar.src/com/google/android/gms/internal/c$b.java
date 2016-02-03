package com.google.android.gms.internal;

import java.util.List;

public final class c$b
  extends ma<b>
{
  private static volatile b[] eG;
  public int[] eH;
  public int eI;
  public boolean eJ;
  public boolean eK;
  public int name;
  
  public c$b()
  {
    e();
  }
  
  public static b[] d()
  {
    if (eG == null) {}
    synchronized (mc.ana)
    {
      if (eG == null) {
        eG = new b[0];
      }
      return eG;
    }
  }
  
  public void a(lz paramlz)
  {
    if (this.eK) {
      paramlz.a(1, this.eK);
    }
    paramlz.p(2, this.eI);
    if ((this.eH != null) && (this.eH.length > 0))
    {
      int i = 0;
      while (i < this.eH.length)
      {
        paramlz.p(3, this.eH[i]);
        i += 1;
      }
    }
    if (this.name != 0) {
      paramlz.p(4, this.name);
    }
    if (this.eJ) {
      paramlz.a(6, this.eJ);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int j = 0;
    int k = super.c();
    int i = k;
    if (this.eK) {
      i = k + lz.b(1, this.eK);
    }
    k = lz.r(2, this.eI) + i;
    if ((this.eH != null) && (this.eH.length > 0))
    {
      i = 0;
      while (i < this.eH.length)
      {
        j += lz.eE(this.eH[i]);
        i += 1;
      }
    }
    for (j = k + j + this.eH.length * 1;; j = k)
    {
      i = j;
      if (this.name != 0) {
        i = j + lz.r(4, this.name);
      }
      j = i;
      if (this.eJ) {
        j = i + lz.b(6, this.eJ);
      }
      return j;
    }
  }
  
  public b c(ly paramly)
  {
    for (;;)
    {
      int i = paramly.nB();
      int j;
      int[] arrayOfInt;
      switch (i)
      {
      default: 
        if (a(paramly, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        this.eK = paramly.nF();
        break;
      case 16: 
        this.eI = paramly.nE();
        break;
      case 24: 
        j = mh.b(paramly, 24);
        if (this.eH == null) {}
        for (i = 0;; i = this.eH.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.eH, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.eH = arrayOfInt;
        break;
      case 26: 
        int k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
        if (this.eH == null) {}
        for (i = 0;; i = this.eH.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.eH, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.eH = arrayOfInt;
        paramly.ey(k);
        break;
      case 32: 
        this.name = paramly.nE();
        break;
      case 48: 
        this.eJ = paramly.nF();
      }
    }
  }
  
  public b e()
  {
    this.eH = mh.and;
    this.eI = 0;
    this.name = 0;
    this.eJ = false;
    this.eK = false;
    this.amX = null;
    this.anb = -1;
    return this;
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
              do
              {
                do
                {
                  return bool1;
                  bool1 = bool2;
                } while (!(paramObject instanceof b));
                paramObject = (b)paramObject;
                bool1 = bool2;
              } while (!mc.equals(this.eH, ((b)paramObject).eH));
              bool1 = bool2;
            } while (this.eI != ((b)paramObject).eI);
            bool1 = bool2;
          } while (this.name != ((b)paramObject).name);
          bool1 = bool2;
        } while (this.eJ != ((b)paramObject).eJ);
        bool1 = bool2;
      } while (this.eK != ((b)paramObject).eK);
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label135;
      }
      if (((b)paramObject).amX == null) {
        break;
      }
      bool1 = bool2;
    } while (!((b)paramObject).amX.isEmpty());
    return true;
    label135:
    return this.amX.equals(((b)paramObject).amX);
  }
  
  public int hashCode()
  {
    int j = 1231;
    int m = mc.hashCode(this.eH);
    int n = this.eI;
    int i1 = this.name;
    int i;
    if (this.eJ)
    {
      i = 1231;
      if (!this.eK) {
        break label105;
      }
      label43:
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label112;
      }
    }
    label105:
    label112:
    for (int k = 0;; k = this.amX.hashCode())
    {
      return k + ((i + (((m + 527) * 31 + n) * 31 + i1) * 31) * 31 + j) * 31;
      i = 1237;
      break;
      j = 1237;
      break label43;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */