package com.flurry.android.monolithic.sdk.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hi
{
  private hs a = new hs();
  private ht b = new ht();
  private ExecutorService c = Executors.newSingleThreadExecutor();
  
  public void a(hm paramhm, fr paramfr)
  {
    paramhm.a(1);
    this.a.a(paramhm);
    this.c.submit(new hj(this, paramfr));
  }
  
  public void b(hm paramhm, fr paramfr)
  {
    paramhm.a(2);
    this.a.a(paramhm);
    this.c.submit(new hj(this, paramfr));
  }
  
  public void c(hm paramhm, fr paramfr)
  {
    paramhm.a(32);
    this.a.a(paramhm);
    this.c.submit(new hj(this, paramfr));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */