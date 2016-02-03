package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.ly;
import com.google.android.gms.internal.lz;
import com.google.android.gms.internal.ma;
import com.google.android.gms.internal.me;
import java.util.List;

public final class af
  extends ma<af>
{
  public String Jt;
  public long Ju;
  public long Jv;
  public int versionCode;
  
  public af()
  {
    gs();
  }
  
  public static af g(byte[] paramArrayOfByte)
  {
    return (af)me.a(new af(), paramArrayOfByte);
  }
  
  public void a(lz paramlz)
  {
    paramlz.p(1, this.versionCode);
    paramlz.b(2, this.Jt);
    paramlz.c(3, this.Ju);
    paramlz.c(4, this.Jv);
    super.a(paramlz);
  }
  
  protected int c()
  {
    return super.c() + lz.r(1, this.versionCode) + lz.h(2, this.Jt) + lz.e(3, this.Ju) + lz.e(4, this.Jv);
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
        } while (!(paramObject instanceof af));
        paramObject = (af)paramObject;
        bool1 = bool2;
      } while (this.versionCode != ((af)paramObject).versionCode);
      if (this.Jt != null) {
        break;
      }
      bool1 = bool2;
    } while (((af)paramObject).Jt != null);
    while (this.Jt.equals(((af)paramObject).Jt))
    {
      bool1 = bool2;
      if (this.Ju != ((af)paramObject).Ju) {
        break;
      }
      bool1 = bool2;
      if (this.Jv != ((af)paramObject).Jv) {
        break;
      }
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label140;
      }
      if (((af)paramObject).amX != null)
      {
        bool1 = bool2;
        if (!((af)paramObject).amX.isEmpty()) {
          break;
        }
      }
      return true;
    }
    return false;
    label140:
    return this.amX.equals(((af)paramObject).amX);
  }
  
  public af gs()
  {
    this.versionCode = 1;
    this.Jt = "";
    this.Ju = -1L;
    this.Jv = -1L;
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this.versionCode;
    int i;
    int n;
    int i1;
    if (this.Jt == null)
    {
      i = 0;
      n = (int)(this.Ju ^ this.Ju >>> 32);
      i1 = (int)(this.Jv ^ this.Jv >>> 32);
      j = k;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label110;
        }
      }
    }
    label110:
    for (int j = k;; j = this.amX.hashCode())
    {
      return (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + j;
      i = this.Jt.hashCode();
      break;
    }
  }
  
  public af m(ly paramly)
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
        this.versionCode = paramly.nE();
        break;
      case 18: 
        this.Jt = paramly.readString();
        break;
      case 24: 
        this.Ju = paramly.nH();
        break;
      case 32: 
        this.Jv = paramly.nH();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */