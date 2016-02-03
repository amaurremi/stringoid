package com.amazonaws.org.apache.http;

public abstract interface Header
{
  public abstract HeaderElement[] getElements();
  
  public abstract String getName();
  
  public abstract String getValue();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */