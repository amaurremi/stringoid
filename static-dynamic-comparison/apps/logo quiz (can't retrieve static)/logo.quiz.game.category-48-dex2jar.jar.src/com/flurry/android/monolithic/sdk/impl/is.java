package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class is
{
  private static is a;
  private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
  private final Map<Thread.UncaughtExceptionHandler, Void> c = new WeakHashMap();
  
  private is()
  {
    Thread.setDefaultUncaughtExceptionHandler(new iu(this, null));
  }
  
  public static is a()
  {
    try
    {
      if (a == null) {
        a = new is();
      }
      is localis = a;
      return localis;
    }
    finally {}
  }
  
  private void a(Thread paramThread, Throwable paramThrowable)
  {
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = (Thread.UncaughtExceptionHandler)localIterator.next();
      try
      {
        localUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  private Set<Thread.UncaughtExceptionHandler> b()
  {
    synchronized (this.c)
    {
      Set localSet = this.c.keySet();
      return localSet;
    }
  }
  
  private void b(Thread paramThread, Throwable paramThrowable)
  {
    if (this.b != null) {
      this.b.uncaughtException(paramThread, paramThrowable);
    }
  }
  
  public void a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    synchronized (this.c)
    {
      this.c.put(paramUncaughtExceptionHandler, null);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/is.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */