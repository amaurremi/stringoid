package org.codehaus.jackson.map.ser;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.SerializerFactory.Config;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

public class CustomSerializerFactory
  extends BeanSerializerFactory
{
  protected HashMap _directClassMappings = null;
  protected JsonSerializer _enumSerializerOverride;
  protected HashMap _interfaceMappings = null;
  protected HashMap _transitiveClassMappings = null;
  
  public CustomSerializerFactory()
  {
    this(null);
  }
  
  public CustomSerializerFactory(SerializerFactory.Config paramConfig)
  {
    super(paramConfig);
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
  
  public void addGenericMapping(Class paramClass, JsonSerializer paramJsonSerializer)
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
    if (this._transitiveClassMappings == null) {
      this._transitiveClassMappings = new HashMap();
    }
    this._transitiveClassMappings.put(localClassKey, paramJsonSerializer);
  }
  
  public void addSpecificMapping(Class paramClass, JsonSerializer paramJsonSerializer)
  {
    ClassKey localClassKey = new ClassKey(paramClass);
    if (paramClass.isInterface()) {
      throw new IllegalArgumentException("Can not add specific mapping for an interface (" + paramClass.getName() + ")");
    }
    if (Modifier.isAbstract(paramClass.getModifiers())) {
      throw new IllegalArgumentException("Can not add specific mapping for an abstract class (" + paramClass.getName() + ")");
    }
    if (this._directClassMappings == null) {
      this._directClassMappings = new HashMap();
    }
    this._directClassMappings.put(localClassKey, paramJsonSerializer);
  }
  
  public JsonSerializer createSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    JsonSerializer localJsonSerializer = findCustomSerializer(paramJavaType.getRawClass(), paramSerializationConfig);
    if (localJsonSerializer != null) {
      return localJsonSerializer;
    }
    return super.createSerializer(paramSerializationConfig, paramJavaType, paramBeanProperty);
  }
  
  protected JsonSerializer findCustomSerializer(Class paramClass, SerializationConfig paramSerializationConfig)
  {
    ClassKey localClassKey = new ClassKey(paramClass);
    if (this._directClassMappings != null)
    {
      paramSerializationConfig = (JsonSerializer)this._directClassMappings.get(localClassKey);
      if (paramSerializationConfig == null) {}
    }
    Object localObject;
    label104:
    do
    {
      return paramSerializationConfig;
      if ((paramClass.isEnum()) && (this._enumSerializerOverride != null)) {
        return this._enumSerializerOverride;
      }
      if (this._transitiveClassMappings != null) {
        for (localObject = paramClass;; localObject = ((Class)localObject).getSuperclass())
        {
          if (localObject == null) {
            break label104;
          }
          localClassKey.reset((Class)localObject);
          JsonSerializer localJsonSerializer = (JsonSerializer)this._transitiveClassMappings.get(localClassKey);
          paramSerializationConfig = localJsonSerializer;
          if (localJsonSerializer != null) {
            break;
          }
        }
      }
      if (this._interfaceMappings == null) {
        break;
      }
      localClassKey.reset(paramClass);
      localObject = (JsonSerializer)this._interfaceMappings.get(localClassKey);
      paramSerializationConfig = (SerializationConfig)localObject;
    } while (localObject != null);
    for (;;)
    {
      if (paramClass == null) {
        break label162;
      }
      localObject = _findInterfaceMapping(paramClass, localClassKey);
      paramSerializationConfig = (SerializationConfig)localObject;
      if (localObject != null) {
        break;
      }
      paramClass = paramClass.getSuperclass();
    }
    label162:
    return null;
  }
  
  public void setEnumSerializer(JsonSerializer paramJsonSerializer)
  {
    this._enumSerializerOverride = paramJsonSerializer;
  }
  
  public SerializerFactory withConfig(SerializerFactory.Config paramConfig)
  {
    if (getClass() != CustomSerializerFactory.class) {
      throw new IllegalStateException("Subtype of CustomSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
    }
    return new CustomSerializerFactory(paramConfig);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/CustomSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */