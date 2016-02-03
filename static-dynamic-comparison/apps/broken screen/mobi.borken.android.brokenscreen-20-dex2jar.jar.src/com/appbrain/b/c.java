package com.appbrain.b;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

public abstract class c
  implements Iterable
{
  public static final c a;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = new l(new byte[0]);
      return;
    }
  }
  
  static b a(int paramInt)
  {
    return new b(paramInt, (byte)0);
  }
  
  public static c a(String paramString)
  {
    try
    {
      paramString = new l(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new l(arrayOfByte);
  }
  
  protected abstract int a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract a a();
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException("Target offset < 0: " + paramInt2);
    }
    if (paramInt3 < 0) {
      throw new IndexOutOfBoundsException("Length < 0: " + paramInt3);
    }
    if (paramInt1 + paramInt3 > b()) {
      throw new IndexOutOfBoundsException("Source end offset < 0: " + (paramInt1 + paramInt3));
    }
    if (paramInt2 + paramInt3 > paramArrayOfByte.length) {
      throw new IndexOutOfBoundsException("Target end offset < 0: " + (paramInt2 + paramInt3));
    }
    if (paramInt3 > 0) {
      b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public abstract int b();
  
  protected abstract int b(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String b(String paramString);
  
  protected abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public final byte[] c()
  {
    int i = b();
    byte[] arrayOfByte = new byte[i];
    b(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String d()
  {
    try
    {
      String str = b("UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
  
  public abstract boolean e();
  
  public abstract InputStream f();
  
  protected abstract int g();
  
  public String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b()) });
  }
  
  public static abstract interface a
    extends Iterator
  {
    public abstract byte a();
  }
  
  static final class b
  {
    private final e a;
    private final byte[] b;
    
    private b(int paramInt)
    {
      this.b = new byte[paramInt];
      this.a = e.a(this.b);
    }
    
    public final c a()
    {
      this.a.b();
      return new l(this.b);
    }
    
    public final e b()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */