package com.appbrain.b;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

final class l
  extends c
{
  protected final byte[] c;
  private int d = 0;
  
  l(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  protected final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 += 0;
    return u.a(paramInt1, this.c, paramInt2, paramInt2 + paramInt3);
  }
  
  public final c.a a()
  {
    return new a((byte)0);
  }
  
  final boolean a(l paraml, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paraml.c.length) {
      throw new IllegalArgumentException("Length too large: " + paramInt2 + this.c.length);
    }
    if (paramInt1 + paramInt2 > paraml.c.length) {
      throw new IllegalArgumentException("Ran off end of other: " + paramInt1 + ", " + paramInt2 + ", " + paraml.c.length);
    }
    byte[] arrayOfByte = this.c;
    paraml = paraml.c;
    paramInt1 += 0;
    int i = 0;
    while (i < paramInt2 + 0)
    {
      if (arrayOfByte[i] != paraml[paramInt1]) {
        return false;
      }
      i += 1;
      paramInt1 += 1;
    }
    return true;
  }
  
  public final byte b(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public final int b()
  {
    return this.c.length;
  }
  
  protected final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = this.c;
    int i = paramInt2 + 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt1 < i + paramInt3)
    {
      paramInt2 = paramInt2 * 31 + arrayOfByte[paramInt1];
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public final String b(String paramString)
  {
    return new String(this.c, 0, this.c.length, paramString);
  }
  
  protected final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.c, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public final boolean e()
  {
    boolean bool = false;
    if (u.a(this.c, 0, this.c.length + 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    if (this.c.length != ((c)paramObject).b()) {
      return false;
    }
    if (this.c.length == 0) {
      return true;
    }
    if ((paramObject instanceof l)) {
      return a((l)paramObject, 0, this.c.length);
    }
    if ((paramObject instanceof p)) {
      return paramObject.equals(this);
    }
    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + paramObject.getClass());
  }
  
  public final InputStream f()
  {
    return new ByteArrayInputStream(this.c, 0, this.c.length);
  }
  
  protected final int g()
  {
    return this.d;
  }
  
  public final int hashCode()
  {
    int j = this.d;
    int i = j;
    if (j == 0)
    {
      i = this.c.length;
      j = b(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.d = i;
    }
    return i;
  }
  
  private final class a
    implements c.a
  {
    private int b = 0;
    private final int c = l.this.b();
    
    private a() {}
    
    public final byte a()
    {
      try
      {
        byte[] arrayOfByte = l.this.c;
        int i = this.b;
        this.b = (i + 1);
        byte b1 = arrayOfByte[i];
        return b1;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
      }
    }
    
    public final boolean hasNext()
    {
      return this.b < this.c;
    }
    
    public final void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */