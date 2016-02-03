package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class xa
  extends wv<Timestamp>
{
  public xa()
  {
    super(Timestamp.class);
  }
  
  public Timestamp b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return new Timestamp(B(paramow, paramqm).getTime());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */