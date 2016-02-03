package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public final class tf
  extends qu<Object>
{
  final rw a;
  final qu<Object> b;
  
  public tf(rw paramrw, qu<Object> paramqu)
  {
    this.a = paramrw;
    this.b = paramqu;
  }
  
  public Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return this.b.a(paramow, paramqm, this.a);
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */