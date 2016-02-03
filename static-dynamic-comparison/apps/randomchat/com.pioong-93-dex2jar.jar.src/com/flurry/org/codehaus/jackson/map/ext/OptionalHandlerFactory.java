package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializerProvider;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializationConfig;
import com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer;
import com.flurry.org.codehaus.jackson.map.util.Provider;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class OptionalHandlerFactory
{
  private static final String CLASS_NAME_DOM_DOCUMENT = "org.w3c.dom.Node";
  private static final String CLASS_NAME_DOM_NODE = "org.w3c.dom.Node";
  private static final String DESERIALIZERS_FOR_JAVAX_XML = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLDeserializers";
  private static final String DESERIALIZERS_FOR_JODA_DATETIME = "com.flurry.org.codehaus.jackson.map.ext.JodaDeserializers";
  private static final String DESERIALIZER_FOR_DOM_DOCUMENT = "com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer";
  private static final String DESERIALIZER_FOR_DOM_NODE = "com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer";
  private static final String PACKAGE_PREFIX_JAVAX_XML = "javax.xml.";
  private static final String PACKAGE_PREFIX_JODA_DATETIME = "org.joda.time.";
  private static final String SERIALIZERS_FOR_JAVAX_XML = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLSerializers";
  private static final String SERIALIZERS_FOR_JODA_DATETIME = "com.flurry.org.codehaus.jackson.map.ext.JodaSerializers";
  private static final String SERIALIZER_FOR_DOM_NODE = "com.flurry.org.codehaus.jackson.map.ext.DOMSerializer";
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
    for (Class localClass = paramClass.getSuperclass(); localClass != null; localClass = localClass.getSuperclass()) {
      if (localClass.getName().startsWith(paramString)) {
        return true;
      }
    }
    for (;;)
    {
      if (paramClass == null) {
        break label51;
      }
      if (hasInterfaceStartingWith(paramClass, paramString)) {
        break;
      }
      paramClass = paramClass.getSuperclass();
    }
    label51:
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
  
  public JsonDeserializer<?> findDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
  {
    paramDeserializationConfig = paramJavaType.getRawClass();
    paramJavaType = paramDeserializationConfig.getName();
    if (paramJavaType.startsWith("org.joda.time."))
    {
      paramJavaType = "com.flurry.org.codehaus.jackson.map.ext.JodaDeserializers";
      paramJavaType = instantiate(paramJavaType);
      if (paramJavaType != null) {
        break label99;
      }
    }
    label99:
    do
    {
      while (!paramJavaType.hasNext())
      {
        do
        {
          return null;
          if ((paramJavaType.startsWith("javax.xml.")) || (hasSupertypeStartingWith(paramDeserializationConfig, "javax.xml.")))
          {
            paramJavaType = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLDeserializers";
            break;
          }
          if (doesImplement(paramDeserializationConfig, "org.w3c.dom.Node")) {
            return (JsonDeserializer)instantiate("com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer");
          }
        } while (!doesImplement(paramDeserializationConfig, "org.w3c.dom.Node"));
        return (JsonDeserializer)instantiate("com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer");
        paramJavaType = ((Provider)paramJavaType).provide();
        paramDeserializerProvider = paramJavaType.iterator();
        while (paramDeserializerProvider.hasNext())
        {
          StdDeserializer localStdDeserializer = (StdDeserializer)paramDeserializerProvider.next();
          if (paramDeserializationConfig == localStdDeserializer.getValueClass()) {
            return localStdDeserializer;
          }
        }
        paramJavaType = paramJavaType.iterator();
      }
      paramDeserializerProvider = (StdDeserializer)paramJavaType.next();
    } while (!paramDeserializerProvider.getValueClass().isAssignableFrom(paramDeserializationConfig));
    return paramDeserializerProvider;
  }
  
  public JsonSerializer<?> findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType)
  {
    paramJavaType = paramJavaType.getRawClass();
    paramSerializationConfig = paramJavaType.getName();
    if (paramSerializationConfig.startsWith("org.joda.time.")) {}
    for (paramSerializationConfig = "com.flurry.org.codehaus.jackson.map.ext.JodaSerializers";; paramSerializationConfig = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLSerializers")
    {
      paramSerializationConfig = instantiate(paramSerializationConfig);
      if (paramSerializationConfig != null) {
        break label81;
      }
      return null;
      if ((!paramSerializationConfig.startsWith("javax.xml.")) && (!hasSupertypeStartingWith(paramJavaType, "javax.xml."))) {
        break;
      }
    }
    if (doesImplement(paramJavaType, "org.w3c.dom.Node")) {
      return (JsonSerializer)instantiate("com.flurry.org.codehaus.jackson.map.ext.DOMSerializer");
    }
    return null;
    label81:
    paramSerializationConfig = ((Provider)paramSerializationConfig).provide();
    Object localObject = paramSerializationConfig.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (paramJavaType == localEntry.getKey()) {
        return (JsonSerializer)localEntry.getValue();
      }
    }
    paramSerializationConfig = paramSerializationConfig.iterator();
    while (paramSerializationConfig.hasNext())
    {
      localObject = (Map.Entry)paramSerializationConfig.next();
      if (((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramJavaType)) {
        return (JsonSerializer)((Map.Entry)localObject).getValue();
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ext/OptionalHandlerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */