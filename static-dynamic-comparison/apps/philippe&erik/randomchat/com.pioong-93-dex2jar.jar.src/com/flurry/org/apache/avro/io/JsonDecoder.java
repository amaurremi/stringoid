package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.JsonGrammarGenerator;
import com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler;
import com.flurry.org.apache.avro.io.parsing.SkipParser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.io.parsing.Symbol.Alternative;
import com.flurry.org.apache.avro.io.parsing.Symbol.EnumLabelsAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction;
import com.flurry.org.apache.avro.util.Utf8;
import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonLocation;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonParser.NumberType;
import com.flurry.org.codehaus.jackson.JsonStreamContext;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.ObjectCodec;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class JsonDecoder
  extends ParsingDecoder
  implements Parser.ActionHandler
{
  static final String CHARSET = "ISO-8859-1";
  private static JsonFactory jsonFactory = new JsonFactory();
  ReorderBuffer currentReorderBuffer;
  private JsonParser in;
  Stack<ReorderBuffer> reorderBuffers = new Stack();
  
  JsonDecoder(Schema paramSchema, InputStream paramInputStream)
    throws IOException
  {
    this(getSymbol(paramSchema), paramInputStream);
  }
  
  JsonDecoder(Schema paramSchema, String paramString)
    throws IOException
  {
    this(getSymbol(paramSchema), paramString);
  }
  
  private JsonDecoder(Symbol paramSymbol, InputStream paramInputStream)
    throws IOException
  {
    super(paramSymbol);
    configure(paramInputStream);
  }
  
  private JsonDecoder(Symbol paramSymbol, String paramString)
    throws IOException
  {
    super(paramSymbol);
    configure(paramString);
  }
  
  private void advance(Symbol paramSymbol)
    throws IOException
  {
    this.parser.processTrailingImplicitActions();
    if ((this.in.getCurrentToken() == null) && (this.parser.depth() == 1)) {
      throw new EOFException();
    }
    this.parser.advance(paramSymbol);
  }
  
  private void checkFixed(int paramInt)
    throws IOException
  {
    advance(Symbol.FIXED);
    Symbol.IntCheckAction localIntCheckAction = (Symbol.IntCheckAction)this.parser.popSymbol();
    if (paramInt != localIntCheckAction.size) {
      throw new AvroTypeException("Incorrect length for fixed binary: expected " + localIntCheckAction.size + " but received " + paramInt + " bytes.");
    }
  }
  
  private long doArrayNext()
    throws IOException
  {
    if (this.in.getCurrentToken() == JsonToken.END_ARRAY)
    {
      this.parser.advance(Symbol.ARRAY_END);
      this.in.nextToken();
      return 0L;
    }
    return 1L;
  }
  
  private long doMapNext()
    throws IOException
  {
    if (this.in.getCurrentToken() == JsonToken.END_OBJECT)
    {
      this.in.nextToken();
      advance(Symbol.MAP_END);
      return 0L;
    }
    return 1L;
  }
  
  private void doSkipFixed(int paramInt)
    throws IOException
  {
    if (this.in.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      byte[] arrayOfByte = readByteArray();
      this.in.nextToken();
      if (arrayOfByte.length != paramInt) {
        throw new AvroTypeException("Expected fixed length " + paramInt + ", but got" + arrayOfByte.length);
      }
    }
    else
    {
      throw error("fixed");
    }
  }
  
  private AvroTypeException error(String paramString)
  {
    return new AvroTypeException("Expected " + paramString + ". Got " + this.in.getCurrentToken());
  }
  
  private static Symbol getSymbol(Schema paramSchema)
  {
    if (paramSchema == null) {
      throw new NullPointerException("Schema cannot be null!");
    }
    return new JsonGrammarGenerator().generate(paramSchema);
  }
  
  private static List<JsonElement> getVaueAsTree(JsonParser paramJsonParser)
    throws IOException
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    int i;
    switch (localJsonToken)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      paramJsonParser.nextToken();
      j = i;
      if (i != 0) {
        break;
      }
      localArrayList.add(new JsonElement(null));
      return localArrayList;
      i = j + 1;
      localArrayList.add(new JsonElement(localJsonToken));
      continue;
      i = j - 1;
      localArrayList.add(new JsonElement(localJsonToken));
      continue;
      localArrayList.add(new JsonElement(localJsonToken, paramJsonParser.getText()));
      i = j;
    }
  }
  
  private JsonParser makeParser(final List<JsonElement> paramList)
    throws IOException
  {
    new JsonParser()
    {
      int pos = 0;
      
      public void close()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public BigInteger getBigIntegerValue()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public byte[] getBinaryValue(Base64Variant paramAnonymousBase64Variant)
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public ObjectCodec getCodec()
      {
        throw new UnsupportedOperationException();
      }
      
      public JsonLocation getCurrentLocation()
      {
        throw new UnsupportedOperationException();
      }
      
      public String getCurrentName()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public JsonToken getCurrentToken()
      {
        return ((JsonDecoder.JsonElement)paramList.get(this.pos)).token;
      }
      
      public BigDecimal getDecimalValue()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public double getDoubleValue()
        throws IOException
      {
        return Double.parseDouble(getText());
      }
      
      public float getFloatValue()
        throws IOException
      {
        return Float.parseFloat(getText());
      }
      
      public int getIntValue()
        throws IOException
      {
        return Integer.parseInt(getText());
      }
      
      public long getLongValue()
        throws IOException
      {
        return Long.parseLong(getText());
      }
      
      public JsonParser.NumberType getNumberType()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public Number getNumberValue()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public JsonStreamContext getParsingContext()
      {
        throw new UnsupportedOperationException();
      }
      
      public String getText()
        throws IOException
      {
        return ((JsonDecoder.JsonElement)paramList.get(this.pos)).value;
      }
      
      public char[] getTextCharacters()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public int getTextLength()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public int getTextOffset()
        throws IOException
      {
        throw new UnsupportedOperationException();
      }
      
      public JsonLocation getTokenLocation()
      {
        throw new UnsupportedOperationException();
      }
      
      public boolean isClosed()
      {
        throw new UnsupportedOperationException();
      }
      
      public JsonToken nextToken()
        throws IOException
      {
        this.pos += 1;
        return ((JsonDecoder.JsonElement)paramList.get(this.pos)).token;
      }
      
      public void setCodec(ObjectCodec paramAnonymousObjectCodec)
      {
        throw new UnsupportedOperationException();
      }
      
      public JsonParser skipChildren()
        throws IOException
      {
        int j = 0;
        int[] arrayOfInt = JsonDecoder.2.$SwitchMap$org$codehaus$jackson$JsonToken;
        List localList = paramList;
        int i = this.pos;
        this.pos = (i + 1);
        switch (arrayOfInt[((JsonDecoder.JsonElement)localList.get(i)).token.ordinal()])
        {
        default: 
          i = j;
        }
        for (;;)
        {
          j = i;
          if (i > 0) {
            break;
          }
          return this;
          i = j + 1;
          continue;
          i = j - 1;
        }
      }
    };
  }
  
  private byte[] readByteArray()
    throws IOException
  {
    return this.in.getText().getBytes("ISO-8859-1");
  }
  
  public long arrayNext()
    throws IOException
  {
    advance(Symbol.ITEM_END);
    return doArrayNext();
  }
  
  public JsonDecoder configure(InputStream paramInputStream)
    throws IOException
  {
    if (paramInputStream == null) {
      throw new NullPointerException("InputStream to read from cannot be null!");
    }
    this.parser.reset();
    this.in = jsonFactory.createJsonParser(paramInputStream);
    this.in.nextToken();
    return this;
  }
  
  public JsonDecoder configure(String paramString)
    throws IOException
  {
    if (paramString == null) {
      throw new NullPointerException("String to read from cannot be null!");
    }
    this.parser.reset();
    this.in = new JsonFactory().createJsonParser(paramString);
    this.in.nextToken();
    return this;
  }
  
  public Symbol doAction(Symbol paramSymbol1, Symbol paramSymbol2)
    throws IOException
  {
    Object localObject;
    if ((paramSymbol2 instanceof Symbol.FieldAdjustAction))
    {
      paramSymbol1 = (Symbol.FieldAdjustAction)paramSymbol2;
      paramSymbol2 = paramSymbol1.fname;
      if (this.currentReorderBuffer != null)
      {
        localObject = (List)this.currentReorderBuffer.savedFields.get(paramSymbol2);
        if (localObject != null)
        {
          this.currentReorderBuffer.savedFields.remove(paramSymbol2);
          this.currentReorderBuffer.origParser = this.in;
          this.in = makeParser((List)localObject);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
        } while (this.in.getCurrentToken() != JsonToken.FIELD_NAME);
        do
        {
          localObject = this.in.getText();
          this.in.nextToken();
          if (paramSymbol2.equals(localObject)) {
            break;
          }
          if (this.currentReorderBuffer == null) {
            this.currentReorderBuffer = new ReorderBuffer(null);
          }
          this.currentReorderBuffer.savedFields.put(localObject, getVaueAsTree(this.in));
        } while (this.in.getCurrentToken() == JsonToken.FIELD_NAME);
        throw new AvroTypeException("Expected field name not found: " + paramSymbol1.fname);
        if (paramSymbol2 != Symbol.FIELD_END) {
          break;
        }
      } while ((this.currentReorderBuffer == null) || (this.currentReorderBuffer.origParser == null));
      this.in = this.currentReorderBuffer.origParser;
      this.currentReorderBuffer.origParser = null;
      return null;
      if (paramSymbol2 == Symbol.RECORD_START)
      {
        if (this.in.getCurrentToken() == JsonToken.START_OBJECT)
        {
          this.in.nextToken();
          this.reorderBuffers.push(this.currentReorderBuffer);
          this.currentReorderBuffer = null;
          return null;
        }
        throw error("record-start");
      }
      if ((paramSymbol2 != Symbol.RECORD_END) && (paramSymbol2 != Symbol.UNION_END)) {
        break label442;
      }
      if (this.in.getCurrentToken() != JsonToken.END_OBJECT) {
        break;
      }
      this.in.nextToken();
    } while (paramSymbol2 != Symbol.RECORD_END);
    if ((this.currentReorderBuffer != null) && (!this.currentReorderBuffer.savedFields.isEmpty())) {
      throw error("Unknown fields: " + this.currentReorderBuffer.savedFields.keySet());
    }
    this.currentReorderBuffer = ((ReorderBuffer)this.reorderBuffers.pop());
    return null;
    if (paramSymbol2 == Symbol.RECORD_END) {}
    for (paramSymbol1 = "record-end";; paramSymbol1 = "union-end") {
      throw error(paramSymbol1);
    }
    label442:
    throw new AvroTypeException("Unknown action symbol " + paramSymbol2);
  }
  
  public long mapNext()
    throws IOException
  {
    advance(Symbol.ITEM_END);
    return doMapNext();
  }
  
  public long readArrayStart()
    throws IOException
  {
    advance(Symbol.ARRAY_START);
    if (this.in.getCurrentToken() == JsonToken.START_ARRAY)
    {
      this.in.nextToken();
      return doArrayNext();
    }
    throw error("array-start");
  }
  
  public boolean readBoolean()
    throws IOException
  {
    advance(Symbol.BOOLEAN);
    JsonToken localJsonToken = this.in.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_TRUE) || (localJsonToken == JsonToken.VALUE_FALSE))
    {
      this.in.nextToken();
      return localJsonToken == JsonToken.VALUE_TRUE;
    }
    throw error("boolean");
  }
  
  public ByteBuffer readBytes(ByteBuffer paramByteBuffer)
    throws IOException
  {
    advance(Symbol.BYTES);
    if (this.in.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      paramByteBuffer = readByteArray();
      this.in.nextToken();
      return ByteBuffer.wrap(paramByteBuffer);
    }
    throw error("bytes");
  }
  
  public double readDouble()
    throws IOException
  {
    advance(Symbol.DOUBLE);
    if (this.in.getCurrentToken() == JsonToken.VALUE_NUMBER_FLOAT)
    {
      double d = this.in.getDoubleValue();
      this.in.nextToken();
      return d;
    }
    throw error("double");
  }
  
  public int readEnum()
    throws IOException
  {
    advance(Symbol.ENUM);
    Symbol.EnumLabelsAction localEnumLabelsAction = (Symbol.EnumLabelsAction)this.parser.popSymbol();
    if (this.in.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      this.in.getText();
      int i = localEnumLabelsAction.findLabel(this.in.getText());
      if (i >= 0)
      {
        this.in.nextToken();
        return i;
      }
      throw new AvroTypeException("Unknown symbol in enum " + this.in.getText());
    }
    throw error("fixed");
  }
  
  public void readFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    checkFixed(paramInt2);
    if (this.in.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      byte[] arrayOfByte = readByteArray();
      this.in.nextToken();
      if (arrayOfByte.length != paramInt2) {
        throw new AvroTypeException("Expected fixed length " + paramInt2 + ", but got" + arrayOfByte.length);
      }
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw error("fixed");
  }
  
  public float readFloat()
    throws IOException
  {
    advance(Symbol.FLOAT);
    if (this.in.getCurrentToken() == JsonToken.VALUE_NUMBER_FLOAT)
    {
      float f = this.in.getFloatValue();
      this.in.nextToken();
      return f;
    }
    throw error("float");
  }
  
  public int readIndex()
    throws IOException
  {
    advance(Symbol.UNION);
    Symbol.Alternative localAlternative = (Symbol.Alternative)this.parser.popSymbol();
    String str;
    if (this.in.getCurrentToken() == JsonToken.VALUE_NULL) {
      str = "null";
    }
    int i;
    for (;;)
    {
      i = localAlternative.findLabel(str);
      if (i >= 0) {
        break label136;
      }
      throw new AvroTypeException("Unknown union branch " + str);
      if ((this.in.getCurrentToken() != JsonToken.START_OBJECT) || (this.in.nextToken() != JsonToken.FIELD_NAME)) {
        break;
      }
      str = this.in.getText();
      this.in.nextToken();
      this.parser.pushSymbol(Symbol.UNION_END);
    }
    throw error("start-union");
    label136:
    this.parser.pushSymbol(localAlternative.getSymbol(i));
    return i;
  }
  
  public int readInt()
    throws IOException
  {
    advance(Symbol.INT);
    if (this.in.getCurrentToken() == JsonToken.VALUE_NUMBER_INT)
    {
      int i = this.in.getIntValue();
      this.in.nextToken();
      return i;
    }
    throw error("int");
  }
  
  public long readLong()
    throws IOException
  {
    advance(Symbol.LONG);
    if (this.in.getCurrentToken() == JsonToken.VALUE_NUMBER_INT)
    {
      long l = this.in.getLongValue();
      this.in.nextToken();
      return l;
    }
    throw error("long");
  }
  
  public long readMapStart()
    throws IOException
  {
    advance(Symbol.MAP_START);
    if (this.in.getCurrentToken() == JsonToken.START_OBJECT)
    {
      this.in.nextToken();
      return doMapNext();
    }
    throw error("map-start");
  }
  
  public void readNull()
    throws IOException
  {
    advance(Symbol.NULL);
    if (this.in.getCurrentToken() == JsonToken.VALUE_NULL)
    {
      this.in.nextToken();
      return;
    }
    throw error("null");
  }
  
  public Utf8 readString(Utf8 paramUtf8)
    throws IOException
  {
    return new Utf8(readString());
  }
  
  public String readString()
    throws IOException
  {
    advance(Symbol.STRING);
    if (this.parser.topSymbol() == Symbol.MAP_KEY_MARKER)
    {
      this.parser.advance(Symbol.MAP_KEY_MARKER);
      if (this.in.getCurrentToken() != JsonToken.FIELD_NAME) {
        throw error("map-key");
      }
    }
    else if (this.in.getCurrentToken() != JsonToken.VALUE_STRING)
    {
      throw error("string");
    }
    String str = this.in.getText();
    this.in.nextToken();
    return str;
  }
  
  public long skipArray()
    throws IOException
  {
    advance(Symbol.ARRAY_START);
    if (this.in.getCurrentToken() == JsonToken.START_ARRAY)
    {
      this.in.skipChildren();
      this.in.nextToken();
      advance(Symbol.ARRAY_END);
      return 0L;
    }
    throw error("array-start");
  }
  
  public void skipBytes()
    throws IOException
  {
    advance(Symbol.BYTES);
    if (this.in.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      this.in.nextToken();
      return;
    }
    throw error("bytes");
  }
  
  protected void skipFixed()
    throws IOException
  {
    advance(Symbol.FIXED);
    doSkipFixed(((Symbol.IntCheckAction)this.parser.popSymbol()).size);
  }
  
  public void skipFixed(int paramInt)
    throws IOException
  {
    checkFixed(paramInt);
    doSkipFixed(paramInt);
  }
  
  public long skipMap()
    throws IOException
  {
    advance(Symbol.MAP_START);
    if (this.in.getCurrentToken() == JsonToken.START_OBJECT)
    {
      this.in.skipChildren();
      this.in.nextToken();
      advance(Symbol.MAP_END);
      return 0L;
    }
    throw error("map-start");
  }
  
  public void skipString()
    throws IOException
  {
    advance(Symbol.STRING);
    if (this.parser.topSymbol() == Symbol.MAP_KEY_MARKER)
    {
      this.parser.advance(Symbol.MAP_KEY_MARKER);
      if (this.in.getCurrentToken() != JsonToken.FIELD_NAME) {
        throw error("map-key");
      }
    }
    else if (this.in.getCurrentToken() != JsonToken.VALUE_STRING)
    {
      throw error("string");
    }
    this.in.nextToken();
  }
  
  private static class JsonElement
  {
    public final JsonToken token;
    public final String value;
    
    public JsonElement(JsonToken paramJsonToken)
    {
      this(paramJsonToken, null);
    }
    
    public JsonElement(JsonToken paramJsonToken, String paramString)
    {
      this.token = paramJsonToken;
      this.value = paramString;
    }
  }
  
  private static class ReorderBuffer
  {
    public JsonParser origParser = null;
    public Map<String, List<JsonDecoder.JsonElement>> savedFields = new HashMap();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/JsonDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */