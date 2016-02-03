package com.flurry.android.monolithic.sdk.impl;

import java.util.StringTokenizer;

final class adn
  extends StringTokenizer
{
  protected final String a;
  protected int b;
  protected String c;
  
  public adn(String paramString)
  {
    super(paramString, "<,>", true);
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
    this.b -= paramString.length();
  }
  
  public String b()
  {
    return this.a.substring(this.b);
  }
  
  public boolean hasMoreTokens()
  {
    return (this.c != null) || (super.hasMoreTokens());
  }
  
  public String nextToken()
  {
    String str;
    if (this.c != null)
    {
      str = this.c;
      this.c = null;
    }
    for (;;)
    {
      this.b += str.length();
      return str;
      str = super.nextToken();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */