package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.util.Provider;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class OptionalHandlerFactory
  implements Serializable
{
  public static final OptionalHandlerFactory instance = new OptionalHandlerFactory();
  
  private boolean doesImplement(Class<?> paramClass, String paramString)
  {
    while (paramClass != null)
    {
      if (paramClass.getName().equals(paramString)) {}
      while (hasInterface(paramClass, paramString)) {
        return true;
      }
      paramClass = paramClass.getSuperclass();
    }
    return false;
  }
  
  private boolean hasInterface(Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      if (paramClass[i].getName().equals(paramString)) {
        return true;
      }
      i += 1;
    }
    j = paramClass.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label69;
      }
      if (hasInterface(paramClass[i], paramString)) {
        break;
      }
      i += 1;
    }
    label69:
    return false;
  }
  
  private boolean hasInterfaceStartingWith(Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      if (paramClass[i].getName().startsWith(paramString)) {
        return true;
      }
      i += 1;
    }
    j = paramClass.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label69;
      }
      if (hasInterfaceStartingWith(paramClass[i], paramString)) {
        break;
      }
      i += 1;
    }
    label69:
    return false;
  }
  
  private boolean hasSupertypeStartingWith(Class<?> paramClass, String paramString)
  {
    Object localObject;
    for (Class localClass = paramClass.getSuperclass();; localClass = localClass.getSuperclass())
    {
      localObject = paramClass;
      if (localClass == null) {
        break;
      }
      if (localClass.getName().startsWith(paramString)) {
        return true;
      }
    }
    do
    {
      localObject = ((Class)localObject).getSuperclass();
      if (localObject == null) {
        break;
      }
    } while (!hasInterfaceStartingWith((Class)localObject, paramString));
    return true;
    return false;
  }
  
  private Object instantiate(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (Exception paramString)
    {
      return null;
    }
    catch (LinkageError paramString)
    {
      for (;;) {}
    }
  }
  
  public JsonDeserializer<?> findDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig)
  {
    paramJavaType = paramJavaType.getRawClass();
    if ((paramJavaType.getName().startsWith("javax.xml.")) || (hasSupertypeStartingWith(paramJavaType, "javax.xml.")))
    {
      paramDeserializationConfig = instantiate("com.fasterxml.jackson.databind.ext.CoreXMLDeserializers");
      if (paramDeserializationConfig == null) {
        return null;
      }
    }
    else
    {
      if (doesImplement(paramJavaType, "org.w3c.dom.Node")) {
        return (JsonDeserializer)instantiate("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer");
      }
      if (doesImplement(paramJavaType, "org.w3c.dom.Node")) {
        return (JsonDeserializer)instantiate("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer");
      }
      return null;
    }
    paramDeserializationConfig = ((Provider)paramDeserializationConfig).provide();
    Object localObject = paramDeserializationConfig.iterator();
    while (((Iterator)localObject).hasNext())
    {
      StdDeserializer localStdDeserializer = (StdDeserializer)((Iterator)localObject).next();
      if (paramJavaType == localStdDeserializer.getValueClass()) {
        return localStdDeserializer;
      }
    }
    paramDeserializationConfig = paramDeserializationConfig.iterator();
    while (paramDeserializationConfig.hasNext())
    {
      localObject = (StdDeserializer)paramDeserializationConfig.next();
      if (((StdDeserializer)localObject).getValueClass().isAssignableFrom(paramJavaType)) {
        return (JsonDeserializer<?>)localObject;
      }
    }
    return null;
  }
  
  public JsonSerializer<?> findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType)
  {
    paramSerializationConfig = paramJavaType.getRawClass();
    if ((paramSerializationConfig.getName().startsWith("javax.xml.")) || (hasSupertypeStartingWith(paramSerializationConfig, "javax.xml.")))
    {
      paramJavaType = instantiate("com.fasterxml.jackson.databind.ext.CoreXMLSerializers");
      if (paramJavaType == null) {
        return null;
      }
    }
    else
    {
      if (doesImplement(paramSerializationConfig, "org.w3c.dom.Node")) {
        return (JsonSerializer)instantiate("com.fasterxml.jackson.databind.ext.DOMSerializer");
      }
      return null;
    }
    paramJavaType = ((Provider)paramJavaType).provide();
    Object localObject = paramJavaType.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (paramSerializationConfig == localEntry.getKey()) {
        return (JsonSerializer)localEntry.getValue();
      }
    }
    paramJavaType = paramJavaType.iterator();
    while (paramJavaType.hasNext())
    {
      localObject = (Map.Entry)paramJavaType.next();
      if (((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramSerializationConfig)) {
        return (JsonSerializer)((Map.Entry)localObject).getValue();
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ext/OptionalHandlerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */