package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class wc
  extends wv<java.sql.Date>
{
  public wc()
  {
    super(java.sql.Date.class);
  }
  
  public java.sql.Date b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    paramow = B(paramow, paramqm);
    if (paramow == null) {
      return null;
    }
    return new java.sql.Date(paramow.getTime());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */