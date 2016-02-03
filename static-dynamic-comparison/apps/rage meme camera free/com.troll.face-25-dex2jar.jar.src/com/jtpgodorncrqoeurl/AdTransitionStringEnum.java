package com.jtpgodorncrqoeurl;

public enum AdTransitionStringEnum
{
  private String a;
  
  private AdTransitionStringEnum(String paramString1)
  {
    this.a = paramString1;
  }
  
  public static AdTransitionStringEnum fromString(String paramString)
  {
    if (paramString != null)
    {
      AdTransitionStringEnum[] arrayOfAdTransitionStringEnum = values();
      int j = arrayOfAdTransitionStringEnum.length;
      int i = 0;
      while (i < j)
      {
        AdTransitionStringEnum localAdTransitionStringEnum = arrayOfAdTransitionStringEnum[i];
        if (paramString.equalsIgnoreCase(localAdTransitionStringEnum.a)) {
          return localAdTransitionStringEnum;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public final String getText()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdTransitionStringEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */