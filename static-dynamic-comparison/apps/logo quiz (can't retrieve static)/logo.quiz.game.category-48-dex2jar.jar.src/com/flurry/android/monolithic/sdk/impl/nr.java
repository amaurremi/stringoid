package com.flurry.android.monolithic.sdk.impl;

public class nr<T>
  extends kx<T>
{
  public nr()
  {
    this(null, null, nn.b());
  }
  
  public nr(ji paramji)
  {
    this(paramji, paramji, nn.b());
  }
  
  public nr(ji paramji1, ji paramji2, nn paramnn)
  {
    super(paramji1, paramji2, paramnn);
  }
  
  public nr(Class<T> paramClass)
  {
    this(nn.b().a(paramClass));
  }
  
  protected Object a(String paramString, ji paramji)
  {
    Class localClass = b().b(paramji);
    if (localClass == null) {
      return super.a(paramString, paramji);
    }
    return Enum.valueOf(localClass, paramString);
  }
  
  public nn b()
  {
    return (nn)a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */