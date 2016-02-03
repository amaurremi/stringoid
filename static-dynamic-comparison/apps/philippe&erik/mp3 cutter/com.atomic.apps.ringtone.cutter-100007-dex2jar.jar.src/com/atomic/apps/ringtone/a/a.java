package com.atomic.apps.ringtone.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;

public final class a
  extends h
{
  private static int[] c = { 1684631142, 1751411826, 1835296868, 1835297121, 1835626086, 1836019574, 1836476516, 1936549988, 1937007212, 1937011556, 1937011578, 1937011827, 1953196132, 1953653099 };
  private static int[] d = { 1684631142, 1751411826, 1835296868, 1836476516, 1936549988, 1953196132, 1937011556 };
  private int e;
  private int[] f;
  private int[] g;
  private int[] h;
  private int i;
  private HashMap j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  
  public static i a()
  {
    return new b();
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    c localc2 = (c)this.j.get(Integer.valueOf(paramInt));
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c(this);
      this.j.put(Integer.valueOf(paramInt), localc1);
    }
    localc1.a = (paramArrayOfByte.length + 8);
    localc1.b = paramArrayOfByte;
  }
  
  private void a(FileOutputStream paramFileOutputStream, int paramInt)
  {
    int i1 = ((c)this.j.get(Integer.valueOf(paramInt))).a;
    paramFileOutputStream.write(new byte[] { (byte)(i1 >>> 24), (byte)(i1 >> 16), (byte)(i1 >> 8), (byte)i1, (byte)(paramInt >>> 24), (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt }, 0, 8);
  }
  
  private void a(InputStream paramInputStream, int paramInt)
  {
    if (paramInt <= 8) {
      return;
    }
    int i3 = this.m;
    Object localObject = new byte[8];
    paramInputStream.read((byte[])localObject, 0, 8);
    int i1 = (localObject[0] & 0xFF) << 24 | (localObject[1] & 0xFF) << 16 | (localObject[2] & 0xFF) << 8 | localObject[3] & 0xFF;
    if (i1 > paramInt) {
      i1 = paramInt;
    }
    for (;;)
    {
      int i4 = (localObject[4] & 0xFF) << 24 | (localObject[5] & 0xFF) << 16 | (localObject[6] & 0xFF) << 8 | localObject[7] & 0xFF;
      localObject = new c(this);
      int i2 = this.m;
      ((c)localObject).a = i1;
      this.j.put(Integer.valueOf(i4), localObject);
      this.m += 8;
      if ((i4 == 1836019574) || (i4 == 1953653099) || (i4 == 1835297121) || (i4 == 1835626086) || (i4 == 1937007212)) {
        a(paramInputStream, i1);
      }
      for (;;)
      {
        if (i4 == 1937011556)
        {
          localObject = ((c)this.j.get(Integer.valueOf(1937011556))).b;
          i2 = localObject[40];
          this.k = (localObject[41] & 0xFF | (i2 & 0xFF) << 8);
        }
        paramInt -= i1;
        i1 -= this.m - i3;
        if (i1 >= 0) {
          break;
        }
        throw new IOException("Went over by " + -i1 + " bytes");
        int i5;
        int i6;
        if (i4 == 1937011578)
        {
          localObject = new byte[12];
          paramInputStream.read((byte[])localObject, 0, 12);
          this.m += 12;
          i2 = localObject[8];
          i5 = localObject[9];
          i6 = localObject[10];
          this.e = (localObject[11] & 0xFF | (i2 & 0xFF) << 24 | (i5 & 0xFF) << 16 | (i6 & 0xFF) << 8);
          this.f = new int[this.e];
          this.g = new int[this.e];
          this.h = new int[this.e];
          localObject = new byte[this.e * 4];
          paramInputStream.read((byte[])localObject, 0, this.e * 4);
          this.m += this.e * 4;
          i2 = 0;
          while (i2 < this.e)
          {
            this.g[i2] = ((localObject[(i2 * 4)] & 0xFF) << 24 | (localObject[(i2 * 4 + 1)] & 0xFF) << 16 | (localObject[(i2 * 4 + 2)] & 0xFF) << 8 | localObject[(i2 * 4 + 3)] & 0xFF);
            i2 += 1;
          }
        }
        else if (i4 == 1937011827)
        {
          localObject = new byte[16];
          paramInputStream.read((byte[])localObject, 0, 16);
          this.m += 16;
          i2 = localObject[12];
          i5 = localObject[13];
          i6 = localObject[14];
          this.l = (localObject[15] & 0xFF | (i2 & 0xFF) << 24 | (i5 & 0xFF) << 16 | (i6 & 0xFF) << 8);
        }
        else if (i4 == 1835295092)
        {
          this.p = this.m;
          this.q = (i1 - 8);
        }
        else
        {
          localObject = d;
          i5 = localObject.length;
          i2 = 0;
          while (i2 < i5)
          {
            if (localObject[i2] == i4)
            {
              byte[] arrayOfByte = new byte[i1 - 8];
              paramInputStream.read(arrayOfByte, 0, i1 - 8);
              this.m += i1 - 8;
              ((c)this.j.get(Integer.valueOf(i4))).b = arrayOfByte;
            }
            i2 += 1;
          }
        }
      }
      paramInputStream.skip(i1);
      this.m = (i1 + this.m);
      break;
    }
  }
  
  private void b(FileOutputStream paramFileOutputStream, int paramInt)
  {
    c localc = (c)this.j.get(Integer.valueOf(paramInt));
    a(paramFileOutputStream, paramInt);
    paramFileOutputStream.write(localc.b, 0, localc.a - 8);
  }
  
  private void b(InputStream paramInputStream, int paramInt)
  {
    int i8 = this.m;
    int i2 = 0;
    if (i2 >= this.e) {
      label18:
      return;
    }
    this.f[i2] = this.m;
    if (this.m - i8 + this.g[i2] > paramInt - 8) {
      this.h[i2] = 0;
    }
    for (;;)
    {
      if (this.h[i2] < this.n) {
        this.n = this.h[i2];
      }
      if (this.h[i2] > this.o) {
        this.o = this.h[i2];
      }
      if ((this.a != null) && (!this.a.a(this.m / this.i))) {
        break label18;
      }
      i2 += 1;
      break;
      if (this.g[i2] >= 4) {
        break label184;
      }
      this.h[i2] = 0;
      paramInputStream.skip(this.g[i2]);
    }
    label184:
    int i9 = this.m;
    byte[] arrayOfByte1 = new byte[4];
    paramInputStream.read(arrayOfByte1, 0, 4);
    this.m += 4;
    int i1;
    int i3;
    int i4;
    int i5;
    label408:
    int i6;
    switch ((arrayOfByte1[0] & 0xE0) >> 5)
    {
    default: 
      if (i2 > 0) {
        this.h[i2] = this.h[(i2 - 1)];
      }
      break;
    case 0: 
      for (;;)
      {
        i1 = this.g[i2] - (this.m - i9);
        paramInputStream.skip(i1);
        this.m = (i1 + this.m);
        break;
        i1 = arrayOfByte1[0];
        i3 = arrayOfByte1[1];
        this.h[i2] = ((i1 & 0x1) << 7 | (i3 & 0xFE) >> 1);
      }
    case 1: 
      if ((arrayOfByte1[1] & 0x60) >> 5 == 2)
      {
        i4 = arrayOfByte1[1];
        i3 = arrayOfByte1[2];
        i5 = (arrayOfByte1[2] & 0x1) << 1 | (arrayOfByte1[3] & 0x80) >> 7;
        i1 = 25;
        i4 &= 0xF;
        i3 = (i3 & 0xFE) >> 1;
        if (i5 != 1) {
          break label685;
        }
        i6 = 0;
        i5 = 0;
        label420:
        if (i5 < 7) {
          break label587;
        }
        i1 = (i6 + 1) * i4 + i1;
      }
      break;
    }
    label587:
    label685:
    for (;;)
    {
      i3 = (i1 + 7) / 8 + 1;
      byte[] arrayOfByte2 = new byte[i3];
      arrayOfByte2[0] = arrayOfByte1[0];
      arrayOfByte2[1] = arrayOfByte1[1];
      arrayOfByte2[2] = arrayOfByte1[2];
      arrayOfByte2[3] = arrayOfByte1[3];
      paramInputStream.read(arrayOfByte2, 4, i3 - 4);
      this.m = (i3 - 4 + this.m);
      i4 = 0;
      i3 = 0;
      for (;;)
      {
        if (i3 >= 8)
        {
          this.h[i2] = i4;
          break;
          i3 = arrayOfByte1[1];
          i4 = arrayOfByte1[2];
          i5 = (arrayOfByte1[2] & 0x18) >> 3;
          i1 = 21;
          i4 = (i3 & 0xF) << 2 | (i4 & 0xC0) >> 6;
          i3 = -1;
          break label408;
          int i7 = i6;
          if ((1 << i5 & i3) == 0) {
            i7 = i6 + 1;
          }
          i5 += 1;
          i6 = i7;
          break label420;
        }
        i5 = (i3 + i1) / 8;
        i6 = 7 - (i3 + i1) % 8;
        i4 += ((arrayOfByte2[i5] & 1 << i6) >> i6 << 7 - i3);
        i3 += 1;
      }
      this.h[i2] = 0;
      break;
    }
  }
  
  public final void a(File paramFile)
  {
    int i2 = 0;
    super.a(paramFile);
    this.k = 0;
    this.l = 0;
    this.e = 0;
    this.n = 255;
    this.o = 0;
    this.m = 0;
    this.p = -1;
    this.q = -1;
    this.j = new HashMap();
    this.i = ((int)this.b.length());
    if (this.i < 128) {
      throw new IOException("File too small to parse");
    }
    paramFile = new FileInputStream(this.b);
    byte[] arrayOfByte = new byte[8];
    paramFile.read(arrayOfByte, 0, 8);
    int i3;
    int i1;
    if ((arrayOfByte[0] == 0) && (arrayOfByte[4] == 102) && (arrayOfByte[5] == 116) && (arrayOfByte[6] == 121) && (arrayOfByte[7] == 112))
    {
      a(new FileInputStream(this.b), this.i);
      if ((this.p <= 0) || (this.q <= 0)) {
        break label277;
      }
      paramFile = new FileInputStream(this.b);
      paramFile.skip(this.p);
      this.m = this.p;
      b(paramFile, this.q);
      paramFile = c;
      i3 = paramFile.length;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i3)
      {
        if (i2 == 0) {
          break;
        }
        throw new IOException("Could not parse MP4 file");
        throw new IOException("Unknown file format");
        label277:
        throw new IOException("Didn't find mdat");
      }
      int i4 = paramFile[i1];
      if (!this.j.containsKey(Integer.valueOf(i4)))
      {
        System.out.println("Missing atom: " + new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append((char)(i4 >>> 24)).toString())).append((char)(i4 >> 16 & 0xFF)).toString())).append((char)(i4 >> 8 & 0xFF)).toString())).append((char)(i4 & 0xFF)).toString());
        i2 = 1;
      }
      i1 += 1;
    }
  }
  
  public final void a(File paramFile, int paramInt1, int paramInt2)
  {
    paramFile.createNewFile();
    FileInputStream localFileInputStream = new FileInputStream(this.b);
    paramFile = new FileOutputStream(paramFile);
    Object localObject = new byte[24];
    localObject[0] = 77;
    localObject[1] = 52;
    localObject[2] = 65;
    localObject[3] = 32;
    localObject[8] = 77;
    localObject[9] = 52;
    localObject[10] = 65;
    localObject[11] = 32;
    localObject[12] = 109;
    localObject[13] = 112;
    localObject[14] = 52;
    localObject[15] = 50;
    localObject[16] = 105;
    localObject[17] = 115;
    localObject[18] = 111;
    localObject[19] = 109;
    a(1718909296, (byte[])localObject);
    localObject = new byte[16];
    localObject[7] = 1;
    localObject[8] = ((byte)(paramInt2 >>> 24));
    localObject[9] = ((byte)(paramInt2 >> 16));
    localObject[10] = ((byte)(paramInt2 >> 8));
    localObject[11] = ((byte)paramInt2);
    localObject[12] = ((byte)(this.l >>> 24));
    localObject[13] = ((byte)(this.l >> 16));
    localObject[14] = ((byte)(this.l >> 8));
    localObject[15] = ((byte)this.l);
    a(1937011827, (byte[])localObject);
    localObject = new byte[20];
    localObject[7] = 1;
    localObject[11] = 1;
    localObject[12] = ((byte)(paramInt2 >>> 24));
    localObject[13] = ((byte)(paramInt2 >> 16));
    localObject[14] = ((byte)(paramInt2 >> 8));
    localObject[15] = ((byte)paramInt2);
    localObject[19] = 1;
    a(1937011555, (byte[])localObject);
    localObject = new byte[paramInt2 * 4 + 12];
    localObject[8] = ((byte)(paramInt2 >>> 24));
    localObject[9] = ((byte)(paramInt2 >> 16));
    localObject[10] = ((byte)(paramInt2 >> 8));
    localObject[11] = ((byte)paramInt2);
    int i1 = 0;
    int i2;
    int i3;
    int i4;
    int i5;
    if (i1 >= paramInt2)
    {
      a(1937011578, (byte[])localObject);
      i1 = ((c)this.j.get(Integer.valueOf(1937011556))).a;
      i2 = ((c)this.j.get(Integer.valueOf(1937011555))).a;
      i3 = ((c)this.j.get(Integer.valueOf(1836476516))).a;
      i4 = ((c)this.j.get(Integer.valueOf(1953196132))).a;
      i5 = ((c)this.j.get(Integer.valueOf(1835296868))).a;
      int i6 = ((c)this.j.get(Integer.valueOf(1751411826))).a;
      int i7 = ((c)this.j.get(Integer.valueOf(1936549988))).a;
      i1 = ((c)this.j.get(Integer.valueOf(1684631142))).a + (paramInt2 * 4 + 144 + i1 + i2 + i3 + i4 + i5 + i6 + i7);
      localObject = new byte[12];
      localObject[7] = 1;
      localObject[8] = ((byte)(i1 >>> 24));
      localObject[9] = ((byte)(i1 >> 16));
      localObject[10] = ((byte)(i1 >> 8));
      localObject[11] = ((byte)i1);
      a(1937007471, (byte[])localObject);
      localObject = (c)this.j.get(Integer.valueOf(1937007212));
      i1 = ((c)this.j.get(Integer.valueOf(1937011556))).a;
      i2 = ((c)this.j.get(Integer.valueOf(1937011827))).a;
      i3 = ((c)this.j.get(Integer.valueOf(1937011555))).a;
      i4 = ((c)this.j.get(Integer.valueOf(1937011578))).a;
      ((c)localObject).a = (((c)this.j.get(Integer.valueOf(1937007471))).a + (i1 + 8 + i2 + i3 + i4));
      localObject = (c)this.j.get(Integer.valueOf(1835626086));
      i1 = ((c)this.j.get(Integer.valueOf(1684631142))).a;
      i2 = ((c)this.j.get(Integer.valueOf(1936549988))).a;
      ((c)localObject).a = (((c)this.j.get(Integer.valueOf(1937007212))).a + (i1 + 8 + i2));
      localObject = (c)this.j.get(Integer.valueOf(1835297121));
      i1 = ((c)this.j.get(Integer.valueOf(1835296868))).a;
      i2 = ((c)this.j.get(Integer.valueOf(1751411826))).a;
      ((c)localObject).a = (((c)this.j.get(Integer.valueOf(1835626086))).a + (i1 + 8 + i2));
      localObject = (c)this.j.get(Integer.valueOf(1953653099));
      i1 = ((c)this.j.get(Integer.valueOf(1953196132))).a;
      ((c)localObject).a = (((c)this.j.get(Integer.valueOf(1835297121))).a + (i1 + 8));
      localObject = (c)this.j.get(Integer.valueOf(1836019574));
      i1 = ((c)this.j.get(Integer.valueOf(1836476516))).a;
      ((c)localObject).a = (((c)this.j.get(Integer.valueOf(1953653099))).a + (i1 + 8));
      i1 = 0;
      i2 = 8;
      label1090:
      if (i1 < paramInt2) {
        break label1380;
      }
      ((c)this.j.get(Integer.valueOf(1835295092))).a = i2;
      b(paramFile, 1718909296);
      a(paramFile, 1836019574);
      b(paramFile, 1836476516);
      a(paramFile, 1953653099);
      b(paramFile, 1953196132);
      a(paramFile, 1835297121);
      b(paramFile, 1835296868);
      b(paramFile, 1751411826);
      a(paramFile, 1835626086);
      b(paramFile, 1684631142);
      b(paramFile, 1936549988);
      a(paramFile, 1937007212);
      b(paramFile, 1937011556);
      b(paramFile, 1937011827);
      b(paramFile, 1937011555);
      b(paramFile, 1937011578);
      b(paramFile, 1937007471);
      a(paramFile, 1835295092);
      i2 = 0;
      i1 = 0;
      label1248:
      if (i1 < paramInt2) {
        break label1403;
      }
      localObject = new byte[i2];
      i2 = 0;
    }
    for (i1 = 0;; i1 = i3)
    {
      if (i2 >= paramInt2)
      {
        localFileInputStream.close();
        paramFile.close();
        return;
        localObject[(i1 * 4 + 12)] = ((byte)(this.g[(paramInt1 + i1)] >>> 24));
        localObject[(i1 * 4 + 13)] = ((byte)(this.g[(paramInt1 + i1)] >> 16));
        localObject[(i1 * 4 + 14)] = ((byte)(this.g[(paramInt1 + i1)] >> 8));
        localObject[(i1 * 4 + 15)] = ((byte)this.g[(paramInt1 + i1)]);
        i1 += 1;
        break;
        label1380:
        i2 += this.g[(paramInt1 + i1)];
        i1 += 1;
        break label1090;
        label1403:
        i3 = i2;
        if (this.g[(paramInt1 + i1)] > i2) {
          i3 = this.g[(paramInt1 + i1)];
        }
        i1 += 1;
        i2 = i3;
        break label1248;
      }
      i5 = this.f[(paramInt1 + i2)] - i1;
      i4 = this.g[(paramInt1 + i2)];
      i3 = i1;
      if (i5 >= 0)
      {
        i3 = i1;
        if (i5 > 0)
        {
          localFileInputStream.skip(i5);
          i3 = i1 + i5;
        }
        localFileInputStream.read((byte[])localObject, 0, i4);
        paramFile.write((byte[])localObject, 0, i4);
        i3 += i4;
      }
      i2 += 1;
    }
  }
  
  public final int b()
  {
    return this.e;
  }
  
  public final int c()
  {
    return this.l;
  }
  
  public final int[] d()
  {
    return this.h;
  }
  
  public final int e()
  {
    return this.i / (this.e * this.l);
  }
  
  public final int f()
  {
    return this.k;
  }
  
  public final String g()
  {
    return "AAC";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */