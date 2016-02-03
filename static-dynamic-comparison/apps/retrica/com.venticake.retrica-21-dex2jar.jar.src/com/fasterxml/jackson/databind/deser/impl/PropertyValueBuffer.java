package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;

public final class PropertyValueBuffer
{
  private PropertyValue _buffered;
  protected final DeserializationContext _context;
  protected final Object[] _creatorParameters;
  private Object _idValue;
  protected final ObjectIdReader _objectIdReader;
  private int _paramsNeeded;
  protected final JsonParser _parser;
  
  public PropertyValueBuffer(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, int paramInt, ObjectIdReader paramObjectIdReader)
  {
    this._parser = paramJsonParser;
    this._context = paramDeserializationContext;
    this._paramsNeeded = paramInt;
    this._objectIdReader = paramObjectIdReader;
    this._creatorParameters = new Object[paramInt];
  }
  
  public boolean assignParameter(int paramInt, Object paramObject)
  {
    this._creatorParameters[paramInt] = paramObject;
    paramInt = this._paramsNeeded - 1;
    this._paramsNeeded = paramInt;
    return paramInt <= 0;
  }
  
  public void bufferAnyProperty(SettableAnyProperty paramSettableAnyProperty, String paramString, Object paramObject)
  {
    this._buffered = new PropertyValue.Any(this._buffered, paramObject, paramSettableAnyProperty, paramString);
  }
  
  public void bufferMapProperty(Object paramObject1, Object paramObject2)
  {
    this._buffered = new PropertyValue.Map(this._buffered, paramObject2, paramObject1);
  }
  
  public void bufferProperty(SettableBeanProperty paramSettableBeanProperty, Object paramObject)
  {
    this._buffered = new PropertyValue.Regular(this._buffered, paramObject, paramSettableBeanProperty);
  }
  
  protected PropertyValue buffered()
  {
    return this._buffered;
  }
  
  protected final Object[] getParameters(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      int i = 0;
      int j = this._creatorParameters.length;
      while (i < j)
      {
        if (this._creatorParameters[i] == null)
        {
          Object localObject = paramArrayOfObject[i];
          if (localObject != null) {
            this._creatorParameters[i] = localObject;
          }
        }
        i += 1;
      }
    }
    return this._creatorParameters;
  }
  
  public Object handleIdValue(DeserializationContext paramDeserializationContext, Object paramObject)
  {
    Object localObject = paramObject;
    if (this._objectIdReader != null)
    {
      localObject = paramObject;
      if (this._idValue != null)
      {
        paramDeserializationContext.findObjectId(this._idValue, this._objectIdReader.generator).bindItem(paramObject);
        paramDeserializationContext = this._objectIdReader.idProperty;
        localObject = paramObject;
        if (paramDeserializationContext != null) {
          localObject = paramDeserializationContext.setAndReturn(paramObject, this._idValue);
        }
      }
    }
    return localObject;
  }
  
  public void inject(SettableBeanProperty[] paramArrayOfSettableBeanProperty)
  {
    int i = 0;
    int j = paramArrayOfSettableBeanProperty.length;
    while (i < j)
    {
      SettableBeanProperty localSettableBeanProperty = paramArrayOfSettableBeanProperty[i];
      if (localSettableBeanProperty != null) {
        this._creatorParameters[i] = this._context.findInjectableValue(localSettableBeanProperty.getInjectableValueId(), localSettableBeanProperty, null);
      }
      i += 1;
    }
  }
  
  public boolean readIdProperty(String paramString)
  {
    if ((this._objectIdReader != null) && (paramString.equals(this._objectIdReader.propertyName)))
    {
      this._idValue = this._objectIdReader.deserializer.deserialize(this._parser, this._context);
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/PropertyValueBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */