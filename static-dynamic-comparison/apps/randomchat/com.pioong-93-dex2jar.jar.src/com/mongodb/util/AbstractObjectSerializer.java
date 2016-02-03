package com.mongodb.util;

abstract class AbstractObjectSerializer
  implements ObjectSerializer
{
  public String serialize(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    serialize(paramObject, localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/AbstractObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */