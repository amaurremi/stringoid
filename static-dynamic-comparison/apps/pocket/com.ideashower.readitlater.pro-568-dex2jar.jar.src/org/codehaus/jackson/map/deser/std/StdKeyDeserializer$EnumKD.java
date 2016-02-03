package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.EnumResolver;

final class StdKeyDeserializer$EnumKD
  extends StdKeyDeserializer
{
  protected final AnnotatedMethod _factory;
  protected final EnumResolver _resolver;
  
  protected StdKeyDeserializer$EnumKD(EnumResolver paramEnumResolver, AnnotatedMethod paramAnnotatedMethod)
  {
    super(paramEnumResolver.getEnumClass());
    this._resolver = paramEnumResolver;
    this._factory = paramAnnotatedMethod;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    if (this._factory != null) {}
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
      Object localObject2 = localEnum;
    } while (localEnum != null);
    throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "not one of values for Enum class");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$EnumKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */