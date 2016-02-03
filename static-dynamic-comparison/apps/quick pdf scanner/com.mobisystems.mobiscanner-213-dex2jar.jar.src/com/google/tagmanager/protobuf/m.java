package com.google.tagmanager.protobuf;

import java.io.OutputStream;
import java.util.NoSuchElementException;

class m
  extends e
{
  protected final byte[] akd;
  private int ake = 0;
  
  m(byte[] paramArrayOfByte)
  {
    this.akd = paramArrayOfByte;
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
  }
  
  protected int AH()
  {
    return 0;
  }
  
  public e.a AI()
  {
    return new a(null);
  }
  
  public boolean AL()
  {
    int i = AH();
    return u.j(this.akd, i, size() + i);
  }
  
  public f AM()
  {
    return f.a(this);
  }
  
  protected int AO()
  {
    return 0;
  }
  
  protected boolean AP()
  {
    return true;
  }
  
  protected int AQ()
  {
    return this.ake;
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.akd, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  boolean a(m paramm, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramm.size()) {
      throw new IllegalArgumentException("Length too large: " + paramInt2 + size());
    }
    if (paramInt1 + paramInt2 > paramm.size()) {
      throw new IllegalArgumentException("Ran off end of other: " + paramInt1 + ", " + paramInt2 + ", " + paramm.size());
    }
    byte[] arrayOfByte1 = this.akd;
    byte[] arrayOfByte2 = paramm.akd;
    int j = AH();
    int i = AH();
    paramInt1 = paramm.AH() + paramInt1;
    while (i < j + paramInt2)
    {
      if (arrayOfByte1[i] != arrayOfByte2[paramInt1]) {
        return false;
      }
      i += 1;
      paramInt1 += 1;
    }
    return true;
  }
  
  void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    paramOutputStream.write(this.akd, AH() + paramInt1, paramInt2);
  }
  
  public byte eR(int paramInt)
  {
    return this.akd[paramInt];
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof e)) {
      return false;
    }
    if (size() != ((e)paramObject).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof m)) {
      return a((m)paramObject, 0, size());
    }
    if ((paramObject instanceof r)) {
      return paramObject.equals(this);
    }
    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + paramObject.getClass());
  }
  
  protected int g(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = AH() + paramInt2;
    return u.b(paramInt1, this.akd, paramInt2, paramInt2 + paramInt3);
  }
  
  protected int h(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, this.akd, AH() + paramInt2, paramInt3);
  }
  
  public int hashCode()
  {
    int j = this.ake;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = h(i, 0, i);
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
    return this.akd.length;
  }
  
  public String toString(String paramString)
  {
    return new String(this.akd, AH(), size(), paramString);
  }
  
  private class a
    implements e.a
  {
    private final int ahp = m.this.size();
    private int position = 0;
    
    private a() {}
    
    public Byte AJ()
    {
      return Byte.valueOf(nextByte());
    }
    
    public boolean hasNext()
    {
      return this.position < this.ahp;
    }
    
    public byte nextByte()
    {
      try
      {
        byte[] arrayOfByte = m.this.akd;
        int i = this.position;
        this.position = (i + 1);
        byte b = arrayOfByte[i];
        return b;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
      }
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */