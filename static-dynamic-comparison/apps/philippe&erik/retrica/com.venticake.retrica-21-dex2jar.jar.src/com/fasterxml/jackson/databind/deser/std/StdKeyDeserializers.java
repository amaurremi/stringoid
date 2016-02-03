package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class StdKeyDeserializers
{
  protected final HashMap<JavaType, KeyDeserializer> _keyDeserializers = new HashMap();
  
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
    add(new StdKeyDeserializer.LocaleKD());
  }
  
  private void add(StdKeyDeserializer paramStdKeyDeserializer)
  {
    Class localClass = paramStdKeyDeserializer.getKeyClass();
    this._keyDeserializers.put(TypeFactory.defaultInstance().constructType(localClass), paramStdKeyDeserializer);
  }
  
  public static HashMap<JavaType, KeyDeserializer> constructAll()
  {
    return new StdKeyDeserializers()._keyDeserializers;
  }
  
  public static KeyDeserializer constructDelegatingKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer)
  {
    return new StdKeyDeserializer.DelegatingKD(paramJavaType.getRawClass(), paramJsonDeserializer);
  }
  
  public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver<?> paramEnumResolver)
  {
    return new StdKeyDeserializer.EnumKD(paramEnumResolver, null);
  }
  
  public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver<?> paramEnumResolver, AnnotatedMethod paramAnnotatedMethod)
  {
    return new StdKeyDeserializer.EnumKD(paramEnumResolver, paramAnnotatedMethod);
  }
  
  public static KeyDeserializer constructStringKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    return StdKeyDeserializer.StringKD.forType(paramJavaType.getRawClass());
  }
  
  public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    paramJavaType = paramDeserializationConfig.introspect(paramJavaType);
    Constructor localConstructor = paramJavaType.findSingleArgConstructor(new Class[] { String.class });
    if (localConstructor != null)
    {
      if (paramDeserializationConfig.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(localConstructor);
      }
      return new StdKeyDeserializer.StringCtorKeyDeserializer(localConstructor);
    }
    paramJavaType = paramJavaType.findFactoryMethod(new Class[] { String.class });
    if (paramJavaType != null)
    {
      if (paramDeserializationConfig.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(paramJavaType);
      }
      return new StdKeyDeserializer.StringFactoryKeyDeserializer(paramJavaType);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */