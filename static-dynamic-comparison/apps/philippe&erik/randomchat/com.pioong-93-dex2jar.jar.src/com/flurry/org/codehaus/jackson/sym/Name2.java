package com.flurry.org.codehaus.jackson.sym;

public final class Name2
  extends Name
{
  final int mQuad1;
  final int mQuad2;
  
  Name2(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString, paramInt1);
    this.mQuad1 = paramInt2;
    this.mQuad2 = paramInt3;
  }
  
  public boolean equals(int paramInt)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return (paramInt1 == this.mQuad1) && (paramInt2 == this.mQuad2);
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 2) && (paramArrayOfInt[0] == this.mQuad1) && (paramArrayOfInt[1] == this.mQuad2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/sym/Name2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */