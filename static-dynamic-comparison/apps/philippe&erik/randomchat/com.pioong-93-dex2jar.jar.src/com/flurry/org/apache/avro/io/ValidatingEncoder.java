package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.Parser;
import com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.io.parsing.Symbol.Alternative;
import com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction;
import com.flurry.org.apache.avro.io.parsing.ValidatingGrammarGenerator;
import com.flurry.org.apache.avro.util.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ValidatingEncoder
  extends ParsingEncoder
  implements Parser.ActionHandler
{
  protected Encoder out;
  protected final Parser parser;
  
  ValidatingEncoder(Schema paramSchema, Encoder paramEncoder)
    throws IOException
  {
    this(new ValidatingGrammarGenerator().generate(paramSchema), paramEncoder);
  }
  
  ValidatingEncoder(Symbol paramSymbol, Encoder paramEncoder)
    throws IOException
  {
    this.out = paramEncoder;
    this.parser = new Parser(paramSymbol, this);
  }
  
  public ValidatingEncoder configure(Encoder paramEncoder)
  {
    this.parser.reset();
    this.out = paramEncoder;
    return this;
  }
  
  public Symbol doAction(Symbol paramSymbol1, Symbol paramSymbol2)
    throws IOException
  {
    return null;
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  public void setItemCount(long paramLong)
    throws IOException
  {
    super.setItemCount(paramLong);
    this.out.setItemCount(paramLong);
  }
  
  public void startItem()
    throws IOException
  {
    super.startItem();
    this.out.startItem();
  }
  
  public void writeArrayEnd()
    throws IOException
  {
    this.parser.advance(Symbol.ARRAY_END);
    this.out.writeArrayEnd();
    pop();
  }
  
  public void writeArrayStart()
    throws IOException
  {
    push();
    this.parser.advance(Symbol.ARRAY_START);
    this.out.writeArrayStart();
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
    this.parser.advance(Symbol.BYTES);
    this.out.writeBytes(paramByteBuffer);
  }
  
  public void writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.parser.advance(Symbol.BYTES);
    this.out.writeBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeDouble(double paramDouble)
    throws IOException
  {
    this.parser.advance(Symbol.DOUBLE);
    this.out.writeDouble(paramDouble);
  }
  
  public void writeEnum(int paramInt)
    throws IOException
  {
    this.parser.advance(Symbol.ENUM);
    Symbol.IntCheckAction localIntCheckAction = (Symbol.IntCheckAction)this.parser.popSymbol();
    if ((paramInt < 0) || (paramInt >= localIntCheckAction.size)) {
      throw new AvroTypeException("Enumeration out of range: max is " + localIntCheckAction.size + " but received " + paramInt);
    }
    this.out.writeEnum(paramInt);
  }
  
  public void writeFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.parser.advance(Symbol.FIXED);
    Symbol.IntCheckAction localIntCheckAction = (Symbol.IntCheckAction)this.parser.popSymbol();
    if (paramInt2 != localIntCheckAction.size) {
      throw new AvroTypeException("Incorrect length for fixed binary: expected " + localIntCheckAction.size + " but received " + paramInt2 + " bytes.");
    }
    this.out.writeFixed(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeFloat(float paramFloat)
    throws IOException
  {
    this.parser.advance(Symbol.FLOAT);
    this.out.writeFloat(paramFloat);
  }
  
  public void writeIndex(int paramInt)
    throws IOException
  {
    this.parser.advance(Symbol.UNION);
    Symbol.Alternative localAlternative = (Symbol.Alternative)this.parser.popSymbol();
    this.parser.pushSymbol(localAlternative.getSymbol(paramInt));
    this.out.writeIndex(paramInt);
  }
  
  public void writeInt(int paramInt)
    throws IOException
  {
    this.parser.advance(Symbol.INT);
    this.out.writeInt(paramInt);
  }
  
  public void writeLong(long paramLong)
    throws IOException
  {
    this.parser.advance(Symbol.LONG);
    this.out.writeLong(paramLong);
  }
  
  public void writeMapEnd()
    throws IOException
  {
    this.parser.advance(Symbol.MAP_END);
    this.out.writeMapEnd();
    pop();
  }
  
  public void writeMapStart()
    throws IOException
  {
    push();
    this.parser.advance(Symbol.MAP_START);
    this.out.writeMapStart();
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
    this.parser.advance(Symbol.STRING);
    this.out.writeString(paramUtf8);
  }
  
  public void writeString(CharSequence paramCharSequence)
    throws IOException
  {
    this.parser.advance(Symbol.STRING);
    this.out.writeString(paramCharSequence);
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    this.parser.advance(Symbol.STRING);
    this.out.writeString(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/ValidatingEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */