package com.google.android.gms.internal;

import java.util.List;

public final class c$g
  extends ma<g>
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
  
  public c$g()
  {
    m();
  }
  
  public static g[] l()
  {
    if (fm == null) {}
    synchronized (mc.ana)
    {
      if (fm == null) {
        fm = new g[0];
      }
      return fm;
    }
  }
  
  public void a(lz paramlz)
  {
    int j = 0;
    int i;
    if ((this.fn != null) && (this.fn.length > 0))
    {
      i = 0;
      while (i < this.fn.length)
      {
        paramlz.p(1, this.fn[i]);
        i += 1;
      }
    }
    if ((this.fo != null) && (this.fo.length > 0))
    {
      i = 0;
      while (i < this.fo.length)
      {
        paramlz.p(2, this.fo[i]);
        i += 1;
      }
    }
    if ((this.fp != null) && (this.fp.length > 0))
    {
      i = 0;
      while (i < this.fp.length)
      {
        paramlz.p(3, this.fp[i]);
        i += 1;
      }
    }
    if ((this.fq != null) && (this.fq.length > 0))
    {
      i = 0;
      while (i < this.fq.length)
      {
        paramlz.p(4, this.fq[i]);
        i += 1;
      }
    }
    if ((this.fr != null) && (this.fr.length > 0))
    {
      i = 0;
      while (i < this.fr.length)
      {
        paramlz.p(5, this.fr[i]);
        i += 1;
      }
    }
    if ((this.fs != null) && (this.fs.length > 0))
    {
      i = 0;
      while (i < this.fs.length)
      {
        paramlz.p(6, this.fs[i]);
        i += 1;
      }
    }
    if ((this.ft != null) && (this.ft.length > 0))
    {
      i = 0;
      while (i < this.ft.length)
      {
        paramlz.p(7, this.ft[i]);
        i += 1;
      }
    }
    if ((this.fu != null) && (this.fu.length > 0))
    {
      i = 0;
      while (i < this.fu.length)
      {
        paramlz.p(8, this.fu[i]);
        i += 1;
      }
    }
    if ((this.fv != null) && (this.fv.length > 0))
    {
      i = 0;
      while (i < this.fv.length)
      {
        paramlz.p(9, this.fv[i]);
        i += 1;
      }
    }
    if ((this.fw != null) && (this.fw.length > 0))
    {
      i = j;
      while (i < this.fw.length)
      {
        paramlz.p(10, this.fw[i]);
        i += 1;
      }
    }
    super.a(paramlz);
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
        j += lz.eE(this.fn[i]);
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
            k += lz.eE(this.fo[i]);
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
            k += lz.eE(this.fp[j]);
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
            k += lz.eE(this.fq[i]);
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
            k += lz.eE(this.fr[j]);
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
            k += lz.eE(this.fs[i]);
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
            k += lz.eE(this.ft[j]);
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
            k += lz.eE(this.fu[i]);
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
            k += lz.eE(this.fv[j]);
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
            k += lz.eE(this.fw[i]);
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
                        } while (!mc.equals(this.fn, ((g)paramObject).fn));
                        bool1 = bool2;
                      } while (!mc.equals(this.fo, ((g)paramObject).fo));
                      bool1 = bool2;
                    } while (!mc.equals(this.fp, ((g)paramObject).fp));
                    bool1 = bool2;
                  } while (!mc.equals(this.fq, ((g)paramObject).fq));
                  bool1 = bool2;
                } while (!mc.equals(this.fr, ((g)paramObject).fr));
                bool1 = bool2;
              } while (!mc.equals(this.fs, ((g)paramObject).fs));
              bool1 = bool2;
            } while (!mc.equals(this.ft, ((g)paramObject).ft));
            bool1 = bool2;
          } while (!mc.equals(this.fu, ((g)paramObject).fu));
          bool1 = bool2;
        } while (!mc.equals(this.fv, ((g)paramObject).fv));
        bool1 = bool2;
      } while (!mc.equals(this.fw, ((g)paramObject).fw));
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label227;
      }
      if (((g)paramObject).amX == null) {
        break;
      }
      bool1 = bool2;
    } while (!((g)paramObject).amX.isEmpty());
    return true;
    label227:
    return this.amX.equals(((g)paramObject).amX);
  }
  
  public g h(ly paramly)
  {
    for (;;)
    {
      int i = paramly.nB();
      int j;
      int[] arrayOfInt;
      int k;
      switch (i)
      {
      default: 
        if (a(paramly, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        j = mh.b(paramly, 8);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fn = arrayOfInt;
        break;
      case 10: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fn = arrayOfInt;
        paramly.ey(k);
        break;
      case 16: 
        j = mh.b(paramly, 16);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fo = arrayOfInt;
        break;
      case 18: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fo = arrayOfInt;
        paramly.ey(k);
        break;
      case 24: 
        j = mh.b(paramly, 24);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fp = arrayOfInt;
        break;
      case 26: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fp = arrayOfInt;
        paramly.ey(k);
        break;
      case 32: 
        j = mh.b(paramly, 32);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fq = arrayOfInt;
        break;
      case 34: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fq = arrayOfInt;
        paramly.ey(k);
        break;
      case 40: 
        j = mh.b(paramly, 40);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fr = arrayOfInt;
        break;
      case 42: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fr = arrayOfInt;
        paramly.ey(k);
        break;
      case 48: 
        j = mh.b(paramly, 48);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fs = arrayOfInt;
        break;
      case 50: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fs = arrayOfInt;
        paramly.ey(k);
        break;
      case 56: 
        j = mh.b(paramly, 56);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.ft = arrayOfInt;
        break;
      case 58: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.ft = arrayOfInt;
        paramly.ey(k);
        break;
      case 64: 
        j = mh.b(paramly, 64);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fu = arrayOfInt;
        break;
      case 66: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fu = arrayOfInt;
        paramly.ey(k);
        break;
      case 72: 
        j = mh.b(paramly, 72);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fv = arrayOfInt;
        break;
      case 74: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fv = arrayOfInt;
        paramly.ey(k);
        break;
      case 80: 
        j = mh.b(paramly, 80);
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
            arrayOfInt[j] = paramly.nE();
            paramly.nB();
            j += 1;
          }
        }
        arrayOfInt[j] = paramly.nE();
        this.fw = arrayOfInt;
        break;
      case 82: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nE();
          j += 1;
        }
        paramly.ez(i);
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
            arrayOfInt[j] = paramly.nE();
            j += 1;
          }
        }
        this.fw = arrayOfInt;
        paramly.ey(k);
      }
    }
  }
  
  public int hashCode()
  {
    int j = mc.hashCode(this.fn);
    int k = mc.hashCode(this.fo);
    int m = mc.hashCode(this.fp);
    int n = mc.hashCode(this.fq);
    int i1 = mc.hashCode(this.fr);
    int i2 = mc.hashCode(this.fs);
    int i3 = mc.hashCode(this.ft);
    int i4 = mc.hashCode(this.fu);
    int i5 = mc.hashCode(this.fv);
    int i6 = mc.hashCode(this.fw);
    if ((this.amX == null) || (this.amX.isEmpty())) {}
    for (int i = 0;; i = this.amX.hashCode()) {
      return i + ((((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31;
    }
  }
  
  public g m()
  {
    this.fn = mh.and;
    this.fo = mh.and;
    this.fp = mh.and;
    this.fq = mh.and;
    this.fr = mh.and;
    this.fs = mh.and;
    this.ft = mh.and;
    this.fu = mh.and;
    this.fv = mh.and;
    this.fw = mh.and;
    this.amX = null;
    this.anb = -1;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */