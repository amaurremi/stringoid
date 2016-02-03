package org.codehaus.jackson.map.module;

import java.util.HashMap;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.deser.ValueInstantiator;
import org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import org.codehaus.jackson.map.type.ClassKey;

public class SimpleValueInstantiators
  extends ValueInstantiators.Base
{
  protected HashMap _classMappings = new HashMap();
  
  public SimpleValueInstantiators addValueInstantiator(Class paramClass, ValueInstantiator paramValueInstantiator)
  {
    this._classMappings.put(new ClassKey(paramClass), paramValueInstantiator);
    return this;
  }
  
  public ValueInstantiator findValueInstantiator(DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, ValueInstantiator paramValueInstantiator)
  {
    paramDeserializationConfig = (ValueInstantiator)this._classMappings.get(new ClassKey(paramBeanDescription.getBeanClass()));
    if (paramDeserializationConfig == null) {
      return paramValueInstantiator;
    }
    return paramDeserializationConfig;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/module/SimpleValueInstantiators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */