package com.a.a;

import java.util.Map;

public class i
  extends Exception
{
  private int a;
  private String b;
  private Map<String, String> c;
  
  public i(int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramMap;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String getMessage()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "FBRequestError (" + this.a + "): " + this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */