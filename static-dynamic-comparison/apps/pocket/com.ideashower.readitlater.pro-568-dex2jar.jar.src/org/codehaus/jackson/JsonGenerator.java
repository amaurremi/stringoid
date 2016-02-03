package org.codehaus.jackson;

import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.io.SerializedString;

public abstract class JsonGenerator
  implements Closeable, Versioned
{
  protected PrettyPrinter _cfgPrettyPrinter;
  
  public boolean canUseSchema(FormatSchema paramFormatSchema)
  {
    return false;
  }
  
  public abstract void close();
  
  public JsonGenerator configure(JsonGenerator.Feature paramFeature, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      enable(paramFeature);
      return this;
    }
    disable(paramFeature);
    return this;
  }
  
  public abstract void copyCurrentEvent(JsonParser paramJsonParser);
  
  public abstract void copyCurrentStructure(JsonParser paramJsonParser);
  
  public abstract JsonGenerator disable(JsonGenerator.Feature paramFeature);
  
  @Deprecated
  public void disableFeature(JsonGenerator.Feature paramFeature)
  {
    disable(paramFeature);
  }
  
  public abstract JsonGenerator enable(JsonGenerator.Feature paramFeature);
  
  @Deprecated
  public void enableFeature(JsonGenerator.Feature paramFeature)
  {
    enable(paramFeature);
  }
  
  public abstract void flush();
  
  public CharacterEscapes getCharacterEscapes()
  {
    return null;
  }
  
  public abstract ObjectCodec getCodec();
  
  public int getHighestEscapedChar()
  {
    return 0;
  }
  
  public abstract JsonStreamContext getOutputContext();
  
  public Object getOutputTarget()
  {
    return null;
  }
  
  public abstract boolean isClosed();
  
  public abstract boolean isEnabled(JsonGenerator.Feature paramFeature);
  
  @Deprecated
  public boolean isFeatureEnabled(JsonGenerator.Feature paramFeature)
  {
    return isEnabled(paramFeature);
  }
  
  public JsonGenerator setCharacterEscapes(CharacterEscapes paramCharacterEscapes)
  {
    return this;
  }
  
  public abstract JsonGenerator setCodec(ObjectCodec paramObjectCodec);
  
  @Deprecated
  public void setFeature(JsonGenerator.Feature paramFeature, boolean paramBoolean)
  {
    configure(paramFeature, paramBoolean);
  }
  
  public JsonGenerator setHighestNonEscapedChar(int paramInt)
  {
    return this;
  }
  
  public JsonGenerator setPrettyPrinter(PrettyPrinter paramPrettyPrinter)
  {
    this._cfgPrettyPrinter = paramPrettyPrinter;
    return this;
  }
  
  public void setSchema(FormatSchema paramFormatSchema)
  {
    throw new UnsupportedOperationException("Generator of type " + getClass().getName() + " does not support schema of type '" + paramFormatSchema.getSchemaType() + "'");
  }
  
  public abstract JsonGenerator useDefaultPrettyPrinter();
  
  public Version version()
  {
    return Version.unknownVersion();
  }
  
  public final void writeArrayFieldStart(String paramString)
  {
    writeFieldName(paramString);
    writeStartArray();
  }
  
  public abstract void writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void writeBinary(byte[] paramArrayOfByte)
  {
    writeBinary(Base64Variants.getDefaultVariant(), paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void writeBinary(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    writeBinary(Base64Variants.getDefaultVariant(), paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final void writeBinaryField(String paramString, byte[] paramArrayOfByte)
  {
    writeFieldName(paramString);
    writeBinary(paramArrayOfByte);
  }
  
  public abstract void writeBoolean(boolean paramBoolean);
  
  public final void writeBooleanField(String paramString, boolean paramBoolean)
  {
    writeFieldName(paramString);
    writeBoolean(paramBoolean);
  }
  
  public abstract void writeEndArray();
  
  public abstract void writeEndObject();
  
  public abstract void writeFieldName(String paramString);
  
  public void writeFieldName(SerializableString paramSerializableString)
  {
    writeFieldName(paramSerializableString.getValue());
  }
  
  public void writeFieldName(SerializedString paramSerializedString)
  {
    writeFieldName(paramSerializedString.getValue());
  }
  
  public abstract void writeNull();
  
  public final void writeNullField(String paramString)
  {
    writeFieldName(paramString);
    writeNull();
  }
  
  public abstract void writeNumber(double paramDouble);
  
  public abstract void writeNumber(float paramFloat);
  
  public abstract void writeNumber(int paramInt);
  
  public abstract void writeNumber(long paramLong);
  
  public abstract void writeNumber(String paramString);
  
  public abstract void writeNumber(BigDecimal paramBigDecimal);
  
  public abstract void writeNumber(BigInteger paramBigInteger);
  
  public final void writeNumberField(String paramString, double paramDouble)
  {
    writeFieldName(paramString);
    writeNumber(paramDouble);
  }
  
  public final void writeNumberField(String paramString, float paramFloat)
  {
    writeFieldName(paramString);
    writeNumber(paramFloat);
  }
  
  public final void writeNumberField(String paramString, int paramInt)
  {
    writeFieldName(paramString);
    writeNumber(paramInt);
  }
  
  public final void writeNumberField(String paramString, long paramLong)
  {
    writeFieldName(paramString);
    writeNumber(paramLong);
  }
  
  public final void writeNumberField(String paramString, BigDecimal paramBigDecimal)
  {
    writeFieldName(paramString);
    writeNumber(paramBigDecimal);
  }
  
  public abstract void writeObject(Object paramObject);
  
  public final void writeObjectField(String paramString, Object paramObject)
  {
    writeFieldName(paramString);
    writeObject(paramObject);
  }
  
  public final void writeObjectFieldStart(String paramString)
  {
    writeFieldName(paramString);
    writeStartObject();
  }
  
  public abstract void writeRaw(char paramChar);
  
  public abstract void writeRaw(String paramString);
  
  public abstract void writeRaw(String paramString, int paramInt1, int paramInt2);
  
  public abstract void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2);
  
  public abstract void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeRawValue(String paramString);
  
  public abstract void writeRawValue(String paramString, int paramInt1, int paramInt2);
  
  public abstract void writeRawValue(char[] paramArrayOfChar, int paramInt1, int paramInt2);
  
  public abstract void writeStartArray();
  
  public abstract void writeStartObject();
  
  public abstract void writeString(String paramString);
  
  public void writeString(SerializableString paramSerializableString)
  {
    writeString(paramSerializableString.getValue());
  }
  
  public abstract void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2);
  
  public void writeStringField(String paramString1, String paramString2)
  {
    writeFieldName(paramString1);
    writeString(paramString2);
  }
  
  public abstract void writeTree(JsonNode paramJsonNode);
  
  public abstract void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/JsonGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */