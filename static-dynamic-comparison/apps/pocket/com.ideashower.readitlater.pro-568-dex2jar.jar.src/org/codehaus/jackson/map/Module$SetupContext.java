package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonGenerator.Feature;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.map.deser.ValueInstantiators;
import org.codehaus.jackson.map.ser.BeanSerializerModifier;
import org.codehaus.jackson.map.type.TypeModifier;

public abstract interface Module$SetupContext
{
  public abstract void addAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver);
  
  public abstract void addBeanDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier);
  
  public abstract void addBeanSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier);
  
  public abstract void addDeserializers(Deserializers paramDeserializers);
  
  public abstract void addKeyDeserializers(KeyDeserializers paramKeyDeserializers);
  
  public abstract void addKeySerializers(Serializers paramSerializers);
  
  public abstract void addSerializers(Serializers paramSerializers);
  
  public abstract void addTypeModifier(TypeModifier paramTypeModifier);
  
  public abstract void addValueInstantiators(ValueInstantiators paramValueInstantiators);
  
  public abstract void appendAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract DeserializationConfig getDeserializationConfig();
  
  public abstract Version getMapperVersion();
  
  public abstract SerializationConfig getSerializationConfig();
  
  public abstract void insertAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract boolean isEnabled(JsonGenerator.Feature paramFeature);
  
  public abstract boolean isEnabled(JsonParser.Feature paramFeature);
  
  public abstract boolean isEnabled(DeserializationConfig.Feature paramFeature);
  
  public abstract boolean isEnabled(SerializationConfig.Feature paramFeature);
  
  public abstract void setMixInAnnotations(Class paramClass1, Class paramClass2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/Module$SetupContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */