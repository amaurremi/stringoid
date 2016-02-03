package com.flurry.org.codehaus.jackson.sym;

public final class Name1
  extends Name
{
  static final Name1 sEmptyName = new Name1("", 0, 0);
  final int mQuad;
  
  Name1(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
    this.mQuad = paramInt2;
  }
  
  static final Name1 getEmptyName()
  {
    return sEmptyName;
  }
  
  public boolean equals(int paramInt)
  {
    return paramInt == this.mQuad;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return (paramInt1 == this.mQuad) && (paramInt2 == 0);
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 1) && (paramArrayOfInt[0] == this.mQuad);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/sym/Name1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */