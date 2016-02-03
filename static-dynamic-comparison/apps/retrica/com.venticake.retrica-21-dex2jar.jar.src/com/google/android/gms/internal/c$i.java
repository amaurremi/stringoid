package com.google.android.gms.internal;

import java.util.List;

public final class c$i
  extends ma<i>
{
  private static volatile i[] fG;
  public d.a fH;
  public c.d fI;
  public String name;
  
  public c$i()
  {
    p();
  }
  
  public static i[] o()
  {
    if (fG == null) {}
    synchronized (mc.ana)
    {
      if (fG == null) {
        fG = new i[0];
      }
      return fG;
    }
  }
  
  public void a(lz paramlz)
  {
    if (!this.name.equals("")) {
      paramlz.b(1, this.name);
    }
    if (this.fH != null) {
      paramlz.a(2, this.fH);
    }
    if (this.fI != null) {
      paramlz.a(3, this.fI);
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int j = super.c();
    int i = j;
    if (!this.name.equals("")) {
      i = j + lz.h(1, this.name);
    }
    j = i;
    if (this.fH != null) {
      j = i + lz.b(2, this.fH);
    }
    i = j;
    if (this.fI != null) {
      i = j + lz.b(3, this.fI);
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
          } while (!(paramObject instanceof i));
          paramObject = (i)paramObject;
          if (this.name != null) {
            break;
          }
          bool1 = bool2;
        } while (((i)paramObject).name != null);
        if (this.fH != null) {
          break label131;
        }
        bool1 = bool2;
      } while (((i)paramObject).fH != null);
      if (this.fI != null) {
        break label147;
      }
      bool1 = bool2;
    } while (((i)paramObject).fI != null);
    for (;;)
    {
      if ((this.amX == null) || (this.amX.isEmpty()))
      {
        if (((i)paramObject).amX != null)
        {
          bool1 = bool2;
          if (!((i)paramObject).amX.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.name.equals(((i)paramObject).name)) {
          break label41;
        }
        return false;
        label131:
        if (this.fH.equals(((i)paramObject).fH)) {
          break label57;
        }
        return false;
        label147:
        if (!this.fI.equals(((i)paramObject).fI)) {
          return false;
        }
      }
    }
    return this.amX.equals(((i)paramObject).amX);
  }
  
  public int hashCode()
  {
    int n = 0;
    int i;
    int j;
    label21:
    int k;
    if (this.name == null)
    {
      i = 0;
      if (this.fH != null) {
        break label90;
      }
      j = 0;
      if (this.fI != null) {
        break label101;
      }
      k = 0;
      label30:
      m = n;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label112;
        }
      }
    }
    label90:
    label101:
    label112:
    for (int m = n;; m = this.amX.hashCode())
    {
      return (k + (j + (i + 527) * 31) * 31) * 31 + m;
      i = this.name.hashCode();
      break;
      j = this.fH.hashCode();
      break label21;
      k = this.fI.hashCode();
      break label30;
    }
  }
  
  public i j(ly paramly)
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
        this.name = paramly.readString();
        break;
      case 18: 
        if (this.fH == null) {
          this.fH = new d.a();
        }
        paramly.a(this.fH);
        break;
      case 26: 
        if (this.fI == null) {
          this.fI = new c.d();
        }
        paramly.a(this.fI);
      }
    }
  }
  
  public i p()
  {
    this.name = "";
    this.fH = null;
    this.fI = null;
    this.amX = null;
    this.anb = -1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */