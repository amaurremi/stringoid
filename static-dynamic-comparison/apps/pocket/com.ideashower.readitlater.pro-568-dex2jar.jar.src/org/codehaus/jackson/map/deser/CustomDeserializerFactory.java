package org.codehaus.jackson.map.deser;

import java.util.HashMap;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerFactory.Config;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

@Deprecated
public class CustomDeserializerFactory
  extends BeanDeserializerFactory
{
  protected HashMap _directClassMappings = null;
  protected HashMap _mixInAnnotations;
  
  public CustomDeserializerFactory()
  {
    this(null);
  }
  
  protected CustomDeserializerFactory(DeserializerFactory.Config paramConfig)
  {
    super(paramConfig);
  }
  
  public void addMixInAnnotationMapping(Class paramClass1, Class paramClass2)
  {
    if (this._mixInAnnotations == null) {
      this._mixInAnnotations = new HashMap();
    }
    this._mixInAnnotations.put(new ClassKey(paramClass1), paramClass2);
  }
  
  public void addSpecificMapping(Class paramClass, JsonDeserializer paramJsonDeserializer)
  {
    paramClass = new ClassKey(paramClass);
    if (this._directClassMappings == null) {
      this._directClassMappings = new HashMap();
    }
    this._directClassMappings.put(paramClass, paramJsonDeserializer);
  }
  
  public JsonDeserializer createArrayDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, ArrayType paramArrayType, BeanProperty paramBeanProperty)
  {
    Object localObject = new ClassKey(paramArrayType.getRawClass());
    if (this._directClassMappings != null)
    {
      localObject = (JsonDeserializer)this._directClassMappings.get(localObject);
      if (localObject != null) {
        return (JsonDeserializer)localObject;
      }
    }
    return super.createArrayDeserializer(paramDeserializationConfig, paramDeserializerProvider, paramArrayType, paramBeanProperty);
  }
  
  public JsonDeserializer createBeanDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    Object localObject = new ClassKey(paramJavaType.getRawClass());
    if (this._directClassMappings != null)
    {
      localObject = (JsonDeserializer)this._directClassMappings.get(localObject);
      if (localObject != null) {
        return (JsonDeserializer)localObject;
      }
    }
    return super.createBeanDeserializer(paramDeserializationConfig, paramDeserializerProvider, paramJavaType, paramBeanProperty);
  }
  
  public JsonDeserializer createEnumDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    if (this._directClassMappings != null)
    {
      Object localObject = new ClassKey(paramJavaType.getRawClass());
      localObject = (JsonDeserializer)this._directClassMappings.get(localObject);
      if (localObject != null) {
        return (JsonDeserializer)localObject;
      }
    }
    return super.createEnumDeserializer(paramDeserializationConfig, paramDeserializerProvider, paramJavaType, paramBeanProperty);
  }
  
  public DeserializerFactory withConfig(DeserializerFactory.Config paramConfig)
  {
    if (getClass() != CustomDeserializerFactory.class) {
      throw new IllegalStateException("Subtype of CustomDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with " + "additional deserializer definitions");
    }
    return new CustomDeserializerFactory(paramConfig);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/CustomDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */