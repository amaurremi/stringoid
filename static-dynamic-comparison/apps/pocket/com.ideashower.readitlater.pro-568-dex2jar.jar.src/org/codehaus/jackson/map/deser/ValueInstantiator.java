package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.introspect.AnnotatedWithParams;
import org.codehaus.jackson.type.JavaType;

public abstract class ValueInstantiator
{
  public boolean canCreateFromBoolean()
  {
    return false;
  }
  
  public boolean canCreateFromDouble()
  {
    return false;
  }
  
  public boolean canCreateFromInt()
  {
    return false;
  }
  
  public boolean canCreateFromLong()
  {
    return false;
  }
  
  public boolean canCreateFromObjectWith()
  {
    return false;
  }
  
  public boolean canCreateFromString()
  {
    return false;
  }
  
  public boolean canCreateUsingDefault()
  {
    return getDefaultCreator() != null;
  }
  
  public boolean canCreateUsingDelegate()
  {
    return getDelegateType() != null;
  }
  
  public boolean canInstantiate()
  {
    return (canCreateUsingDefault()) || (canCreateUsingDelegate()) || (canCreateFromObjectWith()) || (canCreateFromString()) || (canCreateFromInt()) || (canCreateFromLong()) || (canCreateFromDouble()) || (canCreateFromBoolean());
  }
  
  public Object createFromBoolean(boolean paramBoolean)
  {
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON boolean value");
  }
  
  public Object createFromDouble(double paramDouble)
  {
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON floating-point number");
  }
  
  public Object createFromInt(int paramInt)
  {
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON int number");
  }
  
  public Object createFromLong(long paramLong)
  {
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON long number");
  }
  
  public Object createFromObjectWith(Object[] paramArrayOfObject)
  {
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " with arguments");
  }
  
  public Object createFromString(String paramString)
  {
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " from JSON String");
  }
  
  public Object createUsingDefault()
  {
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + "; no default creator found");
  }
  
  public Object createUsingDelegate(Object paramObject)
  {
    throw new JsonMappingException("Can not instantiate value of type " + getValueTypeDesc() + " using delegate");
  }
  
  public AnnotatedWithParams getDefaultCreator()
  {
    return null;
  }
  
  public AnnotatedWithParams getDelegateCreator()
  {
    return null;
  }
  
  public JavaType getDelegateType()
  {
    return null;
  }
  
  public SettableBeanProperty[] getFromObjectArguments()
  {
    return null;
  }
  
  public abstract String getValueTypeDesc();
  
  public AnnotatedWithParams getWithArgsCreator()
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/ValueInstantiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */