package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class pc
  extends pg<pc>
{
  public a[] avS;
  
  public pc()
  {
    qa();
  }
  
  public static pc n(byte[] paramArrayOfByte)
    throws pl
  {
    return (pc)pm.a(new pc(), paramArrayOfByte);
  }
  
  public void a(pf parampf)
    throws IOException
  {
    if ((this.avS != null) && (this.avS.length > 0))
    {
      int i = 0;
      while (i < this.avS.length)
      {
        a locala = this.avS[i];
        if (locala != null) {
          parampf.a(1, locala);
        }
        i += 1;
      }
    }
    super.a(parampf);
  }
  
  protected int c()
  {
    int i = super.c();
    int k = i;
    if (this.avS != null)
    {
      k = i;
      if (this.avS.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.avS.length) {
            break;
          }
          a locala = this.avS[j];
          k = i;
          if (locala != null) {
            k = i + pf.c(1, locala);
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
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof pc));
      paramObject = (pc)paramObject;
      bool1 = bool2;
    } while (!pk.equals(this.avS, ((pc)paramObject).avS));
    return a((pg)paramObject);
  }
  
  public int hashCode()
  {
    return (pk.hashCode(this.avS) + 527) * 31 + qx();
  }
  
  public pc q(pe parampe)
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
        int j = pp.b(parampe, 10);
        if (this.avS == null) {}
        a[] arrayOfa;
        for (i = 0;; i = this.avS.length)
        {
          arrayOfa = new a[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.avS, 0, arrayOfa, 0, i);
            j = i;
          }
          while (j < arrayOfa.length - 1)
          {
            arrayOfa[j] = new a();
            parampe.a(arrayOfa[j]);
            parampe.qg();
            j += 1;
          }
        }
        arrayOfa[j] = new a();
        parampe.a(arrayOfa[j]);
        this.avS = arrayOfa;
      }
    }
  }
  
  public pc qa()
  {
    this.avS = a.qb();
    this.awy = null;
    this.awJ = -1;
    return this;
  }
  
  public static final class a
    extends pg<a>
  {
    private static volatile a[] avT;
    public a avU;
    public String name;
    
    public a()
    {
      qc();
    }
    
    public static a[] qb()
    {
      if (avT == null) {}
      synchronized (pk.awI)
      {
        if (avT == null) {
          avT = new a[0];
        }
        return avT;
      }
    }
    
    public void a(pf parampf)
      throws IOException
    {
      parampf.b(1, this.name);
      if (this.avU != null) {
        parampf.a(2, this.avU);
      }
      super.a(parampf);
    }
    
    protected int c()
    {
      int j = super.c() + pf.j(1, this.name);
      int i = j;
      if (this.avU != null) {
        i = j + pf.c(2, this.avU);
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
          if (this.name != null) {
            break;
          }
          bool1 = bool2;
        } while (((a)paramObject).name != null);
        if (this.avU != null) {
          break label79;
        }
        bool1 = bool2;
      } while (((a)paramObject).avU != null);
      label79:
      while (this.avU.equals(((a)paramObject).avU))
      {
        return a((pg)paramObject);
        if (this.name.equals(((a)paramObject).name)) {
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
      if (this.name == null)
      {
        i = 0;
        if (this.avU != null) {
          break label48;
        }
      }
      for (;;)
      {
        return ((i + 527) * 31 + j) * 31 + qx();
        i = this.name.hashCode();
        break;
        label48:
        j = this.avU.hashCode();
      }
    }
    
    public a qc()
    {
      this.name = "";
      this.avU = null;
      this.awy = null;
      this.awJ = -1;
      return this;
    }
    
    public a r(pe parampe)
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
          this.name = parampe.readString();
          break;
        case 18: 
          if (this.avU == null) {
            this.avU = new a();
          }
          parampe.a(this.avU);
        }
      }
    }
    
    public static final class a
      extends pg<a>
    {
      private static volatile a[] avV;
      public a avW;
      public int type;
      
      public a()
      {
        qe();
      }
      
      public static a[] qd()
      {
        if (avV == null) {}
        synchronized (pk.awI)
        {
          if (avV == null) {
            avV = new a[0];
          }
          return avV;
        }
      }
      
      public void a(pf parampf)
        throws IOException
      {
        parampf.s(1, this.type);
        if (this.avW != null) {
          parampf.a(2, this.avW);
        }
        super.a(parampf);
      }
      
      protected int c()
      {
        int j = super.c() + pf.u(1, this.type);
        int i = j;
        if (this.avW != null) {
          i = j + pf.c(2, this.avW);
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
          if (this.avW != null) {
            break;
          }
          bool1 = bool2;
        } while (((a)paramObject).avW != null);
        while (this.avW.equals(((a)paramObject).avW)) {
          return a((pg)paramObject);
        }
        return false;
      }
      
      public int hashCode()
      {
        int j = this.type;
        if (this.avW == null) {}
        for (int i = 0;; i = this.avW.hashCode()) {
          return (i + (j + 527) * 31) * 31 + qx();
        }
      }
      
      public a qe()
      {
        this.type = 1;
        this.avW = null;
        this.awy = null;
        this.awJ = -1;
        return this;
      }
      
      public a s(pe parampe)
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
            if (this.avW == null) {
              this.avW = new a();
            }
            parampe.a(this.avW);
          }
        }
      }
      
      public static final class a
        extends pg<a>
      {
        public byte[] avX;
        public String avY;
        public double avZ;
        public float awa;
        public long awb;
        public int awc;
        public int awd;
        public boolean awe;
        public pc.a[] awf;
        public pc.a.a[] awg;
        public String[] awh;
        public long[] awi;
        public float[] awj;
        public long awk;
        
        public a()
        {
          qf();
        }
        
        public void a(pf parampf)
          throws IOException
        {
          int j = 0;
          if (!Arrays.equals(this.avX, pp.awS)) {
            parampf.a(1, this.avX);
          }
          if (!this.avY.equals("")) {
            parampf.b(2, this.avY);
          }
          if (Double.doubleToLongBits(this.avZ) != Double.doubleToLongBits(0.0D)) {
            parampf.a(3, this.avZ);
          }
          if (Float.floatToIntBits(this.awa) != Float.floatToIntBits(0.0F)) {
            parampf.b(4, this.awa);
          }
          if (this.awb != 0L) {
            parampf.b(5, this.awb);
          }
          if (this.awc != 0) {
            parampf.s(6, this.awc);
          }
          if (this.awd != 0) {
            parampf.t(7, this.awd);
          }
          if (this.awe) {
            parampf.b(8, this.awe);
          }
          int i;
          Object localObject;
          if ((this.awf != null) && (this.awf.length > 0))
          {
            i = 0;
            while (i < this.awf.length)
            {
              localObject = this.awf[i];
              if (localObject != null) {
                parampf.a(9, (pm)localObject);
              }
              i += 1;
            }
          }
          if ((this.awg != null) && (this.awg.length > 0))
          {
            i = 0;
            while (i < this.awg.length)
            {
              localObject = this.awg[i];
              if (localObject != null) {
                parampf.a(10, (pm)localObject);
              }
              i += 1;
            }
          }
          if ((this.awh != null) && (this.awh.length > 0))
          {
            i = 0;
            while (i < this.awh.length)
            {
              localObject = this.awh[i];
              if (localObject != null) {
                parampf.b(11, (String)localObject);
              }
              i += 1;
            }
          }
          if ((this.awi != null) && (this.awi.length > 0))
          {
            i = 0;
            while (i < this.awi.length)
            {
              parampf.b(12, this.awi[i]);
              i += 1;
            }
          }
          if (this.awk != 0L) {
            parampf.b(13, this.awk);
          }
          if ((this.awj != null) && (this.awj.length > 0))
          {
            i = j;
            while (i < this.awj.length)
            {
              parampf.b(14, this.awj[i]);
              i += 1;
            }
          }
          super.a(parampf);
        }
        
        protected int c()
        {
          int i2 = 0;
          int j = super.c();
          int i = j;
          if (!Arrays.equals(this.avX, pp.awS)) {
            i = j + pf.b(1, this.avX);
          }
          j = i;
          if (!this.avY.equals("")) {
            j = i + pf.j(2, this.avY);
          }
          i = j;
          if (Double.doubleToLongBits(this.avZ) != Double.doubleToLongBits(0.0D)) {
            i = j + pf.b(3, this.avZ);
          }
          j = i;
          if (Float.floatToIntBits(this.awa) != Float.floatToIntBits(0.0F)) {
            j = i + pf.c(4, this.awa);
          }
          i = j;
          if (this.awb != 0L) {
            i = j + pf.d(5, this.awb);
          }
          j = i;
          if (this.awc != 0) {
            j = i + pf.u(6, this.awc);
          }
          int k = j;
          if (this.awd != 0) {
            k = j + pf.v(7, this.awd);
          }
          i = k;
          if (this.awe) {
            i = k + pf.c(8, this.awe);
          }
          j = i;
          Object localObject;
          if (this.awf != null)
          {
            j = i;
            if (this.awf.length > 0)
            {
              j = 0;
              while (j < this.awf.length)
              {
                localObject = this.awf[j];
                k = i;
                if (localObject != null) {
                  k = i + pf.c(9, (pm)localObject);
                }
                j += 1;
                i = k;
              }
              j = i;
            }
          }
          i = j;
          if (this.awg != null)
          {
            i = j;
            if (this.awg.length > 0)
            {
              i = j;
              j = 0;
              while (j < this.awg.length)
              {
                localObject = this.awg[j];
                k = i;
                if (localObject != null) {
                  k = i + pf.c(10, (pm)localObject);
                }
                j += 1;
                i = k;
              }
            }
          }
          j = i;
          if (this.awh != null)
          {
            j = i;
            if (this.awh.length > 0)
            {
              j = 0;
              k = 0;
              int n;
              for (int m = 0; j < this.awh.length; m = n)
              {
                localObject = this.awh[j];
                int i1 = k;
                n = m;
                if (localObject != null)
                {
                  n = m + 1;
                  i1 = k + pf.df((String)localObject);
                }
                j += 1;
                k = i1;
              }
              j = i + k + m * 1;
            }
          }
          i = j;
          if (this.awi != null)
          {
            i = j;
            if (this.awi.length > 0)
            {
              k = 0;
              i = i2;
              while (i < this.awi.length)
              {
                k += pf.D(this.awi[i]);
                i += 1;
              }
              i = j + k + this.awi.length * 1;
            }
          }
          j = i;
          if (this.awk != 0L) {
            j = i + pf.d(13, this.awk);
          }
          i = j;
          if (this.awj != null)
          {
            i = j;
            if (this.awj.length > 0) {
              i = j + this.awj.length * 4 + this.awj.length * 1;
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
            } while (!Arrays.equals(this.avX, ((a)paramObject).avX));
            if (this.avY != null) {
              break;
            }
            bool1 = bool2;
          } while (((a)paramObject).avY != null);
          while (this.avY.equals(((a)paramObject).avY))
          {
            bool1 = bool2;
            if (Double.doubleToLongBits(this.avZ) != Double.doubleToLongBits(((a)paramObject).avZ)) {
              break;
            }
            bool1 = bool2;
            if (Float.floatToIntBits(this.awa) != Float.floatToIntBits(((a)paramObject).awa)) {
              break;
            }
            bool1 = bool2;
            if (this.awb != ((a)paramObject).awb) {
              break;
            }
            bool1 = bool2;
            if (this.awc != ((a)paramObject).awc) {
              break;
            }
            bool1 = bool2;
            if (this.awd != ((a)paramObject).awd) {
              break;
            }
            bool1 = bool2;
            if (this.awe != ((a)paramObject).awe) {
              break;
            }
            bool1 = bool2;
            if (!pk.equals(this.awf, ((a)paramObject).awf)) {
              break;
            }
            bool1 = bool2;
            if (!pk.equals(this.awg, ((a)paramObject).awg)) {
              break;
            }
            bool1 = bool2;
            if (!pk.equals(this.awh, ((a)paramObject).awh)) {
              break;
            }
            bool1 = bool2;
            if (!pk.equals(this.awi, ((a)paramObject).awi)) {
              break;
            }
            bool1 = bool2;
            if (!pk.equals(this.awj, ((a)paramObject).awj)) {
              break;
            }
            bool1 = bool2;
            if (this.awk != ((a)paramObject).awk) {
              break;
            }
            return a((pg)paramObject);
          }
          return false;
        }
        
        public int hashCode()
        {
          int k = Arrays.hashCode(this.avX);
          int i;
          int m;
          int n;
          int i1;
          int i2;
          int i3;
          if (this.avY == null)
          {
            i = 0;
            long l = Double.doubleToLongBits(this.avZ);
            m = (int)(l ^ l >>> 32);
            n = Float.floatToIntBits(this.awa);
            i1 = (int)(this.awb ^ this.awb >>> 32);
            i2 = this.awc;
            i3 = this.awd;
            if (!this.awe) {
              break label221;
            }
          }
          label221:
          for (int j = 1231;; j = 1237)
          {
            return (((((((j + ((((((i + (k + 527) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + pk.hashCode(this.awf)) * 31 + pk.hashCode(this.awg)) * 31 + pk.hashCode(this.awh)) * 31 + pk.hashCode(this.awi)) * 31 + pk.hashCode(this.awj)) * 31 + (int)(this.awk ^ this.awk >>> 32)) * 31 + qx();
            i = this.avY.hashCode();
            break;
          }
        }
        
        public a qf()
        {
          this.avX = pp.awS;
          this.avY = "";
          this.avZ = 0.0D;
          this.awa = 0.0F;
          this.awb = 0L;
          this.awc = 0;
          this.awd = 0;
          this.awe = false;
          this.awf = pc.a.qb();
          this.awg = pc.a.a.qd();
          this.awh = pp.awQ;
          this.awi = pp.awM;
          this.awj = pp.awN;
          this.awk = 0L;
          this.awy = null;
          this.awJ = -1;
          return this;
        }
        
        public a t(pe parampe)
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
            case 10: 
              this.avX = parampe.readBytes();
              break;
            case 18: 
              this.avY = parampe.readString();
              break;
            case 25: 
              this.avZ = parampe.readDouble();
              break;
            case 37: 
              this.awa = parampe.readFloat();
              break;
            case 40: 
              this.awb = parampe.qi();
              break;
            case 48: 
              this.awc = parampe.qj();
              break;
            case 56: 
              this.awd = parampe.ql();
              break;
            case 64: 
              this.awe = parampe.qk();
              break;
            case 74: 
              j = pp.b(parampe, 74);
              if (this.awf == null) {}
              for (i = 0;; i = this.awf.length)
              {
                localObject = new pc.a[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.awf, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new pc.a();
                  parampe.a(localObject[j]);
                  parampe.qg();
                  j += 1;
                }
              }
              localObject[j] = new pc.a();
              parampe.a(localObject[j]);
              this.awf = ((pc.a[])localObject);
              break;
            case 82: 
              j = pp.b(parampe, 82);
              if (this.awg == null) {}
              for (i = 0;; i = this.awg.length)
              {
                localObject = new pc.a.a[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.awg, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new pc.a.a();
                  parampe.a(localObject[j]);
                  parampe.qg();
                  j += 1;
                }
              }
              localObject[j] = new pc.a.a();
              parampe.a(localObject[j]);
              this.awg = ((pc.a.a[])localObject);
              break;
            case 90: 
              j = pp.b(parampe, 90);
              if (this.awh == null) {}
              for (i = 0;; i = this.awh.length)
              {
                localObject = new String[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.awh, 0, localObject, 0, i);
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
              this.awh = ((String[])localObject);
              break;
            case 96: 
              j = pp.b(parampe, 96);
              if (this.awi == null) {}
              for (i = 0;; i = this.awi.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.awi, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = parampe.qi();
                  parampe.qg();
                  j += 1;
                }
              }
              localObject[j] = parampe.qi();
              this.awi = ((long[])localObject);
              break;
            case 98: 
              k = parampe.go(parampe.qn());
              i = parampe.getPosition();
              j = 0;
              while (parampe.qs() > 0)
              {
                parampe.qi();
                j += 1;
              }
              parampe.gq(i);
              if (this.awi == null) {}
              for (i = 0;; i = this.awi.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.awi, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = parampe.qi();
                  j += 1;
                }
              }
              this.awi = ((long[])localObject);
              parampe.gp(k);
              break;
            case 104: 
              this.awk = parampe.qi();
              break;
            case 117: 
              j = pp.b(parampe, 117);
              if (this.awj == null) {}
              for (i = 0;; i = this.awj.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.awj, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = parampe.readFloat();
                  parampe.qg();
                  j += 1;
                }
              }
              localObject[j] = parampe.readFloat();
              this.awj = ((float[])localObject);
              break;
            case 114: 
              i = parampe.qn();
              k = parampe.go(i);
              j = i / 4;
              if (this.awj == null) {}
              for (i = 0;; i = this.awj.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.awj, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = parampe.readFloat();
                  j += 1;
                }
              }
              this.awj = ((float[])localObject);
              parampe.gp(k);
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */