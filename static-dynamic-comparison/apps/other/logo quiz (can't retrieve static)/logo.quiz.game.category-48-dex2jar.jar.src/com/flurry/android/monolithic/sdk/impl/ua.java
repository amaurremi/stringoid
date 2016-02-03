package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class ua
  extends wv<AtomicReference<?>>
  implements ro
{
  protected final afm a;
  protected final qc b;
  protected qu<?> c;
  
  public ua(afm paramafm, qc paramqc)
  {
    super(AtomicReference.class);
    this.a = paramafm;
    this.b = paramqc;
  }
  
  public void a(qk paramqk, qq paramqq)
    throws qw
  {
    this.c = paramqq.a(paramqk, this.a, this.b);
  }
  
  public AtomicReference<?> b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    return new AtomicReference(this.c.a(paramow, paramqm));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */