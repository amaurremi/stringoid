package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.io.parsing.ResolvingGrammarGenerator;
import com.flurry.org.apache.avro.io.parsing.SkipParser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.io.parsing.Symbol.Alternative;
import com.flurry.org.apache.avro.io.parsing.Symbol.DefaultStartAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.EnumAdjustAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.ErrorAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.FieldOrderAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.ResolvingAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.SkipAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.UnionAdjustAction;
import com.flurry.org.apache.avro.io.parsing.Symbol.WriterUnionAction;
import java.io.IOException;

public class ResolvingDecoder
  extends ValidatingDecoder
{
  private Decoder backup;
  
  static
  {
    if (!ResolvingDecoder.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  ResolvingDecoder(Schema paramSchema1, Schema paramSchema2, Decoder paramDecoder)
    throws IOException
  {
    this(resolve(paramSchema1, paramSchema2), paramDecoder);
  }
  
  private ResolvingDecoder(Object paramObject, Decoder paramDecoder)
    throws IOException
  {
    super((Symbol)paramObject, paramDecoder);
  }
  
  public static Object resolve(Schema paramSchema1, Schema paramSchema2)
    throws IOException
  {
    if (paramSchema1 == null) {
      throw new NullPointerException("writer cannot be null!");
    }
    if (paramSchema2 == null) {
      throw new NullPointerException("reader cannot be null!");
    }
    return new ResolvingGrammarGenerator().generate(paramSchema1, paramSchema2);
  }
  
  public Symbol doAction(Symbol paramSymbol1, Symbol paramSymbol2)
    throws IOException
  {
    if ((paramSymbol2 instanceof Symbol.FieldOrderAction))
    {
      if (paramSymbol1 == Symbol.FIELD_ACTION) {
        return paramSymbol2;
      }
      return null;
    }
    if ((paramSymbol2 instanceof Symbol.ResolvingAction))
    {
      paramSymbol2 = (Symbol.ResolvingAction)paramSymbol2;
      if (paramSymbol2.reader != paramSymbol1) {
        throw new AvroTypeException("Found " + paramSymbol2.reader + " while looking for " + paramSymbol1);
      }
      return paramSymbol2.writer;
    }
    if ((paramSymbol2 instanceof Symbol.SkipAction))
    {
      paramSymbol1 = ((Symbol.SkipAction)paramSymbol2).symToSkip;
      this.parser.skipSymbol(paramSymbol1);
    }
    for (;;)
    {
      return null;
      if ((paramSymbol2 instanceof Symbol.WriterUnionAction))
      {
        paramSymbol1 = (Symbol.Alternative)this.parser.popSymbol();
        this.parser.pushSymbol(paramSymbol1.getSymbol(this.in.readIndex()));
      }
      else
      {
        if ((paramSymbol2 instanceof Symbol.ErrorAction)) {
          throw new AvroTypeException(((Symbol.ErrorAction)paramSymbol2).msg);
        }
        if ((paramSymbol2 instanceof Symbol.DefaultStartAction))
        {
          paramSymbol1 = (Symbol.DefaultStartAction)paramSymbol2;
          this.backup = this.in;
          this.in = DecoderFactory.get().binaryDecoder(paramSymbol1.contents, null);
        }
        else
        {
          if (paramSymbol2 != Symbol.DEFAULT_END_ACTION) {
            break;
          }
          this.in = this.backup;
        }
      }
    }
    throw new AvroTypeException("Unknown action: " + paramSymbol2);
  }
  
  public final void drain()
    throws IOException
  {
    this.parser.processImplicitActions();
  }
  
  public double readDouble()
    throws IOException
  {
    Symbol localSymbol = this.parser.advance(Symbol.DOUBLE);
    if (localSymbol == Symbol.INT) {
      return this.in.readInt();
    }
    if (localSymbol == Symbol.LONG) {
      return this.in.readLong();
    }
    if (localSymbol == Symbol.FLOAT) {
      return this.in.readFloat();
    }
    assert (localSymbol == Symbol.DOUBLE);
    return this.in.readDouble();
  }
  
  public int readEnum()
    throws IOException
  {
    this.parser.advance(Symbol.ENUM);
    Object localObject = (Symbol.EnumAdjustAction)this.parser.popSymbol();
    int i = this.in.readEnum();
    localObject = localObject.adjustments[i];
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    throw new AvroTypeException((String)localObject);
  }
  
  public final Schema.Field[] readFieldOrder()
    throws IOException
  {
    return ((Symbol.FieldOrderAction)this.parser.advance(Symbol.FIELD_ACTION)).fields;
  }
  
  public float readFloat()
    throws IOException
  {
    Symbol localSymbol = this.parser.advance(Symbol.FLOAT);
    if (localSymbol == Symbol.INT) {
      return this.in.readInt();
    }
    if (localSymbol == Symbol.LONG) {
      return (float)this.in.readLong();
    }
    assert (localSymbol == Symbol.FLOAT);
    return this.in.readFloat();
  }
  
  public int readIndex()
    throws IOException
  {
    this.parser.advance(Symbol.UNION);
    Symbol.UnionAdjustAction localUnionAdjustAction = (Symbol.UnionAdjustAction)this.parser.popSymbol();
    this.parser.pushSymbol(localUnionAdjustAction.symToParse);
    return localUnionAdjustAction.rindex;
  }
  
  public long readLong()
    throws IOException
  {
    Symbol localSymbol = this.parser.advance(Symbol.LONG);
    if (localSymbol == Symbol.INT) {
      return this.in.readInt();
    }
    if (localSymbol == Symbol.DOUBLE) {
      return this.in.readDouble();
    }
    assert (localSymbol == Symbol.LONG);
    return this.in.readLong();
  }
  
  public void skipAction()
    throws IOException
  {
    Object localObject = this.parser.popSymbol();
    if ((localObject instanceof Symbol.ResolvingAction)) {
      this.parser.pushSymbol(((Symbol.ResolvingAction)localObject).writer);
    }
    do
    {
      return;
      if ((localObject instanceof Symbol.SkipAction))
      {
        this.parser.pushSymbol(((Symbol.SkipAction)localObject).symToSkip);
        return;
      }
      if ((localObject instanceof Symbol.WriterUnionAction))
      {
        localObject = (Symbol.Alternative)this.parser.popSymbol();
        this.parser.pushSymbol(((Symbol.Alternative)localObject).getSymbol(this.in.readIndex()));
        return;
      }
      if ((localObject instanceof Symbol.ErrorAction)) {
        throw new AvroTypeException(((Symbol.ErrorAction)localObject).msg);
      }
      if ((localObject instanceof Symbol.DefaultStartAction))
      {
        localObject = (Symbol.DefaultStartAction)localObject;
        this.backup = this.in;
        this.in = DecoderFactory.get().binaryDecoder(((Symbol.DefaultStartAction)localObject).contents, null);
        return;
      }
    } while (localObject != Symbol.DEFAULT_END_ACTION);
    this.in = this.backup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/ResolvingDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */