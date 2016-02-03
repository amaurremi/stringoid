package com.google.android.gms.internal;

import java.util.List;

public final class iv$a
  extends ma<a>
{
  public iv.a.a[] Uy;
  
  public iv$a()
  {
    iQ();
  }
  
  public void a(lz paramlz)
  {
    if ((this.Uy != null) && (this.Uy.length > 0))
    {
      int i = 0;
      while (i < this.Uy.length)
      {
        iv.a.a locala = this.Uy[i];
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
    if (this.Uy != null)
    {
      k = i;
      if (this.Uy.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.Uy.length) {
            break;
          }
          iv.a.a locala = this.Uy[j];
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
        } while (!(paramObject instanceof a));
        paramObject = (a)paramObject;
        bool1 = bool2;
      } while (!mc.equals(this.Uy, ((a)paramObject).Uy));
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label83;
      }
      if (((a)paramObject).amX == null) {
        break;
      }
      bool1 = bool2;
    } while (!((a)paramObject).amX.isEmpty());
    return true;
    label83:
    return this.amX.equals(((a)paramObject).amX);
  }
  
  public int hashCode()
  {
    int j = mc.hashCode(this.Uy);
    if ((this.amX == null) || (this.amX.isEmpty())) {}
    for (int i = 0;; i = this.amX.hashCode()) {
      return i + (j + 527) * 31;
    }
  }
  
  public a iQ()
  {
    this.Uy = iv.a.a.iR();
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public a n(ly paramly)
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
        if (this.Uy == null) {}
        iv.a.a[] arrayOfa;
        for (i = 0;; i = this.Uy.length)
        {
          arrayOfa = new iv.a.a[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.Uy, 0, arrayOfa, 0, i);
            j = i;
          }
          while (j < arrayOfa.length - 1)
          {
            arrayOfa[j] = new iv.a.a();
            paramly.a(arrayOfa[j]);
            paramly.nB();
            j += 1;
          }
        }
        arrayOfa[j] = new iv.a.a();
        paramly.a(arrayOfa[j]);
        this.Uy = arrayOfa;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/iv$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */