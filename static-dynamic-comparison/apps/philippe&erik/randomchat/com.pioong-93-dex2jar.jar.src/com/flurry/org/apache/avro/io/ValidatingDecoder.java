package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler;
import com.flurry.org.apache.avro.io.parsing.SkipParser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.io.parsing.Symbol.Alternative;
import com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction;
import com.flurry.org.apache.avro.io.parsing.ValidatingGrammarGenerator;
import com.flurry.org.apache.avro.util.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ValidatingDecoder
  extends ParsingDecoder
  implements Parser.ActionHandler
{
  protected Decoder in;
  
  ValidatingDecoder(Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    this(getSymbol(paramSchema), paramDecoder);
  }
  
  ValidatingDecoder(Symbol paramSymbol, Decoder paramDecoder)
    throws IOException
  {
    super(paramSymbol);
    configure(paramDecoder);
  }
  
  private void checkFixed(int paramInt)
    throws IOException
  {
    this.parser.advance(Symbol.FIXED);
    Symbol.IntCheckAction localIntCheckAction = (Symbol.IntCheckAction)this.parser.popSymbol();
    if (paramInt != localIntCheckAction.size) {
      throw new AvroTypeException("Incorrect length for fixed binary: expected " + localIntCheckAction.size + " but received " + paramInt + " bytes.");
    }
  }
  
  private static Symbol getSymbol(Schema paramSchema)
  {
    if (paramSchema == null) {
      throw new NullPointerException("Schema cannot be null");
    }
    return new ValidatingGrammarGenerator().generate(paramSchema);
  }
  
  public long arrayNext()
    throws IOException
  {
    this.parser.processTrailingImplicitActions();
    long l = this.in.arrayNext();
    if (l == 0L) {
      this.parser.advance(Symbol.ARRAY_END);
    }
    return l;
  }
  
  public ValidatingDecoder configure(Decoder paramDecoder)
    throws IOException
  {
    this.parser.reset();
    this.in = paramDecoder;
    return this;
  }
  
  public Symbol doAction(Symbol paramSymbol1, Symbol paramSymbol2)
    throws IOException
  {
    return null;
  }
  
  public long mapNext()
    throws IOException
  {
    this.parser.processTrailingImplicitActions();
    long l = this.in.mapNext();
    if (l == 0L) {
      this.parser.advance(Symbol.MAP_END);
    }
    return l;
  }
  
  public long readArrayStart()
    throws IOException
  {
    this.parser.advance(Symbol.ARRAY_START);
    long l = this.in.readArrayStart();
    if (l == 0L) {
      this.parser.advance(Symbol.ARRAY_END);
    }
    return l;
  }
  
  public boolean readBoolean()
    throws IOException
  {
    this.parser.advance(Symbol.BOOLEAN);
    return this.in.readBoolean();
  }
  
  public ByteBuffer readBytes(ByteBuffer paramByteBuffer)
    throws IOException
  {
    this.parser.advance(Symbol.BYTES);
    return this.in.readBytes(paramByteBuffer);
  }
  
  public double readDouble()
    throws IOException
  {
    this.parser.advance(Symbol.DOUBLE);
    return this.in.readDouble();
  }
  
  public int readEnum()
    throws IOException
  {
    this.parser.advance(Symbol.ENUM);
    Symbol.IntCheckAction localIntCheckAction = (Symbol.IntCheckAction)this.parser.popSymbol();
    int i = this.in.readEnum();
    if ((i < 0) || (i >= localIntCheckAction.size)) {
      throw new AvroTypeException("Enumeration out of range: max is " + localIntCheckAction.size + " but received " + i);
    }
    return i;
  }
  
  public void readFixed(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    checkFixed(paramInt2);
    this.in.readFixed(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public float readFloat()
    throws IOException
  {
    this.parser.advance(Symbol.FLOAT);
    return this.in.readFloat();
  }
  
  public int readIndex()
    throws IOException
  {
    this.parser.advance(Symbol.UNION);
    Symbol.Alternative localAlternative = (Symbol.Alternative)this.parser.popSymbol();
    int i = this.in.readIndex();
    this.parser.pushSymbol(localAlternative.getSymbol(i));
    return i;
  }
  
  public int readInt()
    throws IOException
  {
    this.parser.advance(Symbol.INT);
    return this.in.readInt();
  }
  
  public long readLong()
    throws IOException
  {
    this.parser.advance(Symbol.LONG);
    return this.in.readLong();
  }
  
  public long readMapStart()
    throws IOException
  {
    this.parser.advance(Symbol.MAP_START);
    long l = this.in.readMapStart();
    if (l == 0L) {
      this.parser.advance(Symbol.MAP_END);
    }
    return l;
  }
  
  public void readNull()
    throws IOException
  {
    this.parser.advance(Symbol.NULL);
    this.in.readNull();
  }
  
  public Utf8 readString(Utf8 paramUtf8)
    throws IOException
  {
    this.parser.advance(Symbol.STRING);
    return this.in.readString(paramUtf8);
  }
  
  public String readString()
    throws IOException
  {
    this.parser.advance(Symbol.STRING);
    return this.in.readString();
  }
  
  public long skipArray()
    throws IOException
  {
    this.parser.advance(Symbol.ARRAY_START);
    for (long l = this.in.skipArray(); l != 0L; l = this.in.skipArray()) {
      while (l > 0L)
      {
        this.parser.skipRepeater();
        l -= 1L;
      }
    }
    this.parser.advance(Symbol.ARRAY_END);
    return 0L;
  }
  
  public void skipBytes()
    throws IOException
  {
    this.parser.advance(Symbol.BYTES);
    this.in.skipBytes();
  }
  
  protected void skipFixed()
    throws IOException
  {
    this.parser.advance(Symbol.FIXED);
    Symbol.IntCheckAction localIntCheckAction = (Symbol.IntCheckAction)this.parser.popSymbol();
    this.in.skipFixed(localIntCheckAction.size);
  }
  
  public void skipFixed(int paramInt)
    throws IOException
  {
    checkFixed(paramInt);
    this.in.skipFixed(paramInt);
  }
  
  public long skipMap()
    throws IOException
  {
    this.parser.advance(Symbol.MAP_START);
    for (long l = this.in.skipMap(); l != 0L; l = this.in.skipMap()) {
      while (l > 0L)
      {
        this.parser.skipRepeater();
        l -= 1L;
      }
    }
    this.parser.advance(Symbol.MAP_END);
    return 0L;
  }
  
  public void skipString()
    throws IOException
  {
    this.parser.advance(Symbol.STRING);
    this.in.skipString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/ValidatingDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */