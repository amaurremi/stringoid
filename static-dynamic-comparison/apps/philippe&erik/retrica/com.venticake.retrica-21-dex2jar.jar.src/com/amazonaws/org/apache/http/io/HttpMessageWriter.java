package com.amazonaws.org.apache.http.io;

import com.amazonaws.org.apache.http.HttpMessage;

public abstract interface HttpMessageWriter<T extends HttpMessage>
{
  public abstract void write(T paramT);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/io/HttpMessageWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */