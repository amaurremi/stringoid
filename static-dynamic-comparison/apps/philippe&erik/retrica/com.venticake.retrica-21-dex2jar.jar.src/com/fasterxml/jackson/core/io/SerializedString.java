package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.Serializable;

public class SerializedString
  implements SerializableString, Serializable
{
  protected final String _value;
  
  public SerializedString(String paramString)
  {
    if (paramString == null) {
      throw new IllegalStateException("Null String illegal for SerializedString");
    }
    this._value = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      return false;
    }
    paramObject = (SerializedString)paramObject;
    return this._value.equals(((SerializedString)paramObject)._value);
  }
  
  public final String getValue()
  {
    return this._value;
  }
  
  public final int hashCode()
  {
    return this._value.hashCode();
  }
  
  public final String toString()
  {
    return this._value;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/io/SerializedString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */