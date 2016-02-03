package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonParserDelegate
  extends JsonParser
{
  protected JsonParser delegate;
  
  public JsonParserDelegate(JsonParser paramJsonParser)
  {
    this.delegate = paramJsonParser;
  }
  
  public void clearCurrentToken()
  {
    this.delegate.clearCurrentToken();
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public BigInteger getBigIntegerValue()
  {
    return this.delegate.getBigIntegerValue();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
  {
    return this.delegate.getBinaryValue(paramBase64Variant);
  }
  
  public byte getByteValue()
  {
    return this.delegate.getByteValue();
  }
  
  public ObjectCodec getCodec()
  {
    return this.delegate.getCodec();
  }
  
  public JsonLocation getCurrentLocation()
  {
    return this.delegate.getCurrentLocation();
  }
  
  public String getCurrentName()
  {
    return this.delegate.getCurrentName();
  }
  
  public JsonToken getCurrentToken()
  {
    return this.delegate.getCurrentToken();
  }
  
  public BigDecimal getDecimalValue()
  {
    return this.delegate.getDecimalValue();
  }
  
  public double getDoubleValue()
  {
    return this.delegate.getDoubleValue();
  }
  
  public Object getEmbeddedObject()
  {
    return this.delegate.getEmbeddedObject();
  }
  
  public float getFloatValue()
  {
    return this.delegate.getFloatValue();
  }
  
  public int getIntValue()
  {
    return this.delegate.getIntValue();
  }
  
  public long getLongValue()
  {
    return this.delegate.getLongValue();
  }
  
  public JsonParser.NumberType getNumberType()
  {
    return this.delegate.getNumberType();
  }
  
  public Number getNumberValue()
  {
    return this.delegate.getNumberValue();
  }
  
  public short getShortValue()
  {
    return this.delegate.getShortValue();
  }
  
  public String getText()
  {
    return this.delegate.getText();
  }
  
  public char[] getTextCharacters()
  {
    return this.delegate.getTextCharacters();
  }
  
  public int getTextLength()
  {
    return this.delegate.getTextLength();
  }
  
  public int getTextOffset()
  {
    return this.delegate.getTextOffset();
  }
  
  public JsonLocation getTokenLocation()
  {
    return this.delegate.getTokenLocation();
  }
  
  public int getValueAsInt()
  {
    return this.delegate.getValueAsInt();
  }
  
  public int getValueAsInt(int paramInt)
  {
    return this.delegate.getValueAsInt(paramInt);
  }
  
  public long getValueAsLong()
  {
    return this.delegate.getValueAsLong();
  }
  
  public long getValueAsLong(long paramLong)
  {
    return this.delegate.getValueAsLong(paramLong);
  }
  
  public String getValueAsString()
  {
    return this.delegate.getValueAsString();
  }
  
  public String getValueAsString(String paramString)
  {
    return this.delegate.getValueAsString(paramString);
  }
  
  public boolean hasCurrentToken()
  {
    return this.delegate.hasCurrentToken();
  }
  
  public boolean hasTextCharacters()
  {
    return this.delegate.hasTextCharacters();
  }
  
  public boolean isEnabled(JsonParser.Feature paramFeature)
  {
    return this.delegate.isEnabled(paramFeature);
  }
  
  public JsonToken nextToken()
  {
    return this.delegate.nextToken();
  }
  
  public JsonToken nextValue()
  {
    return this.delegate.nextValue();
  }
  
  public JsonParser skipChildren()
  {
    this.delegate.skipChildren();
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/util/JsonParserDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */