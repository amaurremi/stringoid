package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;

public abstract interface HeaderValueParser
{
  public abstract HeaderElement[] parseElements(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor);
  
  public abstract HeaderElement parseHeaderElement(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/HeaderValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */