package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.nio.charset.Charset;

public class un
  extends um<Charset>
{
  public un()
  {
    super(Charset.class);
  }
  
  protected Charset b(String paramString, qm paramqm)
    throws IOException
  {
    return Charset.forName(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/un.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */