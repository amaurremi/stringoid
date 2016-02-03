package com.amazonaws.org.apache.http;

import java.util.Iterator;

public abstract interface HeaderElementIterator
  extends Iterator<Object>
{
  public abstract boolean hasNext();
  
  public abstract HeaderElement nextElement();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/HeaderElementIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */