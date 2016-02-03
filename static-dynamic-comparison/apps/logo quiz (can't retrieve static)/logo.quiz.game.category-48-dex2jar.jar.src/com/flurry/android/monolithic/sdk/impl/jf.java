package com.flurry.android.monolithic.sdk.impl;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class jf
  implements Runnable
{
  private static final String a = jf.class.getSimpleName();
  PrintStream i;
  PrintWriter j;
  
  public abstract void a();
  
  public final void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.i == null) {
        break label33;
      }
    }
    localThrowable.printStackTrace(this.i);
    for (;;)
    {
      ja.a(6, a, "", localThrowable);
      return;
      label33:
      if (this.j != null) {
        localThrowable.printStackTrace(this.j);
      } else {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/jf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */