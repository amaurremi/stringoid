package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class StdContainerSerializers
{
  public static ContainerSerializerBase<?> collectionSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
  {
    return new CollectionSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
  }
  
  public static JsonSerializer<?> enumSetSerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    return new EnumSetSerializer(paramJavaType, paramBeanProperty);
  }
  
  public static ContainerSerializerBase<?> indexedListSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
  {
    return new IndexedListSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
  }
  
  public static ContainerSerializerBase<?> iterableSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    return new IterableSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty);
  }
  
  public static ContainerSerializerBase<?> iteratorSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    return new IteratorSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty);
  }
  
  @JacksonStdImpl
  public static class IndexedListSerializer
    extends AsArraySerializerBase<List<?>>
  {
    public IndexedListSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
    {
      super(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
    }
    
    public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
    {
      return new IndexedListSerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._property, this._elementSerializer);
    }
    
    public void serializeContents(List<?> paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
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
        Object localObject1;
        Class localClass;
        try
        {
          localObject2 = this._dynamicSerializers;
          if (i >= k) {
            break;
          }
          j = i;
          Object localObject4 = paramList.get(i);
          if (localObject4 == null)
          {
            j = i;
            paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
            localObject1 = localObject2;
          }
          else
          {
            j = i;
            localClass = localObject4.getClass();
            j = i;
            JsonSerializer localJsonSerializer = ((PropertySerializerMap)localObject2).serializerFor(localClass);
            Object localObject3 = localJsonSerializer;
            localObject1 = localObject2;
            if (localJsonSerializer == null)
            {
              j = i;
              if (this._elementType.hasGenericTypes())
              {
                j = i;
                localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, paramSerializerProvider.constructSpecializedType(this._elementType, localClass), paramSerializerProvider);
                j = i;
                localObject1 = this._dynamicSerializers;
                localObject3 = localObject2;
              }
            }
            else
            {
              j = i;
              ((JsonSerializer)localObject3).serialize(localObject4, paramJsonGenerator, paramSerializerProvider);
            }
          }
        }
        catch (Exception paramJsonGenerator)
        {
          wrapAndThrow(paramSerializerProvider, paramJsonGenerator, paramList, j);
          return;
        }
        j = i;
        Object localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, localClass, paramSerializerProvider);
        continue;
        i += 1;
        localObject2 = localObject1;
      }
    }
    
    public void serializeContentsUsing(List<?> paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, JsonSerializer<Object> paramJsonSerializer)
      throws IOException, JsonGenerationException
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
    
    public void serializeTypedContents(List<?> paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
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
        Object localObject1;
        Class localClass;
        try
        {
          TypeSerializer localTypeSerializer = this._valueTypeSerializer;
          j = k;
          localObject2 = this._dynamicSerializers;
          if (i >= m) {
            break;
          }
          j = i;
          Object localObject4 = paramList.get(i);
          if (localObject4 == null)
          {
            j = i;
            paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
            localObject1 = localObject2;
          }
          else
          {
            j = i;
            localClass = localObject4.getClass();
            j = i;
            JsonSerializer localJsonSerializer = ((PropertySerializerMap)localObject2).serializerFor(localClass);
            Object localObject3 = localJsonSerializer;
            localObject1 = localObject2;
            if (localJsonSerializer == null)
            {
              j = i;
              if (this._elementType.hasGenericTypes())
              {
                j = i;
                localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, paramSerializerProvider.constructSpecializedType(this._elementType, localClass), paramSerializerProvider);
                j = i;
                localObject1 = this._dynamicSerializers;
                localObject3 = localObject2;
              }
            }
            else
            {
              j = i;
              ((JsonSerializer)localObject3).serializeWithType(localObject4, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
            }
          }
        }
        catch (Exception paramJsonGenerator)
        {
          wrapAndThrow(paramSerializerProvider, paramJsonGenerator, paramList, j);
          return;
        }
        j = i;
        Object localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, localClass, paramSerializerProvider);
        continue;
        i += 1;
        localObject2 = localObject1;
      }
    }
  }
  
  @JacksonStdImpl
  public static class IteratorSerializer
    extends AsArraySerializerBase<Iterator<?>>
  {
    public IteratorSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
    {
      super(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, null);
    }
    
    public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
    {
      return new IteratorSerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._property);
    }
    
    public void serializeContents(Iterator<?> paramIterator, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      TypeSerializer localTypeSerializer;
      Object localObject1;
      Object localObject2;
      if (paramIterator.hasNext())
      {
        localTypeSerializer = this._valueTypeSerializer;
        localObject1 = null;
        localObject2 = null;
      }
      for (;;)
      {
        Object localObject4 = paramIterator.next();
        if (localObject4 == null) {
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        }
        while (!paramIterator.hasNext())
        {
          return;
          Class localClass = localObject4.getClass();
          Object localObject3;
          if (localClass == localObject2) {
            localObject3 = localObject1;
          }
          for (;;)
          {
            if (localTypeSerializer != null) {
              break label107;
            }
            ((JsonSerializer)localObject3).serialize(localObject4, paramJsonGenerator, paramSerializerProvider);
            break;
            localObject3 = paramSerializerProvider.findValueSerializer(localClass, this._property);
            localObject1 = localObject3;
            localObject2 = localClass;
          }
          label107:
          ((JsonSerializer)localObject3).serializeWithType(localObject4, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/std/StdContainerSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */