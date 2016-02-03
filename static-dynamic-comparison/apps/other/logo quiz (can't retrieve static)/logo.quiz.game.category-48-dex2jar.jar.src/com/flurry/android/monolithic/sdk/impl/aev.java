package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class aev
  implements Iterator<String>
{
  static final aev a = new aev();
  
  public static aev a()
  {
    return a;
  }
  
  public String b()
  {
    throw new NoSuchElementException();
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public void remove()
  {
    throw new IllegalStateException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */