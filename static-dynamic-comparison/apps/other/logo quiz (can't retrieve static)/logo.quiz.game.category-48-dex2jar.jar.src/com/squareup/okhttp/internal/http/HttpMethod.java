package com.squareup.okhttp.internal.http;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public final class HttpMethod
{
  public static final Set<String> METHODS = new LinkedHashSet(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH" }));
  
  public static boolean hasRequestBody(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")) || (paramString.equals("DELETE"));
  }
  
  public static boolean invalidatesCache(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/http/HttpMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */