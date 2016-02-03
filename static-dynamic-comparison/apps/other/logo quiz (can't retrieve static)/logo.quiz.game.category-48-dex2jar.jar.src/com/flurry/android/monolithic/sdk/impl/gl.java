package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;

public class gl
  extends gb
{
  public gl(Context paramContext, String paramString)
  {
    this.a = new gg(paramContext, paramString);
  }
  
  protected boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!paramString2.equals(this.a.a(paramString1, paramString3, paramString4)))
    {
      a(paramString3, paramString1, paramString2);
      this.a.a(paramString1, paramString2, paramString3, paramString4);
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */