package com.google.android.gms.internal;

import java.util.List;

public final class c$j
  extends ma<j>
{
  public c.i[] fJ;
  public c.f fK;
  public String fL;
  
  public c$j()
  {
    q();
  }
  
  public static j b(byte[] paramArrayOfByte)
  {
    return (j)me.a(new j(), paramArrayOfByte);
  }
  
  public void a(lz paramlz)
  {
    if ((this.fJ != null) && (this.fJ.length > 0))
    {
      int i = 0;
      while (i < this.fJ.length)
      {
        c.i locali = this.fJ[i];
        if (locali != null) {
          paramlz.a(1, locali);
        }
        i += 1;
      }
    }
    if (this.fK != null) {
      paramlz.a(2, this.fK);
    }
    if (!this.fL.equals("")) {
      paramlz.b(3, this.fL);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int i = super.c();
    int j = i;
    if (this.fJ != null)
    {
      j = i;
      if (this.fJ.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= this.fJ.length) {
            break;
          }
          c.i locali = this.fJ[k];
          j = i;
          if (locali != null) {
            j = i + lz.b(1, locali);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.fK != null) {
      i = j + lz.b(2, this.fK);
    }
    j = i;
    if (!this.fL.equals("")) {
      j = i + lz.h(3, this.fL);
    }
    return j;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    label57:
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
          } while (!(paramObject instanceof j));
          paramObject = (j)paramObject;
          bool1 = bool2;
        } while (!mc.equals(this.fJ, ((j)paramObject).fJ));
        if (this.fK != null) {
          break;
        }
        bool1 = bool2;
      } while (((j)paramObject).fK != null);
      if (this.fL != null) {
        break label131;
      }
      bool1 = bool2;
    } while (((j)paramObject).fL != null);
    for (;;)
    {
      if ((this.amX == null) || (this.amX.isEmpty()))
      {
        if (((j)paramObject).amX != null)
        {
          bool1 = bool2;
          if (!((j)paramObject).amX.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.fK.equals(((j)paramObject).fK)) {
          break label57;
        }
        return false;
        label131:
        if (!this.fL.equals(((j)paramObject).fL)) {
          return false;
        }
      }
    }
    return this.amX.equals(((j)paramObject).amX);
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = mc.hashCode(this.fJ);
    int i;
    int j;
    if (this.fK == null)
    {
      i = 0;
      if (this.fL != null) {
        break label88;
      }
      j = 0;
      label30:
      k = m;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label99;
        }
      }
    }
    label88:
    label99:
    for (int k = m;; k = this.amX.hashCode())
    {
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = this.fK.hashCode();
      break;
      j = this.fL.hashCode();
      break label30;
    }
  }
  
  public j k(ly paramly)
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
        int j = mh.b(paramly, 10);
        if (this.fJ == null) {}
        c.i[] arrayOfi;
        for (i = 0;; i = this.fJ.length)
        {
          arrayOfi = new c.i[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.fJ, 0, arrayOfi, 0, i);
            j = i;
          }
          while (j < arrayOfi.length - 1)
          {
            arrayOfi[j] = new c.i();
            paramly.a(arrayOfi[j]);
            paramly.nB();
            j += 1;
          }
        }
        arrayOfi[j] = new c.i();
        paramly.a(arrayOfi[j]);
        this.fJ = arrayOfi;
        break;
      case 18: 
        if (this.fK == null) {
          this.fK = new c.f();
        }
        paramly.a(this.fK);
        break;
      case 26: 
        this.fL = paramly.readString();
      }
    }
  }
  
  public j q()
  {
    this.fJ = c.i.o();
    this.fK = null;
    this.fL = "";
    this.amX = null;
    this.anb = -1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */