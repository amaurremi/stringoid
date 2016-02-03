package com.google.android.gms.internal;

import java.util.List;

public abstract interface cc
{
  public static final class a
    extends gh<a>
  {
    private static volatile a[] Fx;
    public a[] FA;
    public a[] FB;
    public String FC;
    public String FD;
    public long FE;
    public boolean FF;
    public a[] FG;
    public int[] FH;
    public boolean FI;
    public String Fy;
    public a[] Fz;
    public int type;
    
    public a()
    {
      pT();
    }
    
    public static a[] pS()
    {
      if (Fx == null) {}
      synchronized (gi.Ta)
      {
        if (Fx == null) {
          Fx = new a[0];
        }
        return Fx;
      }
    }
    
    public void a(jz paramjz)
    {
      int j = 0;
      paramjz.r(1, this.type);
      if (!this.Fy.equals("")) {
        paramjz.b(2, this.Fy);
      }
      int i;
      a locala;
      if ((this.Fz != null) && (this.Fz.length > 0))
      {
        i = 0;
        while (i < this.Fz.length)
        {
          locala = this.Fz[i];
          if (locala != null) {
            paramjz.a(3, locala);
          }
          i += 1;
        }
      }
      if ((this.FA != null) && (this.FA.length > 0))
      {
        i = 0;
        while (i < this.FA.length)
        {
          locala = this.FA[i];
          if (locala != null) {
            paramjz.a(4, locala);
          }
          i += 1;
        }
      }
      if ((this.FB != null) && (this.FB.length > 0))
      {
        i = 0;
        while (i < this.FB.length)
        {
          locala = this.FB[i];
          if (locala != null) {
            paramjz.a(5, locala);
          }
          i += 1;
        }
      }
      if (!this.FC.equals("")) {
        paramjz.b(6, this.FC);
      }
      if (!this.FD.equals("")) {
        paramjz.b(7, this.FD);
      }
      if (this.FE != 0L) {
        paramjz.b(8, this.FE);
      }
      if (this.FI) {
        paramjz.b(9, this.FI);
      }
      if ((this.FH != null) && (this.FH.length > 0))
      {
        i = 0;
        while (i < this.FH.length)
        {
          paramjz.r(10, this.FH[i]);
          i += 1;
        }
      }
      if ((this.FG != null) && (this.FG.length > 0))
      {
        i = j;
        while (i < this.FG.length)
        {
          locala = this.FG[i];
          if (locala != null) {
            paramjz.a(11, locala);
          }
          i += 1;
        }
      }
      if (this.FF) {
        paramjz.b(12, this.FF);
      }
      super.a(paramjz);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label54:
      label118:
      do
      {
        do
        {
          do
          {
            do
            {
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
                  } while (this.type != ((a)paramObject).type);
                  if (this.Fy != null) {
                    break;
                  }
                  bool1 = bool2;
                } while (((a)paramObject).Fy != null);
                bool1 = bool2;
              } while (!gi.equals(this.Fz, ((a)paramObject).Fz));
              bool1 = bool2;
            } while (!gi.equals(this.FA, ((a)paramObject).FA));
            bool1 = bool2;
          } while (!gi.equals(this.FB, ((a)paramObject).FB));
          if (this.FC != null) {
            break label264;
          }
          bool1 = bool2;
        } while (((a)paramObject).FC != null);
        if (this.FD != null) {
          break label280;
        }
        bool1 = bool2;
      } while (((a)paramObject).FD != null);
      label264:
      label280:
      while (this.FD.equals(((a)paramObject).FD))
      {
        bool1 = bool2;
        if (this.FE != ((a)paramObject).FE) {
          break;
        }
        bool1 = bool2;
        if (this.FF != ((a)paramObject).FF) {
          break;
        }
        bool1 = bool2;
        if (!gi.equals(this.FG, ((a)paramObject).FG)) {
          break;
        }
        bool1 = bool2;
        if (!gi.equals(this.FH, ((a)paramObject).FH)) {
          break;
        }
        bool1 = bool2;
        if (this.FI != ((a)paramObject).FI) {
          break;
        }
        if ((this.SZ != null) && (!this.SZ.isEmpty())) {
          break label296;
        }
        if (((a)paramObject).SZ != null)
        {
          bool1 = bool2;
          if (!((a)paramObject).SZ.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.Fy.equals(((a)paramObject).Fy)) {
          break label54;
        }
        return false;
        if (this.FC.equals(((a)paramObject).FC)) {
          break label118;
        }
        return false;
      }
      return false;
      label296:
      return this.SZ.equals(((a)paramObject).SZ);
    }
    
    public int hashCode()
    {
      int n = 1231;
      int i2 = 0;
      int i3 = this.type;
      int i;
      int i4;
      int i5;
      int i6;
      int j;
      label59:
      int k;
      label68:
      int i7;
      int m;
      label95:
      int i8;
      int i9;
      if (this.Fy == null)
      {
        i = 0;
        i4 = gi.hashCode(this.Fz);
        i5 = gi.hashCode(this.FA);
        i6 = gi.hashCode(this.FB);
        if (this.FC != null) {
          break label234;
        }
        j = 0;
        if (this.FD != null) {
          break label245;
        }
        k = 0;
        i7 = (int)(this.FE ^ this.FE >>> 32);
        if (!this.FF) {
          break label256;
        }
        m = 1231;
        i8 = gi.hashCode(this.FG);
        i9 = gi.hashCode(this.FH);
        if (!this.FI) {
          break label264;
        }
        label120:
        i1 = i2;
        if (this.SZ != null) {
          if (!this.SZ.isEmpty()) {
            break label272;
          }
        }
      }
      label234:
      label245:
      label256:
      label264:
      label272:
      for (int i1 = i2;; i1 = this.SZ.hashCode())
      {
        return ((((m + ((k + (j + ((((i + (i3 + 527) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31) * 31 + i7) * 31) * 31 + i8) * 31 + i9) * 31 + n) * 31 + i1;
        i = this.Fy.hashCode();
        break;
        j = this.FC.hashCode();
        break label59;
        k = this.FD.hashCode();
        break label68;
        m = 1237;
        break label95;
        n = 1237;
        break label120;
      }
    }
    
    public int nq()
    {
      int m = 0;
      int j = super.nq() + jz.s(1, this.type);
      int i = j;
      if (!this.Fy.equals("")) {
        i = j + jz.c(2, this.Fy);
      }
      j = i;
      a locala;
      int k;
      if (this.Fz != null)
      {
        j = i;
        if (this.Fz.length > 0)
        {
          j = 0;
          while (j < this.Fz.length)
          {
            locala = this.Fz[j];
            k = i;
            if (locala != null) {
              k = i + jz.b(3, locala);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.FA != null)
      {
        i = j;
        if (this.FA.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.FA.length)
          {
            locala = this.FA[j];
            k = i;
            if (locala != null) {
              k = i + jz.b(4, locala);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.FB != null)
      {
        j = i;
        if (this.FB.length > 0)
        {
          j = 0;
          while (j < this.FB.length)
          {
            locala = this.FB[j];
            k = i;
            if (locala != null) {
              k = i + jz.b(5, locala);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!this.FC.equals("")) {
        i = j + jz.c(6, this.FC);
      }
      j = i;
      if (!this.FD.equals("")) {
        j = i + jz.c(7, this.FD);
      }
      i = j;
      if (this.FE != 0L) {
        i = j + jz.d(8, this.FE);
      }
      j = i;
      if (this.FI) {
        j = i + jz.c(9, this.FI);
      }
      i = j;
      if (this.FH != null)
      {
        i = j;
        if (this.FH.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.FH.length)
          {
            k += jz.dA(this.FH[i]);
            i += 1;
          }
          i = j + k + this.FH.length * 1;
        }
      }
      j = i;
      if (this.FG != null)
      {
        j = i;
        if (this.FG.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.FG.length) {
              break;
            }
            locala = this.FG[k];
            j = i;
            if (locala != null) {
              j = i + jz.b(11, locala);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.FF) {
        i = j + jz.c(12, this.FF);
      }
      this.tX = i;
      return i;
    }
    
    public a pT()
    {
      this.type = 1;
      this.Fy = "";
      this.Fz = pS();
      this.FA = pS();
      this.FB = pS();
      this.FC = "";
      this.FD = "";
      this.FE = 0L;
      this.FF = false;
      this.FG = pS();
      this.FH = gm.Tc;
      this.FI = false;
      this.SZ = null;
      this.tX = -1;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */