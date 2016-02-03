package com.atomic.apps.ringtone.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class f
  extends h
{
  private static int[] n;
  private static int[] o;
  private static int[] p;
  private static int[] q;
  private int c;
  private int[] d;
  private int[] e;
  private int[] f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  static
  {
    int[] arrayOfInt = new int[16];
    arrayOfInt[1] = 32;
    arrayOfInt[2] = 40;
    arrayOfInt[3] = 48;
    arrayOfInt[4] = 56;
    arrayOfInt[5] = 64;
    arrayOfInt[6] = 80;
    arrayOfInt[7] = 96;
    arrayOfInt[8] = 112;
    arrayOfInt[9] = 128;
    arrayOfInt[10] = 160;
    arrayOfInt[11] = 192;
    arrayOfInt[12] = 224;
    arrayOfInt[13] = 256;
    arrayOfInt[14] = 320;
    n = arrayOfInt;
    arrayOfInt = new int[16];
    arrayOfInt[1] = 8;
    arrayOfInt[2] = 16;
    arrayOfInt[3] = 24;
    arrayOfInt[4] = 32;
    arrayOfInt[5] = 40;
    arrayOfInt[6] = 48;
    arrayOfInt[7] = 56;
    arrayOfInt[8] = 64;
    arrayOfInt[9] = 80;
    arrayOfInt[10] = 96;
    arrayOfInt[11] = 112;
    arrayOfInt[12] = 128;
    arrayOfInt[13] = 144;
    arrayOfInt[14] = 160;
    o = arrayOfInt;
    arrayOfInt = new int[4];
    arrayOfInt[0] = 44100;
    arrayOfInt[1] = 48000;
    arrayOfInt[2] = 32000;
    p = arrayOfInt;
    arrayOfInt = new int[4];
    arrayOfInt[0] = 22050;
    arrayOfInt[1] = 24000;
    arrayOfInt[2] = 16000;
    q = arrayOfInt;
  }
  
  public static i a()
  {
    return new g();
  }
  
  public final int a(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    if (paramInt >= this.c) {
      return this.g;
    }
    return this.d[paramInt];
  }
  
  public final void a(File paramFile)
  {
    super.a(paramFile);
    this.c = 0;
    this.j = 64;
    this.d = new int[this.j];
    this.e = new int[this.j];
    this.f = new int[this.j];
    this.k = 0;
    this.l = 255;
    this.m = 0;
    this.g = ((int)this.b.length());
    paramFile = new FileInputStream(this.b);
    int i2 = 0;
    int i1 = 0;
    byte[] arrayOfByte = new byte[12];
    if (i2 >= this.g - 12) {}
    while (this.c > 0)
    {
      this.h = (this.k / this.c);
      return;
      do
      {
        i1 += paramFile.read(arrayOfByte, i1, 12 - i1);
      } while (i1 < 12);
      i1 = 0;
      label151:
      int i3;
      if ((i1 >= 12) || (arrayOfByte[i1] == -1))
      {
        if ((this.a != null) && (!this.a.a(i2 / this.g))) {
          continue;
        }
        if (i1 > 0) {
          i3 = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (i3 >= 12 - i1)
          {
            i2 += i1;
            i1 = 12 - i1;
            break;
            i1 += 1;
            break label151;
          }
          arrayOfByte[i3] = arrayOfByte[(i1 + i3)];
          i3 += 1;
        }
      }
      label268:
      int i4;
      if ((arrayOfByte[1] == -6) || (arrayOfByte[1] == -5))
      {
        i1 = 1;
        if (i1 != 1) {
          break label390;
        }
        i4 = n[((arrayOfByte[2] & 0xF0) >> 4)];
        i3 = p[((arrayOfByte[2] & 0xC) >> 2)];
        label304:
        if ((i4 != 0) && (i3 != 0)) {
          break label441;
        }
        i1 = 0;
      }
      for (;;)
      {
        if (i1 >= 10)
        {
          i2 += 2;
          i1 = 10;
          break;
          if ((arrayOfByte[1] == -14) || (arrayOfByte[1] == -13))
          {
            i1 = 2;
            break label268;
          }
          i1 = 0;
          for (;;)
          {
            if (i1 >= 11)
            {
              i2 += 1;
              i1 = 11;
              break;
            }
            arrayOfByte[i1] = arrayOfByte[(i1 + 1)];
            i1 += 1;
          }
          label390:
          i4 = o[((arrayOfByte[2] & 0xF0) >> 4)];
          i3 = q[((arrayOfByte[2] & 0xC) >> 2)];
          break label304;
        }
        arrayOfByte[i1] = arrayOfByte[(i1 + 2)];
        i1 += 1;
      }
      label441:
      this.i = i3;
      int i5 = arrayOfByte[2];
      i5 = i4 * 144 * 1000 / i3 + ((i5 & 0x2) >> 1);
      label517:
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      int[] arrayOfInt3;
      if ((arrayOfByte[3] & 0xC0) == 192) {
        if (i1 == 1)
        {
          i1 = ((arrayOfByte[10] & 0x1) << 7) + ((arrayOfByte[11] & 0xFE) >> 1);
          this.k = (i4 + this.k);
          this.d[this.c] = i2;
          this.e[this.c] = i5;
          this.f[this.c] = i1;
          if (i1 < this.l) {
            this.l = i1;
          }
          if (i1 > this.m) {
            this.m = i1;
          }
          this.c += 1;
          if (this.c == this.j)
          {
            this.h = (this.k / this.c);
            i3 = this.g / this.h * i3 / 144000 * 11 / 10;
            i1 = i3;
            if (i3 < this.j << 1) {
              i1 = this.j << 1;
            }
            arrayOfInt1 = new int[i1];
            arrayOfInt2 = new int[i1];
            arrayOfInt3 = new int[i1];
            i3 = 0;
          }
        }
      }
      for (;;)
      {
        if (i3 >= this.c)
        {
          this.d = arrayOfInt1;
          this.e = arrayOfInt2;
          this.f = arrayOfInt3;
          this.j = i1;
          paramFile.skip(i5 - 12);
          i2 += i5;
          i1 = 0;
          break;
          i1 = ((arrayOfByte[9] & 0x3) << 6) + ((arrayOfByte[10] & 0xFC) >> 2);
          break label517;
          if (i1 == 1)
          {
            i1 = ((arrayOfByte[9] & 0x7F) << 1) + ((arrayOfByte[10] & 0x80) >> 7);
            break label517;
          }
          i1 = 0;
          break label517;
        }
        arrayOfInt1[i3] = this.d[i3];
        arrayOfInt2[i3] = this.e[i3];
        arrayOfInt3[i3] = this.f[i3];
        i3 += 1;
      }
    }
    this.h = 0;
  }
  
  public final void a(File paramFile, int paramInt1, int paramInt2)
  {
    paramFile.createNewFile();
    FileInputStream localFileInputStream = new FileInputStream(this.b);
    paramFile = new FileOutputStream(paramFile);
    int i1 = 0;
    int i2 = 0;
    byte[] arrayOfByte;
    if (i1 >= paramInt2)
    {
      arrayOfByte = new byte[i2];
      i2 = 0;
    }
    int i3;
    int i4;
    for (i1 = 0;; i1 = i3 + i4)
    {
      if (i2 >= paramInt2)
      {
        localFileInputStream.close();
        paramFile.close();
        return;
        i3 = i2;
        if (this.e[(paramInt1 + i1)] > i2) {
          i3 = this.e[(paramInt1 + i1)];
        }
        i1 += 1;
        i2 = i3;
        break;
      }
      int i5 = this.d[(paramInt1 + i2)] - i1;
      i4 = this.e[(paramInt1 + i2)];
      i3 = i1;
      if (i5 > 0)
      {
        localFileInputStream.skip(i5);
        i3 = i1 + i5;
      }
      localFileInputStream.read(arrayOfByte, 0, i4);
      paramFile.write(arrayOfByte, 0, i4);
      i2 += 1;
    }
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return 1152;
  }
  
  public final int[] d()
  {
    return this.f;
  }
  
  public final int e()
  {
    return this.h;
  }
  
  public final int f()
  {
    return this.i;
  }
  
  public final String g()
  {
    return "MP3";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */