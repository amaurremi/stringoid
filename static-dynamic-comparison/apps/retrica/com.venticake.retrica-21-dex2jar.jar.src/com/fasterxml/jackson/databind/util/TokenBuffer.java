package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import java.math.BigDecimal;
import java.math.BigInteger;

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
  
  public TokenBuffer append(TokenBuffer paramTokenBuffer)
  {
    paramTokenBuffer = paramTokenBuffer.asParser();
    while (paramTokenBuffer.nextToken() != null) {
      copyCurrentEvent(paramTokenBuffer);
    }
    return this;
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
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
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
      switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
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
      switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
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
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[localJsonToken1.ordinal()])
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
  
  public void flush() {}
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: new 251	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc -2
    //   11: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_0
    //   16: invokevirtual 70	com/fasterxml/jackson/databind/util/TokenBuffer:asParser	()Lcom/fasterxml/jackson/core/JsonParser;
    //   19: astore_3
    //   20: iconst_0
    //   21: istore_1
    //   22: aload_3
    //   23: invokevirtual 76	com/fasterxml/jackson/core/JsonParser:nextToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   26: astore 4
    //   28: aload 4
    //   30: ifnonnull +42 -> 72
    //   33: iload_1
    //   34: bipush 100
    //   36: if_icmplt +24 -> 60
    //   39: aload_2
    //   40: ldc_w 259
    //   43: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_1
    //   47: bipush 100
    //   49: isub
    //   50: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc_w 264
    //   56: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_2
    //   61: bipush 93
    //   63: invokevirtual 267	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_2
    //   68: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: areturn
    //   72: iload_1
    //   73: bipush 100
    //   75: if_icmpge +56 -> 131
    //   78: iload_1
    //   79: ifle +11 -> 90
    //   82: aload_2
    //   83: ldc_w 271
    //   86: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_2
    //   91: aload 4
    //   93: invokevirtual 272	com/fasterxml/jackson/core/JsonToken:toString	()Ljava/lang/String;
    //   96: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 4
    //   102: getstatic 237	com/fasterxml/jackson/core/JsonToken:FIELD_NAME	Lcom/fasterxml/jackson/core/JsonToken;
    //   105: if_acmpne +26 -> 131
    //   108: aload_2
    //   109: bipush 40
    //   111: invokevirtual 267	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: aload_3
    //   117: invokevirtual 139	com/fasterxml/jackson/core/JsonParser:getCurrentName	()Ljava/lang/String;
    //   120: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_2
    //   125: bipush 41
    //   127: invokevirtual 267	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: iload_1
    //   132: iconst_1
    //   133: iadd
    //   134: istore_1
    //   135: goto -113 -> 22
    //   138: astore_2
    //   139: new 274	java/lang/IllegalStateException
    //   142: dup
    //   143: aload_2
    //   144: invokespecial 277	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	TokenBuffer
    //   21	114	1	i	int
    //   7	118	2	localStringBuilder	StringBuilder
    //   138	6	2	localIOException	java.io.IOException
    //   19	98	3	localJsonParser	JsonParser
    //   26	75	4	localJsonToken	JsonToken
    // Exception table:
    //   from	to	target	type
    //   22	28	138	java/io/IOException
    //   82	90	138	java/io/IOException
    //   90	131	138	java/io/IOException
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
  
  public void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    writeString(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/TokenBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */