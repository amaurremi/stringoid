package org.codehaus.jackson.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.impl.JsonParserMinimalBase;
import org.codehaus.jackson.impl.JsonReadContext;

public final class TokenBuffer$Parser
  extends JsonParserMinimalBase
{
  protected transient ByteArrayBuilder _byteBuilder;
  protected boolean _closed;
  protected ObjectCodec _codec;
  protected JsonLocation _location = null;
  protected JsonReadContext _parsingContext;
  protected TokenBuffer.Segment _segment;
  protected int _segmentPtr;
  
  public TokenBuffer$Parser(TokenBuffer.Segment paramSegment, ObjectCodec paramObjectCodec)
  {
    super(0);
    this._segment = paramSegment;
    this._segmentPtr = -1;
    this._codec = paramObjectCodec;
    this._parsingContext = JsonReadContext.createRootContext(-1, -1);
  }
  
  protected final void _checkIsNumber()
  {
    if ((this._currToken == null) || (!this._currToken.isNumeric())) {
      throw _constructError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
    }
  }
  
  protected final Object _currentObject()
  {
    return this._segment.get(this._segmentPtr);
  }
  
  protected void _handleEOF()
  {
    _throwInternal();
  }
  
  public void close()
  {
    if (!this._closed) {
      this._closed = true;
    }
  }
  
  public BigInteger getBigIntegerValue()
  {
    Number localNumber = getNumberValue();
    if ((localNumber instanceof BigInteger)) {
      return (BigInteger)localNumber;
    }
    switch (TokenBuffer.1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[getNumberType().ordinal()])
    {
    default: 
      return BigInteger.valueOf(localNumber.longValue());
    }
    return ((BigDecimal)localNumber).toBigInteger();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
  {
    if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      localObject = _currentObject();
      if ((localObject instanceof byte[])) {
        return (byte[])localObject;
      }
    }
    if (this._currToken != JsonToken.VALUE_STRING) {
      throw _constructError("Current token (" + this._currToken + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
    }
    String str = getText();
    if (str == null) {
      return null;
    }
    ByteArrayBuilder localByteArrayBuilder = this._byteBuilder;
    Object localObject = localByteArrayBuilder;
    if (localByteArrayBuilder == null)
    {
      localObject = new ByteArrayBuilder(100);
      this._byteBuilder = ((ByteArrayBuilder)localObject);
    }
    _decodeBase64(str, (ByteArrayBuilder)localObject, paramBase64Variant);
    return ((ByteArrayBuilder)localObject).toByteArray();
  }
  
  public ObjectCodec getCodec()
  {
    return this._codec;
  }
  
  public JsonLocation getCurrentLocation()
  {
    if (this._location == null) {
      return JsonLocation.NA;
    }
    return this._location;
  }
  
  public String getCurrentName()
  {
    return this._parsingContext.getCurrentName();
  }
  
  public BigDecimal getDecimalValue()
  {
    Number localNumber = getNumberValue();
    if ((localNumber instanceof BigDecimal)) {
      return (BigDecimal)localNumber;
    }
    switch (TokenBuffer.1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[getNumberType().ordinal()])
    {
    case 3: 
    case 4: 
    default: 
      return BigDecimal.valueOf(localNumber.doubleValue());
    case 1: 
    case 5: 
      return BigDecimal.valueOf(localNumber.longValue());
    }
    return new BigDecimal((BigInteger)localNumber);
  }
  
  public double getDoubleValue()
  {
    return getNumberValue().doubleValue();
  }
  
  public Object getEmbeddedObject()
  {
    if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
      return _currentObject();
    }
    return null;
  }
  
  public float getFloatValue()
  {
    return getNumberValue().floatValue();
  }
  
  public int getIntValue()
  {
    if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
      return ((Number)_currentObject()).intValue();
    }
    return getNumberValue().intValue();
  }
  
  public long getLongValue()
  {
    return getNumberValue().longValue();
  }
  
  public JsonParser.NumberType getNumberType()
  {
    Number localNumber = getNumberValue();
    if ((localNumber instanceof Integer)) {
      return JsonParser.NumberType.INT;
    }
    if ((localNumber instanceof Long)) {
      return JsonParser.NumberType.LONG;
    }
    if ((localNumber instanceof Double)) {
      return JsonParser.NumberType.DOUBLE;
    }
    if ((localNumber instanceof BigDecimal)) {
      return JsonParser.NumberType.BIG_DECIMAL;
    }
    if ((localNumber instanceof Float)) {
      return JsonParser.NumberType.FLOAT;
    }
    if ((localNumber instanceof BigInteger)) {
      return JsonParser.NumberType.BIG_INTEGER;
    }
    return null;
  }
  
  public final Number getNumberValue()
  {
    _checkIsNumber();
    return (Number)_currentObject();
  }
  
  public JsonStreamContext getParsingContext()
  {
    return this._parsingContext;
  }
  
  public String getText()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this._currToken == JsonToken.VALUE_STRING) || (this._currToken == JsonToken.FIELD_NAME))
    {
      localObject1 = _currentObject();
      if ((localObject1 instanceof String)) {
        localObject1 = (String)localObject1;
      }
    }
    Object localObject3;
    do
    {
      do
      {
        return (String)localObject1;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = localObject1.toString()) {
          return (String)localObject1;
        }
        localObject1 = localObject2;
      } while (this._currToken == null);
      switch (TokenBuffer.1.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()])
      {
      default: 
        return this._currToken.asString();
      }
      localObject3 = _currentObject();
      localObject1 = localObject2;
    } while (localObject3 == null);
    return localObject3.toString();
  }
  
  public char[] getTextCharacters()
  {
    String str = getText();
    if (str == null) {
      return null;
    }
    return str.toCharArray();
  }
  
  public int getTextLength()
  {
    String str = getText();
    if (str == null) {
      return 0;
    }
    return str.length();
  }
  
  public int getTextOffset()
  {
    return 0;
  }
  
  public JsonLocation getTokenLocation()
  {
    return getCurrentLocation();
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
    if ((this._closed) || (this._segment == null)) {}
    do
    {
      return null;
      int i = this._segmentPtr + 1;
      this._segmentPtr = i;
      if (i < 16) {
        break;
      }
      this._segmentPtr = 0;
      this._segment = this._segment.next();
    } while (this._segment == null);
    this._currToken = this._segment.type(this._segmentPtr);
    Object localObject;
    if (this._currToken == JsonToken.FIELD_NAME)
    {
      localObject = _currentObject();
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        this._parsingContext.setCurrentName((String)localObject);
      }
    }
    for (;;)
    {
      return this._currToken;
      localObject = localObject.toString();
      break;
      if (this._currToken == JsonToken.START_OBJECT)
      {
        this._parsingContext = this._parsingContext.createChildObjectContext(-1, -1);
      }
      else if (this._currToken == JsonToken.START_ARRAY)
      {
        this._parsingContext = this._parsingContext.createChildArrayContext(-1, -1);
      }
      else if ((this._currToken == JsonToken.END_OBJECT) || (this._currToken == JsonToken.END_ARRAY))
      {
        this._parsingContext = this._parsingContext.getParent();
        if (this._parsingContext == null) {
          this._parsingContext = JsonReadContext.createRootContext(-1, -1);
        }
      }
    }
  }
  
  public JsonToken peekNextToken()
  {
    if (this._closed) {}
    label54:
    for (;;)
    {
      return null;
      TokenBuffer.Segment localSegment = this._segment;
      int i = this._segmentPtr + 1;
      if (i >= 16) {
        if (localSegment == null)
        {
          localSegment = null;
          i = 0;
        }
      }
      for (;;)
      {
        if (localSegment == null) {
          break label54;
        }
        return localSegment.type(i);
        localSegment = localSegment.next();
        break;
      }
    }
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this._codec = paramObjectCodec;
  }
  
  public void setLocation(JsonLocation paramJsonLocation)
  {
    this._location = paramJsonLocation;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/util/TokenBuffer$Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */