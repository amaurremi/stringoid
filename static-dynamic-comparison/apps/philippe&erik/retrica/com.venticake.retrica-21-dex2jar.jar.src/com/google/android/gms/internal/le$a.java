package com.google.android.gms.internal;

import java.util.List;

public final class le$a
  extends ma<a>
{
  public long aiG;
  public c.j aiH;
  public c.f fK;
  
  public le$a()
  {
    nf();
  }
  
  public static a l(byte[] paramArrayOfByte)
  {
    return (a)me.a(new a(), paramArrayOfByte);
  }
  
  public void a(lz paramlz)
  {
    paramlz.b(1, this.aiG);
    if (this.fK != null) {
      paramlz.a(2, this.fK);
    }
    if (this.aiH != null) {
      paramlz.a(3, this.aiH);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int j = super.c() + lz.d(1, this.aiG);
    int i = j;
    if (this.fK != null) {
      i = j + lz.b(2, this.fK);
    }
    j = i;
    if (this.aiH != null) {
      j = i + lz.b(3, this.aiH);
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
    label55:
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
        } while (this.aiG != ((a)paramObject).aiG);
        if (this.fK != null) {
          break;
        }
        bool1 = bool2;
      } while (((a)paramObject).fK != null);
      if (this.aiH != null) {
        break label129;
      }
      bool1 = bool2;
    } while (((a)paramObject).aiH != null);
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
        if (this.fK.equals(((a)paramObject).fK)) {
          break label55;
        }
        return false;
        label129:
        if (!this.aiH.equals(((a)paramObject).aiH)) {
          return false;
        }
      }
    }
    return this.amX.equals(((a)paramObject).amX);
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = (int)(this.aiG ^ this.aiG >>> 32);
    int i;
    int j;
    if (this.fK == null)
    {
      i = 0;
      if (this.aiH != null) {
        break label94;
      }
      j = 0;
      label36:
      k = m;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label105;
        }
      }
    }
    label94:
    label105:
    for (int k = m;; k = this.amX.hashCode())
    {
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = this.fK.hashCode();
      break;
      j = this.aiH.hashCode();
      break label36;
    }
  }
  
  public a nf()
  {
    this.aiG = 0L;
    this.fK = null;
    this.aiH = null;
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public a p(ly paramly)
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
        this.aiG = paramly.nD();
        break;
      case 18: 
        if (this.fK == null) {
          this.fK = new c.f();
        }
        paramly.a(this.fK);
        break;
      case 26: 
        if (this.aiH == null) {
          this.aiH = new c.j();
        }
        paramly.a(this.aiH);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/le$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */