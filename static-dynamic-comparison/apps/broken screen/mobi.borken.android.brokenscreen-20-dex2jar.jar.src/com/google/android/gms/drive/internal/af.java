package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.lz;
import com.google.android.gms.internal.ma;
import com.google.android.gms.internal.mb;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.mf;
import java.io.IOException;
import java.util.List;

public final class af
  extends mb<af>
{
  public String Jq;
  public long Jr;
  public long Js;
  public int versionCode;
  
  public af()
  {
    gn();
  }
  
  public static af g(byte[] paramArrayOfByte)
    throws me
  {
    return (af)mf.a(new af(), paramArrayOfByte);
  }
  
  public void a(ma paramma)
    throws IOException
  {
    paramma.p(1, this.versionCode);
    paramma.b(2, this.Jq);
    paramma.c(3, this.Jr);
    paramma.c(4, this.Js);
    super.a(paramma);
  }
  
  protected int c()
  {
    return super.c() + ma.r(1, this.versionCode) + ma.h(2, this.Jq) + ma.e(3, this.Jr) + ma.e(4, this.Js);
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
      if (this.Jq != null) {
        break;
      }
      bool1 = bool2;
    } while (((af)paramObject).Jq != null);
    while (this.Jq.equals(((af)paramObject).Jq))
    {
      bool1 = bool2;
      if (this.Jr != ((af)paramObject).Jr) {
        break;
      }
      bool1 = bool2;
      if (this.Js != ((af)paramObject).Js) {
        break;
      }
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        break label140;
      }
      if (((af)paramObject).amU != null)
      {
        bool1 = bool2;
        if (!((af)paramObject).amU.isEmpty()) {
          break;
        }
      }
      return true;
    }
    return false;
    label140:
    return this.amU.equals(((af)paramObject).amU);
  }
  
  public af gn()
  {
    this.versionCode = 1;
    this.Jq = "";
    this.Jr = -1L;
    this.Js = -1L;
    this.amU = null;
    this.amY = -1;
    return this;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this.versionCode;
    int i;
    int n;
    int i1;
    if (this.Jq == null)
    {
      i = 0;
      n = (int)(this.Jr ^ this.Jr >>> 32);
      i1 = (int)(this.Js ^ this.Js >>> 32);
      j = k;
      if (this.amU != null) {
        if (!this.amU.isEmpty()) {
          break label110;
        }
      }
    }
    label110:
    for (int j = k;; j = this.amU.hashCode())
    {
      return (((i + (m + 527) * 31) * 31 + n) * 31 + i1) * 31 + j;
      i = this.Jq.hashCode();
      break;
    }
  }
  
  public af m(lz paramlz)
    throws IOException
  {
    for (;;)
    {
      int i = paramlz.nw();
      switch (i)
      {
      default: 
        if (a(paramlz, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        this.versionCode = paramlz.nz();
        break;
      case 18: 
        this.Jq = paramlz.readString();
        break;
      case 24: 
        this.Jr = paramlz.nC();
        break;
      case 32: 
        this.Js = paramlz.nC();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */