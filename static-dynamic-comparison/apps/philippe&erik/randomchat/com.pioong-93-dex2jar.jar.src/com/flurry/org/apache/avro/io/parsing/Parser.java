package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.AvroTypeException;
import java.io.IOException;

public class Parser
{
  protected int pos;
  protected Symbol[] stack;
  protected final ActionHandler symbolHandler;
  
  public Parser(Symbol paramSymbol, ActionHandler paramActionHandler)
    throws IOException
  {
    this.symbolHandler = paramActionHandler;
    this.stack = new Symbol[5];
    this.stack[0] = paramSymbol;
    this.pos = 1;
  }
  
  private void expandStack()
  {
    Symbol[] arrayOfSymbol = new Symbol[this.stack.length + Math.max(this.stack.length, 1024)];
    System.arraycopy(this.stack, 0, arrayOfSymbol, 0, this.stack.length);
    this.stack = arrayOfSymbol;
  }
  
  public final Symbol advance(Symbol paramSymbol)
    throws IOException
  {
    for (;;)
    {
      Object localObject = this.stack;
      int i = this.pos - 1;
      this.pos = i;
      localObject = localObject[i];
      if (localObject == paramSymbol) {
        return (Symbol)localObject;
      }
      Symbol.Kind localKind = ((Symbol)localObject).kind;
      if (localKind == Symbol.Kind.IMPLICIT_ACTION)
      {
        localObject = this.symbolHandler.doAction(paramSymbol, (Symbol)localObject);
        if (localObject != null) {
          return (Symbol)localObject;
        }
      }
      else
      {
        if (localKind == Symbol.Kind.TERMINAL) {
          throw new AvroTypeException("Attempt to process a " + paramSymbol + " when a " + localObject + " was expected.");
        }
        if ((localKind == Symbol.Kind.REPEATER) && (paramSymbol == ((Symbol.Repeater)localObject).end)) {
          return paramSymbol;
        }
        pushProduction((Symbol)localObject);
      }
    }
  }
  
  public int depth()
  {
    return this.pos;
  }
  
  public Symbol popSymbol()
  {
    Symbol[] arrayOfSymbol = this.stack;
    int i = this.pos - 1;
    this.pos = i;
    return arrayOfSymbol[i];
  }
  
  public final void processImplicitActions()
    throws IOException
  {
    for (;;)
    {
      if (this.pos <= 1) {}
      Symbol localSymbol;
      do
      {
        return;
        localSymbol = this.stack[(this.pos - 1)];
        if (localSymbol.kind == Symbol.Kind.IMPLICIT_ACTION)
        {
          this.pos -= 1;
          this.symbolHandler.doAction(null, localSymbol);
          break;
        }
      } while (localSymbol.kind == Symbol.Kind.TERMINAL);
      this.pos -= 1;
      pushProduction(localSymbol);
    }
  }
  
  public final void processTrailingImplicitActions()
    throws IOException
  {
    for (;;)
    {
      if (this.pos < 1) {}
      Symbol localSymbol;
      do
      {
        return;
        localSymbol = this.stack[(this.pos - 1)];
      } while ((localSymbol.kind != Symbol.Kind.IMPLICIT_ACTION) || (!((Symbol.ImplicitAction)localSymbol).isTrailing));
      this.pos -= 1;
      this.symbolHandler.doAction(null, localSymbol);
    }
  }
  
  public final void pushProduction(Symbol paramSymbol)
  {
    paramSymbol = paramSymbol.production;
    for (;;)
    {
      if (this.pos + paramSymbol.length <= this.stack.length)
      {
        System.arraycopy(paramSymbol, 0, this.stack, this.pos, paramSymbol.length);
        this.pos += paramSymbol.length;
        return;
      }
      expandStack();
    }
  }
  
  public void pushSymbol(Symbol paramSymbol)
  {
    if (this.pos == this.stack.length) {
      expandStack();
    }
    Symbol[] arrayOfSymbol = this.stack;
    int i = this.pos;
    this.pos = (i + 1);
    arrayOfSymbol[i] = paramSymbol;
  }
  
  public void reset()
  {
    this.pos = 1;
  }
  
  public Symbol topSymbol()
  {
    return this.stack[(this.pos - 1)];
  }
  
  public static abstract interface ActionHandler
  {
    public abstract Symbol doAction(Symbol paramSymbol1, Symbol paramSymbol2)
      throws IOException;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/parsing/Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */