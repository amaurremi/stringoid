package com.ideashower.readitlater.objects;

public class i
{
  public int a;
  public int b;
  
  public i()
  {
    this(0, 0);
  }
  
  public i(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 < paramFloat1) {
      return paramFloat1;
    }
    if (paramFloat3 > paramFloat2) {
      return paramFloat2;
    }
    return paramFloat3;
  }
  
  public static boolean b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 <= paramFloat2) && (paramFloat3 >= paramFloat1);
  }
  
  public int a(int paramInt)
  {
    int i;
    if (paramInt >= this.b) {
      i = this.b;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt > this.a);
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public String toString()
  {
    return this.a + "-" + this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */