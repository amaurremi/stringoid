package com.mongodb.util;

import com.mongodb.DBObject;
import org.bson.BSONCallback;

public class JSON
{
  public static Object parse(String paramString)
  {
    return parse(paramString, null);
  }
  
  public static Object parse(String paramString, BSONCallback paramBSONCallback)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (!paramString.equals("")) {}
    }
    else
    {
      return (DBObject)null;
    }
    return new JSONParser(paramString, paramBSONCallback).parse();
  }
  
  public static String serialize(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    serialize(paramObject, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static void serialize(Object paramObject, StringBuilder paramStringBuilder)
  {
    JSONSerializers.getLegacy().serialize(paramObject, paramStringBuilder);
  }
  
  static void string(StringBuilder paramStringBuilder, String paramString)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/JSON.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */