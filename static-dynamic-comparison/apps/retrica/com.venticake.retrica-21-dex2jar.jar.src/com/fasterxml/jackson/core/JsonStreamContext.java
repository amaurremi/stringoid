package com.fasterxml.jackson.core;

public abstract class JsonStreamContext
{
  protected int _index;
  protected int _type;
  
  public final int getCurrentIndex()
  {
    if (this._index < 0) {
      return 0;
    }
    return this._index;
  }
  
  public final String getTypeDesc()
  {
    switch (this._type)
    {
    default: 
      return "?";
    case 0: 
      return "ROOT";
    case 1: 
      return "ARRAY";
    }
    return "OBJECT";
  }
  
  public final boolean inArray()
  {
    return this._type == 1;
  }
  
  public final boolean inObject()
  {
    return this._type == 2;
  }
  
  public final boolean inRoot()
  {
    return this._type == 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/JsonStreamContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */