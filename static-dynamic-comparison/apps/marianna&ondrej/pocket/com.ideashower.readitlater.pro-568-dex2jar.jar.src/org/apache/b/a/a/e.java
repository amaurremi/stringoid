package org.apache.b.a.a;

import java.io.IOException;
import java.io.InputStream;
import org.apache.b.a.b.a;

public class e
  extends InputStream
{
  private final byte[] a = new byte[1];
  private final InputStream b;
  private final a c;
  private final a d;
  private final byte[] e;
  private int f = 0;
  private int g = 0;
  private boolean h;
  private final c i;
  
  protected e(int paramInt, InputStream paramInputStream, c paramc)
  {
    this.b = paramInputStream;
    this.e = new byte[paramInt];
    this.c = new a(512);
    this.d = new a(512);
    this.h = false;
    this.i = paramc;
  }
  
  public e(InputStream paramInputStream, c paramc)
  {
    this(2048, paramInputStream, paramc);
  }
  
  private int a()
  {
    int j = 0;
    if (this.f < this.g)
    {
      System.arraycopy(this.e, this.f, this.e, 0, this.g - this.f);
      this.g -= this.f;
    }
    for (this.f = 0;; this.f = 0)
    {
      int k = this.e.length - this.g;
      if (k > 0)
      {
        k = this.b.read(this.e, this.g, k);
        j = k;
        if (k > 0)
        {
          this.g += k;
          j = k;
        }
      }
      return j;
      this.g = 0;
    }
  }
  
  private int a(int paramInt)
  {
    if (this.f + paramInt < this.g) {
      return this.e[(this.f + paramInt)] & 0xFF;
    }
    return -1;
  }
  
  private int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int j = 0;
    if ((paramBoolean) && (this.d.c() > 0))
    {
      j = Math.min(this.d.c(), paramInt3 - paramInt2);
      System.arraycopy(this.d.d(), 0, paramArrayOfByte, paramInt2, j);
      int k = this.d.c() - j;
      if (k > 0) {
        this.c.a(this.d.d(), j, k);
      }
      this.d.a();
      paramInt2 += j;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        if (paramInt2 < paramInt3)
        {
          paramArrayOfByte[paramInt2] = ((byte)paramInt1);
          return paramInt2 + 1;
          if ((this.d.c() > 0) && (!paramBoolean))
          {
            StringBuilder localStringBuilder = new StringBuilder(this.d.c() * 3);
            while (j < this.d.c())
            {
              localStringBuilder.append(" " + this.d.b(j));
              j += 1;
            }
            if (this.i.a("ignored blanks", localStringBuilder.toString())) {
              throw new IOException("ignored blanks");
            }
          }
        }
        else
        {
          this.c.a(paramInt1);
        }
      }
      else {
        return paramInt2;
      }
    }
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    int n = paramInt1 + paramInt2;
    if (this.c.c() > 0)
    {
      paramInt2 = Math.min(this.c.c(), n - paramInt1);
      System.arraycopy(this.c.d(), 0, paramArrayOfByte, paramInt1, paramInt2);
      this.c.a(0, paramInt2);
      paramInt2 = paramInt1 + paramInt2;
    }
    for (;;)
    {
      if (paramInt2 < n)
      {
        if (this.g - this.f >= 3) {
          break label794;
        }
        if (a() == -1) {
          j = 1;
        }
      }
      label90:
      label134:
      label336:
      label794:
      for (int k = j;; k = j)
      {
        if ((this.g - this.f == 0) && (k != 0))
        {
          if (paramInt2 == paramInt1)
          {
            return -1;
            j = 0;
            break label90;
          }
          return paramInt2 - paramInt1;
        }
        int m = 0;
        j = paramInt2;
        paramInt2 = j;
        int i1;
        if (this.f < this.g)
        {
          paramInt2 = j;
          if (j < n)
          {
            byte[] arrayOfByte = this.e;
            paramInt2 = this.f;
            this.f = (paramInt2 + 1);
            i1 = arrayOfByte[paramInt2] & 0xFF;
            if ((m != 0) && (i1 != 10))
            {
              if (this.i.a("Found CR without LF", "Leaving it as is")) {
                throw new IOException("Found CR without LF");
              }
              paramInt2 = a(13, paramArrayOfByte, j, n, false);
            }
            for (;;)
            {
              if (i1 == 13)
              {
                m = 1;
                j = paramInt2;
                break;
                paramInt2 = j;
                if (m == 0)
                {
                  paramInt2 = j;
                  if (i1 == 10)
                  {
                    paramInt2 = j;
                    if (this.i.a("Found LF without CR", "Translating to CRLF")) {
                      throw new IOException("Found LF without CR");
                    }
                  }
                }
              }
            }
            if (i1 == 10) {
              if (this.d.c() == 0)
              {
                j = a(10, paramArrayOfByte, a(13, paramArrayOfByte, paramInt2, n, false), n, false);
                this.d.a();
                paramInt2 = j;
              }
            }
          }
        }
        for (;;)
        {
          m = 0;
          j = paramInt2;
          break label134;
          j = paramInt2;
          if (this.d.b(0) == 61) {
            break label336;
          }
          j = a(10, paramArrayOfByte, a(13, paramArrayOfByte, paramInt2, n, false), n, false);
          break label336;
          if (i1 == 61)
          {
            if ((this.g - this.f < 2) && (k == 0))
            {
              this.f -= 1;
              j = k;
              break;
            }
            m = b();
            if (m == 61)
            {
              paramInt2 = a(m, paramArrayOfByte, paramInt2, n, true);
              j = a(0);
              i1 = a(1);
              if ((j == 10) || ((j == 13) && (i1 == 10)))
              {
                this.i.a("Unexpected ==EOL encountered", "== 0x" + j + " 0x" + i1);
                this.d.a(m);
              }
            }
            for (;;)
            {
              break;
              this.i.a("Unexpected == encountered", "==");
              continue;
              if (Character.isWhitespace((char)m))
              {
                j = a(-1, paramArrayOfByte, paramInt2, n, true);
                paramInt2 = j;
                if (m != 10)
                {
                  this.d.a(i1);
                  this.d.a(m);
                  paramInt2 = j;
                }
              }
              else
              {
                j = b();
                i1 = b(m);
                int i2 = b(j);
                if ((i1 < 0) || (i2 < 0))
                {
                  this.i.a("Malformed encoded value encountered", "leaving =" + (char)m + (char)j + " as is");
                  paramInt2 = a(j, paramArrayOfByte, a(m, paramArrayOfByte, a(61, paramArrayOfByte, paramInt2, n, true), n, false), n, false);
                }
                else
                {
                  paramInt2 = a(i1 << 4 | i2, paramArrayOfByte, paramInt2, n, true);
                }
              }
            }
          }
          if (Character.isWhitespace(i1)) {
            this.d.a(i1);
          } else {
            paramInt2 = a(i1 & 0xFF, paramArrayOfByte, paramInt2, n, true);
          }
        }
        return n - paramInt1;
      }
      paramInt2 = paramInt1;
    }
  }
  
  private int b()
  {
    if (this.f < this.g)
    {
      int j = this.e[this.f];
      this.f += 1;
      return j & 0xFF;
    }
    return -1;
  }
  
  private int b(int paramInt)
  {
    if ((paramInt >= 48) && (paramInt <= 57)) {
      return paramInt - 48;
    }
    if ((paramInt >= 65) && (paramInt <= 70)) {
      return paramInt - 65 + 10;
    }
    if ((paramInt >= 97) && (paramInt <= 102)) {
      return paramInt - 97 + 10;
    }
    return -1;
  }
  
  public void close()
  {
    this.h = true;
  }
  
  public int read()
  {
    if (this.h) {
      throw new IOException("Stream has been closed");
    }
    int j;
    do
    {
      j = read(this.a, 0, 1);
      if (j == -1) {
        return -1;
      }
    } while (j != 1);
    return this.a[0] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.h) {
      throw new IOException("Stream has been closed");
    }
    return a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/b/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */