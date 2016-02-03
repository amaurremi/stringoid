package com.inmobi.re.controller.util;

public enum TransitionStringEnum
{
  private String a;
  
  private TransitionStringEnum(String paramString)
  {
    this.a = paramString;
  }
  
  public static TransitionStringEnum fromString(String paramString)
  {
    if (paramString != null)
    {
      TransitionStringEnum[] arrayOfTransitionStringEnum = values();
      int j = arrayOfTransitionStringEnum.length;
      int i = 0;
      while (i < j)
      {
        TransitionStringEnum localTransitionStringEnum = arrayOfTransitionStringEnum[i];
        if (paramString.equalsIgnoreCase(localTransitionStringEnum.a)) {
          return localTransitionStringEnum;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String getText()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/controller/util/TransitionStringEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */