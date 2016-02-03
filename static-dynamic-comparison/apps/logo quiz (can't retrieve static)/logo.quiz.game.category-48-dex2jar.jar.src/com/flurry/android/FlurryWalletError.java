package com.flurry.android;

public class FlurryWalletError
{
  private int a;
  private String b;
  
  public FlurryWalletError(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public int getErrorCode()
  {
    return this.a;
  }
  
  public String getErrorMessage()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/FlurryWalletError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */