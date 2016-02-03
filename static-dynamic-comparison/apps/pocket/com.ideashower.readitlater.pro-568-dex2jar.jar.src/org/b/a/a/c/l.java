package org.b.a.a.c;

public abstract class l
{
  protected short[] a;
  protected byte[] b;
  protected float c;
  protected boolean d;
  protected String e;
  
  public l(short[] paramArrayOfShort, byte[] paramArrayOfByte, float paramFloat, boolean paramBoolean, String paramString)
  {
    this.a = paramArrayOfShort;
    this.b = paramArrayOfByte;
    this.c = paramFloat;
    this.d = paramBoolean;
    this.e = paramString;
  }
  
  public byte a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public float a()
  {
    return this.c;
  }
  
  public short a(byte paramByte)
  {
    return this.a[(paramByte & 0xFF)];
  }
  
  public String b()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */