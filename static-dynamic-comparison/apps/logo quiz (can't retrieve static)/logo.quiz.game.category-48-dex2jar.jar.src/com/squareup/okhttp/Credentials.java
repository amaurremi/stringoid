package com.squareup.okhttp;

import com.squareup.okio.ByteString;
import java.io.UnsupportedEncodingException;

public final class Credentials
{
  public static String basic(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = ByteString.of((paramString1 + ":" + paramString2).getBytes("ISO-8859-1")).base64();
      paramString1 = "Basic " + paramString1;
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/Credentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */