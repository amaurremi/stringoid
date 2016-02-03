package org.codehaus.jackson.map.ser.std;

import java.util.List;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class StdContainerSerializers$IndexedListSerializer
  extends AsArraySerializerBase
{
  public StdContainerSerializers$IndexedListSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer paramJsonSerializer)
  {
    super(List.class, paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
  }
  
  public ContainerSerializerBase _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return new IndexedListSerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._property, this._elementSerializer);
  }
  
  public void serializeContents(List paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    if (this._elementSerializer != null) {
      serializeContentsUsing(paramList, paramJsonGenerator, paramSerializerProvider, this._elementSerializer);
    }
    int k;
    do
    {
      return;
      if (this._valueTypeSerializer != null)
      {
        serializeTypedContents(paramList, paramJsonGenerator, paramSerializerProvider);
        return;
      }
      k = paramList.size();
    } while (k == 0);
    int j = 0;
    int i = 0;
    for (;;)
    {
      Class localClass;
      try
      {
        localObject1 = this._dynamicSerializers;
        if (i >= k) {
          break;
        }
        j = i;
        Object localObject4 = paramList.get(i);
        if (localObject4 == null)
        {
          j = i;
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        }
        else
        {
          j = i;
          localClass = localObject4.getClass();
          j = i;
          JsonSerializer localJsonSerializer = ((PropertySerializerMap)localObject1).serializerFor(localClass);
          Object localObject2 = localObject1;
          Object localObject3 = localJsonSerializer;
          if (localJsonSerializer == null)
          {
            j = i;
            if (this._elementType.hasGenericTypes())
            {
              j = i;
              localObject1 = _findAndAddDynamic((PropertySerializerMap)localObject1, paramSerializerProvider.constructSpecializedType(this._elementType, localClass), paramSerializerProvider);
              j = i;
              localObject2 = this._dynamicSerializers;
              localObject3 = localObject1;
            }
          }
          else
          {
            j = i;
            ((JsonSerializer)localObject3).serialize(localObject4, paramJsonGenerator, paramSerializerProvider);
            localObject1 = localObject2;
          }
        }
      }
      catch (Exception paramJsonGenerator)
      {
        wrapAndThrow(paramSerializerProvider, paramJsonGenerator, paramList, j);
        return;
      }
      j = i;
      Object localObject1 = _findAndAddDynamic((PropertySerializerMap)localObject1, localClass, paramSerializerProvider);
      continue;
      i += 1;
    }
  }
  
  public void serializeContentsUsing(List paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, JsonSerializer paramJsonSerializer)
  {
    int j = paramList.size();
    if (j == 0) {}
    for (;;)
    {
      return;
      TypeSerializer localTypeSerializer = this._valueTypeSerializer;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramList.get(i);
        if (localObject == null) {}
        try
        {
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        }
        catch (Exception localException)
        {
          wrapAndThrow(paramSerializerProvider, localException, paramList, i);
        }
        if (localTypeSerializer == null) {
          paramJsonSerializer.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
        } else {
          paramJsonSerializer.serializeWithType(localException, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
        }
        i += 1;
      }
    }
  }
  
  public void serializeTypedContents(List paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    int m = paramList.size();
    if (m == 0) {
      return;
    }
    int k = 0;
    int i = 0;
    int j = k;
    for (;;)
    {
      Class localClass;
      try
      {
        TypeSerializer localTypeSerializer = this._valueTypeSerializer;
        j = k;
        localObject1 = this._dynamicSerializers;
        if (i >= m) {
          break;
        }
        j = i;
        Object localObject4 = paramList.get(i);
        if (localObject4 == null)
        {
          j = i;
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        }
        else
        {
          j = i;
          localClass = localObject4.getClass();
          j = i;
          JsonSerializer localJsonSerializer = ((PropertySerializerMap)localObject1).serializerFor(localClass);
          Object localObject2 = localObject1;
          Object localObject3 = localJsonSerializer;
          if (localJsonSerializer == null)
          {
            j = i;
            if (this._elementType.hasGenericTypes())
            {
              j = i;
              localObject1 = _findAndAddDynamic((PropertySerializerMap)localObject1, paramSerializerProvider.constructSpecializedType(this._elementType, localClass), paramSerializerProvider);
              j = i;
              localObject2 = this._dynamicSerializers;
              localObject3 = localObject1;
            }
          }
          else
          {
            j = i;
            ((JsonSerializer)localObject3).serializeWithType(localObject4, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
            localObject1 = localObject2;
          }
        }
      }
      catch (Exception paramJsonGenerator)
      {
        wrapAndThrow(paramSerializerProvider, paramJsonGenerator, paramList, j);
        return;
      }
      j = i;
      Object localObject1 = _findAndAddDynamic((PropertySerializerMap)localObject1, localClass, paramSerializerProvider);
      continue;
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdContainerSerializers$IndexedListSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */