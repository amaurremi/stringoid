package com.inmobi.androidsdk.ai.controller.util;

public enum IMNavigationStringEnum
{
  private String a;
  
  static
  {
    CLOSE = new IMNavigationStringEnum("CLOSE", 1, "close");
  }
  
  private IMNavigationStringEnum(String paramString1)
  {
    this.a = paramString1;
  }
  
  public static IMNavigationStringEnum fromString(String paramString)
  {
    IMNavigationStringEnum[] arrayOfIMNavigationStringEnum;
    int j;
    int i;
    if (paramString != null)
    {
      arrayOfIMNavigationStringEnum = values();
      j = arrayOfIMNavigationStringEnum.length;
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i >= j) {
        localObject = null;
      }
      IMNavigationStringEnum localIMNavigationStringEnum;
      do
      {
        return (IMNavigationStringEnum)localObject;
        localIMNavigationStringEnum = arrayOfIMNavigationStringEnum[i];
        localObject = localIMNavigationStringEnum;
      } while (paramString.equalsIgnoreCase(localIMNavigationStringEnum.a));
      i += 1;
    }
  }
  
  public String getText()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/util/IMNavigationStringEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */