package com.flurry.android.monolithic.sdk.impl;

class mn
  extends nm
{
  public ji a;
  
  public mn(ji paramji1, ji paramji2)
  {
    super(paramji1);
    this.a = paramji2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof mn)) {}
    do
    {
      return false;
      paramObject = (mn)paramObject;
    } while ((this.b != ((mn)paramObject).b) || (this.a != ((mn)paramObject).a));
    return true;
  }
  
  public int hashCode()
  {
    return super.hashCode() + this.a.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/mn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */