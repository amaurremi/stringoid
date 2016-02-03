package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface c
{
  public static final class a
    extends mb<a>
  {
    public int eE;
    public int eF;
    public int level;
    
    public a()
    {
      b();
    }
    
    public a a(lz paramlz)
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
            this.level = i;
          }
          break;
        case 16: 
          this.eE = paramlz.nz();
          break;
        case 24: 
          this.eF = paramlz.nz();
        }
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if (this.level != 1) {
        paramma.p(1, this.level);
      }
      if (this.eE != 0) {
        paramma.p(2, this.eE);
      }
      if (this.eF != 0) {
        paramma.p(3, this.eF);
      }
      super.a(paramma);
    }
    
    public a b()
    {
      this.level = 1;
      this.eE = 0;
      this.eF = 0;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    protected int c()
    {
      int j = super.c();
      int i = j;
      if (this.level != 1) {
        i = j + ma.r(1, this.level);
      }
      j = i;
      if (this.eE != 0) {
        j = i + ma.r(2, this.eE);
      }
      i = j;
      if (this.eF != 0) {
        i = j + ma.r(3, this.eF);
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
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof a));
              paramObject = (a)paramObject;
              bool1 = bool2;
            } while (this.level != ((a)paramObject).level);
            bool1 = bool2;
          } while (this.eE != ((a)paramObject).eE);
          bool1 = bool2;
        } while (this.eF != ((a)paramObject).eF);
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label106;
        }
        if (((a)paramObject).amU == null) {
          break;
        }
        bool1 = bool2;
      } while (!((a)paramObject).amU.isEmpty());
      return true;
      label106:
      return this.amU.equals(((a)paramObject).amU);
    }
    
    public int hashCode()
    {
      int j = this.level;
      int k = this.eE;
      int m = this.eF;
      if ((this.amU == null) || (this.amU.isEmpty())) {}
      for (int i = 0;; i = this.amU.hashCode()) {
        return i + (((j + 527) * 31 + k) * 31 + m) * 31;
      }
    }
  }
  
  public static final class b
    extends mb<b>
  {
    private static volatile b[] eG;
    public int[] eH;
    public int eI;
    public boolean eJ;
    public boolean eK;
    public int name;
    
    public b()
    {
      e();
    }
    
    public static b[] d()
    {
      if (eG == null) {}
      synchronized (md.amX)
      {
        if (eG == null) {
          eG = new b[0];
        }
        return eG;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if (this.eK) {
        paramma.a(1, this.eK);
      }
      paramma.p(2, this.eI);
      if ((this.eH != null) && (this.eH.length > 0))
      {
        int i = 0;
        while (i < this.eH.length)
        {
          paramma.p(3, this.eH[i]);
          i += 1;
        }
      }
      if (this.name != 0) {
        paramma.p(4, this.name);
      }
      if (this.eJ) {
        paramma.a(6, this.eJ);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int j = 0;
      int k = super.c();
      int i = k;
      if (this.eK) {
        i = k + ma.b(1, this.eK);
      }
      k = ma.r(2, this.eI) + i;
      if ((this.eH != null) && (this.eH.length > 0))
      {
        i = 0;
        while (i < this.eH.length)
        {
          j += ma.eE(this.eH[i]);
          i += 1;
        }
      }
      for (j = k + j + this.eH.length * 1;; j = k)
      {
        i = j;
        if (this.name != 0) {
          i = j + ma.r(4, this.name);
        }
        j = i;
        if (this.eJ) {
          j = i + ma.b(6, this.eJ);
        }
        return j;
      }
    }
    
    public b c(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        int j;
        int[] arrayOfInt;
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.eK = paramlz.nA();
          break;
        case 16: 
          this.eI = paramlz.nz();
          break;
        case 24: 
          j = mi.b(paramlz, 24);
          if (this.eH == null) {}
          for (i = 0;; i = this.eH.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eH, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.eH = arrayOfInt;
          break;
        case 26: 
          int k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.eH == null) {}
          for (i = 0;; i = this.eH.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eH, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.eH = arrayOfInt;
          paramlz.ey(k);
          break;
        case 32: 
          this.name = paramlz.nz();
          break;
        case 48: 
          this.eJ = paramlz.nA();
        }
      }
    }
    
    public b e()
    {
      this.eH = mi.ana;
      this.eI = 0;
      this.name = 0;
      this.eJ = false;
      this.eK = false;
      this.amU = null;
      this.amY = -1;
      return this;
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
                } while (!md.equals(this.eH, ((b)paramObject).eH));
                bool1 = bool2;
              } while (this.eI != ((b)paramObject).eI);
              bool1 = bool2;
            } while (this.name != ((b)paramObject).name);
            bool1 = bool2;
          } while (this.eJ != ((b)paramObject).eJ);
          bool1 = bool2;
        } while (this.eK != ((b)paramObject).eK);
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label135;
        }
        if (((b)paramObject).amU == null) {
          break;
        }
        bool1 = bool2;
      } while (!((b)paramObject).amU.isEmpty());
      return true;
      label135:
      return this.amU.equals(((b)paramObject).amU);
    }
    
    public int hashCode()
    {
      int j = 1231;
      int m = md.hashCode(this.eH);
      int n = this.eI;
      int i1 = this.name;
      int i;
      if (this.eJ)
      {
        i = 1231;
        if (!this.eK) {
          break label105;
        }
        label43:
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label112;
        }
      }
      label105:
      label112:
      for (int k = 0;; k = this.amU.hashCode())
      {
        return k + ((i + (((m + 527) * 31 + n) * 31 + i1) * 31) * 31 + j) * 31;
        i = 1237;
        break;
        j = 1237;
        break label43;
      }
    }
  }
  
  public static final class c
    extends mb<c>
  {
    private static volatile c[] eL;
    public String eM;
    public long eN;
    public long eO;
    public boolean eP;
    public long eQ;
    
    public c()
    {
      g();
    }
    
    public static c[] f()
    {
      if (eL == null) {}
      synchronized (md.amX)
      {
        if (eL == null) {
          eL = new c[0];
        }
        return eL;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if (!this.eM.equals("")) {
        paramma.b(1, this.eM);
      }
      if (this.eN != 0L) {
        paramma.b(2, this.eN);
      }
      if (this.eO != 2147483647L) {
        paramma.b(3, this.eO);
      }
      if (this.eP) {
        paramma.a(4, this.eP);
      }
      if (this.eQ != 0L) {
        paramma.b(5, this.eQ);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int j = super.c();
      int i = j;
      if (!this.eM.equals("")) {
        i = j + ma.h(1, this.eM);
      }
      j = i;
      if (this.eN != 0L) {
        j = i + ma.d(2, this.eN);
      }
      i = j;
      if (this.eO != 2147483647L) {
        i = j + ma.d(3, this.eO);
      }
      j = i;
      if (this.eP) {
        j = i + ma.b(4, this.eP);
      }
      i = j;
      if (this.eQ != 0L) {
        i = j + ma.d(5, this.eQ);
      }
      return i;
    }
    
    public c d(lz paramlz)
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
          this.eM = paramlz.readString();
          break;
        case 16: 
          this.eN = paramlz.ny();
          break;
        case 24: 
          this.eO = paramlz.ny();
          break;
        case 32: 
          this.eP = paramlz.nA();
          break;
        case 40: 
          this.eQ = paramlz.ny();
        }
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
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof c));
        paramObject = (c)paramObject;
        if (this.eM != null) {
          break;
        }
        bool1 = bool2;
      } while (((c)paramObject).eM != null);
      while (this.eM.equals(((c)paramObject).eM))
      {
        bool1 = bool2;
        if (this.eN != ((c)paramObject).eN) {
          break;
        }
        bool1 = bool2;
        if (this.eO != ((c)paramObject).eO) {
          break;
        }
        bool1 = bool2;
        if (this.eP != ((c)paramObject).eP) {
          break;
        }
        bool1 = bool2;
        if (this.eQ != ((c)paramObject).eQ) {
          break;
        }
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label154;
        }
        if (((c)paramObject).amU != null)
        {
          bool1 = bool2;
          if (!((c)paramObject).amU.isEmpty()) {
            break;
          }
        }
        return true;
      }
      return false;
      label154:
      return this.amU.equals(((c)paramObject).amU);
    }
    
    public c g()
    {
      this.eM = "";
      this.eN = 0L;
      this.eO = 2147483647L;
      this.eP = false;
      this.eQ = 0L;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public int hashCode()
    {
      int m = 0;
      int i;
      int n;
      int i1;
      int j;
      label53:
      int i2;
      if (this.eM == null)
      {
        i = 0;
        n = (int)(this.eN ^ this.eN >>> 32);
        i1 = (int)(this.eO ^ this.eO >>> 32);
        if (!this.eP) {
          break label138;
        }
        j = 1231;
        i2 = (int)(this.eQ ^ this.eQ >>> 32);
        k = m;
        if (this.amU != null) {
          if (!this.amU.isEmpty()) {
            break label145;
          }
        }
      }
      label138:
      label145:
      for (int k = m;; k = this.amU.hashCode())
      {
        return ((j + (((i + 527) * 31 + n) * 31 + i1) * 31) * 31 + i2) * 31 + k;
        i = this.eM.hashCode();
        break;
        j = 1237;
        break label53;
      }
    }
  }
  
  public static final class d
    extends mb<d>
  {
    public d.a[] eR;
    public d.a[] eS;
    public c.c[] eT;
    
    public d()
    {
      h();
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.eR != null) && (this.eR.length > 0))
      {
        i = 0;
        while (i < this.eR.length)
        {
          localObject = this.eR[i];
          if (localObject != null) {
            paramma.a(1, (mf)localObject);
          }
          i += 1;
        }
      }
      if ((this.eS != null) && (this.eS.length > 0))
      {
        i = 0;
        while (i < this.eS.length)
        {
          localObject = this.eS[i];
          if (localObject != null) {
            paramma.a(2, (mf)localObject);
          }
          i += 1;
        }
      }
      if ((this.eT != null) && (this.eT.length > 0))
      {
        i = j;
        while (i < this.eT.length)
        {
          localObject = this.eT[i];
          if (localObject != null) {
            paramma.a(3, (mf)localObject);
          }
          i += 1;
        }
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int m = 0;
      int i = super.c();
      int j = i;
      Object localObject;
      if (this.eR != null)
      {
        j = i;
        if (this.eR.length > 0)
        {
          j = 0;
          while (j < this.eR.length)
          {
            localObject = this.eR[j];
            k = i;
            if (localObject != null) {
              k = i + ma.b(1, (mf)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.eS != null)
      {
        i = j;
        if (this.eS.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.eS.length)
          {
            localObject = this.eS[j];
            k = i;
            if (localObject != null) {
              k = i + ma.b(2, (mf)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      int k = i;
      if (this.eT != null)
      {
        k = i;
        if (this.eT.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.eT.length) {
              break;
            }
            localObject = this.eT[j];
            k = i;
            if (localObject != null) {
              k = i + ma.b(3, (mf)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
    
    public d e(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = mi.b(paramlz, 10);
          if (this.eR == null) {}
          for (i = 0;; i = this.eR.length)
          {
            localObject = new d.a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eR, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new d.a();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new d.a();
          paramlz.a(localObject[j]);
          this.eR = ((d.a[])localObject);
          break;
        case 18: 
          j = mi.b(paramlz, 18);
          if (this.eS == null) {}
          for (i = 0;; i = this.eS.length)
          {
            localObject = new d.a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eS, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new d.a();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new d.a();
          paramlz.a(localObject[j]);
          this.eS = ((d.a[])localObject);
          break;
        case 26: 
          j = mi.b(paramlz, 26);
          if (this.eT == null) {}
          for (i = 0;; i = this.eT.length)
          {
            localObject = new c.c[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eT, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new c.c();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new c.c();
          paramlz.a(localObject[j]);
          this.eT = ((c.c[])localObject);
        }
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
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof d));
              paramObject = (d)paramObject;
              bool1 = bool2;
            } while (!md.equals(this.eR, ((d)paramObject).eR));
            bool1 = bool2;
          } while (!md.equals(this.eS, ((d)paramObject).eS));
          bool1 = bool2;
        } while (!md.equals(this.eT, ((d)paramObject).eT));
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label115;
        }
        if (((d)paramObject).amU == null) {
          break;
        }
        bool1 = bool2;
      } while (!((d)paramObject).amU.isEmpty());
      return true;
      label115:
      return this.amU.equals(((d)paramObject).amU);
    }
    
    public d h()
    {
      this.eR = d.a.r();
      this.eS = d.a.r();
      this.eT = c.c.f();
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public int hashCode()
    {
      int j = md.hashCode(this.eR);
      int k = md.hashCode(this.eS);
      int m = md.hashCode(this.eT);
      if ((this.amU == null) || (this.amU.isEmpty())) {}
      for (int i = 0;; i = this.amU.hashCode()) {
        return i + (((j + 527) * 31 + k) * 31 + m) * 31;
      }
    }
  }
  
  public static final class e
    extends mb<e>
  {
    private static volatile e[] eU;
    public int key;
    public int value;
    
    public e()
    {
      j();
    }
    
    public static e[] i()
    {
      if (eU == null) {}
      synchronized (md.amX)
      {
        if (eU == null) {
          eU = new e[0];
        }
        return eU;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      paramma.p(1, this.key);
      paramma.p(2, this.value);
      super.a(paramma);
    }
    
    protected int c()
    {
      return super.c() + ma.r(1, this.key) + ma.r(2, this.value);
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
            } while (!(paramObject instanceof e));
            paramObject = (e)paramObject;
            bool1 = bool2;
          } while (this.key != ((e)paramObject).key);
          bool1 = bool2;
        } while (this.value != ((e)paramObject).value);
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label93;
        }
        if (((e)paramObject).amU == null) {
          break;
        }
        bool1 = bool2;
      } while (!((e)paramObject).amU.isEmpty());
      return true;
      label93:
      return this.amU.equals(((e)paramObject).amU);
    }
    
    public e f(lz paramlz)
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
          this.key = paramlz.nz();
          break;
        case 16: 
          this.value = paramlz.nz();
        }
      }
    }
    
    public int hashCode()
    {
      int j = this.key;
      int k = this.value;
      if ((this.amU == null) || (this.amU.isEmpty())) {}
      for (int i = 0;; i = this.amU.hashCode()) {
        return i + ((j + 527) * 31 + k) * 31;
      }
    }
    
    public e j()
    {
      this.key = 0;
      this.value = 0;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class f
    extends mb<f>
  {
    public String[] eV;
    public String[] eW;
    public d.a[] eX;
    public c.e[] eY;
    public c.b[] eZ;
    public c.b[] fa;
    public c.b[] fb;
    public c.g[] fc;
    public String fd;
    public String fe;
    public String ff;
    public String fg;
    public c.a fh;
    public float fi;
    public boolean fj;
    public String[] fk;
    public int fl;
    
    public f()
    {
      k();
    }
    
    public static f a(byte[] paramArrayOfByte)
      throws me
    {
      return (f)mf.a(new f(), paramArrayOfByte);
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.eW != null) && (this.eW.length > 0))
      {
        i = 0;
        while (i < this.eW.length)
        {
          localObject = this.eW[i];
          if (localObject != null) {
            paramma.b(1, (String)localObject);
          }
          i += 1;
        }
      }
      if ((this.eX != null) && (this.eX.length > 0))
      {
        i = 0;
        while (i < this.eX.length)
        {
          localObject = this.eX[i];
          if (localObject != null) {
            paramma.a(2, (mf)localObject);
          }
          i += 1;
        }
      }
      if ((this.eY != null) && (this.eY.length > 0))
      {
        i = 0;
        while (i < this.eY.length)
        {
          localObject = this.eY[i];
          if (localObject != null) {
            paramma.a(3, (mf)localObject);
          }
          i += 1;
        }
      }
      if ((this.eZ != null) && (this.eZ.length > 0))
      {
        i = 0;
        while (i < this.eZ.length)
        {
          localObject = this.eZ[i];
          if (localObject != null) {
            paramma.a(4, (mf)localObject);
          }
          i += 1;
        }
      }
      if ((this.fa != null) && (this.fa.length > 0))
      {
        i = 0;
        while (i < this.fa.length)
        {
          localObject = this.fa[i];
          if (localObject != null) {
            paramma.a(5, (mf)localObject);
          }
          i += 1;
        }
      }
      if ((this.fb != null) && (this.fb.length > 0))
      {
        i = 0;
        while (i < this.fb.length)
        {
          localObject = this.fb[i];
          if (localObject != null) {
            paramma.a(6, (mf)localObject);
          }
          i += 1;
        }
      }
      if ((this.fc != null) && (this.fc.length > 0))
      {
        i = 0;
        while (i < this.fc.length)
        {
          localObject = this.fc[i];
          if (localObject != null) {
            paramma.a(7, (mf)localObject);
          }
          i += 1;
        }
      }
      if (!this.fd.equals("")) {
        paramma.b(9, this.fd);
      }
      if (!this.fe.equals("")) {
        paramma.b(10, this.fe);
      }
      if (!this.ff.equals("0")) {
        paramma.b(12, this.ff);
      }
      if (!this.fg.equals("")) {
        paramma.b(13, this.fg);
      }
      if (this.fh != null) {
        paramma.a(14, this.fh);
      }
      if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0F)) {
        paramma.b(15, this.fi);
      }
      if ((this.fk != null) && (this.fk.length > 0))
      {
        i = 0;
        while (i < this.fk.length)
        {
          localObject = this.fk[i];
          if (localObject != null) {
            paramma.b(16, (String)localObject);
          }
          i += 1;
        }
      }
      if (this.fl != 0) {
        paramma.p(17, this.fl);
      }
      if (this.fj) {
        paramma.a(18, this.fj);
      }
      if ((this.eV != null) && (this.eV.length > 0))
      {
        i = j;
        while (i < this.eV.length)
        {
          localObject = this.eV[i];
          if (localObject != null) {
            paramma.b(19, (String)localObject);
          }
          i += 1;
        }
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int i2 = 0;
      int i1 = super.c();
      int i;
      int k;
      Object localObject;
      int n;
      int m;
      if ((this.eW != null) && (this.eW.length > 0))
      {
        i = 0;
        j = 0;
        for (k = 0; i < this.eW.length; k = m)
        {
          localObject = this.eW[i];
          n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + ma.cz((String)localObject);
          }
          i += 1;
          j = n;
        }
      }
      for (int j = i1 + j + k * 1;; j = i1)
      {
        i = j;
        if (this.eX != null)
        {
          i = j;
          if (this.eX.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.eX.length)
            {
              localObject = this.eX[j];
              k = i;
              if (localObject != null) {
                k = i + ma.b(2, (mf)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.eY != null)
        {
          j = i;
          if (this.eY.length > 0)
          {
            j = 0;
            while (j < this.eY.length)
            {
              localObject = this.eY[j];
              k = i;
              if (localObject != null) {
                k = i + ma.b(3, (mf)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.eZ != null)
        {
          i = j;
          if (this.eZ.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.eZ.length)
            {
              localObject = this.eZ[j];
              k = i;
              if (localObject != null) {
                k = i + ma.b(4, (mf)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.fa != null)
        {
          j = i;
          if (this.fa.length > 0)
          {
            j = 0;
            while (j < this.fa.length)
            {
              localObject = this.fa[j];
              k = i;
              if (localObject != null) {
                k = i + ma.b(5, (mf)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.fb != null)
        {
          i = j;
          if (this.fb.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.fb.length)
            {
              localObject = this.fb[j];
              k = i;
              if (localObject != null) {
                k = i + ma.b(6, (mf)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.fc != null)
        {
          j = i;
          if (this.fc.length > 0)
          {
            j = 0;
            while (j < this.fc.length)
            {
              localObject = this.fc[j];
              k = i;
              if (localObject != null) {
                k = i + ma.b(7, (mf)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (!this.fd.equals("")) {
          i = j + ma.h(9, this.fd);
        }
        j = i;
        if (!this.fe.equals("")) {
          j = i + ma.h(10, this.fe);
        }
        i = j;
        if (!this.ff.equals("0")) {
          i = j + ma.h(12, this.ff);
        }
        j = i;
        if (!this.fg.equals("")) {
          j = i + ma.h(13, this.fg);
        }
        k = j;
        if (this.fh != null) {
          k = j + ma.b(14, this.fh);
        }
        i = k;
        if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0F)) {
          i = k + ma.c(15, this.fi);
        }
        j = i;
        if (this.fk != null)
        {
          j = i;
          if (this.fk.length > 0)
          {
            j = 0;
            k = 0;
            for (m = 0; j < this.fk.length; m = n)
            {
              localObject = this.fk[j];
              i1 = k;
              n = m;
              if (localObject != null)
              {
                n = m + 1;
                i1 = k + ma.cz((String)localObject);
              }
              j += 1;
              k = i1;
            }
            j = i + k + m * 2;
          }
        }
        k = j;
        if (this.fl != 0) {
          k = j + ma.r(17, this.fl);
        }
        i = k;
        if (this.fj) {
          i = k + ma.b(18, this.fj);
        }
        j = i;
        if (this.eV != null)
        {
          j = i;
          if (this.eV.length > 0)
          {
            k = 0;
            m = 0;
            j = i2;
            while (j < this.eV.length)
            {
              localObject = this.eV[j];
              i1 = k;
              n = m;
              if (localObject != null)
              {
                n = m + 1;
                i1 = k + ma.cz((String)localObject);
              }
              j += 1;
              k = i1;
              m = n;
            }
            j = i + k + m * 2;
          }
        }
        return j;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label169:
      label185:
      label201:
      label217:
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
                                do
                                {
                                  return bool1;
                                  bool1 = bool2;
                                } while (!(paramObject instanceof f));
                                paramObject = (f)paramObject;
                                bool1 = bool2;
                              } while (!md.equals(this.eV, ((f)paramObject).eV));
                              bool1 = bool2;
                            } while (!md.equals(this.eW, ((f)paramObject).eW));
                            bool1 = bool2;
                          } while (!md.equals(this.eX, ((f)paramObject).eX));
                          bool1 = bool2;
                        } while (!md.equals(this.eY, ((f)paramObject).eY));
                        bool1 = bool2;
                      } while (!md.equals(this.eZ, ((f)paramObject).eZ));
                      bool1 = bool2;
                    } while (!md.equals(this.fa, ((f)paramObject).fa));
                    bool1 = bool2;
                  } while (!md.equals(this.fb, ((f)paramObject).fb));
                  bool1 = bool2;
                } while (!md.equals(this.fc, ((f)paramObject).fc));
                if (this.fd != null) {
                  break;
                }
                bool1 = bool2;
              } while (((f)paramObject).fd != null);
              if (this.fe != null) {
                break label352;
              }
              bool1 = bool2;
            } while (((f)paramObject).fe != null);
            if (this.ff != null) {
              break label368;
            }
            bool1 = bool2;
          } while (((f)paramObject).ff != null);
          if (this.fg != null) {
            break label384;
          }
          bool1 = bool2;
        } while (((f)paramObject).fg != null);
        if (this.fh != null) {
          break label400;
        }
        bool1 = bool2;
      } while (((f)paramObject).fh != null);
      label352:
      label368:
      label384:
      label400:
      while (this.fh.equals(((f)paramObject).fh))
      {
        bool1 = bool2;
        if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(((f)paramObject).fi)) {
          break;
        }
        bool1 = bool2;
        if (this.fj != ((f)paramObject).fj) {
          break;
        }
        bool1 = bool2;
        if (!md.equals(this.fk, ((f)paramObject).fk)) {
          break;
        }
        bool1 = bool2;
        if (this.fl != ((f)paramObject).fl) {
          break;
        }
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label416;
        }
        if (((f)paramObject).amU != null)
        {
          bool1 = bool2;
          if (!((f)paramObject).amU.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.fd.equals(((f)paramObject).fd)) {
          break label169;
        }
        return false;
        if (this.fe.equals(((f)paramObject).fe)) {
          break label185;
        }
        return false;
        if (this.ff.equals(((f)paramObject).ff)) {
          break label201;
        }
        return false;
        if (this.fg.equals(((f)paramObject).fg)) {
          break label217;
        }
        return false;
      }
      return false;
      label416:
      return this.amU.equals(((f)paramObject).amU);
    }
    
    public f g(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = mi.b(paramlz, 10);
          if (this.eW == null) {}
          for (i = 0;; i = this.eW.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eW, 0, localObject, 0, i);
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
          this.eW = ((String[])localObject);
          break;
        case 18: 
          j = mi.b(paramlz, 18);
          if (this.eX == null) {}
          for (i = 0;; i = this.eX.length)
          {
            localObject = new d.a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eX, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new d.a();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new d.a();
          paramlz.a(localObject[j]);
          this.eX = ((d.a[])localObject);
          break;
        case 26: 
          j = mi.b(paramlz, 26);
          if (this.eY == null) {}
          for (i = 0;; i = this.eY.length)
          {
            localObject = new c.e[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eY, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new c.e();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new c.e();
          paramlz.a(localObject[j]);
          this.eY = ((c.e[])localObject);
          break;
        case 34: 
          j = mi.b(paramlz, 34);
          if (this.eZ == null) {}
          for (i = 0;; i = this.eZ.length)
          {
            localObject = new c.b[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eZ, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new c.b();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new c.b();
          paramlz.a(localObject[j]);
          this.eZ = ((c.b[])localObject);
          break;
        case 42: 
          j = mi.b(paramlz, 42);
          if (this.fa == null) {}
          for (i = 0;; i = this.fa.length)
          {
            localObject = new c.b[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fa, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new c.b();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new c.b();
          paramlz.a(localObject[j]);
          this.fa = ((c.b[])localObject);
          break;
        case 50: 
          j = mi.b(paramlz, 50);
          if (this.fb == null) {}
          for (i = 0;; i = this.fb.length)
          {
            localObject = new c.b[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fb, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new c.b();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new c.b();
          paramlz.a(localObject[j]);
          this.fb = ((c.b[])localObject);
          break;
        case 58: 
          j = mi.b(paramlz, 58);
          if (this.fc == null) {}
          for (i = 0;; i = this.fc.length)
          {
            localObject = new c.g[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fc, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new c.g();
              paramlz.a(localObject[j]);
              paramlz.nw();
              j += 1;
            }
          }
          localObject[j] = new c.g();
          paramlz.a(localObject[j]);
          this.fc = ((c.g[])localObject);
          break;
        case 74: 
          this.fd = paramlz.readString();
          break;
        case 82: 
          this.fe = paramlz.readString();
          break;
        case 98: 
          this.ff = paramlz.readString();
          break;
        case 106: 
          this.fg = paramlz.readString();
          break;
        case 114: 
          if (this.fh == null) {
            this.fh = new c.a();
          }
          paramlz.a(this.fh);
          break;
        case 125: 
          this.fi = paramlz.readFloat();
          break;
        case 130: 
          j = mi.b(paramlz, 130);
          if (this.fk == null) {}
          for (i = 0;; i = this.fk.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fk, 0, localObject, 0, i);
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
          this.fk = ((String[])localObject);
          break;
        case 136: 
          this.fl = paramlz.nz();
          break;
        case 144: 
          this.fj = paramlz.nA();
          break;
        case 154: 
          j = mi.b(paramlz, 154);
          if (this.eV == null) {}
          for (i = 0;; i = this.eV.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.eV, 0, localObject, 0, i);
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
          this.eV = ((String[])localObject);
        }
      }
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i4 = md.hashCode(this.eV);
      int i5 = md.hashCode(this.eW);
      int i6 = md.hashCode(this.eX);
      int i7 = md.hashCode(this.eY);
      int i8 = md.hashCode(this.eZ);
      int i9 = md.hashCode(this.fa);
      int i10 = md.hashCode(this.fb);
      int i11 = md.hashCode(this.fc);
      int i;
      int j;
      label93:
      int k;
      label102:
      int m;
      label112:
      int n;
      label122:
      int i12;
      int i1;
      label143:
      int i13;
      int i14;
      if (this.fd == null)
      {
        i = 0;
        if (this.fe != null) {
          break label302;
        }
        j = 0;
        if (this.ff != null) {
          break label313;
        }
        k = 0;
        if (this.fg != null) {
          break label324;
        }
        m = 0;
        if (this.fh != null) {
          break label336;
        }
        n = 0;
        i12 = Float.floatToIntBits(this.fi);
        if (!this.fj) {
          break label348;
        }
        i1 = 1231;
        i13 = md.hashCode(this.fk);
        i14 = this.fl;
        i2 = i3;
        if (this.amU != null) {
          if (!this.amU.isEmpty()) {
            break label356;
          }
        }
      }
      label302:
      label313:
      label324:
      label336:
      label348:
      label356:
      for (int i2 = i3;; i2 = this.amU.hashCode())
      {
        return (((i1 + ((n + (m + (k + (j + (i + ((((((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31) * 31) * 31) * 31) * 31) * 31 + i12) * 31) * 31 + i13) * 31 + i14) * 31 + i2;
        i = this.fd.hashCode();
        break;
        j = this.fe.hashCode();
        break label93;
        k = this.ff.hashCode();
        break label102;
        m = this.fg.hashCode();
        break label112;
        n = this.fh.hashCode();
        break label122;
        i1 = 1237;
        break label143;
      }
    }
    
    public f k()
    {
      this.eV = mi.anf;
      this.eW = mi.anf;
      this.eX = d.a.r();
      this.eY = c.e.i();
      this.eZ = c.b.d();
      this.fa = c.b.d();
      this.fb = c.b.d();
      this.fc = c.g.l();
      this.fd = "";
      this.fe = "";
      this.ff = "0";
      this.fg = "";
      this.fh = null;
      this.fi = 0.0F;
      this.fj = false;
      this.fk = mi.anf;
      this.fl = 0;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class g
    extends mb<g>
  {
    private static volatile g[] fm;
    public int[] fn;
    public int[] fo;
    public int[] fp;
    public int[] fq;
    public int[] fr;
    public int[] fs;
    public int[] ft;
    public int[] fu;
    public int[] fv;
    public int[] fw;
    
    public g()
    {
      m();
    }
    
    public static g[] l()
    {
      if (fm == null) {}
      synchronized (md.amX)
      {
        if (fm == null) {
          fm = new g[0];
        }
        return fm;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.fn != null) && (this.fn.length > 0))
      {
        i = 0;
        while (i < this.fn.length)
        {
          paramma.p(1, this.fn[i]);
          i += 1;
        }
      }
      if ((this.fo != null) && (this.fo.length > 0))
      {
        i = 0;
        while (i < this.fo.length)
        {
          paramma.p(2, this.fo[i]);
          i += 1;
        }
      }
      if ((this.fp != null) && (this.fp.length > 0))
      {
        i = 0;
        while (i < this.fp.length)
        {
          paramma.p(3, this.fp[i]);
          i += 1;
        }
      }
      if ((this.fq != null) && (this.fq.length > 0))
      {
        i = 0;
        while (i < this.fq.length)
        {
          paramma.p(4, this.fq[i]);
          i += 1;
        }
      }
      if ((this.fr != null) && (this.fr.length > 0))
      {
        i = 0;
        while (i < this.fr.length)
        {
          paramma.p(5, this.fr[i]);
          i += 1;
        }
      }
      if ((this.fs != null) && (this.fs.length > 0))
      {
        i = 0;
        while (i < this.fs.length)
        {
          paramma.p(6, this.fs[i]);
          i += 1;
        }
      }
      if ((this.ft != null) && (this.ft.length > 0))
      {
        i = 0;
        while (i < this.ft.length)
        {
          paramma.p(7, this.ft[i]);
          i += 1;
        }
      }
      if ((this.fu != null) && (this.fu.length > 0))
      {
        i = 0;
        while (i < this.fu.length)
        {
          paramma.p(8, this.fu[i]);
          i += 1;
        }
      }
      if ((this.fv != null) && (this.fv.length > 0))
      {
        i = 0;
        while (i < this.fv.length)
        {
          paramma.p(9, this.fv[i]);
          i += 1;
        }
      }
      if ((this.fw != null) && (this.fw.length > 0))
      {
        i = j;
        while (i < this.fw.length)
        {
          paramma.p(10, this.fw[i]);
          i += 1;
        }
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int m = 0;
      int k = super.c();
      int i;
      if ((this.fn != null) && (this.fn.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.fn.length)
        {
          j += ma.eE(this.fn[i]);
          i += 1;
        }
      }
      for (int j = k + j + this.fn.length * 1;; j = k)
      {
        i = j;
        if (this.fo != null)
        {
          i = j;
          if (this.fo.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.fo.length)
            {
              k += ma.eE(this.fo[i]);
              i += 1;
            }
            i = j + k + this.fo.length * 1;
          }
        }
        j = i;
        if (this.fp != null)
        {
          j = i;
          if (this.fp.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.fp.length)
            {
              k += ma.eE(this.fp[j]);
              j += 1;
            }
            j = i + k + this.fp.length * 1;
          }
        }
        i = j;
        if (this.fq != null)
        {
          i = j;
          if (this.fq.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.fq.length)
            {
              k += ma.eE(this.fq[i]);
              i += 1;
            }
            i = j + k + this.fq.length * 1;
          }
        }
        j = i;
        if (this.fr != null)
        {
          j = i;
          if (this.fr.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.fr.length)
            {
              k += ma.eE(this.fr[j]);
              j += 1;
            }
            j = i + k + this.fr.length * 1;
          }
        }
        i = j;
        if (this.fs != null)
        {
          i = j;
          if (this.fs.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.fs.length)
            {
              k += ma.eE(this.fs[i]);
              i += 1;
            }
            i = j + k + this.fs.length * 1;
          }
        }
        j = i;
        if (this.ft != null)
        {
          j = i;
          if (this.ft.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.ft.length)
            {
              k += ma.eE(this.ft[j]);
              j += 1;
            }
            j = i + k + this.ft.length * 1;
          }
        }
        i = j;
        if (this.fu != null)
        {
          i = j;
          if (this.fu.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.fu.length)
            {
              k += ma.eE(this.fu[i]);
              i += 1;
            }
            i = j + k + this.fu.length * 1;
          }
        }
        j = i;
        if (this.fv != null)
        {
          j = i;
          if (this.fv.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.fv.length)
            {
              k += ma.eE(this.fv[j]);
              j += 1;
            }
            j = i + k + this.fv.length * 1;
          }
        }
        i = j;
        if (this.fw != null)
        {
          i = j;
          if (this.fw.length > 0)
          {
            k = 0;
            i = m;
            while (i < this.fw.length)
            {
              k += ma.eE(this.fw[i]);
              i += 1;
            }
            i = j + k + this.fw.length * 1;
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
                            } while (!(paramObject instanceof g));
                            paramObject = (g)paramObject;
                            bool1 = bool2;
                          } while (!md.equals(this.fn, ((g)paramObject).fn));
                          bool1 = bool2;
                        } while (!md.equals(this.fo, ((g)paramObject).fo));
                        bool1 = bool2;
                      } while (!md.equals(this.fp, ((g)paramObject).fp));
                      bool1 = bool2;
                    } while (!md.equals(this.fq, ((g)paramObject).fq));
                    bool1 = bool2;
                  } while (!md.equals(this.fr, ((g)paramObject).fr));
                  bool1 = bool2;
                } while (!md.equals(this.fs, ((g)paramObject).fs));
                bool1 = bool2;
              } while (!md.equals(this.ft, ((g)paramObject).ft));
              bool1 = bool2;
            } while (!md.equals(this.fu, ((g)paramObject).fu));
            bool1 = bool2;
          } while (!md.equals(this.fv, ((g)paramObject).fv));
          bool1 = bool2;
        } while (!md.equals(this.fw, ((g)paramObject).fw));
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label227;
        }
        if (((g)paramObject).amU == null) {
          break;
        }
        bool1 = bool2;
      } while (!((g)paramObject).amU.isEmpty());
      return true;
      label227:
      return this.amU.equals(((g)paramObject).amU);
    }
    
    public g h(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = mi.b(paramlz, 8);
          if (this.fn == null) {}
          for (i = 0;; i = this.fn.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fn, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fn = arrayOfInt;
          break;
        case 10: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fn == null) {}
          for (i = 0;; i = this.fn.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fn, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fn = arrayOfInt;
          paramlz.ey(k);
          break;
        case 16: 
          j = mi.b(paramlz, 16);
          if (this.fo == null) {}
          for (i = 0;; i = this.fo.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fo, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fo = arrayOfInt;
          break;
        case 18: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fo == null) {}
          for (i = 0;; i = this.fo.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fo, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fo = arrayOfInt;
          paramlz.ey(k);
          break;
        case 24: 
          j = mi.b(paramlz, 24);
          if (this.fp == null) {}
          for (i = 0;; i = this.fp.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fp, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fp = arrayOfInt;
          break;
        case 26: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fp == null) {}
          for (i = 0;; i = this.fp.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fp, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fp = arrayOfInt;
          paramlz.ey(k);
          break;
        case 32: 
          j = mi.b(paramlz, 32);
          if (this.fq == null) {}
          for (i = 0;; i = this.fq.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fq, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fq = arrayOfInt;
          break;
        case 34: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fq == null) {}
          for (i = 0;; i = this.fq.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fq, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fq = arrayOfInt;
          paramlz.ey(k);
          break;
        case 40: 
          j = mi.b(paramlz, 40);
          if (this.fr == null) {}
          for (i = 0;; i = this.fr.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fr, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fr = arrayOfInt;
          break;
        case 42: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fr == null) {}
          for (i = 0;; i = this.fr.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fr, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fr = arrayOfInt;
          paramlz.ey(k);
          break;
        case 48: 
          j = mi.b(paramlz, 48);
          if (this.fs == null) {}
          for (i = 0;; i = this.fs.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fs, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fs = arrayOfInt;
          break;
        case 50: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fs == null) {}
          for (i = 0;; i = this.fs.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fs, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fs = arrayOfInt;
          paramlz.ey(k);
          break;
        case 56: 
          j = mi.b(paramlz, 56);
          if (this.ft == null) {}
          for (i = 0;; i = this.ft.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.ft, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.ft = arrayOfInt;
          break;
        case 58: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.ft == null) {}
          for (i = 0;; i = this.ft.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.ft, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.ft = arrayOfInt;
          paramlz.ey(k);
          break;
        case 64: 
          j = mi.b(paramlz, 64);
          if (this.fu == null) {}
          for (i = 0;; i = this.fu.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fu, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fu = arrayOfInt;
          break;
        case 66: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fu == null) {}
          for (i = 0;; i = this.fu.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fu, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fu = arrayOfInt;
          paramlz.ey(k);
          break;
        case 72: 
          j = mi.b(paramlz, 72);
          if (this.fv == null) {}
          for (i = 0;; i = this.fv.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fv, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fv = arrayOfInt;
          break;
        case 74: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fv == null) {}
          for (i = 0;; i = this.fv.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fv, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fv = arrayOfInt;
          paramlz.ey(k);
          break;
        case 80: 
          j = mi.b(paramlz, 80);
          if (this.fw == null) {}
          for (i = 0;; i = this.fw.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fw, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fw = arrayOfInt;
          break;
        case 82: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fw == null) {}
          for (i = 0;; i = this.fw.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fw, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fw = arrayOfInt;
          paramlz.ey(k);
        }
      }
    }
    
    public int hashCode()
    {
      int j = md.hashCode(this.fn);
      int k = md.hashCode(this.fo);
      int m = md.hashCode(this.fp);
      int n = md.hashCode(this.fq);
      int i1 = md.hashCode(this.fr);
      int i2 = md.hashCode(this.fs);
      int i3 = md.hashCode(this.ft);
      int i4 = md.hashCode(this.fu);
      int i5 = md.hashCode(this.fv);
      int i6 = md.hashCode(this.fw);
      if ((this.amU == null) || (this.amU.isEmpty())) {}
      for (int i = 0;; i = this.amU.hashCode()) {
        return i + ((((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31;
      }
    }
    
    public g m()
    {
      this.fn = mi.ana;
      this.fo = mi.ana;
      this.fp = mi.ana;
      this.fq = mi.ana;
      this.fr = mi.ana;
      this.fs = mi.ana;
      this.ft = mi.ana;
      this.fu = mi.ana;
      this.fv = mi.ana;
      this.fw = mi.ana;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class h
    extends mb<h>
  {
    public static final mc<d.a, h> fx = mc.a(11, h.class, 810);
    private static final h[] fy = new h[0];
    public int[] fA;
    public int[] fB;
    public int fC;
    public int[] fD;
    public int fE;
    public int fF;
    public int[] fz;
    
    public h()
    {
      n();
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.fz != null) && (this.fz.length > 0))
      {
        i = 0;
        while (i < this.fz.length)
        {
          paramma.p(1, this.fz[i]);
          i += 1;
        }
      }
      if ((this.fA != null) && (this.fA.length > 0))
      {
        i = 0;
        while (i < this.fA.length)
        {
          paramma.p(2, this.fA[i]);
          i += 1;
        }
      }
      if ((this.fB != null) && (this.fB.length > 0))
      {
        i = 0;
        while (i < this.fB.length)
        {
          paramma.p(3, this.fB[i]);
          i += 1;
        }
      }
      if (this.fC != 0) {
        paramma.p(4, this.fC);
      }
      if ((this.fD != null) && (this.fD.length > 0))
      {
        i = j;
        while (i < this.fD.length)
        {
          paramma.p(5, this.fD[i]);
          i += 1;
        }
      }
      if (this.fE != 0) {
        paramma.p(6, this.fE);
      }
      if (this.fF != 0) {
        paramma.p(7, this.fF);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int m = 0;
      int k = super.c();
      int i;
      if ((this.fz != null) && (this.fz.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.fz.length)
        {
          j += ma.eE(this.fz[i]);
          i += 1;
        }
      }
      for (int j = k + j + this.fz.length * 1;; j = k)
      {
        i = j;
        if (this.fA != null)
        {
          i = j;
          if (this.fA.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.fA.length)
            {
              k += ma.eE(this.fA[i]);
              i += 1;
            }
            i = j + k + this.fA.length * 1;
          }
        }
        j = i;
        if (this.fB != null)
        {
          j = i;
          if (this.fB.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.fB.length)
            {
              k += ma.eE(this.fB[j]);
              j += 1;
            }
            j = i + k + this.fB.length * 1;
          }
        }
        i = j;
        if (this.fC != 0) {
          i = j + ma.r(4, this.fC);
        }
        j = i;
        if (this.fD != null)
        {
          j = i;
          if (this.fD.length > 0)
          {
            k = 0;
            j = m;
            while (j < this.fD.length)
            {
              k += ma.eE(this.fD[j]);
              j += 1;
            }
            j = i + k + this.fD.length * 1;
          }
        }
        i = j;
        if (this.fE != 0) {
          i = j + ma.r(6, this.fE);
        }
        j = i;
        if (this.fF != 0) {
          j = i + ma.r(7, this.fF);
        }
        return j;
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
                      } while (!(paramObject instanceof h));
                      paramObject = (h)paramObject;
                      bool1 = bool2;
                    } while (!md.equals(this.fz, ((h)paramObject).fz));
                    bool1 = bool2;
                  } while (!md.equals(this.fA, ((h)paramObject).fA));
                  bool1 = bool2;
                } while (!md.equals(this.fB, ((h)paramObject).fB));
                bool1 = bool2;
              } while (this.fC != ((h)paramObject).fC);
              bool1 = bool2;
            } while (!md.equals(this.fD, ((h)paramObject).fD));
            bool1 = bool2;
          } while (this.fE != ((h)paramObject).fE);
          bool1 = bool2;
        } while (this.fF != ((h)paramObject).fF);
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label170;
        }
        if (((h)paramObject).amU == null) {
          break;
        }
        bool1 = bool2;
      } while (!((h)paramObject).amU.isEmpty());
      return true;
      label170:
      return this.amU.equals(((h)paramObject).amU);
    }
    
    public int hashCode()
    {
      int j = md.hashCode(this.fz);
      int k = md.hashCode(this.fA);
      int m = md.hashCode(this.fB);
      int n = this.fC;
      int i1 = md.hashCode(this.fD);
      int i2 = this.fE;
      int i3 = this.fF;
      if ((this.amU == null) || (this.amU.isEmpty())) {}
      for (int i = 0;; i = this.amU.hashCode()) {
        return i + (((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31;
      }
    }
    
    public h i(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = mi.b(paramlz, 8);
          if (this.fz == null) {}
          for (i = 0;; i = this.fz.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fz, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fz = arrayOfInt;
          break;
        case 10: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fz == null) {}
          for (i = 0;; i = this.fz.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fz, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fz = arrayOfInt;
          paramlz.ey(k);
          break;
        case 16: 
          j = mi.b(paramlz, 16);
          if (this.fA == null) {}
          for (i = 0;; i = this.fA.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fA, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fA = arrayOfInt;
          break;
        case 18: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fA == null) {}
          for (i = 0;; i = this.fA.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fA, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fA = arrayOfInt;
          paramlz.ey(k);
          break;
        case 24: 
          j = mi.b(paramlz, 24);
          if (this.fB == null) {}
          for (i = 0;; i = this.fB.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fB, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fB = arrayOfInt;
          break;
        case 26: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fB == null) {}
          for (i = 0;; i = this.fB.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fB, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fB = arrayOfInt;
          paramlz.ey(k);
          break;
        case 32: 
          this.fC = paramlz.nz();
          break;
        case 40: 
          j = mi.b(paramlz, 40);
          if (this.fD == null) {}
          for (i = 0;; i = this.fD.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fD, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramlz.nz();
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfInt[j] = paramlz.nz();
          this.fD = arrayOfInt;
          break;
        case 42: 
          k = paramlz.ex(paramlz.nD());
          i = paramlz.getPosition();
          j = 0;
          while (paramlz.nI() > 0)
          {
            paramlz.nz();
            j += 1;
          }
          paramlz.ez(i);
          if (this.fD == null) {}
          for (i = 0;; i = this.fD.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fD, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramlz.nz();
              j += 1;
            }
          }
          this.fD = arrayOfInt;
          paramlz.ey(k);
          break;
        case 48: 
          this.fE = paramlz.nz();
          break;
        case 56: 
          this.fF = paramlz.nz();
        }
      }
    }
    
    public h n()
    {
      this.fz = mi.ana;
      this.fA = mi.ana;
      this.fB = mi.ana;
      this.fC = 0;
      this.fD = mi.ana;
      this.fE = 0;
      this.fF = 0;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class i
    extends mb<i>
  {
    private static volatile i[] fG;
    public d.a fH;
    public c.d fI;
    public String name;
    
    public i()
    {
      p();
    }
    
    public static i[] o()
    {
      if (fG == null) {}
      synchronized (md.amX)
      {
        if (fG == null) {
          fG = new i[0];
        }
        return fG;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if (!this.name.equals("")) {
        paramma.b(1, this.name);
      }
      if (this.fH != null) {
        paramma.a(2, this.fH);
      }
      if (this.fI != null) {
        paramma.a(3, this.fI);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int j = super.c();
      int i = j;
      if (!this.name.equals("")) {
        i = j + ma.h(1, this.name);
      }
      j = i;
      if (this.fH != null) {
        j = i + ma.b(2, this.fH);
      }
      i = j;
      if (this.fI != null) {
        i = j + ma.b(3, this.fI);
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
        if ((this.amU == null) || (this.amU.isEmpty()))
        {
          if (((i)paramObject).amU != null)
          {
            bool1 = bool2;
            if (!((i)paramObject).amU.isEmpty()) {
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
      return this.amU.equals(((i)paramObject).amU);
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
        if (this.amU != null) {
          if (!this.amU.isEmpty()) {
            break label112;
          }
        }
      }
      label90:
      label101:
      label112:
      for (int m = n;; m = this.amU.hashCode())
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
    
    public i j(lz paramlz)
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
          if (this.fH == null) {
            this.fH = new d.a();
          }
          paramlz.a(this.fH);
          break;
        case 26: 
          if (this.fI == null) {
            this.fI = new c.d();
          }
          paramlz.a(this.fI);
        }
      }
    }
    
    public i p()
    {
      this.name = "";
      this.fH = null;
      this.fI = null;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class j
    extends mb<j>
  {
    public c.i[] fJ;
    public c.f fK;
    public String fL;
    
    public j()
    {
      q();
    }
    
    public static j b(byte[] paramArrayOfByte)
      throws me
    {
      return (j)mf.a(new j(), paramArrayOfByte);
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if ((this.fJ != null) && (this.fJ.length > 0))
      {
        int i = 0;
        while (i < this.fJ.length)
        {
          c.i locali = this.fJ[i];
          if (locali != null) {
            paramma.a(1, locali);
          }
          i += 1;
        }
      }
      if (this.fK != null) {
        paramma.a(2, this.fK);
      }
      if (!this.fL.equals("")) {
        paramma.b(3, this.fL);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int i = super.c();
      int j = i;
      if (this.fJ != null)
      {
        j = i;
        if (this.fJ.length > 0)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= this.fJ.length) {
              break;
            }
            c.i locali = this.fJ[k];
            j = i;
            if (locali != null) {
              j = i + ma.b(1, locali);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.fK != null) {
        i = j + ma.b(2, this.fK);
      }
      j = i;
      if (!this.fL.equals("")) {
        j = i + ma.h(3, this.fL);
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
            } while (!(paramObject instanceof j));
            paramObject = (j)paramObject;
            bool1 = bool2;
          } while (!md.equals(this.fJ, ((j)paramObject).fJ));
          if (this.fK != null) {
            break;
          }
          bool1 = bool2;
        } while (((j)paramObject).fK != null);
        if (this.fL != null) {
          break label131;
        }
        bool1 = bool2;
      } while (((j)paramObject).fL != null);
      for (;;)
      {
        if ((this.amU == null) || (this.amU.isEmpty()))
        {
          if (((j)paramObject).amU != null)
          {
            bool1 = bool2;
            if (!((j)paramObject).amU.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.fK.equals(((j)paramObject).fK)) {
            break label57;
          }
          return false;
          label131:
          if (!this.fL.equals(((j)paramObject).fL)) {
            return false;
          }
        }
      }
      return this.amU.equals(((j)paramObject).amU);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = md.hashCode(this.fJ);
      int i;
      int j;
      if (this.fK == null)
      {
        i = 0;
        if (this.fL != null) {
          break label88;
        }
        j = 0;
        label30:
        k = m;
        if (this.amU != null) {
          if (!this.amU.isEmpty()) {
            break label99;
          }
        }
      }
      label88:
      label99:
      for (int k = m;; k = this.amU.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = this.fK.hashCode();
        break;
        j = this.fL.hashCode();
        break label30;
      }
    }
    
    public j k(lz paramlz)
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
          if (this.fJ == null) {}
          c.i[] arrayOfi;
          for (i = 0;; i = this.fJ.length)
          {
            arrayOfi = new c.i[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.fJ, 0, arrayOfi, 0, i);
              j = i;
            }
            while (j < arrayOfi.length - 1)
            {
              arrayOfi[j] = new c.i();
              paramlz.a(arrayOfi[j]);
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfi[j] = new c.i();
          paramlz.a(arrayOfi[j]);
          this.fJ = arrayOfi;
          break;
        case 18: 
          if (this.fK == null) {
            this.fK = new c.f();
          }
          paramlz.a(this.fK);
          break;
        case 26: 
          this.fL = paramlz.readString();
        }
      }
    }
    
    public j q()
    {
      this.fJ = c.i.o();
      this.fK = null;
      this.fL = "";
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */