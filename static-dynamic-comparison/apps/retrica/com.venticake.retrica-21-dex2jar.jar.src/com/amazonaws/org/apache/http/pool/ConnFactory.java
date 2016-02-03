package com.amazonaws.org.apache.http.pool;

public abstract interface ConnFactory<T, C>
{
  public abstract C create(T paramT);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/pool/ConnFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */