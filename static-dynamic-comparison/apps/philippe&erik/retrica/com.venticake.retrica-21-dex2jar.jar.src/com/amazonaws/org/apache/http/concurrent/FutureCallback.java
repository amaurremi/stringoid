package com.amazonaws.org.apache.http.concurrent;

public abstract interface FutureCallback<T>
{
  public abstract void cancelled();
  
  public abstract void completed(T paramT);
  
  public abstract void failed(Exception paramException);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/concurrent/FutureCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */