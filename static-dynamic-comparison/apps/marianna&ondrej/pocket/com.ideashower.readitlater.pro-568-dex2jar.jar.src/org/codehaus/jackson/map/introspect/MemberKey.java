package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class MemberKey
{
  static final Class[] NO_CLASSES = new Class[0];
  final Class[] _argTypes;
  final String _name;
  
  public MemberKey(String paramString, Class[] paramArrayOfClass)
  {
    this._name = paramString;
    paramString = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      paramString = NO_CLASSES;
    }
    this._argTypes = paramString;
  }
  
  public MemberKey(Constructor paramConstructor)
  {
    this("", paramConstructor.getParameterTypes());
  }
  
  public MemberKey(Method paramMethod)
  {
    this(paramMethod.getName(), paramMethod.getParameterTypes());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (MemberKey)paramObject;
    if (!this._name.equals(((MemberKey)paramObject)._name)) {
      return false;
    }
    paramObject = ((MemberKey)paramObject)._argTypes;
    int j = this._argTypes.length;
    if (paramObject.length != j) {
      return false;
    }
    int i = 0;
    label68:
    Class localClass1;
    Class localClass2;
    if (i < j)
    {
      localClass1 = paramObject[i];
      localClass2 = this._argTypes[i];
      if (localClass1 != localClass2) {
        break label100;
      }
    }
    label100:
    while ((localClass1.isAssignableFrom(localClass2)) || (localClass2.isAssignableFrom(localClass1)))
    {
      i += 1;
      break label68;
      break;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this._name.hashCode() + this._argTypes.length;
  }
  
  public String toString()
  {
    return this._name + "(" + this._argTypes.length + "-args)";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/MemberKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */