package org.codehaus.jackson.map.module;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

public class SimpleAbstractTypeResolver
  extends AbstractTypeResolver
{
  protected final HashMap _mappings = new HashMap();
  
  public SimpleAbstractTypeResolver addMapping(Class paramClass1, Class paramClass2)
  {
    if (paramClass1 == paramClass2) {
      throw new IllegalArgumentException("Can not add mapping from class to itself");
    }
    if (!paramClass1.isAssignableFrom(paramClass2)) {
      throw new IllegalArgumentException("Can not add mapping from class " + paramClass1.getName() + " to " + paramClass2.getName() + ", as latter is not a subtype of former");
    }
    if (!Modifier.isAbstract(paramClass1.getModifiers())) {
      throw new IllegalArgumentException("Can not add mapping from class " + paramClass1.getName() + " since it is not abstract");
    }
    this._mappings.put(new ClassKey(paramClass1), paramClass2);
    return this;
  }
  
  public JavaType findTypeMapping(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    paramDeserializationConfig = paramJavaType.getRawClass();
    paramDeserializationConfig = (Class)this._mappings.get(new ClassKey(paramDeserializationConfig));
    if (paramDeserializationConfig == null) {
      return null;
    }
    return paramJavaType.narrowBy(paramDeserializationConfig);
  }
  
  public JavaType resolveAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/module/SimpleAbstractTypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */