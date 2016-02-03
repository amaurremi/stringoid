package org.b.a.a.d;

public class k
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int[] e;
  
  public k(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramArrayOfInt;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 << 16 | paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt2 << 8 | paramInt1, paramInt4 << 8 | paramInt3);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return a(paramInt2 << 4 | paramInt1, paramInt4 << 4 | paramInt3, paramInt6 << 4 | paramInt5, paramInt8 << 4 | paramInt7);
  }
  
  public int a(int paramInt)
  {
    return this.e[(paramInt >> this.a)] >> ((this.b & paramInt) << this.c) & this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */