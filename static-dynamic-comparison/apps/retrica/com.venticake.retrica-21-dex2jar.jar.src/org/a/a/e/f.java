package org.a.a.e;

import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;
import org.a.a.i;

final class f
  extends i
{
  private final long[] b;
  private final int[] c;
  private final int[] d;
  private final String[] e;
  private final d f;
  
  private f(String paramString, long[] paramArrayOfLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString, d paramd)
  {
    super(paramString);
    this.b = paramArrayOfLong;
    this.c = paramArrayOfInt1;
    this.d = paramArrayOfInt2;
    this.e = paramArrayOfString;
    this.f = paramd;
  }
  
  static f a(DataInput paramDataInput, String paramString)
  {
    int k = paramDataInput.readUnsignedShort();
    Object localObject = new String[k];
    int i = 0;
    while (i < k)
    {
      localObject[i] = paramDataInput.readUTF();
      i += 1;
    }
    int m = paramDataInput.readInt();
    long[] arrayOfLong = new long[m];
    int[] arrayOfInt1 = new int[m];
    int[] arrayOfInt2 = new int[m];
    String[] arrayOfString = new String[m];
    i = 0;
    for (;;)
    {
      int j;
      if (i < m)
      {
        arrayOfLong[i] = c.a(paramDataInput);
        arrayOfInt1[i] = ((int)c.a(paramDataInput));
        arrayOfInt2[i] = ((int)c.a(paramDataInput));
        if (k < 256) {}
        try
        {
          j = paramDataInput.readUnsignedByte();
        }
        catch (ArrayIndexOutOfBoundsException paramDataInput)
        {
          throw new IOException("Invalid encoding");
        }
        j = paramDataInput.readUnsignedShort();
      }
      else
      {
        localObject = null;
        if (paramDataInput.readBoolean()) {
          localObject = d.a(paramDataInput, paramString);
        }
        return new f(paramString, arrayOfLong, arrayOfInt1, arrayOfInt2, arrayOfString, (d)localObject);
      }
      arrayOfString[i] = localObject[j];
      i += 1;
    }
  }
  
  public String a(long paramLong)
  {
    long[] arrayOfLong = this.b;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    if (i >= 0) {
      return this.e[i];
    }
    i ^= 0xFFFFFFFF;
    if (i < arrayOfLong.length)
    {
      if (i > 0) {
        return this.e[(i - 1)];
      }
      return "UTC";
    }
    if (this.f == null) {
      return this.e[(i - 1)];
    }
    return this.f.a(paramLong);
  }
  
  public int b(long paramLong)
  {
    long[] arrayOfLong = this.b;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    if (i >= 0) {
      return this.c[i];
    }
    i ^= 0xFFFFFFFF;
    if (i < arrayOfLong.length)
    {
      if (i > 0) {
        return this.c[(i - 1)];
      }
      return 0;
    }
    if (this.f == null) {
      return this.c[(i - 1)];
    }
    return this.f.b(paramLong);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public long e(long paramLong)
  {
    long[] arrayOfLong = this.b;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    if (i >= 0)
    {
      i += 1;
      if (i >= arrayOfLong.length) {
        break label44;
      }
      l1 = arrayOfLong[i];
    }
    label44:
    do
    {
      return l1;
      i ^= 0xFFFFFFFF;
      break;
      l1 = paramLong;
    } while (this.f == null);
    long l2 = arrayOfLong[(arrayOfLong.length - 1)];
    long l1 = paramLong;
    if (paramLong < l2) {
      l1 = l2;
    }
    return this.f.e(l1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        break label121;
      }
      paramObject = (f)paramObject;
      if ((!c().equals(((f)paramObject).c())) || (!Arrays.equals(this.b, ((f)paramObject).b)) || (!Arrays.equals(this.e, ((f)paramObject).e)) || (!Arrays.equals(this.c, ((f)paramObject).c)) || (!Arrays.equals(this.d, ((f)paramObject).d))) {
        break;
      }
      if (this.f != null) {
        break label105;
      }
    } while (((f)paramObject).f == null);
    label105:
    while (!this.f.equals(((f)paramObject).f)) {
      return false;
    }
    return true;
    label121:
    return false;
  }
  
  public long f(long paramLong)
  {
    long[] arrayOfLong = this.b;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    long l1;
    if (i >= 0)
    {
      l1 = paramLong;
      if (paramLong > Long.MIN_VALUE) {
        l1 = paramLong - 1L;
      }
    }
    long l2;
    do
    {
      do
      {
        do
        {
          return l1;
          i ^= 0xFFFFFFFF;
          if (i >= arrayOfLong.length) {
            break;
          }
          l1 = paramLong;
        } while (i <= 0);
        l2 = arrayOfLong[(i - 1)];
        l1 = paramLong;
      } while (l2 <= Long.MIN_VALUE);
      return l2 - 1L;
      if (this.f != null)
      {
        l1 = this.f.f(paramLong);
        if (l1 < paramLong) {
          return l1;
        }
      }
      l2 = arrayOfLong[(i - 1)];
      l1 = paramLong;
    } while (l2 <= Long.MIN_VALUE);
    return l2 - 1L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */