package org.apache.a.a.a;

public abstract class b
{
  private final int a;
  protected final byte b = 61;
  protected final int c;
  private final int d;
  private final int e;
  
  protected b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.d = paramInt2;
    if ((paramInt3 > 0) && (paramInt4 > 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        i = paramInt3 / paramInt2 * paramInt2;
      }
      this.c = i;
      this.e = paramInt4;
      return;
    }
  }
  
  private byte[] b(c paramc)
  {
    if (paramc.c == null)
    {
      paramc.c = new byte[a()];
      paramc.d = 0;
      paramc.e = 0;
    }
    for (;;)
    {
      return paramc.c;
      byte[] arrayOfByte = new byte[paramc.c.length * 2];
      System.arraycopy(paramc.c, 0, arrayOfByte, 0, paramc.c.length);
      paramc.c = arrayOfByte;
    }
  }
  
  protected int a()
  {
    return 8192;
  }
  
  int a(c paramc)
  {
    if (paramc.c != null) {
      return paramc.d - paramc.e;
    }
    return 0;
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, c paramc);
  
  protected abstract boolean a(byte paramByte);
  
  protected byte[] a(int paramInt, c paramc)
  {
    if ((paramc.c == null) || (paramc.c.length < paramc.d + paramInt)) {
      return b(paramc);
    }
    return paramc.c;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    c localc = new c();
    a(paramArrayOfByte, 0, paramArrayOfByte.length, localc);
    a(paramArrayOfByte, 0, -1, localc);
    paramArrayOfByte = new byte[localc.d - localc.e];
    b(paramArrayOfByte, 0, paramArrayOfByte.length, localc);
    return paramArrayOfByte;
  }
  
  int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, c paramc)
  {
    if (paramc.c != null)
    {
      paramInt2 = Math.min(a(paramc), paramInt2);
      System.arraycopy(paramc.c, paramc.e, paramArrayOfByte, paramInt1, paramInt2);
      paramc.e += paramInt2;
      if (paramc.e >= paramc.d) {
        paramc.c = null;
      }
      return paramInt2;
    }
    if (paramc.f) {
      return -1;
    }
    return 0;
  }
  
  protected boolean b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte b1 = paramArrayOfByte[i];
        if ((61 == b1) || (a(b1))) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */