package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface lf
{
  public static final class a
    extends mb<a>
  {
    public long aiD;
    public c.j aiE;
    public c.f fK;
    
    public a()
    {
      na();
    }
    
    public static a l(byte[] paramArrayOfByte)
      throws me
    {
      return (a)mf.a(new a(), paramArrayOfByte);
    }
    
    public void a(ma paramma)
      throws IOException
    {
      paramma.b(1, this.aiD);
      if (this.fK != null) {
        paramma.a(2, this.fK);
      }
      if (this.aiE != null) {
        paramma.a(3, this.aiE);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int j = super.c() + ma.d(1, this.aiD);
      int i = j;
      if (this.fK != null) {
        i = j + ma.b(2, this.fK);
      }
      j = i;
      if (this.aiE != null) {
        j = i + ma.b(3, this.aiE);
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
          } while (this.aiD != ((a)paramObject).aiD);
          if (this.fK != null) {
            break;
          }
          bool1 = bool2;
        } while (((a)paramObject).fK != null);
        if (this.aiE != null) {
          break label129;
        }
        bool1 = bool2;
      } while (((a)paramObject).aiE != null);
      for (;;)
      {
        if ((this.amU == null) || (this.amU.isEmpty()))
        {
          if (((a)paramObject).amU != null)
          {
            bool1 = bool2;
            if (!((a)paramObject).amU.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.fK.equals(((a)paramObject).fK)) {
            break label55;
          }
          return false;
          label129:
          if (!this.aiE.equals(((a)paramObject).aiE)) {
            return false;
          }
        }
      }
      return this.amU.equals(((a)paramObject).amU);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = (int)(this.aiD ^ this.aiD >>> 32);
      int i;
      int j;
      if (this.fK == null)
      {
        i = 0;
        if (this.aiE != null) {
          break label94;
        }
        j = 0;
        label36:
        k = m;
        if (this.amU != null) {
          if (!this.amU.isEmpty()) {
            break label105;
          }
        }
      }
      label94:
      label105:
      for (int k = m;; k = this.amU.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = this.fK.hashCode();
        break;
        j = this.aiE.hashCode();
        break label36;
      }
    }
    
    public a na()
    {
      this.aiD = 0L;
      this.fK = null;
      this.aiE = null;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public a p(lz paramlz)
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
          this.aiD = paramlz.ny();
          break;
        case 18: 
          if (this.fK == null) {
            this.fK = new c.f();
          }
          paramlz.a(this.fK);
          break;
        case 26: 
          if (this.aiE == null) {
            this.aiE = new c.j();
          }
          paramlz.a(this.aiE);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/lf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */