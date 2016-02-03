package com.squareup.okio;

import java.io.Closeable;
import java.io.IOException;

public abstract interface Sink
  extends Closeable
{
  public abstract void close()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract Timeout timeout();
  
  public abstract void write(Buffer paramBuffer, long paramLong)
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okio/Sink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */