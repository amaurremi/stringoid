package com.google.android.gms.internal;

import java.util.List;

public final class c$c
  extends ma<c>
{
  private static volatile c[] eL;
  public String eM;
  public long eN;
  public long eO;
  public boolean eP;
  public long eQ;
  
  public c$c()
  {
    g();
  }
  
  public static c[] f()
  {
    if (eL == null) {}
    synchronized (mc.ana)
    {
      if (eL == null) {
        eL = new c[0];
      }
      return eL;
    }
  }
  
  public void a(lz paramlz)
  {
    if (!this.eM.equals("")) {
      paramlz.b(1, this.eM);
    }
    if (this.eN != 0L) {
      paramlz.b(2, this.eN);
    }
    if (this.eO != 2147483647L) {
      paramlz.b(3, this.eO);
    }
    if (this.eP) {
      paramlz.a(4, this.eP);
    }
    if (this.eQ != 0L) {
      paramlz.b(5, this.eQ);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int j = super.c();
    int i = j;
    if (!this.eM.equals("")) {
      i = j + lz.h(1, this.eM);
    }
    j = i;
    if (this.eN != 0L) {
      j = i + lz.d(2, this.eN);
    }
    i = j;
    if (this.eO != 2147483647L) {
      i = j + lz.d(3, this.eO);
    }
    j = i;
    if (this.eP) {
      j = i + lz.b(4, this.eP);
    }
    i = j;
    if (this.eQ != 0L) {
      i = j + lz.d(5, this.eQ);
    }
    return i;
  }
  
  public c d(ly paramly)
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
        this.eM = paramly.readString();
        break;
      case 16: 
        this.eN = paramly.nD();
        break;
      case 24: 
        this.eO = paramly.nD();
        break;
      case 32: 
        this.eP = paramly.nF();
        break;
      case 40: 
        this.eQ = paramly.nD();
      }
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
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof c));
      paramObject = (c)paramObject;
      if (this.eM != null) {
        break;
      }
      bool1 = bool2;
    } while (((c)paramObject).eM != null);
    while (this.eM.equals(((c)paramObject).eM))
    {
      bool1 = bool2;
      if (this.eN != ((c)paramObject).eN) {
        break;
      }
      bool1 = bool2;
      if (this.eO != ((c)paramObject).eO) {
        break;
      }
      bool1 = bool2;
      if (this.eP != ((c)paramObject).eP) {
        break;
      }
      bool1 = bool2;
      if (this.eQ != ((c)paramObject).eQ) {
        break;
      }
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label154;
      }
      if (((c)paramObject).amX != null)
      {
        bool1 = bool2;
        if (!((c)paramObject).amX.isEmpty()) {
          break;
        }
      }
      return true;
    }
    return false;
    label154:
    return this.amX.equals(((c)paramObject).amX);
  }
  
  public c g()
  {
    this.eM = "";
    this.eN = 0L;
    this.eO = 2147483647L;
    this.eP = false;
    this.eQ = 0L;
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int n;
    int i1;
    int j;
    label53:
    int i2;
    if (this.eM == null)
    {
      i = 0;
      n = (int)(this.eN ^ this.eN >>> 32);
      i1 = (int)(this.eO ^ this.eO >>> 32);
      if (!this.eP) {
        break label138;
      }
      j = 1231;
      i2 = (int)(this.eQ ^ this.eQ >>> 32);
      k = m;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label145;
        }
      }
    }
    label138:
    label145:
    for (int k = m;; k = this.amX.hashCode())
    {
      return ((j + (((i + 527) * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + k;
      i = this.eM.hashCode();
      break;
      j = 1237;
      break label53;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */