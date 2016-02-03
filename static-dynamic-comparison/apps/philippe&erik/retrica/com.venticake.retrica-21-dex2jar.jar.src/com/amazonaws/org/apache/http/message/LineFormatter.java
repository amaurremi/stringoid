package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;

public abstract interface LineFormatter
{
  public abstract CharArrayBuffer formatHeader(CharArrayBuffer paramCharArrayBuffer, Header paramHeader);
  
  public abstract CharArrayBuffer formatRequestLine(CharArrayBuffer paramCharArrayBuffer, RequestLine paramRequestLine);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/LineFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */