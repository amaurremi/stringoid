package com.flurry.android.monolithic.sdk.impl;

public abstract class pa
{
  protected int a;
  protected int b;
  
  public final boolean a()
  {
    return this.a == 1;
  }
  
  public final boolean b()
  {
    return this.a == 0;
  }
  
  public final boolean c()
  {
    return this.a == 2;
  }
  
  public final String d()
  {
    switch (this.a)
    {
    default: 
      return "?";
    case 0: 
      return "ROOT";
    case 1: 
      return "ARRAY";
    }
    return "OBJECT";
  }
  
  public final int e()
  {
    return this.b + 1;
  }
  
  public final int f()
  {
    if (this.b < 0) {
      return 0;
    }
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */