package com.flurry.android.monolithic.sdk.impl;

public final class oo
{
  public static final on a = new on("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
  public static final on b = new on(a, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
  public static final on c = new on(a, "PEM", true, '=', 64);
  public static final on d;
  
  static
  {
    StringBuffer localStringBuffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    localStringBuffer.setCharAt(localStringBuffer.indexOf("+"), '-');
    localStringBuffer.setCharAt(localStringBuffer.indexOf("/"), '_');
    d = new on("MODIFIED-FOR-URL", localStringBuffer.toString(), false, '\000', Integer.MAX_VALUE);
  }
  
  public static on a()
  {
    return b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/oo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */