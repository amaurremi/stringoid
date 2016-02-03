package com.flurry.org.apache.avro.io.parsing;

import java.io.IOException;

public class SkipParser
  extends Parser
{
  private final SkipHandler skipHandler;
  
  static
  {
    if (!SkipParser.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SkipParser(Symbol paramSymbol, Parser.ActionHandler paramActionHandler, SkipHandler paramSkipHandler)
    throws IOException
  {
    super(paramSymbol, paramActionHandler);
    this.skipHandler = paramSkipHandler;
  }
  
  public final void skipRepeater()
    throws IOException
  {
    int i = this.pos;
    Object localObject = this.stack;
    int j = this.pos - 1;
    this.pos = j;
    localObject = localObject[j];
    assert (((Symbol)localObject).kind == Symbol.Kind.REPEATER);
    pushProduction((Symbol)localObject);
    skipTo(i);
  }
  
  public final void skipSymbol(Symbol paramSymbol)
    throws IOException
  {
    int i = this.pos;
    pushSymbol(paramSymbol);
    skipTo(i);
  }
  
  public final void skipTo(int paramInt)
    throws IOException
  {
    while (paramInt < this.pos)
    {
      Symbol localSymbol = this.stack[(this.pos - 1)];
      if (localSymbol.kind != Symbol.Kind.TERMINAL)
      {
        if ((localSymbol.kind == Symbol.Kind.IMPLICIT_ACTION) || (localSymbol.kind == Symbol.Kind.EXPLICIT_ACTION))
        {
          this.skipHandler.skipAction();
        }
        else
        {
          this.pos -= 1;
          pushProduction(localSymbol);
        }
      }
      else {
        this.skipHandler.skipTopSymbol();
      }
    }
  }
  
  public static abstract interface SkipHandler
  {
    public abstract void skipAction()
      throws IOException;
    
    public abstract void skipTopSymbol()
      throws IOException;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/io/parsing/SkipParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */