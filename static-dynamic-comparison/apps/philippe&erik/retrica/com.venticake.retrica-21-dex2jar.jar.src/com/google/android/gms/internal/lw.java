package com.google.android.gms.internal;

import java.util.List;

public final class lw
  extends ma<lw>
{
  public lw.a[] amr;
  
  public lw()
  {
    nv();
  }
  
  public static lw n(byte[] paramArrayOfByte)
  {
    return (lw)me.a(new lw(), paramArrayOfByte);
  }
  
  public void a(lz paramlz)
  {
    if ((this.amr != null) && (this.amr.length > 0))
    {
      int i = 0;
      while (i < this.amr.length)
      {
        lw.a locala = this.amr[i];
        if (locala != null) {
          paramlz.a(1, locala);
        }
        i += 1;
      }
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int i = super.c();
    int k = i;
    if (this.amr != null)
    {
      k = i;
      if (this.amr.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.amr.length) {
            break;
          }
          lw.a locala = this.amr[j];
          k = i;
          if (locala != null) {
            k = i + lz.b(1, locala);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
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
        } while (!(paramObject instanceof lw));
        paramObject = (lw)paramObject;
        bool1 = bool2;
      } while (!mc.equals(this.amr, ((lw)paramObject).amr));
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label83;
      }
      if (((lw)paramObject).amX == null) {
        break;
      }
      bool1 = bool2;
    } while (!((lw)paramObject).amX.isEmpty());
    return true;
    label83:
    return this.amX.equals(((lw)paramObject).amX);
  }
  
  public int hashCode()
  {
    int j = mc.hashCode(this.amr);
    if ((this.amX == null) || (this.amX.isEmpty())) {}
    for (int i = 0;; i = this.amX.hashCode()) {
      return i + (j + 527) * 31;
    }
  }
  
  public lw nv()
  {
    this.amr = lw.a.nw();
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public lw q(ly paramly)
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
        if (this.amr == null) {}
        lw.a[] arrayOfa;
        for (i = 0;; i = this.amr.length)
        {
          arrayOfa = new lw.a[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amr, 0, arrayOfa, 0, i);
            j = i;
          }
          while (j < arrayOfa.length - 1)
          {
            arrayOfa[j] = new lw.a();
            paramly.a(arrayOfa[j]);
            paramly.nB();
            j += 1;
          }
        }
        arrayOfa[j] = new lw.a();
        paramly.a(arrayOfa[j]);
        this.amr = arrayOfa;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */