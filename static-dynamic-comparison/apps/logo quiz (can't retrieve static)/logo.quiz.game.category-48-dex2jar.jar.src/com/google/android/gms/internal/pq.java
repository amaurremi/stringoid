package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface pq
{
  public static final class a
    extends pg<a>
  {
    public String[] awT;
    public String[] awU;
    public int[] awV;
    
    public a()
    {
      qH();
    }
    
    public void a(pf parampf)
      throws IOException
    {
      int j = 0;
      int i;
      String str;
      if ((this.awT != null) && (this.awT.length > 0))
      {
        i = 0;
        while (i < this.awT.length)
        {
          str = this.awT[i];
          if (str != null) {
            parampf.b(1, str);
          }
          i += 1;
        }
      }
      if ((this.awU != null) && (this.awU.length > 0))
      {
        i = 0;
        while (i < this.awU.length)
        {
          str = this.awU[i];
          if (str != null) {
            parampf.b(2, str);
          }
          i += 1;
        }
      }
      if ((this.awV != null) && (this.awV.length > 0))
      {
        i = j;
        while (i < this.awV.length)
        {
          parampf.s(3, this.awV[i]);
          i += 1;
        }
      }
      super.a(parampf);
    }
    
    protected int c()
    {
      int i2 = 0;
      int i1 = super.c();
      int j;
      int k;
      String str;
      int n;
      int m;
      if ((this.awT != null) && (this.awT.length > 0))
      {
        i = 0;
        j = 0;
        for (k = 0; i < this.awT.length; k = m)
        {
          str = this.awT[i];
          n = j;
          m = k;
          if (str != null)
          {
            m = k + 1;
            n = j + pf.df(str);
          }
          i += 1;
          j = n;
        }
      }
      for (int i = i1 + j + k * 1;; i = i1)
      {
        j = i;
        if (this.awU != null)
        {
          j = i;
          if (this.awU.length > 0)
          {
            j = 0;
            k = 0;
            for (m = 0; j < this.awU.length; m = n)
            {
              str = this.awU[j];
              i1 = k;
              n = m;
              if (str != null)
              {
                n = m + 1;
                i1 = k + pf.df(str);
              }
              j += 1;
              k = i1;
            }
            j = i + k + m * 1;
          }
        }
        i = j;
        if (this.awV != null)
        {
          i = j;
          if (this.awV.length > 0)
          {
            k = 0;
            i = i2;
            while (i < this.awV.length)
            {
              k += pf.gv(this.awV[i]);
              i += 1;
            }
            i = j + k + this.awV.length * 1;
          }
        }
        return i;
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
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof a));
            paramObject = (a)paramObject;
            bool1 = bool2;
          } while (!pk.equals(this.awT, ((a)paramObject).awT));
          bool1 = bool2;
        } while (!pk.equals(this.awU, ((a)paramObject).awU));
        bool1 = bool2;
      } while (!pk.equals(this.awV, ((a)paramObject).awV));
      return a((pg)paramObject);
    }
    
    public int hashCode()
    {
      return (((pk.hashCode(this.awT) + 527) * 31 + pk.hashCode(this.awU)) * 31 + pk.hashCode(this.awV)) * 31 + qx();
    }
    
    public a qH()
    {
      this.awT = pp.awQ;
      this.awU = pp.awQ;
      this.awV = pp.awL;
      this.awy = null;
      this.awJ = -1;
      return this;
    }
    
    public a v(pe parampe)
      throws IOException
    {
      for (;;)
      {
        int i = parampe.qg();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (a(parampe, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = pp.b(parampe, 10);
          if (this.awT == null) {}
          for (i = 0;; i = this.awT.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.awT, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = parampe.readString();
              parampe.qg();
              j += 1;
            }
          }
          localObject[j] = parampe.readString();
          this.awT = ((String[])localObject);
          break;
        case 18: 
          j = pp.b(parampe, 18);
          if (this.awU == null) {}
          for (i = 0;; i = this.awU.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.awU, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = parampe.readString();
              parampe.qg();
              j += 1;
            }
          }
          localObject[j] = parampe.readString();
          this.awU = ((String[])localObject);
          break;
        case 24: 
          j = pp.b(parampe, 24);
          if (this.awV == null) {}
          for (i = 0;; i = this.awV.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.awV, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = parampe.qj();
              parampe.qg();
              j += 1;
            }
          }
          localObject[j] = parampe.qj();
          this.awV = ((int[])localObject);
          break;
        case 26: 
          int k = parampe.go(parampe.qn());
          i = parampe.getPosition();
          j = 0;
          while (parampe.qs() > 0)
          {
            parampe.qj();
            j += 1;
          }
          parampe.gq(i);
          if (this.awV == null) {}
          for (i = 0;; i = this.awV.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.awV, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = parampe.qj();
              j += 1;
            }
          }
          this.awV = ((int[])localObject);
          parampe.gp(k);
        }
      }
    }
  }
  
  public static final class b
    extends pg<b>
  {
    public int awW;
    public String awX;
    public String version;
    
    public b()
    {
      qI();
    }
    
    public void a(pf parampf)
      throws IOException
    {
      if (this.awW != 0) {
        parampf.s(1, this.awW);
      }
      if (!this.awX.equals("")) {
        parampf.b(2, this.awX);
      }
      if (!this.version.equals("")) {
        parampf.b(3, this.version);
      }
      super.a(parampf);
    }
    
    protected int c()
    {
      int j = super.c();
      int i = j;
      if (this.awW != 0) {
        i = j + pf.u(1, this.awW);
      }
      j = i;
      if (!this.awX.equals("")) {
        j = i + pf.j(2, this.awX);
      }
      i = j;
      if (!this.version.equals("")) {
        i = j + pf.j(3, this.version);
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
            } while (!(paramObject instanceof b));
            paramObject = (b)paramObject;
            bool1 = bool2;
          } while (this.awW != ((b)paramObject).awW);
          if (this.awX != null) {
            break;
          }
          bool1 = bool2;
        } while (((b)paramObject).awX != null);
        if (this.version != null) {
          break label92;
        }
        bool1 = bool2;
      } while (((b)paramObject).version != null);
      label92:
      while (this.version.equals(((b)paramObject).version))
      {
        return a((pg)paramObject);
        if (this.awX.equals(((b)paramObject).awX)) {
          break;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int j = 0;
      int k = this.awW;
      int i;
      if (this.awX == null)
      {
        i = 0;
        if (this.version != null) {
          break label58;
        }
      }
      for (;;)
      {
        return ((i + (k + 527) * 31) * 31 + j) * 31 + qx();
        i = this.awX.hashCode();
        break;
        label58:
        j = this.version.hashCode();
      }
    }
    
    public b qI()
    {
      this.awW = 0;
      this.awX = "";
      this.version = "";
      this.awy = null;
      this.awJ = -1;
      return this;
    }
    
    public b w(pe parampe)
      throws IOException
    {
      for (;;)
      {
        int i = parampe.qg();
        switch (i)
        {
        default: 
          if (a(parampe, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          i = parampe.qj();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 19: 
          case 20: 
          case 21: 
          case 22: 
            this.awW = i;
          }
          break;
        case 18: 
          this.awX = parampe.readString();
          break;
        case 26: 
          this.version = parampe.readString();
        }
      }
    }
  }
  
  public static final class c
    extends pg<c>
  {
    public long awY;
    public int awZ;
    public int axa;
    public boolean axb;
    public pq.d[] axc;
    public pq.b axd;
    public byte[] axe;
    public byte[] axf;
    public byte[] axg;
    public pq.a axh;
    public String axi;
    public String tag;
    
    public c()
    {
      qJ();
    }
    
    public void a(pf parampf)
      throws IOException
    {
      if (this.awY != 0L) {
        parampf.b(1, this.awY);
      }
      if (!this.tag.equals("")) {
        parampf.b(2, this.tag);
      }
      if ((this.axc != null) && (this.axc.length > 0))
      {
        int i = 0;
        while (i < this.axc.length)
        {
          pq.d locald = this.axc[i];
          if (locald != null) {
            parampf.a(3, locald);
          }
          i += 1;
        }
      }
      if (!Arrays.equals(this.axe, pp.awS)) {
        parampf.a(6, this.axe);
      }
      if (this.axh != null) {
        parampf.a(7, this.axh);
      }
      if (!Arrays.equals(this.axf, pp.awS)) {
        parampf.a(8, this.axf);
      }
      if (this.axd != null) {
        parampf.a(9, this.axd);
      }
      if (this.axb) {
        parampf.b(10, this.axb);
      }
      if (this.awZ != 0) {
        parampf.s(11, this.awZ);
      }
      if (this.axa != 0) {
        parampf.s(12, this.axa);
      }
      if (!Arrays.equals(this.axg, pp.awS)) {
        parampf.a(13, this.axg);
      }
      if (!this.axi.equals("")) {
        parampf.b(14, this.axi);
      }
      super.a(parampf);
    }
    
    protected int c()
    {
      int i = super.c();
      int j = i;
      if (this.awY != 0L) {
        j = i + pf.d(1, this.awY);
      }
      i = j;
      if (!this.tag.equals("")) {
        i = j + pf.j(2, this.tag);
      }
      j = i;
      if (this.axc != null)
      {
        j = i;
        if (this.axc.length > 0)
        {
          j = 0;
          while (j < this.axc.length)
          {
            pq.d locald = this.axc[j];
            int k = i;
            if (locald != null) {
              k = i + pf.c(3, locald);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!Arrays.equals(this.axe, pp.awS)) {
        i = j + pf.b(6, this.axe);
      }
      j = i;
      if (this.axh != null) {
        j = i + pf.c(7, this.axh);
      }
      i = j;
      if (!Arrays.equals(this.axf, pp.awS)) {
        i = j + pf.b(8, this.axf);
      }
      j = i;
      if (this.axd != null) {
        j = i + pf.c(9, this.axd);
      }
      i = j;
      if (this.axb) {
        i = j + pf.c(10, this.axb);
      }
      j = i;
      if (this.awZ != 0) {
        j = i + pf.u(11, this.awZ);
      }
      i = j;
      if (this.axa != 0) {
        i = j + pf.u(12, this.axa);
      }
      j = i;
      if (!Arrays.equals(this.axg, pp.awS)) {
        j = i + pf.b(13, this.axg);
      }
      i = j;
      if (!this.axi.equals("")) {
        i = j + pf.j(14, this.axi);
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
      label126:
      label190:
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
                              } while (!(paramObject instanceof c));
                              paramObject = (c)paramObject;
                              bool1 = bool2;
                            } while (this.awY != ((c)paramObject).awY);
                            if (this.tag != null) {
                              break;
                            }
                            bool1 = bool2;
                          } while (((c)paramObject).tag != null);
                          bool1 = bool2;
                        } while (this.awZ != ((c)paramObject).awZ);
                        bool1 = bool2;
                      } while (this.axa != ((c)paramObject).axa);
                      bool1 = bool2;
                    } while (this.axb != ((c)paramObject).axb);
                    bool1 = bool2;
                  } while (!pk.equals(this.axc, ((c)paramObject).axc));
                  if (this.axd != null) {
                    break label228;
                  }
                  bool1 = bool2;
                } while (((c)paramObject).axd != null);
                bool1 = bool2;
              } while (!Arrays.equals(this.axe, ((c)paramObject).axe));
              bool1 = bool2;
            } while (!Arrays.equals(this.axf, ((c)paramObject).axf));
            bool1 = bool2;
          } while (!Arrays.equals(this.axg, ((c)paramObject).axg));
          if (this.axh != null) {
            break label244;
          }
          bool1 = bool2;
        } while (((c)paramObject).axh != null);
        if (this.axi != null) {
          break label260;
        }
        bool1 = bool2;
      } while (((c)paramObject).axi != null);
      label228:
      label244:
      label260:
      while (this.axi.equals(((c)paramObject).axi))
      {
        return a((pg)paramObject);
        if (this.tag.equals(((c)paramObject).tag)) {
          break;
        }
        return false;
        if (this.axd.equals(((c)paramObject).axd)) {
          break label126;
        }
        return false;
        if (this.axh.equals(((c)paramObject).axh)) {
          break label190;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = (int)(this.awY ^ this.awY >>> 32);
      int i;
      int i2;
      int i3;
      int j;
      label50:
      int i4;
      int k;
      label68:
      int i5;
      int i6;
      int i7;
      int m;
      if (this.tag == null)
      {
        i = 0;
        i2 = this.awZ;
        i3 = this.axa;
        if (!this.axb) {
          break label201;
        }
        j = 1231;
        i4 = pk.hashCode(this.axc);
        if (this.axd != null) {
          break label208;
        }
        k = 0;
        i5 = Arrays.hashCode(this.axe);
        i6 = Arrays.hashCode(this.axf);
        i7 = Arrays.hashCode(this.axg);
        if (this.axh != null) {
          break label219;
        }
        m = 0;
        label105:
        if (this.axi != null) {
          break label231;
        }
      }
      for (;;)
      {
        return ((m + ((((k + ((j + (((i + (i1 + 527) * 31) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31 + n) * 31 + qx();
        i = this.tag.hashCode();
        break;
        label201:
        j = 1237;
        break label50;
        label208:
        k = this.axd.hashCode();
        break label68;
        label219:
        m = this.axh.hashCode();
        break label105;
        label231:
        n = this.axi.hashCode();
      }
    }
    
    public c qJ()
    {
      this.awY = 0L;
      this.tag = "";
      this.awZ = 0;
      this.axa = 0;
      this.axb = false;
      this.axc = pq.d.qK();
      this.axd = null;
      this.axe = pp.awS;
      this.axf = pp.awS;
      this.axg = pp.awS;
      this.axh = null;
      this.axi = "";
      this.awy = null;
      this.awJ = -1;
      return this;
    }
    
    public c x(pe parampe)
      throws IOException
    {
      for (;;)
      {
        int i = parampe.qg();
        switch (i)
        {
        default: 
          if (a(parampe, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.awY = parampe.qi();
          break;
        case 18: 
          this.tag = parampe.readString();
          break;
        case 26: 
          int j = pp.b(parampe, 26);
          if (this.axc == null) {}
          pq.d[] arrayOfd;
          for (i = 0;; i = this.axc.length)
          {
            arrayOfd = new pq.d[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.axc, 0, arrayOfd, 0, i);
              j = i;
            }
            while (j < arrayOfd.length - 1)
            {
              arrayOfd[j] = new pq.d();
              parampe.a(arrayOfd[j]);
              parampe.qg();
              j += 1;
            }
          }
          arrayOfd[j] = new pq.d();
          parampe.a(arrayOfd[j]);
          this.axc = arrayOfd;
          break;
        case 50: 
          this.axe = parampe.readBytes();
          break;
        case 58: 
          if (this.axh == null) {
            this.axh = new pq.a();
          }
          parampe.a(this.axh);
          break;
        case 66: 
          this.axf = parampe.readBytes();
          break;
        case 74: 
          if (this.axd == null) {
            this.axd = new pq.b();
          }
          parampe.a(this.axd);
          break;
        case 80: 
          this.axb = parampe.qk();
          break;
        case 88: 
          this.awZ = parampe.qj();
          break;
        case 96: 
          this.axa = parampe.qj();
          break;
        case 106: 
          this.axg = parampe.readBytes();
          break;
        case 114: 
          this.axi = parampe.readString();
        }
      }
    }
  }
  
  public static final class d
    extends pg<d>
  {
    private static volatile d[] axj;
    public String fv;
    public String value;
    
    public d()
    {
      qL();
    }
    
    public static d[] qK()
    {
      if (axj == null) {}
      synchronized (pk.awI)
      {
        if (axj == null) {
          axj = new d[0];
        }
        return axj;
      }
    }
    
    public void a(pf parampf)
      throws IOException
    {
      if (!this.fv.equals("")) {
        parampf.b(1, this.fv);
      }
      if (!this.value.equals("")) {
        parampf.b(2, this.value);
      }
      super.a(parampf);
    }
    
    protected int c()
    {
      int j = super.c();
      int i = j;
      if (!this.fv.equals("")) {
        i = j + pf.j(1, this.fv);
      }
      j = i;
      if (!this.value.equals("")) {
        j = i + pf.j(2, this.value);
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
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof d));
          paramObject = (d)paramObject;
          if (this.fv != null) {
            break;
          }
          bool1 = bool2;
        } while (((d)paramObject).fv != null);
        if (this.value != null) {
          break label79;
        }
        bool1 = bool2;
      } while (((d)paramObject).value != null);
      label79:
      while (this.value.equals(((d)paramObject).value))
      {
        return a((pg)paramObject);
        if (this.fv.equals(((d)paramObject).fv)) {
          break;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int j = 0;
      int i;
      if (this.fv == null)
      {
        i = 0;
        if (this.value != null) {
          break label48;
        }
      }
      for (;;)
      {
        return ((i + 527) * 31 + j) * 31 + qx();
        i = this.fv.hashCode();
        break;
        label48:
        j = this.value.hashCode();
      }
    }
    
    public d qL()
    {
      this.fv = "";
      this.value = "";
      this.awy = null;
      this.awJ = -1;
      return this;
    }
    
    public d y(pe parampe)
      throws IOException
    {
      for (;;)
      {
        int i = parampe.qg();
        switch (i)
        {
        default: 
          if (a(parampe, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.fv = parampe.readString();
          break;
        case 18: 
          this.value = parampe.readString();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */