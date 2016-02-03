package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

public final class ObjectIdValueProperty
  extends SettableBeanProperty
{
  protected final ObjectIdReader _objectIdReader;
  
  public ObjectIdValueProperty(ObjectIdReader paramObjectIdReader)
  {
    super(paramObjectIdReader.propertyName, paramObjectIdReader.idType, null, null);
    this._objectIdReader = paramObjectIdReader;
    this._valueDeserializer = paramObjectIdReader.deserializer;
  }
  
  protected ObjectIdValueProperty(ObjectIdValueProperty paramObjectIdValueProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramObjectIdValueProperty, paramJsonDeserializer);
    this._objectIdReader = paramObjectIdValueProperty._objectIdReader;
  }
  
  protected ObjectIdValueProperty(ObjectIdValueProperty paramObjectIdValueProperty, String paramString)
  {
    super(paramObjectIdValueProperty, paramString);
    this._objectIdReader = paramObjectIdValueProperty._objectIdReader;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    deserializeSetAndReturn(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    Object localObject = this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
    paramDeserializationContext.findObjectId(localObject, this._objectIdReader.generator).bindItem(paramObject);
    paramDeserializationContext = this._objectIdReader.idProperty;
    paramJsonParser = (JsonParser)paramObject;
    if (paramDeserializationContext != null) {
      paramJsonParser = paramDeserializationContext.setAndReturn(paramObject, localObject);
    }
    return paramJsonParser;
  }
  
  public AnnotatedMember getMember()
  {
    return null;
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    setAndReturn(paramObject1, paramObject2);
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
  {
    SettableBeanProperty localSettableBeanProperty = this._objectIdReader.idProperty;
    if (localSettableBeanProperty == null) {
      throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }
    return localSettableBeanProperty.setAndReturn(paramObject1, paramObject2);
  }
  
  public ObjectIdValueProperty withName(String paramString)
  {
    return new ObjectIdValueProperty(this, paramString);
  }
  
  public ObjectIdValueProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new ObjectIdValueProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/ObjectIdValueProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */