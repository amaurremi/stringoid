package org.codehaus.jackson.map.deser.impl;

import java.util.HashMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.util.TokenBuffer;

public class ExternalTypeHandler
{
  private final HashMap _nameToPropertyIndex;
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
  
  protected ExternalTypeHandler(ExternalTypeHandler.ExtTypedProperty[] paramArrayOfExtTypedProperty, HashMap paramHashMap, String[] paramArrayOfString, TokenBuffer[] paramArrayOfTokenBuffer)
  {
    this._properties = paramArrayOfExtTypedProperty;
    this._nameToPropertyIndex = paramHashMap;
    this._typeIds = paramArrayOfString;
    this._tokens = paramArrayOfTokenBuffer;
  }
  
  protected final void _deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, int paramInt)
  {
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
    localTokenBuffer.writeStartArray();
    localTokenBuffer.writeString(this._typeIds[paramInt]);
    JsonParser localJsonParser = this._tokens[paramInt].asParser(paramJsonParser);
    localJsonParser.nextToken();
    localTokenBuffer.copyCurrentStructure(localJsonParser);
    localTokenBuffer.writeEndArray();
    paramJsonParser = localTokenBuffer.asParser(paramJsonParser);
    paramJsonParser.nextToken();
    this._properties[paramInt].getProperty().deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object complete(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    int i = 0;
    int j = this._properties.length;
    if (i < j)
    {
      if (this._typeIds[i] == null) {
        if (this._tokens[i] != null) {}
      }
      for (;;)
      {
        i += 1;
        break;
        throw paramDeserializationContext.mappingException("Missing external type id property '" + this._properties[i].getTypePropertyName());
        if (this._tokens[i] == null)
        {
          paramJsonParser = this._properties[i].getProperty();
          throw paramDeserializationContext.mappingException("Missing property '" + paramJsonParser.getName() + "' for external type id '" + this._properties[i].getTypePropertyName());
        }
        _deserialize(paramJsonParser, paramDeserializationContext, paramObject, i);
      }
    }
    return paramObject;
  }
  
  public boolean handleToken(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, String paramString, Object paramObject)
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
        _deserialize(paramJsonParser, paramDeserializationContext, paramObject, k);
        this._typeIds[k] = null;
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
  
  public ExternalTypeHandler start()
  {
    return new ExternalTypeHandler(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/impl/ExternalTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */