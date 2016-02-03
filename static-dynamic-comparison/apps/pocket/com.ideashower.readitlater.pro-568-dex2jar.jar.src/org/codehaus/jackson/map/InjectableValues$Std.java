package org.codehaus.jackson.map;

import java.util.HashMap;
import java.util.Map;

public class InjectableValues$Std
  extends InjectableValues
{
  protected final Map _values;
  
  public InjectableValues$Std()
  {
    this(new HashMap());
  }
  
  public InjectableValues$Std(Map paramMap)
  {
    this._values = paramMap;
  }
  
  public Std addValue(Class paramClass, Object paramObject)
  {
    this._values.put(paramClass.getName(), paramObject);
    return this;
  }
  
  public Std addValue(String paramString, Object paramObject)
  {
    this._values.put(paramString, paramObject);
    return this;
  }
  
  public Object findInjectableValue(Object paramObject1, DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty, Object paramObject2)
  {
    if (!(paramObject1 instanceof String))
    {
      if (paramObject1 == null) {}
      for (paramObject1 = "[null]";; paramObject1 = paramObject1.getClass().getName()) {
        throw new IllegalArgumentException("Unrecognized inject value id type (" + (String)paramObject1 + "), expecting String");
      }
    }
    paramObject1 = (String)paramObject1;
    paramDeserializationContext = this._values.get(paramObject1);
    if ((paramDeserializationContext == null) && (!this._values.containsKey(paramObject1))) {
      throw new IllegalArgumentException("No injectable id with value '" + (String)paramObject1 + "' found (for property '" + paramBeanProperty.getName() + "')");
    }
    return paramDeserializationContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/InjectableValues$Std.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */