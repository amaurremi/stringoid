package com.squareup.okio;

import java.io.Closeable;
import java.io.IOException;

public abstract interface Source
  extends Closeable
{
  public abstract void close()
    throws IOException;
  
  public abstract long read(Buffer paramBuffer, long paramLong)
    throws IOException;
  
  public abstract Timeout timeout();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okio/Source.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */