package org.codehaus.jackson.map.ext;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.util.Provider;
import org.codehaus.jackson.type.JavaType;

public class OptionalHandlerFactory
{
  private static final String CLASS_NAME_DOM_DOCUMENT = "org.w3c.dom.Node";
  private static final String CLASS_NAME_DOM_NODE = "org.w3c.dom.Node";
  private static final String DESERIALIZERS_FOR_JAVAX_XML = "org.codehaus.jackson.map.ext.CoreXMLDeserializers";
  private static final String DESERIALIZERS_FOR_JODA_DATETIME = "org.codehaus.jackson.map.ext.JodaDeserializers";
  private static final String DESERIALIZER_FOR_DOM_DOCUMENT = "org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer";
  private static final String DESERIALIZER_FOR_DOM_NODE = "org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer";
  private static final String PACKAGE_PREFIX_JAVAX_XML = "javax.xml.";
  private static final String PACKAGE_PREFIX_JODA_DATETIME = "org.joda.time.";
  private static final String SERIALIZERS_FOR_JAVAX_XML = "org.codehaus.jackson.map.ext.CoreXMLSerializers";
  private static final String SERIALIZERS_FOR_JODA_DATETIME = "org.codehaus.jackson.map.ext.JodaSerializers";
  private static final String SERIALIZER_FOR_DOM_NODE = "org.codehaus.jackson.map.ext.DOMSerializer";
  public static final OptionalHandlerFactory instance = new OptionalHandlerFactory();
  
  private boolean doesImplement(Class paramClass, String paramString)
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
  
  private boolean hasInterface(Class paramClass, String paramString)
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
  
  private boolean hasInterfaceStartingWith(Class paramClass, String paramString)
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
  
  private boolean hasSupertypeStartingWith(Class paramClass, String paramString)
  {
    Class localClass2;
    for (Class localClass1 = paramClass.getSuperclass();; localClass1 = localClass1.getSuperclass())
    {
      localClass2 = paramClass;
      if (localClass1 == null) {
        break;
      }
      if (localClass1.getName().startsWith(paramString)) {
        return true;
      }
    }
    do
    {
      localClass2 = localClass2.getSuperclass();
      if (localClass2 == null) {
        break;
      }
    } while (!hasInterfaceStartingWith(localClass2, paramString));
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
  
  public JsonDeserializer findDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
  {
    paramDeserializationConfig = paramJavaType.getRawClass();
    paramJavaType = paramDeserializationConfig.getName();
    if (paramJavaType.startsWith("org.joda.time.")) {}
    for (paramJavaType = "org.codehaus.jackson.map.ext.JodaDeserializers";; paramJavaType = "org.codehaus.jackson.map.ext.CoreXMLDeserializers")
    {
      paramJavaType = instantiate(paramJavaType);
      if (paramJavaType != null) {
        break label101;
      }
      return null;
      if ((!paramJavaType.startsWith("javax.xml.")) && (!hasSupertypeStartingWith(paramDeserializationConfig, "javax.xml."))) {
        break;
      }
    }
    if (doesImplement(paramDeserializationConfig, "org.w3c.dom.Node")) {
      return (JsonDeserializer)instantiate("org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer");
    }
    if (doesImplement(paramDeserializationConfig, "org.w3c.dom.Node")) {
      return (JsonDeserializer)instantiate("org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer");
    }
    return null;
    label101:
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
    while (paramJavaType.hasNext())
    {
      paramDeserializerProvider = (StdDeserializer)paramJavaType.next();
      if (paramDeserializerProvider.getValueClass().isAssignableFrom(paramDeserializationConfig)) {
        return paramDeserializerProvider;
      }
    }
    return null;
  }
  
  public JsonSerializer findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType)
  {
    paramJavaType = paramJavaType.getRawClass();
    paramSerializationConfig = paramJavaType.getName();
    if (paramSerializationConfig.startsWith("org.joda.time.")) {}
    for (paramSerializationConfig = "org.codehaus.jackson.map.ext.JodaSerializers";; paramSerializationConfig = "org.codehaus.jackson.map.ext.CoreXMLSerializers")
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
      return (JsonSerializer)instantiate("org.codehaus.jackson.map.ext.DOMSerializer");
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/OptionalHandlerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */