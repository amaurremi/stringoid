package com.flurry.android.monolithic.sdk.impl;

final class iu
  implements Thread.UncaughtExceptionHandler
{
  private iu(is paramis) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    is.a(this.a, paramThread, paramThrowable);
    is.b(this.a, paramThread, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/iu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */