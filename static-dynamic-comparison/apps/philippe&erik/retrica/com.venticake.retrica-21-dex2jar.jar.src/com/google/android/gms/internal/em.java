package com.google.android.gms.internal;

public abstract class em
{
  private final Runnable lg = new Runnable()
  {
    public final void run()
    {
      em.a(em.this, Thread.currentThread());
      em.this.bh();
    }
  };
  private volatile Thread sf;
  
  public abstract void bh();
  
  public final void cancel()
  {
    onStop();
    if (this.sf != null) {
      this.sf.interrupt();
    }
  }
  
  public abstract void onStop();
  
  public final void start()
  {
    en.execute(this.lg);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */