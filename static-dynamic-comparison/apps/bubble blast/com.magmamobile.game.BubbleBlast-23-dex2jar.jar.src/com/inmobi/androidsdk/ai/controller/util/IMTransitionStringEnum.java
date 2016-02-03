package com.inmobi.androidsdk.ai.controller.util;

public enum IMTransitionStringEnum
{
  private String a;
  
  private IMTransitionStringEnum(String paramString1)
  {
    this.a = paramString1;
  }
  
  public static IMTransitionStringEnum fromString(String paramString)
  {
    IMTransitionStringEnum[] arrayOfIMTransitionStringEnum;
    int j;
    int i;
    if (paramString != null)
    {
      arrayOfIMTransitionStringEnum = values();
      j = arrayOfIMTransitionStringEnum.length;
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i >= j) {
        localObject = null;
      }
      IMTransitionStringEnum localIMTransitionStringEnum;
      do
      {
        return (IMTransitionStringEnum)localObject;
        localIMTransitionStringEnum = arrayOfIMTransitionStringEnum[i];
        localObject = localIMTransitionStringEnum;
      } while (paramString.equalsIgnoreCase(localIMTransitionStringEnum.a));
      i += 1;
    }
  }
  
  public String getText()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/util/IMTransitionStringEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */