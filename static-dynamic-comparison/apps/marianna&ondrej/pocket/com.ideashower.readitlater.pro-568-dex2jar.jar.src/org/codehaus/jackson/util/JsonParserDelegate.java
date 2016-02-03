package org.codehaus.jackson.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.Version;

public class JsonParserDelegate
  extends JsonParser
{
  protected JsonParser delegate;
  
  public JsonParserDelegate(JsonParser paramJsonParser)
  {
    this.delegate = paramJsonParser;
  }
  
  public boolean canUseSchema(FormatSchema paramFormatSchema)
  {
    return this.delegate.canUseSchema(paramFormatSchema);
  }
  
  public void clearCurrentToken()
  {
    this.delegate.clearCurrentToken();
  }
  
  public void close()
  {
    this.delegate.close();
  }
  
  public JsonParser disable(JsonParser.Feature paramFeature)
  {
    this.delegate.disable(paramFeature);
    return this;
  }
  
  public JsonParser enable(JsonParser.Feature paramFeature)
  {
    this.delegate.enable(paramFeature);
    return this;
  }
  
  public BigInteger getBigIntegerValue()
  {
    return this.delegate.getBigIntegerValue();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
  {
    return this.delegate.getBinaryValue(paramBase64Variant);
  }
  
  public boolean getBooleanValue()
  {
    return this.delegate.getBooleanValue();
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
  
  public Object getInputSource()
  {
    return this.delegate.getInputSource();
  }
  
  public int getIntValue()
  {
    return this.delegate.getIntValue();
  }
  
  public JsonToken getLastClearedToken()
  {
    return this.delegate.getLastClearedToken();
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
  
  public JsonStreamContext getParsingContext()
  {
    return this.delegate.getParsingContext();
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
  
  public boolean hasCurrentToken()
  {
    return this.delegate.hasCurrentToken();
  }
  
  public boolean isClosed()
  {
    return this.delegate.isClosed();
  }
  
  public boolean isEnabled(JsonParser.Feature paramFeature)
  {
    return this.delegate.isEnabled(paramFeature);
  }
  
  public JsonToken nextToken()
  {
    return this.delegate.nextToken();
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this.delegate.setCodec(paramObjectCodec);
  }
  
  public void setSchema(FormatSchema paramFormatSchema)
  {
    this.delegate.setSchema(paramFormatSchema);
  }
  
  public JsonParser skipChildren()
  {
    this.delegate.skipChildren();
    return this;
  }
  
  public Version version()
  {
    return this.delegate.version();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/util/JsonParserDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */