package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class FormEncodingBuilder
{
  private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
  private final StringBuilder content = new StringBuilder();
  
  public FormEncodingBuilder add(String paramString1, String paramString2)
  {
    if (this.content.length() > 0) {
      this.content.append('&');
    }
    try
    {
      this.content.append(URLEncoder.encode(paramString1, "UTF-8")).append('=').append(URLEncoder.encode(paramString2, "UTF-8"));
      return this;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new AssertionError(paramString1);
    }
  }
  
  public RequestBody build()
  {
    if (this.content.length() == 0) {
      throw new IllegalStateException("Form encoded body must have at least one part.");
    }
    byte[] arrayOfByte = this.content.toString().getBytes(Util.UTF_8);
    return RequestBody.create(CONTENT_TYPE, arrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/FormEncodingBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */