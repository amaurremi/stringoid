package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.util.HashMap;

public class ExternalTypeHandler
{
  private final HashMap<String, Integer> _nameToPropertyIndex;
  private final ExternalTypeHandler.ExtTypedProperty[] _properties;
  private final TokenBuffer[] _tokens;
  private final String[] _typeIds;
  
  protected ExternalTypeHandler(ExternalTypeHandler paramExternalTypeHandler)
  {
    this._properties = paramExternalTypeHandler._properties;
    this._nameToPropertyIndex = paramExternalTypeHandler._nameToPropertyIndex;
    int i = this._properties.length;
    this._typeIds = new String[i];
    this._tokens = new TokenBuffer[i];
  }
  
  protected ExternalTypeHandler(ExternalTypeHandler.ExtTypedProperty[] paramArrayOfExtTypedProperty, HashMap<String, Integer> paramHashMap, String[] paramArrayOfString, TokenBuffer[] paramArrayOfTokenBuffer)
  {
    this._properties = paramArrayOfExtTypedProperty;
    this._nameToPropertyIndex = paramHashMap;
    this._typeIds = paramArrayOfString;
    this._tokens = paramArrayOfTokenBuffer;
  }
  
  protected final Object _deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, int paramInt, String paramString)
  {
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartArray();
    localTokenBuffer.writeString(paramString);
    paramString = this._tokens[paramInt].asParser(paramJsonParser);
    paramString.nextToken();
    localTokenBuffer.copyCurrentStructure(paramString);
    localTokenBuffer.writeEndArray();
    paramJsonParser = localTokenBuffer.asParser(paramJsonParser);
    paramJsonParser.nextToken();
    return this._properties[paramInt].getProperty().deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  protected final void _deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, int paramInt, String paramString)
  {
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartArray();
    localTokenBuffer.writeString(paramString);
    paramString = this._tokens[paramInt].asParser(paramJsonParser);
    paramString.nextToken();
    localTokenBuffer.copyCurrentStructure(paramString);
    localTokenBuffer.writeEndArray();
    paramJsonParser = localTokenBuffer.asParser(paramJsonParser);
    paramJsonParser.nextToken();
    this._properties[paramInt].getProperty().deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object complete(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, PropertyValueBuffer paramPropertyValueBuffer, PropertyBasedCreator paramPropertyBasedCreator)
  {
    int j = this._properties.length;
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      String str = this._typeIds[i];
      if (str == null)
      {
        if (this._tokens[i] == null)
        {
          i += 1;
        }
        else
        {
          if (!this._properties[i].hasDefaultType()) {
            throw paramDeserializationContext.mappingException("Missing external type id property '" + this._properties[i].getTypePropertyName() + "'");
          }
          str = this._properties[i].getDefaultTypeId();
        }
      }
      else
      {
        while (this._tokens[i] != null) {
          for (;;)
          {
            arrayOfObject[i] = _deserialize(paramJsonParser, paramDeserializationContext, i, str);
          }
        }
        paramJsonParser = this._properties[i].getProperty();
        throw paramDeserializationContext.mappingException("Missing property '" + paramJsonParser.getName() + "' for external type id '" + this._properties[i].getTypePropertyName());
      }
    }
    i = 0;
    while (i < j)
    {
      paramJsonParser = this._properties[i].getProperty();
      if (paramPropertyBasedCreator.findCreatorProperty(paramJsonParser.getName()) != null) {
        paramPropertyValueBuffer.assignParameter(paramJsonParser.getCreatorIndex(), arrayOfObject[i]);
      }
      i += 1;
    }
    paramJsonParser = paramPropertyBasedCreator.build(paramDeserializationContext, paramPropertyValueBuffer);
    i = 0;
    while (i < j)
    {
      paramDeserializationContext = this._properties[i].getProperty();
      if (paramPropertyBasedCreator.findCreatorProperty(paramDeserializationContext.getName()) == null) {
        paramDeserializationContext.set(paramJsonParser, arrayOfObject[i]);
      }
      i += 1;
    }
    return paramJsonParser;
  }
  
  public Object complete(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    int i = 0;
    int j = this._properties.length;
    while (i < j)
    {
      String str = this._typeIds[i];
      if (str == null)
      {
        if (this._tokens[i] == null)
        {
          i += 1;
        }
        else
        {
          if (!this._properties[i].hasDefaultType()) {
            throw paramDeserializationContext.mappingException("Missing external type id property '" + this._properties[i].getTypePropertyName() + "'");
          }
          str = this._properties[i].getDefaultTypeId();
        }
      }
      else
      {
        while (this._tokens[i] != null) {
          for (;;)
          {
            _deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, i, str);
          }
        }
        paramJsonParser = this._properties[i].getProperty();
        throw paramDeserializationContext.mappingException("Missing property '" + paramJsonParser.getName() + "' for external type id '" + this._properties[i].getTypePropertyName());
      }
    }
    return paramObject;
  }
  
  public boolean handlePropertyValue(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, String paramString, Object paramObject)
  {
    int j = 0;
    Integer localInteger = (Integer)this._nameToPropertyIndex.get(paramString);
    if (localInteger == null) {
      return false;
    }
    int k = localInteger.intValue();
    int i;
    if (this._properties[k].hasTypePropertyName(paramString))
    {
      this._typeIds[k] = paramJsonParser.getText();
      paramJsonParser.skipChildren();
      if ((paramObject != null) && (this._tokens[k] != null)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramString = this._typeIds[k];
        this._typeIds[k] = null;
        _deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, k, paramString);
        this._tokens[k] = null;
      }
      return true;
      i = 0;
      continue;
      paramString = new TokenBuffer(paramJsonParser.getCodec());
      paramString.copyCurrentStructure(paramJsonParser);
      this._tokens[k] = paramString;
      i = j;
      if (paramObject != null)
      {
        i = j;
        if (this._typeIds[k] != null) {
          i = 1;
        }
      }
    }
  }
  
  public boolean handleTypePropertyValue(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, String paramString, Object paramObject)
  {
    int j = 0;
    Integer localInteger = (Integer)this._nameToPropertyIndex.get(paramString);
    if (localInteger == null) {
      return false;
    }
    int k = localInteger.intValue();
    if (!this._properties[k].hasTypePropertyName(paramString)) {
      return false;
    }
    paramString = paramJsonParser.getText();
    int i = j;
    if (paramObject != null)
    {
      i = j;
      if (this._tokens[k] != null) {
        i = 1;
      }
    }
    if (i != 0)
    {
      _deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, k, paramString);
      this._tokens[k] = null;
    }
    for (;;)
    {
      return true;
      this._typeIds[k] = paramString;
    }
  }
  
  public ExternalTypeHandler start()
  {
    return new ExternalTypeHandler(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/ExternalTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */