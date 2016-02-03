package com.flurry.android.monolithic.sdk.impl;

import java.util.Timer;

class fh
{
  private Timer a;
  private fi b;
  private fj c;
  
  fh(fj paramfj)
  {
    this.c = paramfj;
  }
  
  public void a()
  {
    try
    {
      if (this.a != null)
      {
        this.a.cancel();
        this.a = null;
      }
      this.b = null;
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (b()) {
        a();
      }
      this.a = new Timer("FlurrySessionTimer");
      this.b = new fi(this, this.c);
      this.a.schedule(this.b, paramLong);
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.a != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */