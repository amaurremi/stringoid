package com.mobisystems.photoimageview;

public class b
{
  public static int Z(float paramFloat)
  {
    int i = 0;
    for (;;)
    {
      if ((i >= 31) || (1 << i >= paramFloat)) {
        return i;
      }
      i += 1;
    }
  }
  
  public static int aa(float paramFloat)
  {
    int i = 0;
    for (;;)
    {
      if ((i >= 31) || (1 << i > paramFloat)) {
        return i - 1;
      }
      i += 1;
    }
  }
  
  public static int k(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/photoimageview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */