package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.JsonGenerator.Feature;
import com.flurry.org.codehaus.jackson.JsonParser.Feature;
import com.flurry.org.codehaus.jackson.Version;
import com.flurry.org.codehaus.jackson.Versioned;
import com.flurry.org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiators;
import com.flurry.org.codehaus.jackson.map.ser.BeanSerializerModifier;
import com.flurry.org.codehaus.jackson.map.type.TypeModifier;

public abstract class Module
  implements Versioned
{
  public abstract String getModuleName();
  
  public abstract void setupModule(SetupContext paramSetupContext);
  
  public abstract Version version();
  
  public static abstract interface SetupContext
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
    
    public abstract void setMixInAnnotations(Class<?> paramClass1, Class<?> paramClass2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */