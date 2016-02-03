package com.google.android.gms.internal;

import java.util.List;

public final class c$f
  extends ma<f>
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
  
  public c$f()
  {
    k();
  }
  
  public static f a(byte[] paramArrayOfByte)
  {
    return (f)me.a(new f(), paramArrayOfByte);
  }
  
  public void a(lz paramlz)
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
          paramlz.b(1, (String)localObject);
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
          paramlz.a(2, (me)localObject);
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
          paramlz.a(3, (me)localObject);
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
          paramlz.a(4, (me)localObject);
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
          paramlz.a(5, (me)localObject);
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
          paramlz.a(6, (me)localObject);
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
          paramlz.a(7, (me)localObject);
        }
        i += 1;
      }
    }
    if (!this.fd.equals("")) {
      paramlz.b(9, this.fd);
    }
    if (!this.fe.equals("")) {
      paramlz.b(10, this.fe);
    }
    if (!this.ff.equals("0")) {
      paramlz.b(12, this.ff);
    }
    if (!this.fg.equals("")) {
      paramlz.b(13, this.fg);
    }
    if (this.fh != null) {
      paramlz.a(14, this.fh);
    }
    if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0F)) {
      paramlz.b(15, this.fi);
    }
    if ((this.fk != null) && (this.fk.length > 0))
    {
      i = 0;
      while (i < this.fk.length)
      {
        localObject = this.fk[i];
        if (localObject != null) {
          paramlz.b(16, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.fl != 0) {
      paramlz.p(17, this.fl);
    }
    if (this.fj) {
      paramlz.a(18, this.fj);
    }
    if ((this.eV != null) && (this.eV.length > 0))
    {
      i = j;
      while (i < this.eV.length)
      {
        localObject = this.eV[i];
        if (localObject != null) {
          paramlz.b(19, (String)localObject);
        }
        i += 1;
      }
    }
    super.a(paramlz);
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
          n = j + lz.cz((String)localObject);
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
              k = i + lz.b(2, (me)localObject);
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
              k = i + lz.b(3, (me)localObject);
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
              k = i + lz.b(4, (me)localObject);
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
              k = i + lz.b(5, (me)localObject);
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
              k = i + lz.b(6, (me)localObject);
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
              k = i + lz.b(7, (me)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!this.fd.equals("")) {
        i = j + lz.h(9, this.fd);
      }
      j = i;
      if (!this.fe.equals("")) {
        j = i + lz.h(10, this.fe);
      }
      i = j;
      if (!this.ff.equals("0")) {
        i = j + lz.h(12, this.ff);
      }
      j = i;
      if (!this.fg.equals("")) {
        j = i + lz.h(13, this.fg);
      }
      k = j;
      if (this.fh != null) {
        k = j + lz.b(14, this.fh);
      }
      i = k;
      if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0F)) {
        i = k + lz.c(15, this.fi);
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
              i1 = k + lz.cz((String)localObject);
            }
            j += 1;
            k = i1;
          }
          j = i + k + m * 2;
        }
      }
      k = j;
      if (this.fl != 0) {
        k = j + lz.r(17, this.fl);
      }
      i = k;
      if (this.fj) {
        i = k + lz.b(18, this.fj);
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
              i1 = k + lz.cz((String)localObject);
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
                            } while (!mc.equals(this.eV, ((f)paramObject).eV));
                            bool1 = bool2;
                          } while (!mc.equals(this.eW, ((f)paramObject).eW));
                          bool1 = bool2;
                        } while (!mc.equals(this.eX, ((f)paramObject).eX));
                        bool1 = bool2;
                      } while (!mc.equals(this.eY, ((f)paramObject).eY));
                      bool1 = bool2;
                    } while (!mc.equals(this.eZ, ((f)paramObject).eZ));
                    bool1 = bool2;
                  } while (!mc.equals(this.fa, ((f)paramObject).fa));
                  bool1 = bool2;
                } while (!mc.equals(this.fb, ((f)paramObject).fb));
                bool1 = bool2;
              } while (!mc.equals(this.fc, ((f)paramObject).fc));
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
      if (!mc.equals(this.fk, ((f)paramObject).fk)) {
        break;
      }
      bool1 = bool2;
      if (this.fl != ((f)paramObject).fl) {
        break;
      }
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label416;
      }
      if (((f)paramObject).amX != null)
      {
        bool1 = bool2;
        if (!((f)paramObject).amX.isEmpty()) {
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
    return this.amX.equals(((f)paramObject).amX);
  }
  
  public f g(ly paramly)
  {
    for (;;)
    {
      int i = paramly.nB();
      int j;
      Object localObject;
      switch (i)
      {
      default: 
        if (a(paramly, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        j = mh.b(paramly, 10);
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
            localObject[j] = paramly.readString();
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = paramly.readString();
        this.eW = ((String[])localObject);
        break;
      case 18: 
        j = mh.b(paramly, 18);
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
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new d.a();
        paramly.a(localObject[j]);
        this.eX = ((d.a[])localObject);
        break;
      case 26: 
        j = mh.b(paramly, 26);
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
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new c.e();
        paramly.a(localObject[j]);
        this.eY = ((c.e[])localObject);
        break;
      case 34: 
        j = mh.b(paramly, 34);
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
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new c.b();
        paramly.a(localObject[j]);
        this.eZ = ((c.b[])localObject);
        break;
      case 42: 
        j = mh.b(paramly, 42);
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
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new c.b();
        paramly.a(localObject[j]);
        this.fa = ((c.b[])localObject);
        break;
      case 50: 
        j = mh.b(paramly, 50);
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
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new c.b();
        paramly.a(localObject[j]);
        this.fb = ((c.b[])localObject);
        break;
      case 58: 
        j = mh.b(paramly, 58);
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
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new c.g();
        paramly.a(localObject[j]);
        this.fc = ((c.g[])localObject);
        break;
      case 74: 
        this.fd = paramly.readString();
        break;
      case 82: 
        this.fe = paramly.readString();
        break;
      case 98: 
        this.ff = paramly.readString();
        break;
      case 106: 
        this.fg = paramly.readString();
        break;
      case 114: 
        if (this.fh == null) {
          this.fh = new c.a();
        }
        paramly.a(this.fh);
        break;
      case 125: 
        this.fi = paramly.readFloat();
        break;
      case 130: 
        j = mh.b(paramly, 130);
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
            localObject[j] = paramly.readString();
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = paramly.readString();
        this.fk = ((String[])localObject);
        break;
      case 136: 
        this.fl = paramly.nE();
        break;
      case 144: 
        this.fj = paramly.nF();
        break;
      case 154: 
        j = mh.b(paramly, 154);
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
            localObject[j] = paramly.readString();
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = paramly.readString();
        this.eV = ((String[])localObject);
      }
    }
  }
  
  public int hashCode()
  {
    int i3 = 0;
    int i4 = mc.hashCode(this.eV);
    int i5 = mc.hashCode(this.eW);
    int i6 = mc.hashCode(this.eX);
    int i7 = mc.hashCode(this.eY);
    int i8 = mc.hashCode(this.eZ);
    int i9 = mc.hashCode(this.fa);
    int i10 = mc.hashCode(this.fb);
    int i11 = mc.hashCode(this.fc);
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
      i13 = mc.hashCode(this.fk);
      i14 = this.fl;
      i2 = i3;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
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
    for (int i2 = i3;; i2 = this.amX.hashCode())
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
    this.eV = mh.ani;
    this.eW = mh.ani;
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
    this.fk = mh.ani;
    this.fl = 0;
    this.amX = null;
    this.anb = -1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */