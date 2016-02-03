package org.codehaus.jackson.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonGenerator.Feature;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.SerializedString;

public class TokenBuffer
  extends JsonGenerator
{
  protected static final int DEFAULT_PARSER_FEATURES = ;
  protected int _appendOffset;
  protected boolean _closed;
  protected TokenBuffer.Segment _first;
  protected int _generatorFeatures;
  protected TokenBuffer.Segment _last;
  protected ObjectCodec _objectCodec;
  protected JsonWriteContext _writeContext;
  
  public TokenBuffer(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
    this._generatorFeatures = DEFAULT_PARSER_FEATURES;
    this._writeContext = JsonWriteContext.createRootContext();
    paramObjectCodec = new TokenBuffer.Segment();
    this._last = paramObjectCodec;
    this._first = paramObjectCodec;
    this._appendOffset = 0;
  }
  
  protected final void _append(JsonToken paramJsonToken)
  {
    paramJsonToken = this._last.append(this._appendOffset, paramJsonToken);
    if (paramJsonToken == null)
    {
      this._appendOffset += 1;
      return;
    }
    this._last = paramJsonToken;
    this._appendOffset = 1;
  }
  
  protected final void _append(JsonToken paramJsonToken, Object paramObject)
  {
    paramJsonToken = this._last.append(this._appendOffset, paramJsonToken, paramObject);
    if (paramJsonToken == null)
    {
      this._appendOffset += 1;
      return;
    }
    this._last = paramJsonToken;
    this._appendOffset = 1;
  }
  
  protected void _reportUnsupportedOperation()
  {
    throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
  }
  
  public JsonParser asParser()
  {
    return asParser(this._objectCodec);
  }
  
  public JsonParser asParser(JsonParser paramJsonParser)
  {
    TokenBuffer.Parser localParser = new TokenBuffer.Parser(this._first, paramJsonParser.getCodec());
    localParser.setLocation(paramJsonParser.getTokenLocation());
    return localParser;
  }
  
  public JsonParser asParser(ObjectCodec paramObjectCodec)
  {
    return new TokenBuffer.Parser(this._first, paramObjectCodec);
  }
  
  public void close()
  {
    this._closed = true;
  }
  
  public void copyCurrentEvent(JsonParser paramJsonParser)
  {
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    default: 
      throw new RuntimeException("Internal error: should never end up through this code path");
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
  
  public void copyCurrentStructure(JsonParser paramJsonParser)
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
    this._generatorFeatures &= (paramFeature.getMask() ^ 0xFFFFFFFF);
    return this;
  }
  
  public JsonGenerator enable(JsonGenerator.Feature paramFeature)
  {
    this._generatorFeatures |= paramFeature.getMask();
    return this;
  }
  
  public void flush() {}
  
  public ObjectCodec getCodec()
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
  
  public boolean isEnabled(JsonGenerator.Feature paramFeature)
  {
    return (this._generatorFeatures & paramFeature.getMask()) != 0;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator)
  {
    TokenBuffer.Segment localSegment = this._first;
    int i = -1;
    i += 1;
    if (i >= 16)
    {
      localSegment = localSegment.next();
      if (localSegment == null) {
        label26:
        return;
      }
      i = 0;
    }
    for (;;)
    {
      Object localObject = localSegment.type(i);
      if (localObject == null) {
        break label26;
      }
      switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[localObject.ordinal()])
      {
      default: 
        throw new RuntimeException("Internal error: should never end up through this code path");
      case 1: 
        paramJsonGenerator.writeStartObject();
      }
      for (;;)
      {
        break;
        paramJsonGenerator.writeEndObject();
        continue;
        paramJsonGenerator.writeStartArray();
        continue;
        paramJsonGenerator.writeEndArray();
        continue;
        localObject = localSegment.get(i);
        if ((localObject instanceof SerializableString))
        {
          paramJsonGenerator.writeFieldName((SerializableString)localObject);
        }
        else
        {
          paramJsonGenerator.writeFieldName((String)localObject);
          continue;
          localObject = localSegment.get(i);
          if ((localObject instanceof SerializableString))
          {
            paramJsonGenerator.writeString((SerializableString)localObject);
          }
          else
          {
            paramJsonGenerator.writeString((String)localObject);
            continue;
            localObject = (Number)localSegment.get(i);
            if ((localObject instanceof BigInteger))
            {
              paramJsonGenerator.writeNumber((BigInteger)localObject);
            }
            else if ((localObject instanceof Long))
            {
              paramJsonGenerator.writeNumber(((Number)localObject).longValue());
            }
            else
            {
              paramJsonGenerator.writeNumber(((Number)localObject).intValue());
              continue;
              localObject = localSegment.get(i);
              if ((localObject instanceof BigDecimal))
              {
                paramJsonGenerator.writeNumber((BigDecimal)localObject);
              }
              else if ((localObject instanceof Float))
              {
                paramJsonGenerator.writeNumber(((Float)localObject).floatValue());
              }
              else if ((localObject instanceof Double))
              {
                paramJsonGenerator.writeNumber(((Double)localObject).doubleValue());
              }
              else if (localObject == null)
              {
                paramJsonGenerator.writeNull();
              }
              else if ((localObject instanceof String))
              {
                paramJsonGenerator.writeNumber((String)localObject);
              }
              else
              {
                throw new JsonGenerationException("Unrecognized value type for VALUE_NUMBER_FLOAT: " + localObject.getClass().getName() + ", can not serialize");
                paramJsonGenerator.writeBoolean(true);
                continue;
                paramJsonGenerator.writeBoolean(false);
                continue;
                paramJsonGenerator.writeNull();
                continue;
                paramJsonGenerator.writeObject(localSegment.get(i));
              }
            }
          }
        }
      }
    }
  }
  
  public JsonGenerator setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TokenBuffer: ");
    JsonParser localJsonParser = asParser();
    int i = 0;
    for (;;)
    {
      JsonToken localJsonToken;
      try
      {
        localJsonToken = localJsonParser.nextToken();
        if (localJsonToken == null)
        {
          if (i >= 100) {
            localStringBuilder.append(" ... (truncated ").append(i - 100).append(" entries)");
          }
          localStringBuilder.append(']');
          return localStringBuilder.toString();
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
      if (i < 100)
      {
        if (i > 0) {
          localIOException.append(", ");
        }
        localIOException.append(localJsonToken.toString());
      }
      i += 1;
    }
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    return this;
  }
  
  public void writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramBase64Variant = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, paramBase64Variant, 0, paramInt2);
    writeObject(paramBase64Variant);
  }
  
  public void writeBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (JsonToken localJsonToken = JsonToken.VALUE_TRUE;; localJsonToken = JsonToken.VALUE_FALSE)
    {
      _append(localJsonToken);
      return;
    }
  }
  
  public final void writeEndArray()
  {
    _append(JsonToken.END_ARRAY);
    JsonWriteContext localJsonWriteContext = this._writeContext.getParent();
    if (localJsonWriteContext != null) {
      this._writeContext = localJsonWriteContext;
    }
  }
  
  public final void writeEndObject()
  {
    _append(JsonToken.END_OBJECT);
    JsonWriteContext localJsonWriteContext = this._writeContext.getParent();
    if (localJsonWriteContext != null) {
      this._writeContext = localJsonWriteContext;
    }
  }
  
  public final void writeFieldName(String paramString)
  {
    _append(JsonToken.FIELD_NAME, paramString);
    this._writeContext.writeFieldName(paramString);
  }
  
  public void writeFieldName(SerializableString paramSerializableString)
  {
    _append(JsonToken.FIELD_NAME, paramSerializableString);
    this._writeContext.writeFieldName(paramSerializableString.getValue());
  }
  
  public void writeFieldName(SerializedString paramSerializedString)
  {
    _append(JsonToken.FIELD_NAME, paramSerializedString);
    this._writeContext.writeFieldName(paramSerializedString.getValue());
  }
  
  public void writeNull()
  {
    _append(JsonToken.VALUE_NULL);
  }
  
  public void writeNumber(double paramDouble)
  {
    _append(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(paramDouble));
  }
  
  public void writeNumber(float paramFloat)
  {
    _append(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(paramFloat));
  }
  
  public void writeNumber(int paramInt)
  {
    _append(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(paramInt));
  }
  
  public void writeNumber(long paramLong)
  {
    _append(JsonToken.VALUE_NUMBER_INT, Long.valueOf(paramLong));
  }
  
  public void writeNumber(String paramString)
  {
    _append(JsonToken.VALUE_NUMBER_FLOAT, paramString);
  }
  
  public void writeNumber(BigDecimal paramBigDecimal)
  {
    if (paramBigDecimal == null)
    {
      writeNull();
      return;
    }
    _append(JsonToken.VALUE_NUMBER_FLOAT, paramBigDecimal);
  }
  
  public void writeNumber(BigInteger paramBigInteger)
  {
    if (paramBigInteger == null)
    {
      writeNull();
      return;
    }
    _append(JsonToken.VALUE_NUMBER_INT, paramBigInteger);
  }
  
  public void writeObject(Object paramObject)
  {
    _append(JsonToken.VALUE_EMBEDDED_OBJECT, paramObject);
  }
  
  public void writeRaw(char paramChar)
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(String paramString)
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(String paramString, int paramInt1, int paramInt2)
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRawValue(String paramString)
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRawValue(String paramString, int paramInt1, int paramInt2)
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRawValue(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _reportUnsupportedOperation();
  }
  
  public final void writeStartArray()
  {
    _append(JsonToken.START_ARRAY);
    this._writeContext = this._writeContext.createChildArrayContext();
  }
  
  public final void writeStartObject()
  {
    _append(JsonToken.START_OBJECT);
    this._writeContext = this._writeContext.createChildObjectContext();
  }
  
  public void writeString(String paramString)
  {
    if (paramString == null)
    {
      writeNull();
      return;
    }
    _append(JsonToken.VALUE_STRING, paramString);
  }
  
  public void writeString(SerializableString paramSerializableString)
  {
    if (paramSerializableString == null)
    {
      writeNull();
      return;
    }
    _append(JsonToken.VALUE_STRING, paramSerializableString);
  }
  
  public void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    writeString(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public void writeTree(JsonNode paramJsonNode)
  {
    _append(JsonToken.VALUE_EMBEDDED_OBJECT, paramJsonNode);
  }
  
  public void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _reportUnsupportedOperation();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/util/TokenBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */