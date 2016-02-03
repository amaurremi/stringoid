package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.net.InetAddress;

public class up
  extends um<InetAddress>
{
  public up()
  {
    super(InetAddress.class);
  }
  
  protected InetAddress b(String paramString, qm paramqm)
    throws IOException
  {
    return InetAddress.getByName(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/up.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */