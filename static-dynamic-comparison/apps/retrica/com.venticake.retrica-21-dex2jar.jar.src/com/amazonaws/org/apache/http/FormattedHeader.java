package com.amazonaws.org.apache.http;

import com.amazonaws.org.apache.http.util.CharArrayBuffer;

public abstract interface FormattedHeader
  extends Header
{
  public abstract CharArrayBuffer getBuffer();
  
  public abstract int getValuePos();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/FormattedHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */