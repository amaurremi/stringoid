package com.google.android.gms.internal;

import java.util.List;

public final class iv$a$a
  extends ma<a>
{
  private static volatile a[] Uz;
  public String UA;
  public String UB;
  public int viewId;
  
  public iv$a$a()
  {
    iS();
  }
  
  public static a[] iR()
  {
    if (Uz == null) {}
    synchronized (mc.ana)
    {
      if (Uz == null) {
        Uz = new a[0];
      }
      return Uz;
    }
  }
  
  public void a(lz paramlz)
  {
    if (!this.UA.equals("")) {
      paramlz.b(1, this.UA);
    }
    if (!this.UB.equals("")) {
      paramlz.b(2, this.UB);
    }
    if (this.viewId != 0) {
      paramlz.p(3, this.viewId);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int j = super.c();
    int i = j;
    if (!this.UA.equals("")) {
      i = j + lz.h(1, this.UA);
    }
    j = i;
    if (!this.UB.equals("")) {
      j = i + lz.h(2, this.UB);
    }
    i = j;
    if (this.viewId != 0) {
      i = j + lz.r(3, this.viewId);
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
    label41:
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
        if (this.UA != null) {
          break;
        }
        bool1 = bool2;
      } while (((a)paramObject).UA != null);
      if (this.UB != null) {
        break label128;
      }
      bool1 = bool2;
    } while (((a)paramObject).UB != null);
    label128:
    while (this.UB.equals(((a)paramObject).UB))
    {
      bool1 = bool2;
      if (this.viewId != ((a)paramObject).viewId) {
        break;
      }
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label144;
      }
      if (((a)paramObject).amX != null)
      {
        bool1 = bool2;
        if (!((a)paramObject).amX.isEmpty()) {
          break;
        }
      }
      return true;
      if (this.UA.equals(((a)paramObject).UA)) {
        break label41;
      }
      return false;
    }
    return false;
    label144:
    return this.amX.equals(((a)paramObject).amX);
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int j;
    label21:
    int n;
    if (this.UA == null)
    {
      i = 0;
      if (this.UB != null) {
        break label85;
      }
      j = 0;
      n = this.viewId;
      k = m;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label96;
        }
      }
    }
    label85:
    label96:
    for (int k = m;; k = this.amX.hashCode())
    {
      return ((j + (i + 527) * 31) * 31 + n) * 31 + k;
      i = this.UA.hashCode();
      break;
      j = this.UB.hashCode();
      break label21;
    }
  }
  
  public a iS()
  {
    this.UA = "";
    this.UB = "";
    this.viewId = 0;
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public a o(ly paramly)
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
        this.UA = paramly.readString();
        break;
      case 18: 
        this.UB = paramly.readString();
        break;
      case 24: 
        this.viewId = paramly.nE();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/iv$a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */