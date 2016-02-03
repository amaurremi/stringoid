package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler;
import com.flurry.org.apache.avro.io.parsing.SkipParser;
import com.flurry.org.apache.avro.io.parsing.SkipParser.SkipHandler;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import java.io.IOException;

public abstract class ParsingDecoder
  extends Decoder
  implements Parser.ActionHandler, SkipParser.SkipHandler
{
  protected final SkipParser parser = new SkipParser(paramSymbol, this, this);
  
  protected ParsingDecoder(Symbol paramSymbol)
    throws IOException
  {}
  
  public void skipAction()
    throws IOException
  {
    this.parser.popSymbol();
  }
  
  protected abstract void skipFixed()
    throws IOException;
  
  public void skipTopSymbol()
    throws IOException
  {
    Symbol localSymbol = this.parser.topSymbol();
    if (localSymbol == Symbol.NULL) {
      readNull();
    }
    if (localSymbol == Symbol.BOOLEAN) {
      readBoolean();
    }
    do
    {
      return;
      if (localSymbol == Symbol.INT)
      {
        readInt();
        return;
      }
      if (localSymbol == Symbol.LONG)
      {
        readLong();
        return;
      }
      if (localSymbol == Symbol.FLOAT)
      {
        readFloat();
        return;
      }
      if (localSymbol == Symbol.DOUBLE)
      {
        readDouble();
        return;
      }
      if (localSymbol == Symbol.STRING)
      {
        skipString();
        return;
      }
      if (localSymbol == Symbol.BYTES)
      {
        skipBytes();
        return;
      }
      if (localSymbol == Symbol.ENUM)
      {
        readEnum();
        return;
      }
      if (localSymbol == Symbol.FIXED)
      {
        skipFixed();
        return;
      }
      if (localSymbol == Symbol.UNION)
      {
        readIndex();
        return;
      }
      if (localSymbol == Symbol.ARRAY_START)
      {
        skipArray();
        return;
      }
    } while (localSymbol != Symbol.MAP_START);
    skipMap();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/ParsingDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */