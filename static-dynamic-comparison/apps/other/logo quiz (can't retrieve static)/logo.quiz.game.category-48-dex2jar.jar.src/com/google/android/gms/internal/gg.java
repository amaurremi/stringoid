package com.google.android.gms.internal;

@ez
public abstract class gg
{
  private final Runnable mk = new Runnable()
  {
    public final void run()
    {
      gg.a(gg.this, Thread.currentThread());
      gg.this.cp();
    }
  };
  private volatile Thread wf;
  
  public final void cancel()
  {
    onStop();
    if (this.wf != null) {
      this.wf.interrupt();
    }
  }
  
  public abstract void cp();
  
  public abstract void onStop();
  
  public final void start()
  {
    gi.a(this.mk);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */