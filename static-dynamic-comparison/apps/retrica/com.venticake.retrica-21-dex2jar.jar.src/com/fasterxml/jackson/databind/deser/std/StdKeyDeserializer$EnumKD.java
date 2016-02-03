package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;

@JacksonStdImpl
final class StdKeyDeserializer$EnumKD
  extends StdKeyDeserializer
{
  protected final AnnotatedMethod _factory;
  protected final EnumResolver<?> _resolver;
  
  protected StdKeyDeserializer$EnumKD(EnumResolver<?> paramEnumResolver, AnnotatedMethod paramAnnotatedMethod)
  {
    super(paramEnumResolver.getEnumClass());
    this._resolver = paramEnumResolver;
    this._factory = paramAnnotatedMethod;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    if (this._factory != null) {}
    do
    {
      Enum localEnum;
      do
      {
        try
        {
          Object localObject1 = this._factory.call1(paramString);
          return localObject1;
        }
        catch (Exception localException)
        {
          ClassUtil.unwrapAndThrowAsIAE(localException);
        }
        localEnum = this._resolver.findEnum(paramString);
        localObject2 = localEnum;
      } while (localEnum != null);
      Object localObject2 = localEnum;
    } while (paramDeserializationContext.getConfig().isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL));
    throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "not one of values for Enum class");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$EnumKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */