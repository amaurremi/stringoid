package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.deser.SettableAnyProperty;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.Map;

public abstract class PropertyValue
{
  public final PropertyValue next;
  public final Object value;
  
  protected PropertyValue(PropertyValue paramPropertyValue, Object paramObject)
  {
    this.next = paramPropertyValue;
    this.value = paramObject;
  }
  
  public abstract void assign(Object paramObject)
    throws IOException, JsonProcessingException;
  
  static final class Any
    extends PropertyValue
  {
    final SettableAnyProperty _property;
    final String _propertyName;
    
    public Any(PropertyValue paramPropertyValue, Object paramObject, SettableAnyProperty paramSettableAnyProperty, String paramString)
    {
      super(paramObject);
      this._property = paramSettableAnyProperty;
      this._propertyName = paramString;
    }
    
    public void assign(Object paramObject)
      throws IOException, JsonProcessingException
    {
      this._property.set(paramObject, this._propertyName, this.value);
    }
  }
  
  static final class Map
    extends PropertyValue
  {
    final Object _key;
    
    public Map(PropertyValue paramPropertyValue, Object paramObject1, Object paramObject2)
    {
      super(paramObject1);
      this._key = paramObject2;
    }
    
    public void assign(Object paramObject)
      throws IOException, JsonProcessingException
    {
      ((Map)paramObject).put(this._key, this.value);
    }
  }
  
  static final class Regular
    extends PropertyValue
  {
    final SettableBeanProperty _property;
    
    public Regular(PropertyValue paramPropertyValue, Object paramObject, SettableBeanProperty paramSettableBeanProperty)
    {
      super(paramObject);
      this._property = paramSettableBeanProperty;
    }
    
    public void assign(Object paramObject)
      throws IOException, JsonProcessingException
    {
      this._property.set(paramObject, this.value);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/impl/PropertyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */