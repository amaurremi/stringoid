package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface d
{
  public static final class a
    extends pg<a>
  {
    private static volatile a[] gu;
    public String gA;
    public long gB;
    public boolean gC;
    public a[] gD;
    public int[] gE;
    public boolean gF;
    public String gv;
    public a[] gw;
    public a[] gx;
    public a[] gy;
    public String gz;
    public int type;
    
    public a()
    {
      s();
    }
    
    public static a[] r()
    {
      if (gu == null) {}
      synchronized (pk.awI)
      {
        if (gu == null) {
          gu = new a[0];
        }
        return gu;
      }
    }
    
    public void a(pf parampf)
      throws IOException
    {
      int j = 0;
      parampf.s(1, this.type);
      if (!this.gv.equals("")) {
        parampf.b(2, this.gv);
      }
      int i;
      a locala;
      if ((this.gw != null) && (this.gw.length > 0))
      {
        i = 0;
        while (i < this.gw.length)
        {
          locala = this.gw[i];
          if (locala != null) {
            parampf.a(3, locala);
          }
          i += 1;
        }
      }
      if ((this.gx != null) && (this.gx.length > 0))
      {
        i = 0;
        while (i < this.gx.length)
        {
          locala = this.gx[i];
          if (locala != null) {
            parampf.a(4, locala);
          }
          i += 1;
        }
      }
      if ((this.gy != null) && (this.gy.length > 0))
      {
        i = 0;
        while (i < this.gy.length)
        {
          locala = this.gy[i];
          if (locala != null) {
            parampf.a(5, locala);
          }
          i += 1;
        }
      }
      if (!this.gz.equals("")) {
        parampf.b(6, this.gz);
      }
      if (!this.gA.equals("")) {
        parampf.b(7, this.gA);
      }
      if (this.gB != 0L) {
        parampf.b(8, this.gB);
      }
      if (this.gF) {
        parampf.b(9, this.gF);
      }
      if ((this.gE != null) && (this.gE.length > 0))
      {
        i = 0;
        while (i < this.gE.length)
        {
          parampf.s(10, this.gE[i]);
          i += 1;
        }
      }
      if ((this.gD != null) && (this.gD.length > 0))
      {
        i = j;
        while (i < this.gD.length)
        {
          locala = this.gD[i];
          if (locala != null) {
            parampf.a(11, locala);
          }
          i += 1;
        }
      }
      if (this.gC) {
        parampf.b(12, this.gC);
      }
      super.a(parampf);
    }
    
    protected int c()
    {
      int m = 0;
      int j = super.c() + pf.u(1, this.type);
      int i = j;
      if (!this.gv.equals("")) {
        i = j + pf.j(2, this.gv);
      }
      j = i;
      a locala;
      int k;
      if (this.gw != null)
      {
        j = i;
        if (this.gw.length > 0)
        {
          j = 0;
          while (j < this.gw.length)
          {
            locala = this.gw[j];
            k = i;
            if (locala != null) {
              k = i + pf.c(3, locala);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.gx != null)
      {
        i = j;
        if (this.gx.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.gx.length)
          {
            locala = this.gx[j];
            k = i;
            if (locala != null) {
              k = i + pf.c(4, locala);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.gy != null)
      {
        j = i;
        if (this.gy.length > 0)
        {
          j = 0;
          while (j < this.gy.length)
          {
            locala = this.gy[j];
            k = i;
            if (locala != null) {
              k = i + pf.c(5, locala);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!this.gz.equals("")) {
        i = j + pf.j(6, this.gz);
      }
      j = i;
      if (!this.gA.equals("")) {
        j = i + pf.j(7, this.gA);
      }
      i = j;
      if (this.gB != 0L) {
        i = j + pf.d(8, this.gB);
      }
      j = i;
      if (this.gF) {
        j = i + pf.c(9, this.gF);
      }
      i = j;
      if (this.gE != null)
      {
        i = j;
        if (this.gE.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.gE.length)
          {
            k += pf.gv(this.gE[i]);
            i += 1;
          }
          i = j + k + this.gE.length * 1;
        }
      }
      j = i;
      if (this.gD != null)
      {
        j = i;
        if (this.gD.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.gD.length) {
              break;
            }
            locala = this.gD[k];
            j = i;
            if (locala != null) {
              j = i + pf.c(11, locala);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.gC) {
        i = j + pf.c(12, this.gC);
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
                  if (this.gv != null) {
                    break;
                  }
                  bool1 = bool2;
                } while (((a)paramObject).gv != null);
                bool1 = bool2;
              } while (!pk.equals(this.gw, ((a)paramObject).gw));
              bool1 = bool2;
            } while (!pk.equals(this.gx, ((a)paramObject).gx));
            bool1 = bool2;
          } while (!pk.equals(this.gy, ((a)paramObject).gy));
          if (this.gz != null) {
            break label228;
          }
          bool1 = bool2;
        } while (((a)paramObject).gz != null);
        if (this.gA != null) {
          break label244;
        }
        bool1 = bool2;
      } while (((a)paramObject).gA != null);
      label228:
      label244:
      while (this.gA.equals(((a)paramObject).gA))
      {
        bool1 = bool2;
        if (this.gB != ((a)paramObject).gB) {
          break;
        }
        bool1 = bool2;
        if (this.gC != ((a)paramObject).gC) {
          break;
        }
        bool1 = bool2;
        if (!pk.equals(this.gD, ((a)paramObject).gD)) {
          break;
        }
        bool1 = bool2;
        if (!pk.equals(this.gE, ((a)paramObject).gE)) {
          break;
        }
        bool1 = bool2;
        if (this.gF != ((a)paramObject).gF) {
          break;
        }
        return a((pg)paramObject);
        if (this.gv.equals(((a)paramObject).gv)) {
          break label54;
        }
        return false;
        if (this.gz.equals(((a)paramObject).gz)) {
          break label118;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int n = 1231;
      int k = 0;
      int i1 = this.type;
      int i;
      int i2;
      int i3;
      int i4;
      int j;
      label58:
      label65:
      int i5;
      int m;
      label92:
      int i6;
      int i7;
      if (this.gv == null)
      {
        i = 0;
        i2 = pk.hashCode(this.gw);
        i3 = pk.hashCode(this.gx);
        i4 = pk.hashCode(this.gy);
        if (this.gz != null) {
          break label206;
        }
        j = 0;
        if (this.gA != null) {
          break label217;
        }
        i5 = (int)(this.gB ^ this.gB >>> 32);
        if (!this.gC) {
          break label228;
        }
        m = 1231;
        i6 = pk.hashCode(this.gD);
        i7 = pk.hashCode(this.gE);
        if (!this.gF) {
          break label236;
        }
      }
      for (;;)
      {
        return ((((m + (((j + ((((i + (i1 + 527) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31 + k) * 31 + i5) * 31) * 31 + i6) * 31 + i7) * 31 + n) * 31 + qx();
        i = this.gv.hashCode();
        break;
        label206:
        j = this.gz.hashCode();
        break label58;
        label217:
        k = this.gA.hashCode();
        break label65;
        label228:
        m = 1237;
        break label92;
        label236:
        n = 1237;
      }
    }
    
    public a l(pe parampe)
      throws IOException
    {
      for (;;)
      {
        int i = parampe.qg();
        int j;
        Object localObject;
        int k;
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
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
            this.type = i;
          }
          break;
        case 18: 
          this.gv = parampe.readString();
          break;
        case 26: 
          j = pp.b(parampe, 26);
          if (this.gw == null) {}
          for (i = 0;; i = this.gw.length)
          {
            localObject = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.gw, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new a();
              parampe.a(localObject[j]);
              parampe.qg();
              j += 1;
            }
          }
          localObject[j] = new a();
          parampe.a(localObject[j]);
          this.gw = ((a[])localObject);
          break;
        case 34: 
          j = pp.b(parampe, 34);
          if (this.gx == null) {}
          for (i = 0;; i = this.gx.length)
          {
            localObject = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.gx, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new a();
              parampe.a(localObject[j]);
              parampe.qg();
              j += 1;
            }
          }
          localObject[j] = new a();
          parampe.a(localObject[j]);
          this.gx = ((a[])localObject);
          break;
        case 42: 
          j = pp.b(parampe, 42);
          if (this.gy == null) {}
          for (i = 0;; i = this.gy.length)
          {
            localObject = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.gy, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new a();
              parampe.a(localObject[j]);
              parampe.qg();
              j += 1;
            }
          }
          localObject[j] = new a();
          parampe.a(localObject[j]);
          this.gy = ((a[])localObject);
          break;
        case 50: 
          this.gz = parampe.readString();
          break;
        case 58: 
          this.gA = parampe.readString();
          break;
        case 64: 
          this.gB = parampe.qi();
          break;
        case 72: 
          this.gF = parampe.qk();
          break;
        case 80: 
          int m = pp.b(parampe, 80);
          localObject = new int[m];
          j = 0;
          i = 0;
          if (j < m)
          {
            if (j != 0) {
              parampe.qg();
            }
            int n = parampe.qj();
            switch (n)
            {
            }
            for (;;)
            {
              j += 1;
              break;
              k = i + 1;
              localObject[i] = n;
              i = k;
            }
          }
          if (i != 0)
          {
            if (this.gE == null) {}
            for (j = 0;; j = this.gE.length)
            {
              if ((j != 0) || (i != localObject.length)) {
                break label810;
              }
              this.gE = ((int[])localObject);
              break;
            }
            int[] arrayOfInt = new int[j + i];
            if (j != 0) {
              System.arraycopy(this.gE, 0, arrayOfInt, 0, j);
            }
            System.arraycopy(localObject, 0, arrayOfInt, j, i);
            this.gE = arrayOfInt;
          }
          break;
        case 82: 
          k = parampe.go(parampe.qn());
          i = parampe.getPosition();
          j = 0;
          while (parampe.qs() > 0) {
            switch (parampe.qj())
            {
            default: 
              break;
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
              j += 1;
            }
          }
          if (j != 0)
          {
            parampe.gq(i);
            if (this.gE == null) {}
            for (i = 0;; i = this.gE.length)
            {
              localObject = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.gE, 0, localObject, 0, i);
                j = i;
              }
              while (parampe.qs() > 0)
              {
                i = parampe.qj();
                switch (i)
                {
                default: 
                  break;
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
                  localObject[j] = i;
                  j += 1;
                }
              }
            }
            this.gE = ((int[])localObject);
          }
          parampe.gp(k);
          break;
        case 90: 
          j = pp.b(parampe, 90);
          if (this.gD == null) {}
          for (i = 0;; i = this.gD.length)
          {
            localObject = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.gD, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new a();
              parampe.a(localObject[j]);
              parampe.qg();
              j += 1;
            }
          }
          localObject[j] = new a();
          parampe.a(localObject[j]);
          this.gD = ((a[])localObject);
          break;
        case 96: 
          label810:
          this.gC = parampe.qk();
        }
      }
    }
    
    public a s()
    {
      this.type = 1;
      this.gv = "";
      this.gw = r();
      this.gx = r();
      this.gy = r();
      this.gz = "";
      this.gA = "";
      this.gB = 0L;
      this.gC = false;
      this.gD = r();
      this.gE = pp.awL;
      this.gF = false;
      this.awy = null;
      this.awJ = -1;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */