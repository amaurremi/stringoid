package org.codehaus.jackson.map.deser.impl;

import java.util.Collection;
import java.util.HashMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.map.deser.ValueInstantiator;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public final class PropertyBasedCreator
{
  protected final Object[] _defaultValues;
  protected final HashMap _properties;
  protected final SettableBeanProperty[] _propertiesWithInjectables;
  protected final ValueInstantiator _valueInstantiator;
  
  public PropertyBasedCreator(ValueInstantiator paramValueInstantiator)
  {
    this._valueInstantiator = paramValueInstantiator;
    this._properties = new HashMap();
    SettableBeanProperty[] arrayOfSettableBeanProperty = paramValueInstantiator.getFromObjectArguments();
    int j = arrayOfSettableBeanProperty.length;
    int i = 0;
    paramValueInstantiator = null;
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
      localObject1 = paramValueInstantiator;
      if (localSettableBeanProperty.getInjectableValueId() != null)
      {
        localObject1 = paramValueInstantiator;
        if (paramValueInstantiator == null) {
          localObject1 = new SettableBeanProperty[j];
        }
        localObject1[i] = localSettableBeanProperty;
      }
      i += 1;
      paramValueInstantiator = (ValueInstantiator)localObject1;
      localObject1 = localObject2;
    }
    this._defaultValues = ((Object[])localObject1);
    this._propertiesWithInjectables = paramValueInstantiator;
  }
  
  public void assignDeserializer(SettableBeanProperty paramSettableBeanProperty, JsonDeserializer paramJsonDeserializer)
  {
    paramSettableBeanProperty = paramSettableBeanProperty.withValueDeserializer(paramJsonDeserializer);
    this._properties.put(paramSettableBeanProperty.getName(), paramSettableBeanProperty);
  }
  
  public Object build(PropertyValueBuffer paramPropertyValueBuffer)
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
  
  public Collection getCreatorProperties()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/impl/PropertyBasedCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */