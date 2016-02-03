package com.google.android.gms.internal;

public abstract class en
{
  private final Runnable le = new Runnable()
  {
    public final void run()
    {
      en.a(en.this, Thread.currentThread());
      en.this.bc();
    }
  };
  private volatile Thread sc;
  
  public abstract void bc();
  
  public final void cancel()
  {
    onStop();
    if (this.sc != null) {
      this.sc.interrupt();
    }
  }
  
  public abstract void onStop();
  
  public final void start()
  {
    eo.execute(this.le);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */