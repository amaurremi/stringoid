package com.atomic.apps.ringtone.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class k
  extends h
{
  private int c;
  private int[] d;
  private int[] e;
  private int[] f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public final void a(File paramFile)
  {
    super.a(paramFile);
    this.h = ((int)this.b.length());
    if (this.h < 128) {
      throw new IOException("File too small to parse");
    }
    paramFile = new FileInputStream(this.b);
    byte[] arrayOfByte = new byte[12];
    paramFile.read(arrayOfByte, 0, 12);
    this.k += 12;
    if ((arrayOfByte[0] != 82) || (arrayOfByte[1] != 73) || (arrayOfByte[2] != 70) || (arrayOfByte[3] != 70) || (arrayOfByte[8] != 87) || (arrayOfByte[9] != 65) || (arrayOfByte[10] != 86) || (arrayOfByte[11] != 69)) {
      throw new IOException("Not a WAV file");
    }
    this.j = 0;
    this.i = 0;
    int i4;
    int m;
    int i2;
    label658:
    label737:
    for (;;)
    {
      if (this.k + 8 > this.h) {
        return;
      }
      arrayOfByte = new byte[8];
      paramFile.read(arrayOfByte, 0, 8);
      this.k += 8;
      i4 = (arrayOfByte[7] & 0xFF) << 24 | (arrayOfByte[6] & 0xFF) << 16 | (arrayOfByte[5] & 0xFF) << 8 | arrayOfByte[4] & 0xFF;
      int n;
      int i1;
      if ((arrayOfByte[0] == 102) && (arrayOfByte[1] == 109) && (arrayOfByte[2] == 116) && (arrayOfByte[3] == 32))
      {
        if ((i4 < 16) || (i4 > 1024)) {
          throw new IOException("WAV file has bad fmt chunk");
        }
        arrayOfByte = new byte[i4];
        paramFile.read(arrayOfByte, 0, i4);
        this.k += i4;
        m = arrayOfByte[1];
        n = arrayOfByte[0];
        this.j = ((arrayOfByte[3] & 0xFF) << 8 | arrayOfByte[2] & 0xFF);
        i1 = arrayOfByte[7];
        i2 = arrayOfByte[6];
        i3 = arrayOfByte[5];
        this.i = (arrayOfByte[4] & 0xFF | (i1 & 0xFF) << 24 | (i2 & 0xFF) << 16 | (i3 & 0xFF) << 8);
        if (((m & 0xFF) << 8 | n & 0xFF) != 1) {
          throw new IOException("Unsupported WAV file encoding");
        }
      }
      else
      {
        if ((arrayOfByte[0] != 100) || (arrayOfByte[1] != 97) || (arrayOfByte[2] != 116) || (arrayOfByte[3] != 97)) {
          break label772;
        }
        if ((this.j == 0) || (this.i == 0)) {
          throw new IOException("Bad WAV file: data chunk before fmt chunk");
        }
        this.g = (this.i * this.j / 50 << 1);
        this.c = ((this.g - 1 + i4) / this.g);
        this.d = new int[this.c];
        this.e = new int[this.c];
        this.f = new int[this.c];
        arrayOfByte = new byte[this.g];
        n = 0;
        m = 0;
        for (;;)
        {
          if (m >= i4) {
            break label737;
          }
          int i5 = this.g;
          i1 = m;
          if (m + i5 > i4) {
            i1 = i4 - i5;
          }
          paramFile.read(arrayOfByte, 0, i5);
          m = 0;
          i2 = 1;
          if (i2 < i5) {
            break label739;
          }
          this.d[n] = this.k;
          this.e[n] = i5;
          this.f[n] = m;
          this.k += i5;
          m = i1 + i5;
          if ((this.a != null) && (!this.a.a(m / i4))) {
            break;
          }
          n += 1;
        }
      }
    }
    label739:
    int i3 = Math.abs(arrayOfByte[i2]);
    if (i3 > m) {
      m = i3;
    }
    for (;;)
    {
      i2 = this.j * 4 + i2;
      break label658;
      label772:
      paramFile.skip(i4);
      this.k += i4;
      break;
    }
  }
  
  public final void a(File paramFile, int paramInt1, int paramInt2)
  {
    paramFile.createNewFile();
    FileInputStream localFileInputStream = new FileInputStream(this.b);
    paramFile = new FileOutputStream(paramFile);
    long l1 = 0L;
    int m = 0;
    byte[] arrayOfByte;
    int n;
    if (m >= paramInt2)
    {
      long l2 = 36L + l1;
      long l3 = this.i;
      long l4 = (this.i << 1) * this.j;
      paramFile.write(new byte[] { 82, 73, 70, 70, (byte)(int)(0xFF & l2), (byte)(int)(l2 >> 8 & 0xFF), (byte)(int)(l2 >> 16 & 0xFF), (byte)(int)(l2 >> 24 & 0xFF), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte)this.j, 0, (byte)(int)(0xFF & l3), (byte)(int)(l3 >> 8 & 0xFF), (byte)(int)(l3 >> 16 & 0xFF), (byte)(int)(l3 >> 24 & 0xFF), (byte)(int)(0xFF & l4), (byte)(int)(l4 >> 8 & 0xFF), (byte)(int)(l4 >> 16 & 0xFF), (byte)(int)(l4 >> 24 & 0xFF), (byte)(this.j * 2), 0, 16, 0, 100, 97, 116, 97, (byte)(int)(0xFF & l1), (byte)(int)(l1 >> 8 & 0xFF), (byte)(int)(l1 >> 16 & 0xFF), (byte)(int)(l1 >> 24 & 0xFF) }, 0, 44);
      arrayOfByte = new byte[this.g];
      m = 0;
      n = 0;
    }
    for (;;)
    {
      if (n >= paramInt2)
      {
        localFileInputStream.close();
        paramFile.close();
        return;
        l1 += this.e[(paramInt1 + m)];
        m += 1;
        break;
      }
      int i3 = this.d[(paramInt1 + n)] - m;
      int i2 = this.e[(paramInt1 + n)];
      int i1 = m;
      if (i3 >= 0)
      {
        i1 = m;
        if (i3 > 0)
        {
          localFileInputStream.skip(i3);
          i1 = m + i3;
        }
        localFileInputStream.read(arrayOfByte, 0, i2);
        paramFile.write(arrayOfByte, 0, i2);
        i1 += i2;
      }
      n += 1;
      m = i1;
    }
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.i / 50;
  }
  
  public final int[] d()
  {
    return this.f;
  }
  
  public final int e()
  {
    return (this.i * this.j << 1) / 1024;
  }
  
  public final int f()
  {
    return this.i;
  }
  
  public final String g()
  {
    return "WAV";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */