package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;

public abstract class TypeBase
  extends JavaType
  implements JsonSerializable
{
  volatile transient String _canonicalName;
  
  protected TypeBase(Class<?> paramClass, int paramInt, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramInt, paramObject1, paramObject2);
  }
  
  protected abstract String buildCanonicalName();
  
  public <T> T getTypeHandler()
  {
    return (T)this._typeHandler;
  }
  
  public <T> T getValueHandler()
  {
    return (T)this._valueHandler;
  }
  
  public String toCanonical()
  {
    String str2 = this._canonicalName;
    String str1 = str2;
    if (str2 == null) {
      str1 = buildCanonicalName();
    }
    return str1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/type/TypeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */