package org.apache.a.a.a;

public class a
  extends b
{
  static final byte[] a = { 13, 10 };
  private static final byte[] d = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] e = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] f = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  private final byte[] g;
  private final byte[] h;
  private final byte[] i;
  private final int j;
  private final int k;
  
  public a()
  {
    this(0);
  }
  
  public a(int paramInt)
  {
    this(paramInt, a);
  }
  
  public a(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, c paramc)
  {
    if (paramc.f) {}
    for (;;)
    {
      return;
      if (paramInt2 < 0)
      {
        paramc.f = true;
        if ((paramc.h != 0) || (this.c != 0))
        {
          paramArrayOfByte = a(this.k, paramc);
          paramInt1 = paramc.d;
          switch (paramc.h)
          {
          default: 
            throw new IllegalStateException("Impossible modulus " + paramc.h);
          case 1: 
            paramInt2 = paramc.d;
            paramc.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(paramc.a >> 2 & 0x3F)];
            paramInt2 = paramc.d;
            paramc.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(paramc.a << 4 & 0x3F)];
            if (this.g == d)
            {
              paramInt2 = paramc.d;
              paramc.d = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = 61;
              paramInt2 = paramc.d;
              paramc.d = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = 61;
            }
            break;
          }
          for (;;)
          {
            paramInt2 = paramc.g;
            paramc.g = (paramc.d - paramInt1 + paramInt2);
            if ((this.c <= 0) || (paramc.g <= 0)) {
              break;
            }
            System.arraycopy(this.i, 0, paramArrayOfByte, paramc.d, this.i.length);
            paramc.d += this.i.length;
            return;
            paramInt2 = paramc.d;
            paramc.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(paramc.a >> 10 & 0x3F)];
            paramInt2 = paramc.d;
            paramc.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(paramc.a >> 4 & 0x3F)];
            paramInt2 = paramc.d;
            paramc.d = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = this.g[(paramc.a << 2 & 0x3F)];
            if (this.g == d)
            {
              paramInt2 = paramc.d;
              paramc.d = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = 61;
            }
          }
        }
      }
      else
      {
        int m = 0;
        while (m < paramInt2)
        {
          byte[] arrayOfByte = a(this.k, paramc);
          paramc.h = ((paramc.h + 1) % 3);
          int i1 = paramArrayOfByte[paramInt1];
          int n = i1;
          if (i1 < 0) {
            n = i1 + 256;
          }
          paramc.a = (n + (paramc.a << 8));
          if (paramc.h == 0)
          {
            n = paramc.d;
            paramc.d = (n + 1);
            arrayOfByte[n] = this.g[(paramc.a >> 18 & 0x3F)];
            n = paramc.d;
            paramc.d = (n + 1);
            arrayOfByte[n] = this.g[(paramc.a >> 12 & 0x3F)];
            n = paramc.d;
            paramc.d = (n + 1);
            arrayOfByte[n] = this.g[(paramc.a >> 6 & 0x3F)];
            n = paramc.d;
            paramc.d = (n + 1);
            arrayOfByte[n] = this.g[(paramc.a & 0x3F)];
            paramc.g += 4;
            if ((this.c > 0) && (this.c <= paramc.g))
            {
              System.arraycopy(this.i, 0, arrayOfByte, paramc.d, this.i.length);
              paramc.d += this.i.length;
              paramc.g = 0;
            }
          }
          m += 1;
          paramInt1 += 1;
        }
      }
    }
  }
  
  protected boolean a(byte paramByte)
  {
    return (paramByte >= 0) && (paramByte < this.h.length) && (this.h[paramByte] != -1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */