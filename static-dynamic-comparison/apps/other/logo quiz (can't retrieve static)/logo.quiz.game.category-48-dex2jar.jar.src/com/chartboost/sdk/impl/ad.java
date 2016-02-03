package com.chartboost.sdk.impl;

public class ad
{
  public static String a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramObject, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    ae.a().a(paramObject, paramStringBuilder);
  }
  
  static void a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append("\"");
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (c == '\\') {
        paramStringBuilder.append("\\\\");
      }
      for (;;)
      {
        i += 1;
        break;
        if (c == '"') {
          paramStringBuilder.append("\\\"");
        } else if (c == '\n') {
          paramStringBuilder.append("\\n");
        } else if (c == '\r') {
          paramStringBuilder.append("\\r");
        } else if (c == '\t') {
          paramStringBuilder.append("\\t");
        } else if (c == '\b') {
          paramStringBuilder.append("\\b");
        } else if (c >= ' ') {
          paramStringBuilder.append(c);
        }
      }
    }
    paramStringBuilder.append("\"");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */