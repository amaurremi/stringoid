package com.flurry.sdk;

final class ec$a
  implements Thread.UncaughtExceptionHandler
{
  private ec$a(ec paramec) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    ec.a(this.a, paramThread, paramThrowable);
    ec.b(this.a, paramThread, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/ec$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */