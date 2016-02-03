package com.google.android.gms.internal;

import java.util.List;

public final class c$h
  extends ma<h>
{
  public static final mb<d.a, h> fx = mb.a(11, h.class, 810);
  private static final h[] fy = new h[0];
  public int[] fA;
  public int[] fB;
  public int fC;
  public int[] fD;
  public int fE;
  public int fF;
  public int[] fz;
  
  public c$h()
  {
    n();
  }
  
  public void a(lz paramlz)
  {
    int j = 0;
    int i;
    if ((this.fz != null) && (this.fz.length > 0))
    {
      i = 0;
      while (i < this.fz.length)
      {
        paramlz.p(1, this.fz[i]);
        i += 1;
      }
    }
    if ((this.fA != null) && (this.fA.length > 0))
    {
      i = 0;
      while (i < this.fA.length)
      {
        paramlz.p(2, this.fA[i]);
        i += 1;
      }
    }
    if ((this.fB != null) && (this.fB.length > 0))
    {
      i = 0;
      while (i < this.fB.length)
      {
        paramlz.p(3, this.fB[i]);
        i += 1;
      }
    }
    if (this.fC != 0) {
      paramlz.p(4, this.fC);
    }
    if ((this.fD != null) && (this.fD.length > 0))
    {
      i = j;
      while (i < this.fD.length)
      {
        paramlz.p(5, this.fD[i]);
        i += 1;
      }
    }
    if (this.fE != 0) {
      paramlz.p(6, this.fE);
    }
    if (this.fF != 0) {
      paramlz.p(7, this.fF);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int m = 0;
    int k = super.c();
    int i;
    if ((this.fz != null) && (this.fz.length > 0))
    {
      i = 0;
      j = 0;
      while (i < this.fz.length)
      {
        j += lz.eE(this.fz[i]);
        i += 1;
      }
    }
    for (int j = k + j + this.fz.length * 1;; j = k)
    {
      i = j;
      if (this.fA != null)
      {
        i = j;
        if (this.fA.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.fA.length)
          {
            k += lz.eE(this.fA[i]);
            i += 1;
          }
          i = j + k + this.fA.length * 1;
        }
      }
      j = i;
      if (this.fB != null)
      {
        j = i;
        if (this.fB.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.fB.length)
          {
            k += lz.eE(this.fB[j]);
            j += 1;
          }
          j = i + k + this.fB.length * 1;
        }
      }
      i = j;
      if (this.fC != 0) {
        i = j + lz.r(4, this.fC);
      }
      j = i;
      if (this.fD != null)
      {
        j = i;
        if (this.fD.length > 0)
        {
          k = 0;
          j = m;
          while (j < this.fD.length)
          {
            k += lz.eE(this.fD[j]);
            j += 1;
          }
          j = i + k + this.fD.length * 1;
        }
      }
      i = j;
      if (this.fE != 0) {
        i = j + lz.r(6, this.fE);
      }
      j = i;
      if (this.fF != 0) {
        j = i + lz.r(7, this.fF);
      }
      return j;
    }
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
                  do
                  {
                    do
                    {
                      return bool1;
                      bool1 = bool2;
                    } while (!(paramObject instanceof h));
                    paramObject = (h)paramObject;
                    bool1 = bool2;
                  } while (!mc.equals(this.fz, ((h)paramObject).fz));
                  bool1 = bool2;
                } while (!mc.equals(this.fA, ((h)paramObject).fA));
                bool1 = bool2;
              } while (!mc.equals(this.fB, ((h)paramObject).fB));
              bool1 = bool2;
            } while (this.fC != ((h)paramObject).fC);
            bool1 = bool2;
          } while (!mc.equals(this.fD, ((h)paramObject).fD));
          bool1 = bool2;
        } while (this.fE != ((h)paramObject).fE);
        bool1 = bool2;
      } while (this.fF != ((h)paramObject).fF);
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label170;
      }
      if (((h)paramObject).amX == null) {
        break;
      }
      bool1 = bool2;
    } while (!((h)paramObject).amX.isEmpty());
    return true;
    label170:
    return this.amX.equals(((h)paramObject).amX);
  }
  
  public int hashCode()
  {
    int j = mc.hashCode(this.fz);
    int k = mc.hashCode(this.fA);
    int m = mc.hashCode(this.fB);
    int n = this.fC;
    int i1 = mc.hashCode(this.fD);
    int i2 = this.fE;
    int i3 = this.fF;
    if ((this.amX == null) || (this.amX.isEmpty())) {}
    for (int i = 0;; i = this.amX.hashCode()) {
      return i + (((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31;
    }
  }
  
  public h i(ly paramly)
  {
    for (;;)
    {
      int i = paramly.nB();
      int j;
      int[] arrayOfInt;
      int k;
      switch (i)
      {
      default: 
        if (a(paramly, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        j = mh.b(paramly, 8);
        if (this.fz == null) {}
        for (i = 0;; i = this.fz.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fz, 0, arrayOfInt, 0, i);
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
        this.fz = arrayOfInt;
        break;
      case 10: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
        if (this.fz == null) {}
        for (i = 0;; i = this.fz.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fz, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fz = arrayOfInt;
        paramly.ey(k);
        break;
      case 16: 
        j = mh.b(paramly, 16);
        if (this.fA == null) {}
        for (i = 0;; i = this.fA.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fA, 0, arrayOfInt, 0, i);
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
        this.fA = arrayOfInt;
        break;
      case 18: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
        if (this.fA == null) {}
        for (i = 0;; i = this.fA.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fA, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fA = arrayOfInt;
        paramly.ey(k);
        break;
      case 24: 
        j = mh.b(paramly, 24);
        if (this.fB == null) {}
        for (i = 0;; i = this.fB.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fB, 0, arrayOfInt, 0, i);
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
        this.fB = arrayOfInt;
        break;
      case 26: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
        if (this.fB == null) {}
        for (i = 0;; i = this.fB.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fB, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fB = arrayOfInt;
        paramly.ey(k);
        break;
      case 32: 
        this.fC = paramly.nE();
        break;
      case 40: 
        j = mh.b(paramly, 40);
        if (this.fD == null) {}
        for (i = 0;; i = this.fD.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fD, 0, arrayOfInt, 0, i);
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
        this.fD = arrayOfInt;
        break;
      case 42: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
        if (this.fD == null) {}
        for (i = 0;; i = this.fD.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fD, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fD = arrayOfInt;
        paramly.ey(k);
        break;
      case 48: 
        this.fE = paramly.nE();
        break;
      case 56: 
        this.fF = paramly.nE();
      }
    }
  }
  
  public h n()
  {
    this.fz = mh.and;
    this.fA = mh.and;
    this.fB = mh.and;
    this.fC = 0;
    this.fD = mh.and;
    this.fE = 0;
    this.fF = 0;
    this.amX = null;
    this.anb = -1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */