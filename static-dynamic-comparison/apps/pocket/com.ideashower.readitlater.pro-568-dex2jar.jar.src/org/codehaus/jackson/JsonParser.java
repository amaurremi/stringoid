package org.codehaus.jackson;

import java.io.Closeable;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import org.codehaus.jackson.type.TypeReference;

public abstract class JsonParser
  implements Closeable, Versioned
{
  private static final int MAX_BYTE_I = 127;
  private static final int MAX_SHORT_I = 32767;
  private static final int MIN_BYTE_I = -128;
  private static final int MIN_SHORT_I = -32768;
  protected JsonToken _currToken;
  protected int _features;
  protected JsonToken _lastClearedToken;
  
  protected JsonParser() {}
  
  protected JsonParser(int paramInt)
  {
    this._features = paramInt;
  }
  
  protected JsonParseException _constructError(String paramString)
  {
    return new JsonParseException(paramString, getCurrentLocation());
  }
  
  public boolean canUseSchema(FormatSchema paramFormatSchema)
  {
    return false;
  }
  
  public void clearCurrentToken()
  {
    if (this._currToken != null)
    {
      this._lastClearedToken = this._currToken;
      this._currToken = null;
    }
  }
  
  public abstract void close();
  
  public JsonParser configure(JsonParser.Feature paramFeature, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      enableFeature(paramFeature);
      return this;
    }
    disableFeature(paramFeature);
    return this;
  }
  
  public JsonParser disable(JsonParser.Feature paramFeature)
  {
    this._features &= (paramFeature.getMask() ^ 0xFFFFFFFF);
    return this;
  }
  
  public void disableFeature(JsonParser.Feature paramFeature)
  {
    disable(paramFeature);
  }
  
  public JsonParser enable(JsonParser.Feature paramFeature)
  {
    this._features |= paramFeature.getMask();
    return this;
  }
  
  public void enableFeature(JsonParser.Feature paramFeature)
  {
    enable(paramFeature);
  }
  
  public abstract BigInteger getBigIntegerValue();
  
  public byte[] getBinaryValue()
  {
    return getBinaryValue(Base64Variants.getDefaultVariant());
  }
  
  public abstract byte[] getBinaryValue(Base64Variant paramBase64Variant);
  
  public boolean getBooleanValue()
  {
    if (getCurrentToken() == JsonToken.VALUE_TRUE) {
      return true;
    }
    if (getCurrentToken() == JsonToken.VALUE_FALSE) {
      return false;
    }
    throw new JsonParseException("Current token (" + this._currToken + ") not of boolean type", getCurrentLocation());
  }
  
  public byte getByteValue()
  {
    int i = getIntValue();
    if ((i < -128) || (i > 127)) {
      throw _constructError("Numeric value (" + getText() + ") out of range of Java byte");
    }
    return (byte)i;
  }
  
  public abstract ObjectCodec getCodec();
  
  public abstract JsonLocation getCurrentLocation();
  
  public abstract String getCurrentName();
  
  public JsonToken getCurrentToken()
  {
    return this._currToken;
  }
  
  public abstract BigDecimal getDecimalValue();
  
  public abstract double getDoubleValue();
  
  public Object getEmbeddedObject()
  {
    return null;
  }
  
  public abstract float getFloatValue();
  
  public Object getInputSource()
  {
    return null;
  }
  
  public abstract int getIntValue();
  
  public JsonToken getLastClearedToken()
  {
    return this._lastClearedToken;
  }
  
  public abstract long getLongValue();
  
  public abstract JsonParser.NumberType getNumberType();
  
  public abstract Number getNumberValue();
  
  public abstract JsonStreamContext getParsingContext();
  
  public short getShortValue()
  {
    int i = getIntValue();
    if ((i < 32768) || (i > 32767)) {
      throw _constructError("Numeric value (" + getText() + ") out of range of Java short");
    }
    return (short)i;
  }
  
  public abstract String getText();
  
  public abstract char[] getTextCharacters();
  
  public abstract int getTextLength();
  
  public abstract int getTextOffset();
  
  public abstract JsonLocation getTokenLocation();
  
  public boolean getValueAsBoolean()
  {
    return getValueAsBoolean(false);
  }
  
  public boolean getValueAsBoolean(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public double getValueAsDouble()
  {
    return getValueAsDouble(0.0D);
  }
  
  public double getValueAsDouble(double paramDouble)
  {
    return paramDouble;
  }
  
  public int getValueAsInt()
  {
    return getValueAsInt(0);
  }
  
  public int getValueAsInt(int paramInt)
  {
    return paramInt;
  }
  
  public long getValueAsLong()
  {
    return getValueAsInt(0);
  }
  
  public long getValueAsLong(long paramLong)
  {
    return paramLong;
  }
  
  public boolean hasCurrentToken()
  {
    return this._currToken != null;
  }
  
  public boolean hasTextCharacters()
  {
    return false;
  }
  
  public abstract boolean isClosed();
  
  public boolean isEnabled(JsonParser.Feature paramFeature)
  {
    return (this._features & paramFeature.getMask()) != 0;
  }
  
  public boolean isExpectedStartArrayToken()
  {
    return getCurrentToken() == JsonToken.START_ARRAY;
  }
  
  public final boolean isFeatureEnabled(JsonParser.Feature paramFeature)
  {
    return isEnabled(paramFeature);
  }
  
  public Boolean nextBooleanValue()
  {
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[nextToken().ordinal()])
    {
    default: 
      return null;
    case 1: 
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public boolean nextFieldName(SerializableString paramSerializableString)
  {
    return (nextToken() == JsonToken.FIELD_NAME) && (paramSerializableString.getValue().equals(getCurrentName()));
  }
  
  public int nextIntValue(int paramInt)
  {
    if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
      paramInt = getIntValue();
    }
    return paramInt;
  }
  
  public long nextLongValue(long paramLong)
  {
    if (nextToken() == JsonToken.VALUE_NUMBER_INT) {
      paramLong = getLongValue();
    }
    return paramLong;
  }
  
  public String nextTextValue()
  {
    if (nextToken() == JsonToken.VALUE_STRING) {
      return getText();
    }
    return null;
  }
  
  public abstract JsonToken nextToken();
  
  public JsonToken nextValue()
  {
    JsonToken localJsonToken2 = nextToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME) {
      localJsonToken1 = nextToken();
    }
    return localJsonToken1;
  }
  
  public Object readValueAs(Class paramClass)
  {
    ObjectCodec localObjectCodec = getCodec();
    if (localObjectCodec == null) {
      throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into Java objects");
    }
    return localObjectCodec.readValue(this, paramClass);
  }
  
  public Object readValueAs(TypeReference paramTypeReference)
  {
    ObjectCodec localObjectCodec = getCodec();
    if (localObjectCodec == null) {
      throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into Java objects");
    }
    return localObjectCodec.readValue(this, paramTypeReference);
  }
  
  public JsonNode readValueAsTree()
  {
    ObjectCodec localObjectCodec = getCodec();
    if (localObjectCodec == null) {
      throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into JsonNode tree");
    }
    return localObjectCodec.readTree(this);
  }
  
  public Iterator readValuesAs(Class paramClass)
  {
    ObjectCodec localObjectCodec = getCodec();
    if (localObjectCodec == null) {
      throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into Java objects");
    }
    return localObjectCodec.readValues(this, paramClass);
  }
  
  public Iterator readValuesAs(TypeReference paramTypeReference)
  {
    ObjectCodec localObjectCodec = getCodec();
    if (localObjectCodec == null) {
      throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into Java objects");
    }
    return localObjectCodec.readValues(this, paramTypeReference);
  }
  
  public int releaseBuffered(OutputStream paramOutputStream)
  {
    return -1;
  }
  
  public int releaseBuffered(Writer paramWriter)
  {
    return -1;
  }
  
  public abstract void setCodec(ObjectCodec paramObjectCodec);
  
  public void setFeature(JsonParser.Feature paramFeature, boolean paramBoolean)
  {
    configure(paramFeature, paramBoolean);
  }
  
  public void setSchema(FormatSchema paramFormatSchema)
  {
    throw new UnsupportedOperationException("Parser of type " + getClass().getName() + " does not support schema of type '" + paramFormatSchema.getSchemaType() + "'");
  }
  
  public abstract JsonParser skipChildren();
  
  public Version version()
  {
    return Version.unknownVersion();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/JsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */