package com.appbrain.b;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

final class p
  extends c
{
  private static final int[] c;
  private final int d;
  private final c e;
  private final c f;
  private final int g;
  private int h;
  
  static
  {
    int i = 1;
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    for (;;)
    {
      int k = j;
      if (i <= 0) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
      j = i;
      i = k + i;
    }
    localArrayList.add(Integer.valueOf(Integer.MAX_VALUE));
    c = new int[localArrayList.size()];
    i = 0;
    while (i < c.length)
    {
      c[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  protected final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.g) {
      return this.e.a(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= this.g) {
      return this.f.a(paramInt1, paramInt2 - this.g, paramInt3);
    }
    int i = this.g - paramInt2;
    paramInt1 = this.e.a(paramInt1, paramInt2, i);
    return this.f.a(paramInt1, 0, paramInt3 - i);
  }
  
  public final c.a a()
  {
    return new b((byte)0);
  }
  
  public final int b()
  {
    return this.d;
  }
  
  protected final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.g) {
      return this.e.b(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= this.g) {
      return this.f.b(paramInt1, paramInt2 - this.g, paramInt3);
    }
    int i = this.g - paramInt2;
    paramInt1 = this.e.b(paramInt1, paramInt2, i);
    return this.f.b(paramInt1, 0, paramInt3 - i);
  }
  
  public final String b(String paramString)
  {
    return new String(c(), paramString);
  }
  
  protected final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= this.g)
    {
      this.e.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 >= this.g)
    {
      this.f.b(paramArrayOfByte, paramInt1 - this.g, paramInt2, paramInt3);
      return;
    }
    int i = this.g - paramInt1;
    this.e.b(paramArrayOfByte, paramInt1, paramInt2, i);
    this.f.b(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  public final boolean e()
  {
    boolean bool = false;
    int i = this.e.a(0, 0, this.g);
    if (this.f.a(i, 0, this.f.b()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool3 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof c));
        paramObject = (c)paramObject;
        bool1 = bool3;
      } while (this.d != ((c)paramObject).b());
      if (this.d == 0) {
        return true;
      }
      if (this.h == 0) {
        break;
      }
      i = ((c)paramObject).g();
      if (i == 0) {
        break;
      }
      bool1 = bool3;
    } while (this.h != i);
    a locala1 = new a(this, (byte)0);
    l locall = (l)locala1.next();
    a locala2 = new a((c)paramObject, (byte)0);
    paramObject = (l)locala2.next();
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      int i1 = locall.b() - j;
      int m = ((l)paramObject).b() - i;
      int n = Math.min(i1, m);
      if (j == 0) {}
      for (boolean bool2 = locall.a((l)paramObject, i, n);; bool2 = ((l)paramObject).a(locall, j, n))
      {
        bool1 = bool3;
        if (!bool2) {
          break;
        }
        k += n;
        if (k < this.d) {
          break label233;
        }
        if (k != this.d) {
          break label225;
        }
        return true;
      }
      label225:
      throw new IllegalStateException();
      label233:
      if (n == i1)
      {
        locall = (l)locala1.next();
        j = 0;
      }
      for (;;)
      {
        if (n != m) {
          break label285;
        }
        paramObject = (l)locala2.next();
        i = 0;
        break;
        j += n;
      }
      label285:
      i += n;
    }
  }
  
  public final InputStream f()
  {
    return new c();
  }
  
  protected final int g()
  {
    return this.h;
  }
  
  public final int hashCode()
  {
    int j = this.h;
    int i = j;
    if (j == 0)
    {
      j = b(this.d, 0, this.d);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.h = i;
    }
    return i;
  }
  
  private static final class a
    implements Iterator
  {
    private final Stack a = new Stack();
    private l b = a(paramc);
    
    private a(c paramc) {}
    
    private l a(c paramc)
    {
      while ((paramc instanceof p))
      {
        paramc = (p)paramc;
        this.a.push(paramc);
        paramc = p.a(paramc);
      }
      return (l)paramc;
    }
    
    private l b()
    {
      if (this.a.isEmpty()) {
        return null;
      }
      l locall = a(p.b((p)this.a.pop()));
      if (locall.b() == 0) {}
      for (int i = 1; i == 0; i = 0) {
        return locall;
      }
    }
    
    public final l a()
    {
      if (this.b == null) {
        throw new NoSuchElementException();
      }
      l locall = this.b;
      this.b = b();
      return locall;
    }
    
    public final boolean hasNext()
    {
      return this.b != null;
    }
    
    public final void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private final class b
    implements c.a
  {
    int a = p.this.b();
    private final p.a c = new p.a(p.this, (byte)0);
    private c.a d = this.c.a().a();
    
    private b() {}
    
    public final byte a()
    {
      if (!this.d.hasNext()) {
        this.d = this.c.a().a();
      }
      this.a -= 1;
      return this.d.a();
    }
    
    public final boolean hasNext()
    {
      return this.a > 0;
    }
    
    public final void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private final class c
    extends InputStream
  {
    private p.a b;
    private l c;
    private int d;
    private int e;
    private int f;
    private int g;
    
    public c()
    {
      a();
    }
    
    private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = paramInt2;
      int j = paramInt1;
      paramInt1 = i;
      for (i = j; paramInt1 > 0; i = j)
      {
        b();
        if (this.c == null)
        {
          if (paramInt1 != paramInt2) {
            break;
          }
          return -1;
        }
        int k = Math.min(this.d - this.e, paramInt1);
        j = i;
        if (paramArrayOfByte != null)
        {
          this.c.a(paramArrayOfByte, this.e, i, k);
          j = i + k;
        }
        this.e += k;
        paramInt1 -= k;
      }
      return paramInt2 - paramInt1;
    }
    
    private void a()
    {
      this.b = new p.a(p.this, (byte)0);
      this.c = this.b.a();
      this.d = this.c.b();
      this.e = 0;
      this.f = 0;
    }
    
    private void b()
    {
      if ((this.c != null) && (this.e == this.d))
      {
        this.f += this.d;
        this.e = 0;
        if (this.b.hasNext())
        {
          this.c = this.b.a();
          this.d = this.c.b();
        }
      }
      else
      {
        return;
      }
      this.c = null;
      this.d = 0;
    }
    
    public final int available()
    {
      int i = this.f;
      int j = this.e;
      return p.this.b() - (i + j);
    }
    
    public final void mark(int paramInt)
    {
      this.g = (this.f + this.e);
    }
    
    public final boolean markSupported()
    {
      return true;
    }
    
    public final int read()
    {
      b();
      if (this.c == null) {
        return -1;
      }
      l locall = this.c;
      int i = this.e;
      this.e = (i + 1);
      return locall.b(i) & 0xFF;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
        throw new IndexOutOfBoundsException();
      }
      return a(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void reset()
    {
      try
      {
        a();
        a(null, 0, this.g);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final long skip(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IndexOutOfBoundsException();
      }
      long l = paramLong;
      if (paramLong > 2147483647L) {
        l = 2147483647L;
      }
      return a(null, 0, (int)l);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */