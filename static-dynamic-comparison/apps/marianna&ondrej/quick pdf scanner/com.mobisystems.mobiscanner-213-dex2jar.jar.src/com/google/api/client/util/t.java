package com.google.api.client.util;

public abstract interface t
{
  public static final t aee = new t()
  {
    public long nanoTime()
    {
      return System.nanoTime();
    }
  };
  
  public abstract long nanoTime();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */