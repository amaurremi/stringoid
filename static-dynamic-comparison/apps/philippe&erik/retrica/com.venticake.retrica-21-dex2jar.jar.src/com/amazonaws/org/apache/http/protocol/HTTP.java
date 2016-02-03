package com.amazonaws.org.apache.http.protocol;

import com.amazonaws.org.apache.http.Consts;
import java.nio.charset.Charset;

public final class HTTP
{
  public static final Charset DEF_CONTENT_CHARSET = Consts.ISO_8859_1;
  public static final Charset DEF_PROTOCOL_CHARSET = Consts.ASCII;
  
  public static boolean isWhitespace(char paramChar)
  {
    return (paramChar == ' ') || (paramChar == '\t') || (paramChar == '\r') || (paramChar == '\n');
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/protocol/HTTP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */