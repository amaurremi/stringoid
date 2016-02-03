package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import com.flurry.org.codehaus.jackson.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExternalTypeHandler
{
  private final HashMap<String, Integer> _nameToPropertyIndex;
  private final ExtTypedProperty[] _properties;
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
  
  protected ExternalTypeHandler(ExtTypedProperty[] paramArrayOfExtTypedProperty, HashMap<String, Integer> paramHashMap, String[] paramArrayOfString, TokenBuffer[] paramArrayOfTokenBuffer)
  {
    this._properties = paramArrayOfExtTypedProperty;
    this._nameToPropertyIndex = paramHashMap;
    this._typeIds = paramArrayOfString;
    this._tokens = paramArrayOfTokenBuffer;
  }
  
  protected final void _deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, int paramInt)
    throws IOException, JsonProcessingException
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
    throws IOException, JsonProcessingException
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
    throws IOException, JsonProcessingException
  {
    int k = 0;
    int j = 0;
    Integer localInteger = (Integer)this._nameToPropertyIndex.get(paramString);
    if (localInteger == null) {
      return false;
    }
    int m = localInteger.intValue();
    int i;
    if (this._properties[m].hasTypePropertyName(paramString))
    {
      this._typeIds[m] = paramJsonParser.getText();
      paramJsonParser.skipChildren();
      i = j;
      if (paramObject != null)
      {
        i = j;
        if (this._tokens[m] != null) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        _deserialize(paramJsonParser, paramDeserializationContext, paramObject, m);
        this._typeIds[m] = null;
        this._tokens[m] = null;
      }
      return true;
      paramString = new TokenBuffer(paramJsonParser.getCodec());
      paramString.copyCurrentStructure(paramJsonParser);
      this._tokens[m] = paramString;
      i = k;
      if (paramObject != null)
      {
        i = k;
        if (this._typeIds[m] != null) {
          i = 1;
        }
      }
    }
  }
  
  public ExternalTypeHandler start()
  {
    return new ExternalTypeHandler(this);
  }
  
  public static class Builder
  {
    private final HashMap<String, Integer> _nameToPropertyIndex = new HashMap();
    private final ArrayList<ExternalTypeHandler.ExtTypedProperty> _properties = new ArrayList();
    
    public void addExternal(SettableBeanProperty paramSettableBeanProperty, String paramString)
    {
      Integer localInteger = Integer.valueOf(this._properties.size());
      this._properties.add(new ExternalTypeHandler.ExtTypedProperty(paramSettableBeanProperty, paramString));
      this._nameToPropertyIndex.put(paramSettableBeanProperty.getName(), localInteger);
      this._nameToPropertyIndex.put(paramString, localInteger);
    }
    
    public ExternalTypeHandler build()
    {
      return new ExternalTypeHandler((ExternalTypeHandler.ExtTypedProperty[])this._properties.toArray(new ExternalTypeHandler.ExtTypedProperty[this._properties.size()]), this._nameToPropertyIndex, null, null);
    }
  }
  
  private static final class ExtTypedProperty
  {
    private final SettableBeanProperty _property;
    private final String _typePropertyName;
    
    public ExtTypedProperty(SettableBeanProperty paramSettableBeanProperty, String paramString)
    {
      this._property = paramSettableBeanProperty;
      this._typePropertyName = paramString;
    }
    
    public SettableBeanProperty getProperty()
    {
      return this._property;
    }
    
    public String getTypePropertyName()
    {
      return this._typePropertyName;
    }
    
    public boolean hasTypePropertyName(String paramString)
    {
      return paramString.equals(this._typePropertyName);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/impl/ExternalTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */