package com.appbrain.b;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public abstract class d
  implements Iterable
{
  public static final d a;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = new r(new byte[0]);
      return;
    }
  }
  
  public static d a(String paramString)
  {
    try
    {
      paramString = new r(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static d a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static d a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new r(arrayOfByte);
  }
  
  static f a(int paramInt)
  {
    return new f(paramInt, (byte)0);
  }
  
  protected abstract int a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract e a();
  
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
  
  public final boolean c()
  {
    return b() == 0;
  }
  
  public final byte[] d()
  {
    int i = b();
    byte[] arrayOfByte = new byte[i];
    b(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String e()
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
  
  public abstract boolean f();
  
  public abstract InputStream g();
  
  protected abstract int h();
  
  public String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b()) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */