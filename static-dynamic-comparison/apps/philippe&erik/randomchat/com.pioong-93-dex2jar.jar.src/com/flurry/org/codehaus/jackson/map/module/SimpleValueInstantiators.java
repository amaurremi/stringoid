package com.flurry.org.codehaus.jackson.map.module;

import com.flurry.org.codehaus.jackson.map.BeanDescription;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import java.util.HashMap;

public class SimpleValueInstantiators
  extends ValueInstantiators.Base
{
  protected HashMap<ClassKey, ValueInstantiator> _classMappings = new HashMap();
  
  public SimpleValueInstantiators addValueInstantiator(Class<?> paramClass, ValueInstantiator paramValueInstantiator)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/module/SimpleValueInstantiators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */