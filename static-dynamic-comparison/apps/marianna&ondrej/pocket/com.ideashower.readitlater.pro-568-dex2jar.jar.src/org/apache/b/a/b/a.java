package org.apache.b.a.b;

public final class a
{
  private byte[] a;
  private int b;
  
  public a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Buffer capacity may not be negative");
    }
    this.a = new byte[paramInt];
  }
  
  private void c(int paramInt)
  {
    byte[] arrayOfByte = new byte[Math.max(this.a.length << 1, paramInt)];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    this.a = arrayOfByte;
  }
  
  public void a()
  {
    this.b = 0;
  }
  
  public void a(int paramInt)
  {
    int i = this.b + 1;
    if (i > this.a.length) {
      c(i);
    }
    this.a[this.b] = ((byte)paramInt);
    this.b = i;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > this.b) || (paramInt2 < 0) || (paramInt1 + paramInt2 < 0) || (paramInt1 + paramInt2 > this.b)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    int i = this.b - paramInt1 - paramInt2;
    if (i > 0) {
      System.arraycopy(this.a, paramInt1 + paramInt2, this.a, paramInt1, i);
    }
    this.b -= paramInt2;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
        throw new IndexOutOfBoundsException();
      }
    } while (paramInt2 == 0);
    int i = this.b + paramInt2;
    if (i > this.a.length) {
      c(i);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b = i;
  }
  
  public byte b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.b)) {
      throw new IndexOutOfBoundsException();
    }
    return this.a[paramInt];
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte = new byte[this.b];
    if (this.b > 0) {
      System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    }
    return arrayOfByte;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public byte[] d()
  {
    return this.a;
  }
  
  public String toString()
  {
    return new String(b());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/b/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */