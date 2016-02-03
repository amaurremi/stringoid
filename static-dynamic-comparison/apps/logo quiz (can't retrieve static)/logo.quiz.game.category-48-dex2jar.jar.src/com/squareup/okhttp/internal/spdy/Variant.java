package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okio.BufferedSink;
import com.squareup.okio.BufferedSource;

public abstract interface Variant
{
  public abstract Protocol getProtocol();
  
  public abstract int maxFrameSize();
  
  public abstract FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean);
  
  public abstract FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/spdy/Variant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */