package com.mongodb.util;

public abstract interface ObjectSerializer
{
  public abstract String serialize(Object paramObject);
  
  public abstract void serialize(Object paramObject, StringBuilder paramStringBuilder);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/ObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */