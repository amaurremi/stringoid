package com.google.android.gms.internal;

public abstract class br
{
  private final Runnable De = new Runnable()
  {
    public final void run()
    {
      br.a(br.this, Thread.currentThread());
      br.this.py();
    }
  };
  private volatile Thread Fl;
  
  public final void cancel()
  {
    onStop();
    if (this.Fl != null) {
      this.Fl.interrupt();
    }
  }
  
  public abstract void onStop();
  
  public abstract void py();
  
  public final void start()
  {
    bu.execute(this.De);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */