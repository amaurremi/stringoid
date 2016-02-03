package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.io.StringReader;

public class ke
{
  private kc a = new kc();
  private boolean b = true;
  
  private ji a(ow paramow)
    throws IOException
  {
    boolean bool = ((Boolean)ji.q().get()).booleanValue();
    try
    {
      ji.q().set(Boolean.valueOf(this.b));
      paramow = ji.a(ji.b.a(paramow), this.a);
      return paramow;
    }
    catch (ov paramow)
    {
      throw new kl(paramow);
    }
    finally
    {
      ji.q().set(Boolean.valueOf(bool));
    }
  }
  
  public ji a(String paramString)
  {
    try
    {
      paramString = a(ji.a.a(new StringReader(paramString)));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new kl(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */