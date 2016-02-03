package com.scoreloop.client.android.core.controller;

 enum h
{
  private String a;
  private String b;
  
  static
  {
    BEGINS_WITH = new h("BEGINS_WITH", 2, "begins_with", "string begins with given value");
    IS = new h("IS", 3, "equals", "is");
    IS_GREATER = new h("IS_GREATER", 4, "greater_than", "is greater than");
    IS_LESS = new h("IS_LESS", 5, "less_than", "is less than");
    IS_NOT = new h("IS_NOT", 6, "does_not_equal", "is not");
  }
  
  private h(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.a = paramString2;
  }
  
  public String getDescription()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */