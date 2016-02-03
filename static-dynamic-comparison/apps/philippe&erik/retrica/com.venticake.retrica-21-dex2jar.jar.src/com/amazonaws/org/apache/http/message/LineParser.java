package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;

public abstract interface LineParser
{
  public abstract boolean hasProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor);
  
  public abstract Header parseHeader(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract StatusLine parseStatusLine(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/LineParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */