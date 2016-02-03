package com.google.tagmanager.protobuf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class r
  extends e
{
  private static final int[] akg;
  private int ake = 0;
  private final int akh;
  private final e aki;
  private final e akj;
  private final int akk;
  private final int akl;
  
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
    akg = new int[localArrayList.size()];
    i = 0;
    while (i < akg.length)
    {
      akg[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  private r(e parame1, e parame2)
  {
    this.aki = parame1;
    this.akj = parame2;
    this.akk = parame1.size();
    this.akh = (this.akk + parame2.size());
    this.akl = (Math.max(parame1.AO(), parame2.AO()) + 1);
  }
  
  static e a(e parame1, e parame2)
  {
    if ((parame1 instanceof r)) {}
    for (r localr = (r)parame1; parame2.size() == 0; localr = null) {
      return parame1;
    }
    if (parame1.size() == 0) {
      return parame2;
    }
    int i = parame1.size() + parame2.size();
    if (i < 128) {
      return b(parame1, parame2);
    }
    if ((localr != null) && (localr.akj.size() + parame2.size() < 128))
    {
      parame1 = b(localr.akj, parame2);
      return new r(localr.aki, parame1);
    }
    if ((localr != null) && (localr.aki.AO() > localr.akj.AO()) && (localr.AO() > parame2.AO()))
    {
      parame1 = new r(localr.akj, parame2);
      return new r(localr.aki, parame1);
    }
    int j = Math.max(parame1.AO(), parame2.AO());
    if (i >= akg[(j + 1)]) {
      return new r(parame1, parame2);
    }
    return a.a(new a(null), parame1, parame2);
  }
  
  private static m b(e parame1, e parame2)
  {
    int i = parame1.size();
    int j = parame2.size();
    byte[] arrayOfByte = new byte[i + j];
    parame1.b(arrayOfByte, 0, 0, i);
    parame2.b(arrayOfByte, 0, i, j);
    return new m(arrayOfByte);
  }
  
  private boolean g(e parame)
  {
    b localb1 = new b(this, null);
    m localm = (m)localb1.next();
    b localb2 = new b(parame, null);
    parame = (m)localb2.next();
    int j = 0;
    int i = 0;
    int k = 0;
    int i1 = localm.size() - i;
    int m = parame.size() - j;
    int n = Math.min(i1, m);
    if (i == 0) {}
    for (boolean bool = localm.a(parame, j, n); !bool; bool = parame.a(localm, i, n)) {
      return false;
    }
    k += n;
    if (k >= this.akh)
    {
      if (k == this.akh) {
        return true;
      }
      throw new IllegalStateException();
    }
    if (n == i1)
    {
      localm = (m)localb1.next();
      i = 0;
      label170:
      if (n != m) {
        break label201;
      }
      parame = (m)localb2.next();
      j = 0;
    }
    for (;;)
    {
      break;
      i += n;
      break label170;
      label201:
      j += n;
    }
  }
  
  public e.a AI()
  {
    return new c(null);
  }
  
  public boolean AL()
  {
    boolean bool = false;
    int i = this.aki.g(0, 0, this.akk);
    if (this.akj.g(i, 0, this.akj.size()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public f AM()
  {
    return f.c(new d());
  }
  
  protected int AO()
  {
    return this.akl;
  }
  
  protected boolean AP()
  {
    return this.akh >= akg[this.akl];
  }
  
  protected int AQ()
  {
    return this.ake;
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= this.akk)
    {
      this.aki.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 >= this.akk)
    {
      this.akj.a(paramArrayOfByte, paramInt1 - this.akk, paramInt2, paramInt3);
      return;
    }
    int i = this.akk - paramInt1;
    this.aki.a(paramArrayOfByte, paramInt1, paramInt2, i);
    this.akj.a(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 <= this.akk)
    {
      this.aki.b(paramOutputStream, paramInt1, paramInt2);
      return;
    }
    if (paramInt1 >= this.akk)
    {
      this.akj.b(paramOutputStream, paramInt1 - this.akk, paramInt2);
      return;
    }
    int i = this.akk - paramInt1;
    this.aki.b(paramOutputStream, paramInt1, i);
    this.akj.b(paramOutputStream, 0, paramInt2 - i);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
      if (this.akh != ((e)paramObject).size()) {
        return false;
      }
    } while (this.akh == 0);
    if (this.ake != 0)
    {
      int i = ((e)paramObject).AQ();
      if ((i != 0) && (this.ake != i)) {
        return false;
      }
    }
    return g((e)paramObject);
  }
  
  protected int g(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.akk) {
      return this.aki.g(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= this.akk) {
      return this.akj.g(paramInt1, paramInt2 - this.akk, paramInt3);
    }
    int i = this.akk - paramInt2;
    paramInt1 = this.aki.g(paramInt1, paramInt2, i);
    return this.akj.g(paramInt1, 0, paramInt3 - i);
  }
  
  protected int h(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.akk) {
      return this.aki.h(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= this.akk) {
      return this.akj.h(paramInt1, paramInt2 - this.akk, paramInt3);
    }
    int i = this.akk - paramInt2;
    paramInt1 = this.aki.h(paramInt1, paramInt2, i);
    return this.akj.h(paramInt1, 0, paramInt3 - i);
  }
  
  public int hashCode()
  {
    int j = this.ake;
    int i = j;
    if (j == 0)
    {
      j = h(this.akh, 0, this.akh);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.ake = i;
    }
    return i;
  }
  
  public int size()
  {
    return this.akh;
  }
  
  public String toString(String paramString)
  {
    return new String(toByteArray(), paramString);
  }
  
  private static class a
  {
    private final Deque<e> akm = new ArrayDeque(r.Ca().length);
    
    private e c(e parame1, e parame2)
    {
      h(parame1);
      h(parame2);
      for (parame1 = (e)this.akm.pop(); !this.akm.isEmpty(); parame1 = new r((e)this.akm.pop(), parame1, null)) {}
      return parame1;
    }
    
    private int fu(int paramInt)
    {
      int i = Arrays.binarySearch(r.Ca(), paramInt);
      paramInt = i;
      if (i < 0) {
        paramInt = -(i + 1) - 1;
      }
      return paramInt;
    }
    
    private void h(e parame)
    {
      if (parame.AP())
      {
        i(parame);
        return;
      }
      if ((parame instanceof r))
      {
        parame = (r)parame;
        h(r.a(parame));
        h(r.b(parame));
        return;
      }
      throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + parame.getClass());
    }
    
    private void i(e parame)
    {
      int i = fu(parame.size());
      int j = r.Ca()[(i + 1)];
      if ((this.akm.isEmpty()) || (((e)this.akm.peek()).size() >= j))
      {
        this.akm.push(parame);
        return;
      }
      i = r.Ca()[i];
      for (Object localObject = (e)this.akm.pop(); (!this.akm.isEmpty()) && (((e)this.akm.peek()).size() < i); localObject = new r((e)this.akm.pop(), (e)localObject, null)) {}
      for (parame = new r((e)localObject, parame, null); !this.akm.isEmpty(); parame = new r((e)this.akm.pop(), parame, null))
      {
        i = fu(parame.size());
        i = r.Ca()[(i + 1)];
        if (((e)this.akm.peek()).size() >= i) {
          break;
        }
      }
      this.akm.push(parame);
    }
  }
  
  private static class b
    implements Iterator<m>
  {
    private final Deque<r> akn = new ArrayDeque(r.Ca().length);
    private m ako = j(parame);
    
    private b(e parame) {}
    
    private m Cb()
    {
      m localm;
      do
      {
        if (this.akn.isEmpty()) {
          return null;
        }
        localm = j(r.b((r)this.akn.pop()));
      } while (localm.isEmpty());
      return localm;
    }
    
    private m j(e parame)
    {
      while ((parame instanceof r))
      {
        parame = (r)parame;
        this.akn.push(parame);
        parame = r.a(parame);
      }
      return (m)parame;
    }
    
    public m Cc()
    {
      if (this.ako == null) {
        throw new NoSuchElementException();
      }
      m localm = this.ako;
      this.ako = Cb();
      return localm;
    }
    
    public boolean hasNext()
    {
      return this.ako != null;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private class c
    implements e.a
  {
    private final r.b akp = new r.b(r.this, null);
    private e.a akq = this.akp.Cc().AI();
    int akr = r.this.size();
    
    private c() {}
    
    public Byte AJ()
    {
      return Byte.valueOf(nextByte());
    }
    
    public boolean hasNext()
    {
      return this.akr > 0;
    }
    
    public byte nextByte()
    {
      if (!this.akq.hasNext()) {
        this.akq = this.akp.Cc().AI();
      }
      this.akr -= 1;
      return this.akq.nextByte();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private class d
    extends InputStream
  {
    private r.b akt;
    private m aku;
    private int akv;
    private int akw;
    private int akx;
    private int mark;
    
    public d()
    {
      Cd();
    }
    
    private void Cd()
    {
      this.akt = new r.b(r.this, null);
      this.aku = this.akt.Cc();
      this.akv = this.aku.size();
      this.akw = 0;
      this.akx = 0;
    }
    
    private void Ce()
    {
      if ((this.aku != null) && (this.akw == this.akv))
      {
        this.akx += this.akv;
        this.akw = 0;
        if (this.akt.hasNext())
        {
          this.aku = this.akt.Cc();
          this.akv = this.aku.size();
        }
      }
      else
      {
        return;
      }
      this.aku = null;
      this.akv = 0;
    }
    
    private int i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = paramInt2;
      int j = paramInt1;
      paramInt1 = i;
      for (i = j; paramInt1 > 0; i = j)
      {
        Ce();
        if (this.aku == null)
        {
          if (paramInt1 != paramInt2) {
            break;
          }
          return -1;
        }
        int k = Math.min(this.akv - this.akw, paramInt1);
        j = i;
        if (paramArrayOfByte != null)
        {
          this.aku.b(paramArrayOfByte, this.akw, i, k);
          j = i + k;
        }
        this.akw += k;
        paramInt1 -= k;
      }
      return paramInt2 - paramInt1;
    }
    
    public int available()
    {
      int i = this.akx;
      int j = this.akw;
      return r.this.size() - (i + j);
    }
    
    public void mark(int paramInt)
    {
      this.mark = (this.akx + this.akw);
    }
    
    public boolean markSupported()
    {
      return true;
    }
    
    public int read()
    {
      Ce();
      if (this.aku == null) {
        return -1;
      }
      m localm = this.aku;
      int i = this.akw;
      this.akw = (i + 1);
      return localm.eR(i) & 0xFF;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
        throw new IndexOutOfBoundsException();
      }
      return i(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void reset()
    {
      try
      {
        Cd();
        i(null, 0, this.mark);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public long skip(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IndexOutOfBoundsException();
      }
      long l = paramLong;
      if (paramLong > 2147483647L) {
        l = 2147483647L;
      }
      return i(null, 0, (int)l);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */