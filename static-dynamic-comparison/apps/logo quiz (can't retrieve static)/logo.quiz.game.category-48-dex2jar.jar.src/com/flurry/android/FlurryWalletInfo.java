package com.flurry.android;

public class FlurryWalletInfo
{
  private final String a;
  private final float b;
  
  public FlurryWalletInfo(String paramString, float paramFloat)
  {
    this.a = paramString;
    this.b = paramFloat;
  }
  
  public float getCurrencyAmount()
  {
    return this.b;
  }
  
  public String getCurrencyKey()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/FlurryWalletInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */