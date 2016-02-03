package com.amazonaws.org.apache.http.entity;

import com.amazonaws.org.apache.http.HttpMessage;

public abstract interface ContentLengthStrategy
{
  public abstract long determineLength(HttpMessage paramHttpMessage);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/entity/ContentLengthStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */