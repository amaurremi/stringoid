package com.squareup.okio;

import java.io.IOException;

public abstract class ForwardingSink
  implements Sink
{
  private final Sink delegate;
  
  public ForwardingSink(Sink paramSink)
  {
    if (paramSink == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.delegate = paramSink;
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public final Sink delegate()
  {
    return this.delegate;
  }
  
  public void flush()
    throws IOException
  {
    this.delegate.flush();
  }
  
  public Timeout timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    this.delegate.write(paramBuffer, paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okio/ForwardingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */