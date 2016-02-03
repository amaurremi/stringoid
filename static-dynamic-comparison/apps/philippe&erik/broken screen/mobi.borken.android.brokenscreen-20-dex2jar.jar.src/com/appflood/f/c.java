package com.appflood.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.io.InputStream;
import java.util.Vector;

public final class c
{
  private Bitmap A;
  private byte[] B = new byte['Ā'];
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private boolean F = false;
  private int G = 0;
  private int H;
  private short[] I;
  private byte[] J;
  private byte[] K;
  private byte[] L;
  private int M;
  int a = 0;
  Vector b;
  private InputStream c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  private int[] i;
  private int[] j;
  private int[] k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private Bitmap z;
  
  private boolean a()
  {
    return this.d != 0;
  }
  
  private int b()
  {
    try
    {
      int i1 = this.c.read();
      return i1;
    }
    catch (Exception localException)
    {
      this.d = 1;
    }
    return 0;
  }
  
  private int[] b(int paramInt)
  {
    int i2 = 0;
    int i3 = paramInt * 3;
    Object localObject = null;
    byte[] arrayOfByte = new byte[i3];
    int i1;
    int[] arrayOfInt;
    try
    {
      i1 = this.c.read(arrayOfByte);
      if (i1 < i3)
      {
        this.d = 1;
        return (int[])localObject;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i1 = 0;
      }
      arrayOfInt = new int['Ā'];
      i1 = 0;
    }
    for (;;)
    {
      localObject = arrayOfInt;
      if (i1 >= paramInt) {
        break;
      }
      i3 = i2 + 1;
      int i4 = arrayOfByte[i2];
      i2 = i3 + 1;
      arrayOfInt[i1] = ((i4 & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[i3] & 0xFF) << 8 | arrayOfByte[i2] & 0xFF);
      i1 += 1;
      i2 += 1;
    }
  }
  
  private int c()
  {
    this.C = b();
    i2 = 0;
    int i1 = 0;
    if (this.C > 0) {
      try
      {
        while (i1 < this.C)
        {
          i2 = this.c.read(this.B, i1, this.C - i1);
          if (i2 == -1) {
            break;
          }
          i1 += i2;
        }
        return i2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i2 = i1;
        if (i1 < this.C)
        {
          this.d = 1;
          i2 = i1;
        }
      }
    }
  }
  
  private void d()
  {
    int i13 = 0;
    int i1;
    boolean bool;
    label116:
    label132:
    int i14;
    int i18;
    int i7;
    int i5;
    int i2;
    int i3;
    label377:
    label383:
    int i10;
    int i4;
    int i8;
    int i9;
    int i6;
    int i15;
    label441:
    int i16;
    Object localObject;
    int i17;
    while ((i13 == 0) && (!a())) {
      switch (b())
      {
      case 0: 
      default: 
        this.d = 1;
        break;
      case 44: 
        this.r = g();
        this.s = g();
        this.t = g();
        this.u = g();
        i1 = b();
        if ((i1 & 0x80) != 0)
        {
          bool = true;
          this.o = bool;
          if ((i1 & 0x40) == 0) {
            break label377;
          }
          bool = true;
          this.p = bool;
          this.q = (2 << (i1 & 0x7));
          if (!this.o) {
            break label383;
          }
          this.j = b(this.q);
          this.k = this.j;
        }
        int i19;
        int i20;
        for (;;)
        {
          i14 = 0;
          if (this.F)
          {
            i14 = this.k[this.H];
            this.k[this.H] = 0;
          }
          if (this.k == null) {
            this.d = 1;
          }
          if (a()) {
            break;
          }
          i18 = this.t * this.u;
          if ((this.L == null) || (this.L.length < i18)) {
            this.L = new byte[i18];
          }
          if (this.I == null) {
            this.I = new short['က'];
          }
          if (this.J == null) {
            this.J = new byte['က'];
          }
          if (this.K == null) {
            this.K = new byte['ခ'];
          }
          i19 = b();
          i20 = 1 << i19;
          i7 = i20 + 2;
          i5 = -1;
          i2 = i19 + 1;
          i3 = (1 << i2) - 1;
          i1 = 0;
          while (i1 < i20)
          {
            this.I[i1] = 0;
            this.J[i1] = ((byte)i1);
            i1 += 1;
          }
          bool = false;
          break label116;
          bool = false;
          break label132;
          this.k = this.i;
          if (this.l == this.H) {
            this.m = 0;
          }
        }
        i10 = 0;
        i4 = 0;
        i8 = 0;
        i9 = 0;
        int i11 = 0;
        i6 = 0;
        i15 = 0;
        int i12 = 0;
        i1 = i5;
        i5 = i9;
        while (i15 < i18)
        {
          if (i4 != 0) {
            break label1752;
          }
          if (i6 < i2)
          {
            i9 = i11;
            if (i11 == 0)
            {
              i9 = c();
              if (i9 > 0) {
                i12 = 0;
              }
            }
            else
            {
              i5 += ((this.B[i12] & 0xFF) << i6);
              i6 += 8;
              i12 += 1;
              i11 = i9 - 1;
            }
          }
          else
          {
            i9 = i5 & i3;
            i16 = i5 >> i2;
            i6 -= i2;
            if ((i9 <= i7) && (i9 != i20 + 1)) {
              if (i9 == i20)
              {
                i2 = i19 + 1;
                i3 = (1 << i2) - 1;
                i7 = i20 + 2;
                i1 = -1;
                i5 = i16;
              }
              else if (i1 == -1)
              {
                this.K[i4] = this.J[i9];
                i4 += 1;
                i1 = i9;
                i8 = i9;
                i5 = i16;
              }
              else
              {
                if (i9 != i7) {
                  break label1745;
                }
                localObject = this.K;
                i17 = i4 + 1;
                localObject[i4] = ((byte)i8);
                i5 = i1;
                i4 = i17;
                label663:
                while (i5 > i20)
                {
                  this.K[i4] = this.J[i5];
                  i5 = this.I[i5];
                  i4 += 1;
                }
                i17 = this.J[i5] & 0xFF;
                if (i7 < 4096)
                {
                  this.K[i4] = ((byte)i17);
                  this.I[i7] = ((short)i1);
                  this.J[i7] = ((byte)i17);
                  i8 = i7 + 1;
                  i1 = i2;
                  i5 = i3;
                  if ((i8 & i3) == 0)
                  {
                    i1 = i2;
                    i5 = i3;
                    if (i8 < 4096)
                    {
                      i1 = i2 + 1;
                      i5 = i3 + i8;
                    }
                  }
                  i2 = i9;
                  i7 = i5;
                  i5 = i17;
                  i9 = i4 + 1;
                  i3 = i8;
                  i4 = i7;
                  i7 = i1;
                  i1 = i16;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i9 -= 1;
      this.L[i10] = this.K[i9];
      i15 += 1;
      i16 = i10 + 1;
      i8 = i7;
      i10 = i9;
      i7 = i3;
      i9 = i2;
      i2 = i8;
      i3 = i4;
      i4 = i10;
      i8 = i5;
      i5 = i1;
      i1 = i9;
      i10 = i16;
      break label441;
      while (i10 < i18)
      {
        this.L[i10] = 0;
        i10 += 1;
      }
      h();
      if (a()) {
        break;
      }
      this.M += 1;
      this.z = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_8888);
      localObject = new int[this.e * this.f];
      if (this.E > 0)
      {
        if (this.E == 3)
        {
          i1 = this.M - 2;
          if (i1 > 0) {
            this.A = a(i1 - 1);
          }
        }
        else
        {
          if (this.A == null) {
            break label1135;
          }
          this.A.getPixels((int[])localObject, 0, this.e, 0, 0, this.e, this.f);
          if (this.E != 2) {
            break label1135;
          }
          i2 = 0;
          if (!this.F) {
            i2 = this.n;
          }
          i3 = 0;
        }
        for (;;)
        {
          if (i3 >= this.y) {
            break label1135;
          }
          i4 = (this.w + i3) * this.e + this.v;
          i5 = this.x;
          i1 = i4;
          for (;;)
          {
            if (i1 < i5 + i4)
            {
              localObject[i1] = i2;
              i1 += 1;
              continue;
              this.A = null;
              break;
            }
          }
          i3 += 1;
        }
      }
      label1135:
      i5 = 1;
      i4 = 8;
      i6 = 0;
      i3 = 0;
      label1147:
      if (i3 < this.u)
      {
        if (!this.p) {
          break label1737;
        }
        i1 = i6;
        i2 = i4;
        i7 = i5;
        if (i6 >= this.u) {
          i7 = i5 + 1;
        }
        switch (i7)
        {
        default: 
          i2 = i4;
          i1 = i6;
          i6 = i1 + i2;
          i5 = i7;
        }
      }
      for (;;)
      {
        i1 += this.s;
        if (i1 < this.f)
        {
          i8 = this.e * i1;
          i7 = i8 + this.r;
          i4 = this.t + i7;
          i1 = i4;
          if (this.e + i8 < i4) {
            i1 = this.e + i8;
          }
          i4 = this.t * i3;
          for (;;)
          {
            if (i7 < i1)
            {
              i8 = this.L[i4];
              i8 = this.k[(i8 & 0xFF)];
              if (i8 != 0) {
                localObject[i7] = i8;
              }
              i7 += 1;
              i4 += 1;
              continue;
              i1 = 4;
              i2 = i4;
              break;
              i1 = 2;
              i2 = 4;
              break;
              i1 = 1;
              i2 = 2;
              break;
            }
          }
        }
        i3 += 1;
        i4 = i2;
        break label1147;
        this.z = Bitmap.createBitmap((int[])localObject, this.e, this.f, Bitmap.Config.ARGB_8888);
        localObject = this.b;
        Bitmap localBitmap = this.z;
        i1 = this.G;
        ((Vector)localObject).addElement(new a(localBitmap));
        if (this.F) {
          this.k[this.H] = i14;
        }
        this.E = this.D;
        this.v = this.r;
        this.w = this.s;
        this.x = this.t;
        this.y = this.u;
        this.A = this.z;
        this.n = this.m;
        this.D = 0;
        this.F = false;
        this.G = 0;
        this.j = null;
        break;
        switch (b())
        {
        default: 
          h();
          break;
        case 249: 
          b();
          i1 = b();
          this.D = ((i1 & 0x1C) >> 2);
          if (this.D == 0) {
            this.D = 1;
          }
          if ((i1 & 0x1) != 0) {}
          for (bool = true;; bool = false)
          {
            this.F = bool;
            this.G = (g() * 10);
            this.H = b();
            b();
            break;
          }
        case 255: 
          c();
          localObject = "";
          i1 = 0;
          while (i1 < 11)
          {
            localObject = (String)localObject + (char)this.B[i1];
            i1 += 1;
          }
          if (((String)localObject).equals("NETSCAPE2.0"))
          {
            f();
            break;
          }
          h();
          break;
          i13 = 1;
          break;
          return;
          label1737:
          i1 = i3;
          i2 = i4;
        }
      }
      label1745:
      i5 = i9;
      break label663;
      label1752:
      i16 = i8;
      i8 = i2;
      i9 = i4;
      i4 = i5;
      i2 = i1;
      i17 = i7;
      i5 = i16;
      i1 = i4;
      i7 = i8;
      i4 = i3;
      i3 = i17;
    }
  }
  
  private void e()
  {
    boolean bool = true;
    String str = "";
    int i1 = 0;
    while (i1 < 6)
    {
      str = str + (char)b();
      i1 += 1;
    }
    if (!str.startsWith("GIF"))
    {
      this.d = 1;
      return;
    }
    this.e = g();
    this.f = g();
    i1 = b();
    if ((i1 & 0x80) != 0) {}
    for (;;)
    {
      this.g = bool;
      this.h = (2 << (i1 & 0x7));
      this.l = b();
      b();
      if ((!this.g) || (a())) {
        break;
      }
      this.i = b(this.h);
      this.m = this.i[this.l];
      return;
      bool = false;
    }
  }
  
  private void f()
  {
    do
    {
      c();
      if (this.B[0] == 1)
      {
        byte[] arrayOfByte = this.B;
        arrayOfByte = this.B;
      }
    } while ((this.C > 0) && (!a()));
  }
  
  private int g()
  {
    return b() | b() << 8;
  }
  
  private void h()
  {
    do
    {
      c();
    } while ((this.C > 0) && (!a()));
  }
  
  public final int a(InputStream paramInputStream)
  {
    this.d = 0;
    this.M = 0;
    this.b = new Vector();
    this.i = null;
    this.j = null;
    if (paramInputStream != null)
    {
      this.c = paramInputStream;
      e();
      if (!a())
      {
        d();
        if (this.M < 0) {
          this.d = 1;
        }
      }
    }
    try
    {
      for (;;)
      {
        paramInputStream.close();
        return this.d;
        this.d = 2;
      }
    }
    catch (Exception paramInputStream)
    {
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  public final Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.M) {
        localObject1 = ((a)this.b.elementAt(paramInt)).a;
      }
    }
    return (Bitmap)localObject1;
  }
  
  static final class a
  {
    public Bitmap a;
    
    public a(Bitmap paramBitmap)
    {
      this.a = paramBitmap;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */