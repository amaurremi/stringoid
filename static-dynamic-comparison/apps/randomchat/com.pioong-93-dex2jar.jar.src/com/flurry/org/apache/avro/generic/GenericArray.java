package com.flurry.org.apache.avro.generic;

import java.util.List;

public abstract interface GenericArray<T>
  extends List<T>, GenericContainer
{
  public abstract T peek();
  
  public abstract void reverse();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/generic/GenericArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */