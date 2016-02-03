package org.codehaus.jackson.map.deser.std;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.EnumResolver;
import org.codehaus.jackson.type.JavaType;

public class StdKeyDeserializers
{
  protected final HashMap _keyDeserializers = new HashMap();
  
  protected StdKeyDeserializers()
  {
    add(new StdKeyDeserializer.BoolKD());
    add(new StdKeyDeserializer.ByteKD());
    add(new StdKeyDeserializer.CharKD());
    add(new StdKeyDeserializer.ShortKD());
    add(new StdKeyDeserializer.IntKD());
    add(new StdKeyDeserializer.LongKD());
    add(new StdKeyDeserializer.FloatKD());
    add(new StdKeyDeserializer.DoubleKD());
    add(new StdKeyDeserializer.DateKD());
    add(new StdKeyDeserializer.CalendarKD());
    add(new StdKeyDeserializer.UuidKD());
  }
  
  private void add(StdKeyDeserializer paramStdKeyDeserializer)
  {
    Class localClass = paramStdKeyDeserializer.getKeyClass();
    this._keyDeserializers.put(TypeFactory.defaultInstance().uncheckedSimpleType(localClass), paramStdKeyDeserializer);
  }
  
  public static HashMap constructAll()
  {
    return new StdKeyDeserializers()._keyDeserializers;
  }
  
  public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver paramEnumResolver)
  {
    return new StdKeyDeserializer.EnumKD(paramEnumResolver, null);
  }
  
  public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver paramEnumResolver, AnnotatedMethod paramAnnotatedMethod)
  {
    return new StdKeyDeserializer.EnumKD(paramEnumResolver, paramAnnotatedMethod);
  }
  
  public static KeyDeserializer constructStringKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    return StdKeyDeserializer.StringKD.forType(paramJavaType.getClass());
  }
  
  public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    paramJavaType = (BasicBeanDescription)paramDeserializationConfig.introspect(paramJavaType);
    Constructor localConstructor = paramJavaType.findSingleArgConstructor(new Class[] { String.class });
    if (localConstructor != null)
    {
      if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
        ClassUtil.checkAndFixAccess(localConstructor);
      }
      return new StdKeyDeserializer.StringCtorKeyDeserializer(localConstructor);
    }
    paramJavaType = paramJavaType.findFactoryMethod(new Class[] { String.class });
    if (paramJavaType != null)
    {
      if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
        ClassUtil.checkAndFixAccess(paramJavaType);
      }
      return new StdKeyDeserializer.StringFactoryKeyDeserializer(paramJavaType);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */