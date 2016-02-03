package org.codehaus.jackson.map.ser.std;

import java.util.Iterator;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class IterableSerializer
  extends AsArraySerializerBase
{
  public IterableSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    super(Iterable.class, paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, null);
  }
  
  public ContainerSerializerBase _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return new IterableSerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._property);
  }
  
  public void serializeContents(Iterable paramIterable, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    Object localObject1 = null;
    Iterator localIterator = paramIterable.iterator();
    TypeSerializer localTypeSerializer;
    if (localIterator.hasNext())
    {
      localTypeSerializer = this._valueTypeSerializer;
      paramIterable = null;
    }
    for (;;)
    {
      Object localObject3 = localIterator.next();
      if (localObject3 == null) {
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
      }
      while (!localIterator.hasNext())
      {
        return;
        Object localObject2 = localObject3.getClass();
        if (localObject2 == localObject1) {}
        for (localObject2 = paramIterable;; localObject2 = paramIterable)
        {
          if (localTypeSerializer != null) {
            break label114;
          }
          ((JsonSerializer)localObject2).serialize(localObject3, paramJsonGenerator, paramSerializerProvider);
          break;
          paramIterable = paramSerializerProvider.findValueSerializer((Class)localObject2, this._property);
          localObject1 = localObject2;
        }
        label114:
        ((JsonSerializer)localObject2).serializeWithType(localObject3, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/IterableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */