package com.flurry.org.codehaus.jackson.map.module;

import com.flurry.org.codehaus.jackson.Version;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer;
import com.flurry.org.codehaus.jackson.map.Module;
import com.flurry.org.codehaus.jackson.map.Module.SetupContext;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SimpleModule
  extends Module
{
  protected SimpleAbstractTypeResolver _abstractTypes = null;
  protected SimpleDeserializers _deserializers = null;
  protected SimpleKeyDeserializers _keyDeserializers = null;
  protected SimpleSerializers _keySerializers = null;
  protected HashMap<Class<?>, Class<?>> _mixins = null;
  protected final String _name;
  protected SimpleSerializers _serializers = null;
  protected SimpleValueInstantiators _valueInstantiators = null;
  protected final Version _version;
  
  public SimpleModule(String paramString, Version paramVersion)
  {
    this._name = paramString;
    this._version = paramVersion;
  }
  
  public <T> SimpleModule addAbstractTypeMapping(Class<T> paramClass, Class<? extends T> paramClass1)
  {
    if (this._abstractTypes == null) {
      this._abstractTypes = new SimpleAbstractTypeResolver();
    }
    this._abstractTypes = this._abstractTypes.addMapping(paramClass, paramClass1);
    return this;
  }
  
  public <T> SimpleModule addDeserializer(Class<T> paramClass, JsonDeserializer<? extends T> paramJsonDeserializer)
  {
    if (this._deserializers == null) {
      this._deserializers = new SimpleDeserializers();
    }
    this._deserializers.addDeserializer(paramClass, paramJsonDeserializer);
    return this;
  }
  
  public SimpleModule addKeyDeserializer(Class<?> paramClass, KeyDeserializer paramKeyDeserializer)
  {
    if (this._keyDeserializers == null) {
      this._keyDeserializers = new SimpleKeyDeserializers();
    }
    this._keyDeserializers.addDeserializer(paramClass, paramKeyDeserializer);
    return this;
  }
  
  public <T> SimpleModule addKeySerializer(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    if (this._keySerializers == null) {
      this._keySerializers = new SimpleSerializers();
    }
    this._keySerializers.addSerializer(paramClass, paramJsonSerializer);
    return this;
  }
  
  public SimpleModule addSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    if (this._serializers == null) {
      this._serializers = new SimpleSerializers();
    }
    this._serializers.addSerializer(paramJsonSerializer);
    return this;
  }
  
  public <T> SimpleModule addSerializer(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    if (this._serializers == null) {
      this._serializers = new SimpleSerializers();
    }
    this._serializers.addSerializer(paramClass, paramJsonSerializer);
    return this;
  }
  
  public SimpleModule addValueInstantiator(Class<?> paramClass, ValueInstantiator paramValueInstantiator)
  {
    if (this._valueInstantiators == null) {
      this._valueInstantiators = new SimpleValueInstantiators();
    }
    this._valueInstantiators = this._valueInstantiators.addValueInstantiator(paramClass, paramValueInstantiator);
    return this;
  }
  
  public String getModuleName()
  {
    return this._name;
  }
  
  public void setAbstractTypes(SimpleAbstractTypeResolver paramSimpleAbstractTypeResolver)
  {
    this._abstractTypes = paramSimpleAbstractTypeResolver;
  }
  
  public void setDeserializers(SimpleDeserializers paramSimpleDeserializers)
  {
    this._deserializers = paramSimpleDeserializers;
  }
  
  public void setKeyDeserializers(SimpleKeyDeserializers paramSimpleKeyDeserializers)
  {
    this._keyDeserializers = paramSimpleKeyDeserializers;
  }
  
  public void setKeySerializers(SimpleSerializers paramSimpleSerializers)
  {
    this._keySerializers = paramSimpleSerializers;
  }
  
  public SimpleModule setMixInAnnotation(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (this._mixins == null) {
      this._mixins = new HashMap();
    }
    this._mixins.put(paramClass1, paramClass2);
    return this;
  }
  
  public void setSerializers(SimpleSerializers paramSimpleSerializers)
  {
    this._serializers = paramSimpleSerializers;
  }
  
  public void setValueInstantiators(SimpleValueInstantiators paramSimpleValueInstantiators)
  {
    this._valueInstantiators = paramSimpleValueInstantiators;
  }
  
  public void setupModule(Module.SetupContext paramSetupContext)
  {
    if (this._serializers != null) {
      paramSetupContext.addSerializers(this._serializers);
    }
    if (this._deserializers != null) {
      paramSetupContext.addDeserializers(this._deserializers);
    }
    if (this._keySerializers != null) {
      paramSetupContext.addKeySerializers(this._keySerializers);
    }
    if (this._keyDeserializers != null) {
      paramSetupContext.addKeyDeserializers(this._keyDeserializers);
    }
    if (this._abstractTypes != null) {
      paramSetupContext.addAbstractTypeResolver(this._abstractTypes);
    }
    if (this._valueInstantiators != null) {
      paramSetupContext.addValueInstantiators(this._valueInstantiators);
    }
    if (this._mixins != null)
    {
      Iterator localIterator = this._mixins.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramSetupContext.setMixInAnnotations((Class)localEntry.getKey(), (Class)localEntry.getValue());
      }
    }
  }
  
  public Version version()
  {
    return this._version;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/module/SimpleModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */