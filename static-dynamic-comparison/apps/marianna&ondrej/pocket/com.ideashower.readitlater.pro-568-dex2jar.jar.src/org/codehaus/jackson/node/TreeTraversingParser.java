package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.impl.JsonParserMinimalBase;

public class TreeTraversingParser
  extends JsonParserMinimalBase
{
  protected boolean _closed;
  protected JsonToken _nextToken;
  protected NodeCursor _nodeCursor;
  protected ObjectCodec _objectCodec;
  protected boolean _startContainer;
  
  public TreeTraversingParser(JsonNode paramJsonNode)
  {
    this(paramJsonNode, null);
  }
  
  public TreeTraversingParser(JsonNode paramJsonNode, ObjectCodec paramObjectCodec)
  {
    super(0);
    this._objectCodec = paramObjectCodec;
    if (paramJsonNode.isArray())
    {
      this._nextToken = JsonToken.START_ARRAY;
      this._nodeCursor = new NodeCursor.Array(paramJsonNode, null);
      return;
    }
    if (paramJsonNode.isObject())
    {
      this._nextToken = JsonToken.START_OBJECT;
      this._nodeCursor = new NodeCursor.Object(paramJsonNode, null);
      return;
    }
    this._nodeCursor = new NodeCursor.RootValue(paramJsonNode, null);
  }
  
  protected void _handleEOF()
  {
    _throwInternal();
  }
  
  public void close()
  {
    if (!this._closed)
    {
      this._closed = true;
      this._nodeCursor = null;
      this._currToken = null;
    }
  }
  
  protected JsonNode currentNode()
  {
    if ((this._closed) || (this._nodeCursor == null)) {
      return null;
    }
    return this._nodeCursor.currentNode();
  }
  
  protected JsonNode currentNumericNode()
  {
    Object localObject = currentNode();
    if ((localObject == null) || (!((JsonNode)localObject).isNumber()))
    {
      if (localObject == null) {}
      for (localObject = null;; localObject = ((JsonNode)localObject).asToken()) {
        throw _constructError("Current token (" + localObject + ") not numeric, can not use numeric value accessors");
      }
    }
    return (JsonNode)localObject;
  }
  
  public BigInteger getBigIntegerValue()
  {
    return currentNumericNode().getBigIntegerValue();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
  {
    paramBase64Variant = currentNode();
    if (paramBase64Variant != null)
    {
      byte[] arrayOfByte = paramBase64Variant.getBinaryValue();
      if (arrayOfByte != null) {
        return arrayOfByte;
      }
      if (paramBase64Variant.isPojo())
      {
        paramBase64Variant = ((POJONode)paramBase64Variant).getPojo();
        if ((paramBase64Variant instanceof byte[])) {
          return (byte[])paramBase64Variant;
        }
      }
    }
    return null;
  }
  
  public ObjectCodec getCodec()
  {
    return this._objectCodec;
  }
  
  public JsonLocation getCurrentLocation()
  {
    return JsonLocation.NA;
  }
  
  public String getCurrentName()
  {
    if (this._nodeCursor == null) {
      return null;
    }
    return this._nodeCursor.getCurrentName();
  }
  
  public BigDecimal getDecimalValue()
  {
    return currentNumericNode().getDecimalValue();
  }
  
  public double getDoubleValue()
  {
    return currentNumericNode().getDoubleValue();
  }
  
  public Object getEmbeddedObject()
  {
    if (!this._closed)
    {
      JsonNode localJsonNode = currentNode();
      if (localJsonNode != null)
      {
        if (localJsonNode.isPojo()) {
          return ((POJONode)localJsonNode).getPojo();
        }
        if (localJsonNode.isBinary()) {
          return ((BinaryNode)localJsonNode).getBinaryValue();
        }
      }
    }
    return null;
  }
  
  public float getFloatValue()
  {
    return (float)currentNumericNode().getDoubleValue();
  }
  
  public int getIntValue()
  {
    return currentNumericNode().getIntValue();
  }
  
  public long getLongValue()
  {
    return currentNumericNode().getLongValue();
  }
  
  public JsonParser.NumberType getNumberType()
  {
    JsonNode localJsonNode = currentNumericNode();
    if (localJsonNode == null) {
      return null;
    }
    return localJsonNode.getNumberType();
  }
  
  public Number getNumberValue()
  {
    return currentNumericNode().getNumberValue();
  }
  
  public JsonStreamContext getParsingContext()
  {
    return this._nodeCursor;
  }
  
  public String getText()
  {
    if (this._closed) {}
    JsonNode localJsonNode;
    do
    {
      while (this._currToken == null)
      {
        return null;
        switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()])
        {
        }
      }
      return this._currToken.asString();
      return this._nodeCursor.getCurrentName();
      return currentNode().getTextValue();
      return String.valueOf(currentNode().getNumberValue());
      localJsonNode = currentNode();
    } while ((localJsonNode == null) || (!localJsonNode.isBinary()));
    return localJsonNode.asText();
  }
  
  public char[] getTextCharacters()
  {
    return getText().toCharArray();
  }
  
  public int getTextLength()
  {
    return getText().length();
  }
  
  public int getTextOffset()
  {
    return 0;
  }
  
  public JsonLocation getTokenLocation()
  {
    return JsonLocation.NA;
  }
  
  public boolean hasTextCharacters()
  {
    return false;
  }
  
  public boolean isClosed()
  {
    return this._closed;
  }
  
  public JsonToken nextToken()
  {
    if (this._nextToken != null)
    {
      this._currToken = this._nextToken;
      this._nextToken = null;
      return this._currToken;
    }
    if (this._startContainer)
    {
      this._startContainer = false;
      if (!this._nodeCursor.currentHasChildren())
      {
        if (this._currToken == JsonToken.START_OBJECT) {}
        for (JsonToken localJsonToken = JsonToken.END_OBJECT;; localJsonToken = JsonToken.END_ARRAY)
        {
          this._currToken = localJsonToken;
          return this._currToken;
        }
      }
      this._nodeCursor = this._nodeCursor.iterateChildren();
      this._currToken = this._nodeCursor.nextToken();
      if ((this._currToken == JsonToken.START_OBJECT) || (this._currToken == JsonToken.START_ARRAY)) {
        this._startContainer = true;
      }
      return this._currToken;
    }
    if (this._nodeCursor == null)
    {
      this._closed = true;
      return null;
    }
    this._currToken = this._nodeCursor.nextToken();
    if (this._currToken != null)
    {
      if ((this._currToken == JsonToken.START_OBJECT) || (this._currToken == JsonToken.START_ARRAY)) {
        this._startContainer = true;
      }
      return this._currToken;
    }
    this._currToken = this._nodeCursor.endToken();
    this._nodeCursor = this._nodeCursor.getParent();
    return this._currToken;
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
  }
  
  public JsonParser skipChildren()
  {
    if (this._currToken == JsonToken.START_OBJECT)
    {
      this._startContainer = false;
      this._currToken = JsonToken.END_OBJECT;
    }
    while (this._currToken != JsonToken.START_ARRAY) {
      return this;
    }
    this._startContainer = false;
    this._currToken = JsonToken.END_ARRAY;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/TreeTraversingParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */