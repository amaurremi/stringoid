package org.b.a.a;

import java.nio.ByteBuffer;

public abstract class b
{
  private boolean a(byte paramByte)
  {
    return (paramByte & 0x80) == 0;
  }
  
  private boolean b(byte paramByte)
  {
    paramByte &= 0xFF;
    return (paramByte < 65) || ((paramByte > 90) && (paramByte < 97)) || (paramByte > 122);
  }
  
  public abstract String a();
  
  public abstract c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract float b();
  
  public ByteBuffer b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2);
    int m = paramInt1;
    int k = 0;
    int i = paramInt1;
    int n = i;
    if (n < paramInt1 + paramInt2)
    {
      byte b = paramArrayOfByte[n];
      int j;
      if (!a(b))
      {
        j = 1;
        i = m;
      }
      for (;;)
      {
        n += 1;
        m = i;
        k = j;
        i = n;
        break;
        i = m;
        j = k;
        if (b(b)) {
          if ((k != 0) && (n > m))
          {
            localByteBuffer.put(paramArrayOfByte, m, n - m);
            localByteBuffer.put((byte)32);
            i = n + 1;
            j = 0;
          }
          else
          {
            i = n + 1;
            j = k;
          }
        }
      }
    }
    if ((k != 0) && (n > m)) {
      localByteBuffer.put(paramArrayOfByte, m, n - m);
    }
    return localByteBuffer;
  }
  
  public ByteBuffer c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2);
    int k = paramInt1;
    int m = 0;
    int i = paramInt1;
    int n = i;
    if (n < paramInt1 + paramInt2)
    {
      byte b = paramArrayOfByte[n];
      if (b == 62)
      {
        i = 0;
        label43:
        j = k;
        if (a(b))
        {
          j = k;
          if (b(b))
          {
            if ((n <= k) || (i != 0)) {
              break label147;
            }
            localByteBuffer.put(paramArrayOfByte, k, n - k);
            localByteBuffer.put((byte)32);
          }
        }
      }
      label147:
      for (int j = n + 1;; j = n + 1)
      {
        n += 1;
        m = i;
        k = j;
        i = n;
        break;
        i = m;
        if (b != 60) {
          break label43;
        }
        i = 1;
        break label43;
      }
    }
    if ((m == 0) && (n > k)) {
      localByteBuffer.put(paramArrayOfByte, k, n - k);
    }
    return localByteBuffer;
  }
  
  public abstract c c();
  
  public abstract void d();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */