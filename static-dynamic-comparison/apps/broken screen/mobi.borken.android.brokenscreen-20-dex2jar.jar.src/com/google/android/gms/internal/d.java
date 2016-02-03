package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface d
{
  public static final class a
    extends mb<a>
  {
    private static volatile a[] fM;
    public String fN;
    public a[] fO;
    public a[] fP;
    public a[] fQ;
    public String fR;
    public String fS;
    public long fT;
    public boolean fU;
    public a[] fV;
    public int[] fW;
    public boolean fX;
    public int type;
    
    public a()
    {
      s();
    }
    
    public static a[] r()
    {
      if (fM == null) {}
      synchronized (md.amX)
      {
        if (fM == null) {
          fM = new a[0];
        }
        return fM;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int j = 0;
      paramma.p(1, this.type);
      if (!this.fN.equals("")) {
        paramma.b(2, this.fN);
      }
      int i;
      a locala;
      if ((this.fO != null) && (this.fO.length > 0))
      {
        i = 0;
        while (i < this.fO.length)
        {
          locala = this.fO[i];
          if (locala != null) {
            paramma.a(3, locala);
          }
          i += 1;
        }
      }
      if ((this.fP != null) && (this.fP.length > 0))
      {
        i = 0;
        while (i < this.fP.length)
        {
          locala = this.fP[i];
          if (locala != null) {
            paramma.a(4, locala);
          }
          i += 1;
        }
      }
      if ((this.fQ != null) && (this.fQ.length > 0))
      {
        i = 0;
        while (i < this.fQ.length)
        {
          locala = this.fQ[i];
          if (locala != null) {
            paramma.a(5, locala);
          }
          i += 1;
        }
      }
      if (!this.fR.equals("")) {
        paramma.b(6, this.fR);
      }
      if (!this.fS.equals("")) {
        paramma.b(7, this.fS);
      }
      if (this.fT != 0L) {
        paramma.b(8, this.fT);
      }
      if (this.fX) {
        paramma.a(9, this.fX);
      }
      if ((this.fW != null) && (this.fW.length > 0))
      {
        i = 0;
        while (i < this.fW.length)
        {
          paramma.p(10, this.fW[i]);
          i += 1;
        }
      }
      if ((this.fV != null) && (this.fV.length > 0))
      {
        i = j;
        while (i < this.fV.length)
        {
          locala = this.fV[i];
          if (locala != null) {
            paramma.a(11, locala);
          }
          i += 1;
        }
      }
      if (this.fU) {
        paramma.a(12, this.fU);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int m = 0;
      int j = super.c() + ma.r(1, this.type);
      int i = j;
      if (!this.fN.equals("")) {
        i = j + ma.h(2, this.fN);
      }
      j = i;
      a locala;
      int k;
      if (this.fO != null)
      {
        j = i;
        if (this.fO.length > 0)
        {
          j = 0;
          while (j < this.fO.length)
          {
            locala = this.fO[j];
            k = i;
            if (locala != null) {
              k = i + ma.b(3, locala);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.fP != null)
      {
        i = j;
        if (this.fP.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.fP.length)
          {
            locala = this.fP[j];
            k = i;
            if (locala != null) {
              k = i + ma.b(4, locala);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.fQ != null)
      {
        j = i;
        if (this.fQ.length > 0)
        {
          j = 0;
          while (j < this.fQ.length)
          {
            locala = this.fQ[j];
            k = i;
            if (locala != null) {
              k = i + ma.b(5, locala);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!this.fR.equals("")) {
        i = j + ma.h(6, this.fR);
      }
      j = i;
      if (!this.fS.equals("")) {
        j = i + ma.h(7, this.fS);
      }
      i = j;
      if (this.fT != 0L) {
        i = j + ma.d(8, this.fT);
      }
      j = i;
      if (this.fX) {
        j = i + ma.b(9, this.fX);
      }
      i = j;
      if (this.fW != null)
      {
        i = j;
        if (this.fW.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.fW.length)
          {
            k += ma.eE(this.fW[i]);
            i += 1;
          }
          i = j + k + this.fW.length * 1;
        }
      }
      j = i;
      if (this.fV != null)
      {
        j = i;
        if (this.fV.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.fV.length) {
              break;
            }
            locala = this.fV[k];
            j = i;
            if (locala != null) {
              j = i + ma.b(11, locala);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.fU) {
        i = j + ma.b(12, this.fU);
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
                  if (this.fN != null) {
                    break;
                  }
                  bool1 = bool2;
                } while (((a)paramObject).fN != null);
                bool1 = bool2;
              } while (!md.equals(this.fO, ((a)paramObject).fO));
              bool1 = bool2;
            } while (!md.equals(this.fP, ((a)paramObject).fP));
            bool1 = bool2;
          } while (!md.equals(this.fQ, ((a)paramObject).fQ));
          if (this.fR != null) {
            break label264;
          }
          bool1 = bool2;
        } while (((a)paramObject).fR != null);
        if (this.fS != null) {
          break label280;
        }
        bool1 = bool2;
      } while (((a)paramObject).fS != null);
      label264:
      label280:
      while (this.fS.equals(((a)paramObject).fS))
      {
        bool1 = bool2;
        if (this.fT != ((a)paramObject).fT) {
          break;
        }
        bool1 = bool2;
        if (this.fU != ((a)paramObject).fU) {
          break;
        }
        bool1 = bool2;
        if (!md.equals(this.fV, ((a)paramObject).fV)) {
          break;
        }
        bool1 = bool2;
        if (!md.equals(this.fW, ((a)paramObject).fW)) {
          break;
        }
        bool1 = bool2;
        if (this.fX != ((a)paramObject).fX) {
          break;
        }
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label296;
        }
        if (((a)paramObject).amU != null)
        {
          bool1 = bool2;
          if (!((a)paramObject).amU.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.fN.equals(((a)paramObject).fN)) {
          break label54;
        }
        return false;
        if (this.fR.equals(((a)paramObject).fR)) {
          break label118;
        }
        return false;
      }
      return false;
      label296:
      return this.amU.equals(((a)paramObject).amU);
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
      if (this.fN == null)
      {
        i = 0;
        i4 = md.hashCode(this.fO);
        i5 = md.hashCode(this.fP);
        i6 = md.hashCode(this.fQ);
        if (this.fR != null) {
          break label234;
        }
        j = 0;
        if (this.fS != null) {
          break label245;
        }
        k = 0;
        i7 = (int)(this.fT ^ this.fT >>> 32);
        if (!this.fU) {
          break label256;
        }
        m = 1231;
        i8 = md.hashCode(this.fV);
        i9 = md.hashCode(this.fW);
        if (!this.fX) {
          break label264;
        }
        label120:
        i1 = i2;
        if (this.amU != null) {
          if (!this.amU.isEmpty()) {
            break label272;
          }
        }
      }
      label234:
      label245:
      label256:
      label264:
      label272:
      for (int i1 = i2;; i1 = this.amU.hashCode())
      {
        return ((((m + ((k + (j + ((((i + (i3 + 527) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31) * 31 + i7) * 31) * 31 + i8) * 31 + i9) * 31 + n) * 31 + i1;
        i = this.fN.hashCode();
        break;
        j = this.fR.hashCode();
        break label59;
        k = this.fS.hashCode();
        break label68;
        m = 1237;
        break label95;
        n = 1237;
        break label120;
      }
    }
    
    public a l(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        int j;
        Object localObject;
        int k;
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          i = paramlz.nz();
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
          this.fN = paramlz.readString();
          break;
        case 26: 
          j = mi.b(paramlz, 26);
          if (this.fO == null) {}
          for (i = 0;; i = this.fO.length)
          {
            localObject = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fO, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new a();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new a();
          paramlz.a(localObject[j]);
          this.fO = ((a[])localObject);
          break;
        case 34: 
          j = mi.b(paramlz, 34);
          if (this.fP == null) {}
          for (i = 0;; i = this.fP.length)
          {
            localObject = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fP, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new a();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new a();
          paramlz.a(localObject[j]);
          this.fP = ((a[])localObject);
          break;
        case 42: 
          j = mi.b(paramlz, 42);
          if (this.fQ == null) {}
          for (i = 0;; i = this.fQ.length)
          {
            localObject = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fQ, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new a();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new a();
          paramlz.a(localObject[j]);
          this.fQ = ((a[])localObject);
          break;
        case 50: 
          this.fR = paramlz.readString();
          break;
        case 58: 
          this.fS = paramlz.readString();
          break;
        case 64: 
          this.fT = paramlz.ny();
          break;
        case 72: 
          this.fX = paramlz.nA();
          break;
        case 80: 
          int m = mi.b(paramlz, 80);
          localObject = new int[m];
          j = 0;
          i = 0;
          if (j < m)
          {
            if (j != 0) {
              paramlz.nw();
            }
            int n = paramlz.nz();
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
            if (this.fW == null) {}
            for (j = 0;; j = this.fW.length)
            {
              if ((j != 0) || (i != localObject.length)) {
                break label810;
              }
              this.fW = ((int[])localObject);
              break;
            }
            int[] arrayOfInt = new int[j + i];
            if (j != 0) {
              System.arraycopy(this.fW, 0, arrayOfInt, 0, j);
            }
            System.arraycopy(localObject, 0, arrayOfInt, j, i);
            this.fW = arrayOfInt;
          }
          break;
        case 82: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0) {
            switch (paramlz.nz())
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
            paramlz.ez(i);
            if (this.fW == null) {}
            for (i = 0;; i = this.fW.length)
            {
              localObject = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.fW, 0, localObject, 0, i);
                j = i;
              }
              while (paramlz.nI() > 0)
              {
                i = paramlz.nz();
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
            this.fW = ((int[])localObject);
          }
          paramlz.ey(k);
          break;
        case 90: 
          j = mi.b(paramlz, 90);
          if (this.fV == null) {}
          for (i = 0;; i = this.fV.length)
          {
            localObject = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fV, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new a();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new a();
          paramlz.a(localObject[j]);
          this.fV = ((a[])localObject);
          break;
        case 96: 
          label810:
          this.fU = paramlz.nA();
        }
      }
    }
    
    public a s()
    {
      this.type = 1;
      this.fN = "";
      this.fO = r();
      this.fP = r();
      this.fQ = r();
      this.fR = "";
      this.fS = "";
      this.fT = 0L;
      this.fU = false;
      this.fV = r();
      this.fW = mi.ana;
      this.fX = false;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */