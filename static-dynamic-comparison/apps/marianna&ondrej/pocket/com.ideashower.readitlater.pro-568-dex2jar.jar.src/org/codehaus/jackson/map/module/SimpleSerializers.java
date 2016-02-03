package org.codehaus.jackson.map.module;

import java.util.HashMap;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.Serializers.Base;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.type.JavaType;

public class SimpleSerializers
  extends Serializers.Base
{
  protected HashMap _classMappings = null;
  protected HashMap _interfaceMappings = null;
  
  private void _addSerializer(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    ClassKey localClassKey = new ClassKey(paramClass);
    if (paramClass.isInterface())
    {
      if (this._interfaceMappings == null) {
        this._interfaceMappings = new HashMap();
      }
      this._interfaceMappings.put(localClassKey, paramJsonSerializer);
      return;
    }
    if (this._classMappings == null) {
      this._classMappings = new HashMap();
    }
    this._classMappings.put(localClassKey, paramJsonSerializer);
  }
  
  protected JsonSerializer _findInterfaceMapping(Class paramClass, ClassKey paramClassKey)
  {
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfClass[i];
      paramClassKey.reset((Class)localObject);
      paramClass = (JsonSerializer)this._interfaceMappings.get(paramClassKey);
      if (paramClass != null) {}
      do
      {
        return paramClass;
        localObject = _findInterfaceMapping((Class)localObject, paramClassKey);
        paramClass = (Class)localObject;
      } while (localObject != null);
      i += 1;
    }
    return null;
  }
  
  public void addSerializer(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    _addSerializer(paramClass, paramJsonSerializer);
  }
  
  public void addSerializer(JsonSerializer paramJsonSerializer)
  {
    Class localClass = paramJsonSerializer.handledType();
    if ((localClass == null) || (localClass == Object.class)) {
      throw new IllegalArgumentException("JsonSerializer of type " + paramJsonSerializer.getClass().getName() + " does not define valid handledType() -- must either register with method that takes type argument " + " or make serializer extend 'org.codehaus.jackson.map.ser.std.SerializerBase'");
    }
    _addSerializer(localClass, paramJsonSerializer);
  }
  
  public JsonSerializer findArraySerializer(SerializationConfig paramSerializationConfig, ArrayType paramArrayType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramArrayType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer findCollectionLikeSerializer(SerializationConfig paramSerializationConfig, CollectionLikeType paramCollectionLikeType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramCollectionLikeType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer findCollectionSerializer(SerializationConfig paramSerializationConfig, CollectionType paramCollectionType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramCollectionType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer findMapLikeSerializer(SerializationConfig paramSerializationConfig, MapLikeType paramMapLikeType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, JsonSerializer paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer paramJsonSerializer2)
  {
    return findSerializer(paramSerializationConfig, paramMapLikeType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer findMapSerializer(SerializationConfig paramSerializationConfig, MapType paramMapType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, JsonSerializer paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer paramJsonSerializer2)
  {
    return findSerializer(paramSerializationConfig, paramMapType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty)
  {
    paramJavaType = paramJavaType.getRawClass();
    ClassKey localClassKey = new ClassKey(paramJavaType);
    if (paramJavaType.isInterface())
    {
      if (this._interfaceMappings == null) {
        break label116;
      }
      paramSerializationConfig = (JsonSerializer)this._interfaceMappings.get(localClassKey);
      if (paramSerializationConfig == null) {
        break label116;
      }
    }
    label116:
    do
    {
      do
      {
        return paramSerializationConfig;
        if (this._classMappings == null) {
          break;
        }
        paramBeanDescription = (JsonSerializer)this._classMappings.get(localClassKey);
        paramSerializationConfig = paramBeanDescription;
      } while (paramBeanDescription != null);
      for (paramBeanDescription = paramJavaType;; paramBeanDescription = paramBeanDescription.getSuperclass())
      {
        if (paramBeanDescription == null) {
          break label116;
        }
        localClassKey.reset(paramBeanDescription);
        paramBeanProperty = (JsonSerializer)this._classMappings.get(localClassKey);
        paramSerializationConfig = paramBeanProperty;
        if (paramBeanProperty != null) {
          break;
        }
      }
      if (this._interfaceMappings == null) {
        break;
      }
      paramBeanDescription = _findInterfaceMapping(paramJavaType, localClassKey);
      paramSerializationConfig = paramBeanDescription;
    } while (paramBeanDescription != null);
    if (!paramJavaType.isInterface())
    {
      paramSerializationConfig = paramJavaType;
      do
      {
        paramSerializationConfig = paramSerializationConfig.getSuperclass();
        if (paramSerializationConfig == null) {
          break;
        }
        paramJavaType = _findInterfaceMapping(paramSerializationConfig, localClassKey);
      } while (paramJavaType == null);
      return paramJavaType;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/module/SimpleSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */