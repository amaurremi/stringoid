package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.JsonGrammarGenerator;
import com.flurry.org.apache.avro.io.parsing.Parser;
import com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.io.parsing.Symbol.Alternative;
import com.flurry.org.apache.avro.io.parsing.Symbol.EnumLabelsAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction;
import com.flurry.org.apache.avro.util.Utf8;
import com.flurry.org.codehaus.jackson.JsonEncoding;
import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.util.MinimalPrettyPrinter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.BitSet;

public class JsonEncoder
  extends ParsingEncoder
  implements Parser.ActionHandler
{
  protected BitSet isEmpty = new BitSet();
  private JsonGenerator out;
  final Parser parser;
  
  JsonEncoder(Schema paramSchema, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    configure(paramJsonGenerator);
    this.parser = new Parser(new JsonGrammarGenerator().generate(paramSchema), this);
  }
  
  JsonEncoder(Schema paramSchema, OutputStream paramOutputStream)
    throws IOException
  {
    this(paramSchema, getJsonGenerator(paramOutputStream));
  }
  
  private static JsonGenerator getJsonGenerator(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new NullPointerException("OutputStream cannot be null");
    }
    paramOutputStream = new JsonFactory().createJsonGenerator(paramOutputStream, JsonEncoding.UTF8);
    MinimalPrettyPrinter localMinimalPrettyPrinter = new MinimalPrettyPrinter();
    localMinimalPrettyPrinter.setRootValueSeparator(System.getProperty("line.separator"));
    paramOutputStream.setPrettyPrinter(localMinimalPrettyPrinter);
    return paramOutputStream;
  }
  
  private void writeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.writeString(new String(paramArrayOfByte, paramInt1, paramInt2, "ISO-8859-1"));
  }
  
  public JsonEncoder configure(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if (paramJsonGenerator == null) {
      throw new NullPointerException("JsonGenerator cannot be null");
    }
    if (this.parser != null) {
      flush();
    }
    this.out = paramJsonGenerator;
    return this;
  }
  
  public JsonEncoder configure(OutputStream paramOutputStream)
    throws IOException
  {
    configure(getJsonGenerator(paramOutputStream));
    return this;
  }
  
  public Symbol doAction(Symbol paramSymbol1, Symbol paramSymbol2)
    throws IOException
  {
    if ((paramSymbol2 instanceof Symbol.FieldAdjustAction))
    {
      paramSymbol1 = (Symbol.FieldAdjustAction)paramSymbol2;
      this.out.writeFieldName(paramSymbol1.fname);
    }
    do
    {
      for (;;)
      {
        return null;
        if (paramSymbol2 == Symbol.RECORD_START)
        {
          this.out.writeStartObject();
        }
        else
        {
          if ((paramSymbol2 != Symbol.RECORD_END) && (paramSymbol2 != Symbol.UNION_END)) {
            break;
          }
          this.out.writeEndObject();
        }
      }
    } while (paramSymbol2 == Symbol.FIELD_END);
    throw new AvroTypeException("Unknown action symbol " + paramSymbol2);
  }
  
  public void flush()
    throws IOException
  {
    this.parser.processImplicitActions();
    if (this.out != null) {
      this.out.flush();
    }
  }
  
  public void startItem()
    throws IOException
  {
    if (!this.isEmpty.get(this.pos)) {
      this.parser.advance(Symbol.ITEM_END);
    }
    super.startItem();
    this.isEmpty.clear(depth());
  }
  
  public void writeArrayEnd()
    throws IOException
  {
    if (!this.isEmpty.get(this.pos)) {
      this.parser.advance(Symbol.ITEM_END);
    }
    pop();
    this.parser.advance(Symbol.ARRAY_END);
    this.out.writeEndArray();
  }
  
  public void writeArrayStart()
    throws IOException
  {
    this.parser.advance(Symbol.ARRAY_START);
    this.out.writeStartArray();
    push();
    this.isEmpty.set(depth());
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    this.parser.advance(Symbol.BOOLEAN);
    this.out.writeBoolean(paramBoolean);
  }
  
  public void writeBytes(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramByteBuffer.hasArray())
    {
      writeBytes(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = paramByteBuffer.get();
      i += 1;
    }
    writeBytes(arrayOfByte);
  }
  
  public void writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.parser.advance(Symbol.BYTES);
    writeByteArray(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeDouble(double paramDouble)
    throws IOException
  {
    this.parser.advance(Symbol.DOUBLE);
    this.out.writeNumber(paramDouble);
  }
  
  public void writeEnum(int paramInt)
    throws IOException
  {
    this.parser.advance(Symbol.ENUM);
    Symbol.EnumLabelsAction localEnumLabelsAction = (Symbol.EnumLabelsAction)this.parser.popSymbol();
    if ((paramInt < 0) || (paramInt >= localEnumLabelsAction.size)) {
      throw new AvroTypeException("Enumeration out of range: max is " + localEnumLabelsAction.size + " but received " + paramInt);
    }
    this.out.writeString(localEnumLabelsAction.getLabel(paramInt));
  }
  
  public void writeFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.parser.advance(Symbol.FIXED);
    Symbol.IntCheckAction localIntCheckAction = (Symbol.IntCheckAction)this.parser.popSymbol();
    if (paramInt2 != localIntCheckAction.size) {
      throw new AvroTypeException("Incorrect length for fixed binary: expected " + localIntCheckAction.size + " but received " + paramInt2 + " bytes.");
    }
    writeByteArray(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeFloat(float paramFloat)
    throws IOException
  {
    this.parser.advance(Symbol.FLOAT);
    this.out.writeNumber(paramFloat);
  }
  
  public void writeIndex(int paramInt)
    throws IOException
  {
    this.parser.advance(Symbol.UNION);
    Symbol.Alternative localAlternative = (Symbol.Alternative)this.parser.popSymbol();
    Symbol localSymbol = localAlternative.getSymbol(paramInt);
    if (localSymbol != Symbol.NULL)
    {
      this.out.writeStartObject();
      this.out.writeFieldName(localAlternative.getLabel(paramInt));
      this.parser.pushSymbol(Symbol.UNION_END);
    }
    this.parser.pushSymbol(localSymbol);
  }
  
  public void writeInt(int paramInt)
    throws IOException
  {
    this.parser.advance(Symbol.INT);
    this.out.writeNumber(paramInt);
  }
  
  public void writeLong(long paramLong)
    throws IOException
  {
    this.parser.advance(Symbol.LONG);
    this.out.writeNumber(paramLong);
  }
  
  public void writeMapEnd()
    throws IOException
  {
    if (!this.isEmpty.get(this.pos)) {
      this.parser.advance(Symbol.ITEM_END);
    }
    pop();
    this.parser.advance(Symbol.MAP_END);
    this.out.writeEndObject();
  }
  
  public void writeMapStart()
    throws IOException
  {
    push();
    this.isEmpty.set(depth());
    this.parser.advance(Symbol.MAP_START);
    this.out.writeStartObject();
  }
  
  public void writeNull()
    throws IOException
  {
    this.parser.advance(Symbol.NULL);
    this.out.writeNull();
  }
  
  public void writeString(Utf8 paramUtf8)
    throws IOException
  {
    writeString(paramUtf8.toString());
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    this.parser.advance(Symbol.STRING);
    if (this.parser.topSymbol() == Symbol.MAP_KEY_MARKER)
    {
      this.parser.advance(Symbol.MAP_KEY_MARKER);
      this.out.writeFieldName(paramString);
      return;
    }
    this.out.writeString(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/JsonEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */