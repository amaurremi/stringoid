package com.jtpgodorncrqoeurl;

public enum AdNavigationStringEnum
{
  private String a;
  
  static
  {
    CLOSE = new AdNavigationStringEnum("CLOSE", 1, "close");
  }
  
  private AdNavigationStringEnum(String paramString1)
  {
    this.a = paramString1;
  }
  
  public static AdNavigationStringEnum fromString(String paramString)
  {
    if (paramString != null)
    {
      AdNavigationStringEnum[] arrayOfAdNavigationStringEnum = values();
      int j = arrayOfAdNavigationStringEnum.length;
      int i = 0;
      while (i < j)
      {
        AdNavigationStringEnum localAdNavigationStringEnum = arrayOfAdNavigationStringEnum[i];
        if (paramString.equalsIgnoreCase(localAdNavigationStringEnum.a)) {
          return localAdNavigationStringEnum;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdNavigationStringEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */