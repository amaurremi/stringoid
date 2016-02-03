package com.amazonaws.org.apache.http;

import java.util.Iterator;

public abstract interface TokenIterator
  extends Iterator<Object>
{
  public abstract boolean hasNext();
  
  public abstract String nextToken();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/TokenIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */