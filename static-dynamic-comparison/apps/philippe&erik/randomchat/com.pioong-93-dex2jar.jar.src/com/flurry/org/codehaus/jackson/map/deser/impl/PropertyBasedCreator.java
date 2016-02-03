package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public final class PropertyBasedCreator
{
  protected Object[] _defaultValues;
  protected final HashMap<String, SettableBeanProperty> _properties;
  protected final SettableBeanProperty[] _propertiesWithInjectables;
  protected final ValueInstantiator _valueInstantiator;
  
  public PropertyBasedCreator(ValueInstantiator paramValueInstantiator)
  {
    this._valueInstantiator = paramValueInstantiator;
    this._properties = new HashMap();
    Object localObject1 = null;
    SettableBeanProperty[] arrayOfSettableBeanProperty = paramValueInstantiator.getFromObjectArguments();
    paramValueInstantiator = null;
    int i = 0;
    int j = arrayOfSettableBeanProperty.length;
    while (i < j)
    {
      SettableBeanProperty localSettableBeanProperty = arrayOfSettableBeanProperty[i];
      this._properties.put(localSettableBeanProperty.getName(), localSettableBeanProperty);
      Object localObject2 = localObject1;
      if (localSettableBeanProperty.getType().isPrimitive())
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Object[j];
        }
        localObject2[i] = ClassUtil.defaultValue(localSettableBeanProperty.getType().getRawClass());
      }
      Object localObject3 = paramValueInstantiator;
      if (localSettableBeanProperty.getInjectableValueId() != null)
      {
        localObject1 = paramValueInstantiator;
        if (paramValueInstantiator == null) {
          localObject1 = new SettableBeanProperty[j];
        }
        localObject1[i] = localSettableBeanProperty;
        localObject3 = localObject1;
      }
      i += 1;
      localObject1 = localObject2;
      paramValueInstantiator = (ValueInstantiator)localObject3;
    }
    this._defaultValues = ((Object[])localObject1);
    this._propertiesWithInjectables = paramValueInstantiator;
  }
  
  public void assignDeserializer(SettableBeanProperty paramSettableBeanProperty, JsonDeserializer<Object> paramJsonDeserializer)
  {
    paramSettableBeanProperty = paramSettableBeanProperty.withValueDeserializer(paramJsonDeserializer);
    this._properties.put(paramSettableBeanProperty.getName(), paramSettableBeanProperty);
    paramJsonDeserializer = paramJsonDeserializer.getNullValue();
    if (paramJsonDeserializer != null)
    {
      if (this._defaultValues == null) {
        this._defaultValues = new Object[this._properties.size()];
      }
      this._defaultValues[paramSettableBeanProperty.getPropertyIndex()] = paramJsonDeserializer;
    }
  }
  
  public Object build(PropertyValueBuffer paramPropertyValueBuffer)
    throws IOException
  {
    Object localObject = this._valueInstantiator.createFromObjectWith(paramPropertyValueBuffer.getParameters(this._defaultValues));
    for (paramPropertyValueBuffer = paramPropertyValueBuffer.buffered(); paramPropertyValueBuffer != null; paramPropertyValueBuffer = paramPropertyValueBuffer.next) {
      paramPropertyValueBuffer.assign(localObject);
    }
    return localObject;
  }
  
  public SettableBeanProperty findCreatorProperty(String paramString)
  {
    return (SettableBeanProperty)this._properties.get(paramString);
  }
  
  public Collection<SettableBeanProperty> getCreatorProperties()
  {
    return this._properties.values();
  }
  
  public PropertyValueBuffer startBuilding(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    paramJsonParser = new PropertyValueBuffer(paramJsonParser, paramDeserializationContext, this._properties.size());
    if (this._propertiesWithInjectables != null) {
      paramJsonParser.inject(this._propertiesWithInjectables);
    }
    return paramJsonParser;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/impl/PropertyBasedCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */