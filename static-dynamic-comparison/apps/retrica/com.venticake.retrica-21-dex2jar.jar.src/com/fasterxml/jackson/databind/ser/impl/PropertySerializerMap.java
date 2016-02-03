package com.fasterxml.jackson.databind.ser.impl;

public abstract class PropertySerializerMap
{
  public static PropertySerializerMap emptyMap()
  {
    return PropertySerializerMap.Empty.instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/PropertySerializerMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */