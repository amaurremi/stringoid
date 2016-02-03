package org.codehaus.jackson.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonGenerator.Feature;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.util.VersionUtil;

public abstract class JsonGeneratorBase
  extends JsonGenerator
{
  protected boolean _cfgNumbersAsStrings;
  protected boolean _closed;
  protected int _features;
  protected ObjectCodec _objectCodec;
  protected JsonWriteContext _writeContext;
  
  protected JsonGeneratorBase(int paramInt, ObjectCodec paramObjectCodec)
  {
    this._features = paramInt;
    this._writeContext = JsonWriteContext.createRootContext();
    this._objectCodec = paramObjectCodec;
    this._cfgNumbersAsStrings = isEnabled(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
  }
  
  protected void _cantHappen()
  {
    throw new RuntimeException("Internal error: should never end up through this code path");
  }
  
  protected abstract void _releaseBuffers();
  
  protected void _reportError(String paramString)
  {
    throw new JsonGenerationException(paramString);
  }
  
  protected void _reportUnsupportedOperation()
  {
    throw new UnsupportedOperationException("Operation not supported by generator of type " + getClass().getName());
  }
  
  protected final void _throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  protected abstract void _verifyValueWrite(String paramString);
  
  @Deprecated
  protected void _writeEndArray() {}
  
  @Deprecated
  protected void _writeEndObject() {}
  
  protected void _writeSimpleObject(Object paramObject)
  {
    if (paramObject == null)
    {
      writeNull();
      return;
    }
    if ((paramObject instanceof String))
    {
      writeString((String)paramObject);
      return;
    }
    if ((paramObject instanceof Number))
    {
      Number localNumber = (Number)paramObject;
      if ((localNumber instanceof Integer))
      {
        writeNumber(localNumber.intValue());
        return;
      }
      if ((localNumber instanceof Long))
      {
        writeNumber(localNumber.longValue());
        return;
      }
      if ((localNumber instanceof Double))
      {
        writeNumber(localNumber.doubleValue());
        return;
      }
      if ((localNumber instanceof Float))
      {
        writeNumber(localNumber.floatValue());
        return;
      }
      if ((localNumber instanceof Short))
      {
        writeNumber(localNumber.shortValue());
        return;
      }
      if ((localNumber instanceof Byte))
      {
        writeNumber(localNumber.byteValue());
        return;
      }
      if ((localNumber instanceof BigInteger))
      {
        writeNumber((BigInteger)localNumber);
        return;
      }
      if ((localNumber instanceof BigDecimal))
      {
        writeNumber((BigDecimal)localNumber);
        return;
      }
      if ((localNumber instanceof AtomicInteger))
      {
        writeNumber(((AtomicInteger)localNumber).get());
        return;
      }
      if ((localNumber instanceof AtomicLong)) {
        writeNumber(((AtomicLong)localNumber).get());
      }
    }
    else
    {
      if ((paramObject instanceof byte[]))
      {
        writeBinary((byte[])paramObject);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        writeBoolean(((Boolean)paramObject).booleanValue());
        return;
      }
      if ((paramObject instanceof AtomicBoolean))
      {
        writeBoolean(((AtomicBoolean)paramObject).get());
        return;
      }
    }
    throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + paramObject.getClass().getName() + ")");
  }
  
  @Deprecated
  protected void _writeStartArray() {}
  
  @Deprecated
  protected void _writeStartObject() {}
  
  public void close()
  {
    this._closed = true;
  }
  
  public final void copyCurrentEvent(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == null) {
      _reportError("No current event to copy");
    }
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[localJsonToken.ordinal()])
    {
    default: 
      _cantHappen();
      return;
    case 1: 
      writeStartObject();
      return;
    case 2: 
      writeEndObject();
      return;
    case 3: 
      writeStartArray();
      return;
    case 4: 
      writeEndArray();
      return;
    case 5: 
      writeFieldName(paramJsonParser.getCurrentName());
      return;
    case 6: 
      if (paramJsonParser.hasTextCharacters())
      {
        writeString(paramJsonParser.getTextCharacters(), paramJsonParser.getTextOffset(), paramJsonParser.getTextLength());
        return;
      }
      writeString(paramJsonParser.getText());
      return;
    case 7: 
      switch (1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
      {
      default: 
        writeNumber(paramJsonParser.getLongValue());
        return;
      case 1: 
        writeNumber(paramJsonParser.getIntValue());
        return;
      }
      writeNumber(paramJsonParser.getBigIntegerValue());
      return;
    case 8: 
      switch (1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
      {
      default: 
        writeNumber(paramJsonParser.getDoubleValue());
        return;
      case 3: 
        writeNumber(paramJsonParser.getDecimalValue());
        return;
      }
      writeNumber(paramJsonParser.getFloatValue());
      return;
    case 9: 
      writeBoolean(true);
      return;
    case 10: 
      writeBoolean(false);
      return;
    case 11: 
      writeNull();
      return;
    }
    writeObject(paramJsonParser.getEmbeddedObject());
  }
  
  public final void copyCurrentStructure(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken2 = paramJsonParser.getCurrentToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME)
    {
      writeFieldName(paramJsonParser.getCurrentName());
      localJsonToken1 = paramJsonParser.nextToken();
    }
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[localJsonToken1.ordinal()])
    {
    case 2: 
    default: 
      copyCurrentEvent(paramJsonParser);
      return;
    case 3: 
      writeStartArray();
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        copyCurrentStructure(paramJsonParser);
      }
      writeEndArray();
      return;
    }
    writeStartObject();
    while (paramJsonParser.nextToken() != JsonToken.END_OBJECT) {
      copyCurrentStructure(paramJsonParser);
    }
    writeEndObject();
  }
  
  public JsonGenerator disable(JsonGenerator.Feature paramFeature)
  {
    this._features &= (paramFeature.getMask() ^ 0xFFFFFFFF);
    if (paramFeature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
      this._cfgNumbersAsStrings = false;
    }
    while (paramFeature != JsonGenerator.Feature.ESCAPE_NON_ASCII) {
      return this;
    }
    setHighestNonEscapedChar(0);
    return this;
  }
  
  public JsonGenerator enable(JsonGenerator.Feature paramFeature)
  {
    this._features |= paramFeature.getMask();
    if (paramFeature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
      this._cfgNumbersAsStrings = true;
    }
    while (paramFeature != JsonGenerator.Feature.ESCAPE_NON_ASCII) {
      return this;
    }
    setHighestNonEscapedChar(127);
    return this;
  }
  
  public abstract void flush();
  
  public final ObjectCodec getCodec()
  {
    return this._objectCodec;
  }
  
  public final JsonWriteContext getOutputContext()
  {
    return this._writeContext;
  }
  
  public boolean isClosed()
  {
    return this._closed;
  }
  
  public final boolean isEnabled(JsonGenerator.Feature paramFeature)
  {
    return (this._features & paramFeature.getMask()) != 0;
  }
  
  public JsonGenerator setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
    return this;
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    return setPrettyPrinter(new DefaultPrettyPrinter());
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public void writeEndArray()
  {
    if (!this._writeContext.inArray()) {
      _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
    }
    if (this._cfgPrettyPrinter != null) {
      this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
    }
    for (;;)
    {
      this._writeContext = this._writeContext.getParent();
      return;
      _writeEndArray();
    }
  }
  
  public void writeEndObject()
  {
    if (!this._writeContext.inObject()) {
      _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
    }
    this._writeContext = this._writeContext.getParent();
    if (this._cfgPrettyPrinter != null)
    {
      this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
      return;
    }
    _writeEndObject();
  }
  
  public void writeObject(Object paramObject)
  {
    if (paramObject == null)
    {
      writeNull();
      return;
    }
    if (this._objectCodec != null)
    {
      this._objectCodec.writeValue(this, paramObject);
      return;
    }
    _writeSimpleObject(paramObject);
  }
  
  public void writeRawValue(String paramString)
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramString);
  }
  
  public void writeRawValue(String paramString, int paramInt1, int paramInt2)
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramString, paramInt1, paramInt2);
  }
  
  public void writeRawValue(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void writeStartArray()
  {
    _verifyValueWrite("start an array");
    this._writeContext = this._writeContext.createChildArrayContext();
    if (this._cfgPrettyPrinter != null)
    {
      this._cfgPrettyPrinter.writeStartArray(this);
      return;
    }
    _writeStartArray();
  }
  
  public void writeStartObject()
  {
    _verifyValueWrite("start an object");
    this._writeContext = this._writeContext.createChildObjectContext();
    if (this._cfgPrettyPrinter != null)
    {
      this._cfgPrettyPrinter.writeStartObject(this);
      return;
    }
    _writeStartObject();
  }
  
  public void writeTree(JsonNode paramJsonNode)
  {
    if (paramJsonNode == null)
    {
      writeNull();
      return;
    }
    if (this._objectCodec == null) {
      throw new IllegalStateException("No ObjectCodec defined for the generator, can not serialize JsonNode-based trees");
    }
    this._objectCodec.writeTree(this, paramJsonNode);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/impl/JsonGeneratorBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */