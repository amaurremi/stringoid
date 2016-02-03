package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class lx
  extends mb<lx>
{
  public a[] amo;
  
  public lx()
  {
    nq();
  }
  
  public static lx n(byte[] paramArrayOfByte)
    throws me
  {
    return (lx)mf.a(new lx(), paramArrayOfByte);
  }
  
  public void a(ma paramma)
    throws IOException
  {
    if ((this.amo != null) && (this.amo.length > 0))
    {
      int i = 0;
      while (i < this.amo.length)
      {
        a locala = this.amo[i];
        if (locala != null) {
          paramma.a(1, locala);
        }
        i += 1;
      }
    }
    super.a(paramma);
  }
  
  protected int c()
  {
    int i = super.c();
    int k = i;
    if (this.amo != null)
    {
      k = i;
      if (this.amo.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.amo.length) {
            break;
          }
          a locala = this.amo[j];
          k = i;
          if (locala != null) {
            k = i + ma.b(1, locala);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
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
        } while (!(paramObject instanceof lx));
        paramObject = (lx)paramObject;
        bool1 = bool2;
      } while (!md.equals(this.amo, ((lx)paramObject).amo));
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        break label83;
      }
      if (((lx)paramObject).amU == null) {
        break;
      }
      bool1 = bool2;
    } while (!((lx)paramObject).amU.isEmpty());
    return true;
    label83:
    return this.amU.equals(((lx)paramObject).amU);
  }
  
  public int hashCode()
  {
    int j = md.hashCode(this.amo);
    if ((this.amU == null) || (this.amU.isEmpty())) {}
    for (int i = 0;; i = this.amU.hashCode()) {
      return i + (j + 527) * 31;
    }
  }
  
  public lx nq()
  {
    this.amo = a.nr();
    this.amU = null;
    this.amY = -1;
    return this;
  }
  
  public lx q(lz paramlz)
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
      case 10: 
        int j = mi.b(paramlz, 10);
        if (this.amo == null) {}
        a[] arrayOfa;
        for (i = 0;; i = this.amo.length)
        {
          arrayOfa = new a[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amo, 0, arrayOfa, 0, i);
            j = i;
          }
          while (j < arrayOfa.length - 1)
          {
            arrayOfa[j] = new a();
            paramlz.a(arrayOfa[j]);
            paramlz.nw();
            j += 1;
          }
        }
        arrayOfa[j] = new a();
        paramlz.a(arrayOfa[j]);
        this.amo = arrayOfa;
      }
    }
  }
  
  public static final class a
    extends mb<a>
  {
    private static volatile a[] amp;
    public a amq;
    public String name;
    
    public a()
    {
      ns();
    }
    
    public static a[] nr()
    {
      if (amp == null) {}
      synchronized (md.amX)
      {
        if (amp == null) {
          amp = new a[0];
        }
        return amp;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      paramma.b(1, this.name);
      if (this.amq != null) {
        paramma.a(2, this.amq);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int j = super.c() + ma.h(1, this.name);
      int i = j;
      if (this.amq != null) {
        i = j + ma.b(2, this.amq);
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
          if (this.name != null) {
            break;
          }
          bool1 = bool2;
        } while (((a)paramObject).name != null);
        if (this.amq != null) {
          break label115;
        }
        bool1 = bool2;
      } while (((a)paramObject).amq != null);
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
          if (this.name.equals(((a)paramObject).name)) {
            break label41;
          }
          return false;
          label115:
          if (!this.amq.equals(((a)paramObject).amq)) {
            return false;
          }
        }
      }
      return this.amU.equals(((a)paramObject).amU);
    }
    
    public int hashCode()
    {
      int m = 0;
      int i;
      int j;
      if (this.name == null)
      {
        i = 0;
        if (this.amq != null) {
          break label73;
        }
        j = 0;
        label21:
        k = m;
        if (this.amU != null) {
          if (!this.amU.isEmpty()) {
            break label84;
          }
        }
      }
      label73:
      label84:
      for (int k = m;; k = this.amU.hashCode())
      {
        return (j + (i + 527) * 31) * 31 + k;
        i = this.name.hashCode();
        break;
        j = this.amq.hashCode();
        break label21;
      }
    }
    
    public a ns()
    {
      this.name = "";
      this.amq = null;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public a r(lz paramlz)
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
        case 10: 
          this.name = paramlz.readString();
          break;
        case 18: 
          if (this.amq == null) {
            this.amq = new a();
          }
          paramlz.a(this.amq);
        }
      }
    }
    
    public static final class a
      extends mb<a>
    {
      private static volatile a[] amr;
      public a ams;
      public int type;
      
      public a()
      {
        nu();
      }
      
      public static a[] nt()
      {
        if (amr == null) {}
        synchronized (md.amX)
        {
          if (amr == null) {
            amr = new a[0];
          }
          return amr;
        }
      }
      
      public void a(ma paramma)
        throws IOException
      {
        paramma.p(1, this.type);
        if (this.ams != null) {
          paramma.a(2, this.ams);
        }
        super.a(paramma);
      }
      
      protected int c()
      {
        int j = super.c() + ma.r(1, this.type);
        int i = j;
        if (this.ams != null) {
          i = j + ma.b(2, this.ams);
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
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof a));
            paramObject = (a)paramObject;
            bool1 = bool2;
          } while (this.type != ((a)paramObject).type);
          if (this.ams != null) {
            break;
          }
          bool1 = bool2;
        } while (((a)paramObject).ams != null);
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
            if (!this.ams.equals(((a)paramObject).ams)) {
              return false;
            }
          }
        }
        return this.amU.equals(((a)paramObject).amU);
      }
      
      public int hashCode()
      {
        int k = 0;
        int m = this.type;
        int i;
        if (this.ams == null)
        {
          i = 0;
          j = k;
          if (this.amU != null) {
            if (!this.amU.isEmpty()) {
              break label68;
            }
          }
        }
        label68:
        for (int j = k;; j = this.amU.hashCode())
        {
          return (i + (m + 527) * 31) * 31 + j;
          i = this.ams.hashCode();
          break;
        }
      }
      
      public a nu()
      {
        this.type = 1;
        this.ams = null;
        this.amU = null;
        this.amY = -1;
        return this;
      }
      
      public a s(lz paramlz)
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
              this.type = i;
            }
            break;
          case 18: 
            if (this.ams == null) {
              this.ams = new a();
            }
            paramlz.a(this.ams);
          }
        }
      }
      
      public static final class a
        extends mb<a>
      {
        public boolean amA;
        public lx.a[] amB;
        public lx.a.a[] amC;
        public String[] amD;
        public long[] amE;
        public float[] amF;
        public long amG;
        public byte[] amt;
        public String amu;
        public double amv;
        public float amw;
        public long amx;
        public int amy;
        public int amz;
        
        public a()
        {
          nv();
        }
        
        public void a(ma paramma)
          throws IOException
        {
          int j = 0;
          if (!Arrays.equals(this.amt, mi.anh)) {
            paramma.a(1, this.amt);
          }
          if (!this.amu.equals("")) {
            paramma.b(2, this.amu);
          }
          if (Double.doubleToLongBits(this.amv) != Double.doubleToLongBits(0.0D)) {
            paramma.a(3, this.amv);
          }
          if (Float.floatToIntBits(this.amw) != Float.floatToIntBits(0.0F)) {
            paramma.b(4, this.amw);
          }
          if (this.amx != 0L) {
            paramma.b(5, this.amx);
          }
          if (this.amy != 0) {
            paramma.p(6, this.amy);
          }
          if (this.amz != 0) {
            paramma.q(7, this.amz);
          }
          if (this.amA) {
            paramma.a(8, this.amA);
          }
          int i;
          Object localObject;
          if ((this.amB != null) && (this.amB.length > 0))
          {
            i = 0;
            while (i < this.amB.length)
            {
              localObject = this.amB[i];
              if (localObject != null) {
                paramma.a(9, (mf)localObject);
              }
              i += 1;
            }
          }
          if ((this.amC != null) && (this.amC.length > 0))
          {
            i = 0;
            while (i < this.amC.length)
            {
              localObject = this.amC[i];
              if (localObject != null) {
                paramma.a(10, (mf)localObject);
              }
              i += 1;
            }
          }
          if ((this.amD != null) && (this.amD.length > 0))
          {
            i = 0;
            while (i < this.amD.length)
            {
              localObject = this.amD[i];
              if (localObject != null) {
                paramma.b(11, (String)localObject);
              }
              i += 1;
            }
          }
          if ((this.amE != null) && (this.amE.length > 0))
          {
            i = 0;
            while (i < this.amE.length)
            {
              paramma.b(12, this.amE[i]);
              i += 1;
            }
          }
          if (this.amG != 0L) {
            paramma.b(13, this.amG);
          }
          if ((this.amF != null) && (this.amF.length > 0))
          {
            i = j;
            while (i < this.amF.length)
            {
              paramma.b(14, this.amF[i]);
              i += 1;
            }
          }
          super.a(paramma);
        }
        
        protected int c()
        {
          int i2 = 0;
          int j = super.c();
          int i = j;
          if (!Arrays.equals(this.amt, mi.anh)) {
            i = j + ma.b(1, this.amt);
          }
          j = i;
          if (!this.amu.equals("")) {
            j = i + ma.h(2, this.amu);
          }
          i = j;
          if (Double.doubleToLongBits(this.amv) != Double.doubleToLongBits(0.0D)) {
            i = j + ma.b(3, this.amv);
          }
          j = i;
          if (Float.floatToIntBits(this.amw) != Float.floatToIntBits(0.0F)) {
            j = i + ma.c(4, this.amw);
          }
          i = j;
          if (this.amx != 0L) {
            i = j + ma.d(5, this.amx);
          }
          j = i;
          if (this.amy != 0) {
            j = i + ma.r(6, this.amy);
          }
          int k = j;
          if (this.amz != 0) {
            k = j + ma.s(7, this.amz);
          }
          i = k;
          if (this.amA) {
            i = k + ma.b(8, this.amA);
          }
          j = i;
          Object localObject;
          if (this.amB != null)
          {
            j = i;
            if (this.amB.length > 0)
            {
              j = 0;
              while (j < this.amB.length)
              {
                localObject = this.amB[j];
                k = i;
                if (localObject != null) {
                  k = i + ma.b(9, (mf)localObject);
                }
                j += 1;
                i = k;
              }
              j = i;
            }
          }
          i = j;
          if (this.amC != null)
          {
            i = j;
            if (this.amC.length > 0)
            {
              i = j;
              j = 0;
              while (j < this.amC.length)
              {
                localObject = this.amC[j];
                k = i;
                if (localObject != null) {
                  k = i + ma.b(10, (mf)localObject);
                }
                j += 1;
                i = k;
              }
            }
          }
          j = i;
          if (this.amD != null)
          {
            j = i;
            if (this.amD.length > 0)
            {
              j = 0;
              k = 0;
              int n;
              for (int m = 0; j < this.amD.length; m = n)
              {
                localObject = this.amD[j];
                int i1 = k;
                n = m;
                if (localObject != null)
                {
                  n = m + 1;
                  i1 = k + ma.cz((String)localObject);
                }
                j += 1;
                k = i1;
              }
              j = i + k + m * 1;
            }
          }
          i = j;
          if (this.amE != null)
          {
            i = j;
            if (this.amE.length > 0)
            {
              k = 0;
              i = i2;
              while (i < this.amE.length)
              {
                k += ma.D(this.amE[i]);
                i += 1;
              }
              i = j + k + this.amE.length * 1;
            }
          }
          j = i;
          if (this.amG != 0L) {
            j = i + ma.d(13, this.amG);
          }
          i = j;
          if (this.amF != null)
          {
            i = j;
            if (this.amF.length > 0) {
              i = j + this.amF.length * 4 + this.amF.length * 1;
            }
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
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof a));
              paramObject = (a)paramObject;
              bool1 = bool2;
            } while (!Arrays.equals(this.amt, ((a)paramObject).amt));
            if (this.amu != null) {
              break;
            }
            bool1 = bool2;
          } while (((a)paramObject).amu != null);
          while (this.amu.equals(((a)paramObject).amu))
          {
            bool1 = bool2;
            if (Double.doubleToLongBits(this.amv) != Double.doubleToLongBits(((a)paramObject).amv)) {
              break;
            }
            bool1 = bool2;
            if (Float.floatToIntBits(this.amw) != Float.floatToIntBits(((a)paramObject).amw)) {
              break;
            }
            bool1 = bool2;
            if (this.amx != ((a)paramObject).amx) {
              break;
            }
            bool1 = bool2;
            if (this.amy != ((a)paramObject).amy) {
              break;
            }
            bool1 = bool2;
            if (this.amz != ((a)paramObject).amz) {
              break;
            }
            bool1 = bool2;
            if (this.amA != ((a)paramObject).amA) {
              break;
            }
            bool1 = bool2;
            if (!md.equals(this.amB, ((a)paramObject).amB)) {
              break;
            }
            bool1 = bool2;
            if (!md.equals(this.amC, ((a)paramObject).amC)) {
              break;
            }
            bool1 = bool2;
            if (!md.equals(this.amD, ((a)paramObject).amD)) {
              break;
            }
            bool1 = bool2;
            if (!md.equals(this.amE, ((a)paramObject).amE)) {
              break;
            }
            bool1 = bool2;
            if (!md.equals(this.amF, ((a)paramObject).amF)) {
              break;
            }
            bool1 = bool2;
            if (this.amG != ((a)paramObject).amG) {
              break;
            }
            if ((this.amU != null) && (!this.amU.isEmpty())) {
              break label301;
            }
            if (((a)paramObject).amU != null)
            {
              bool1 = bool2;
              if (!((a)paramObject).amU.isEmpty()) {
                break;
              }
            }
            return true;
          }
          return false;
          label301:
          return this.amU.equals(((a)paramObject).amU);
        }
        
        public int hashCode()
        {
          int m = 0;
          int n = Arrays.hashCode(this.amt);
          int i;
          int i1;
          int i2;
          int i3;
          int i4;
          int i5;
          int j;
          label88:
          int i6;
          int i7;
          int i8;
          int i9;
          int i10;
          int i11;
          if (this.amu == null)
          {
            i = 0;
            long l = Double.doubleToLongBits(this.amv);
            i1 = (int)(l ^ l >>> 32);
            i2 = Float.floatToIntBits(this.amw);
            i3 = (int)(this.amx ^ this.amx >>> 32);
            i4 = this.amy;
            i5 = this.amz;
            if (!this.amA) {
              break label272;
            }
            j = 1231;
            i6 = md.hashCode(this.amB);
            i7 = md.hashCode(this.amC);
            i8 = md.hashCode(this.amD);
            i9 = md.hashCode(this.amE);
            i10 = md.hashCode(this.amF);
            i11 = (int)(this.amG ^ this.amG >>> 32);
            k = m;
            if (this.amU != null) {
              if (!this.amU.isEmpty()) {
                break label279;
              }
            }
          }
          label272:
          label279:
          for (int k = m;; k = this.amU.hashCode())
          {
            return (((((((j + ((((((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + k;
            i = this.amu.hashCode();
            break;
            j = 1237;
            break label88;
          }
        }
        
        public a nv()
        {
          this.amt = mi.anh;
          this.amu = "";
          this.amv = 0.0D;
          this.amw = 0.0F;
          this.amx = 0L;
          this.amy = 0;
          this.amz = 0;
          this.amA = false;
          this.amB = lx.a.nr();
          this.amC = lx.a.a.nt();
          this.amD = mi.anf;
          this.amE = mi.anb;
          this.amF = mi.anc;
          this.amG = 0L;
          this.amU = null;
          this.amY = -1;
          return this;
        }
        
        public a t(lz paramlz)
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
            case 10: 
              this.amt = paramlz.readBytes();
              break;
            case 18: 
              this.amu = paramlz.readString();
              break;
            case 25: 
              this.amv = paramlz.readDouble();
              break;
            case 37: 
              this.amw = paramlz.readFloat();
              break;
            case 40: 
              this.amx = paramlz.ny();
              break;
            case 48: 
              this.amy = paramlz.nz();
              break;
            case 56: 
              this.amz = paramlz.nB();
              break;
            case 64: 
              this.amA = paramlz.nA();
              break;
            case 74: 
              j = mi.b(paramlz, 74);
              if (this.amB == null) {}
              for (i = 0;; i = this.amB.length)
              {
                localObject = new lx.a[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.amB, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new lx.a();
                  paramlz.a(localObject[j]);
                  paramlz.nw();
                  j += 1;
                }
              }
              localObject[j] = new lx.a();
              paramlz.a(localObject[j]);
              this.amB = ((lx.a[])localObject);
              break;
            case 82: 
              j = mi.b(paramlz, 82);
              if (this.amC == null) {}
              for (i = 0;; i = this.amC.length)
              {
                localObject = new lx.a.a[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.amC, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new lx.a.a();
                  paramlz.a(localObject[j]);
                  paramlz.nw();
                  j += 1;
                }
              }
              localObject[j] = new lx.a.a();
              paramlz.a(localObject[j]);
              this.amC = ((lx.a.a[])localObject);
              break;
            case 90: 
              j = mi.b(paramlz, 90);
              if (this.amD == null) {}
              for (i = 0;; i = this.amD.length)
              {
                localObject = new String[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.amD, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramlz.readString();
                  paramlz.nw();
                  j += 1;
                }
              }
              localObject[j] = paramlz.readString();
              this.amD = ((String[])localObject);
              break;
            case 96: 
              j = mi.b(paramlz, 96);
              if (this.amE == null) {}
              for (i = 0;; i = this.amE.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.amE, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramlz.ny();
                  paramlz.nw();
                  j += 1;
                }
              }
              localObject[j] = paramlz.ny();
              this.amE = ((long[])localObject);
              break;
            case 98: 
              k = paramlz.ex(paramlz.nD());
              i = paramlz.getPosition();
              j = 0;
              while (paramlz.nI() > 0)
              {
                paramlz.ny();
                j += 1;
              }
              paramlz.ez(i);
              if (this.amE == null) {}
              for (i = 0;; i = this.amE.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.amE, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramlz.ny();
                  j += 1;
                }
              }
              this.amE = ((long[])localObject);
              paramlz.ey(k);
              break;
            case 104: 
              this.amG = paramlz.ny();
              break;
            case 117: 
              j = mi.b(paramlz, 117);
              if (this.amF == null) {}
              for (i = 0;; i = this.amF.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.amF, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramlz.readFloat();
                  paramlz.nw();
                  j += 1;
                }
              }
              localObject[j] = paramlz.readFloat();
              this.amF = ((float[])localObject);
              break;
            case 114: 
              i = paramlz.nD();
              k = paramlz.ex(i);
              j = i / 4;
              if (this.amF == null) {}
              for (i = 0;; i = this.amF.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.amF, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramlz.readFloat();
                  j += 1;
                }
              }
              this.amF = ((float[])localObject);
              paramlz.ey(k);
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/lx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */