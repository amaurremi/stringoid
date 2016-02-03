package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

final class mm
{
  private final Runnable a;
  private volatile boolean b = false;
  
  public mm(final cj paramcj)
  {
    this.a = new Runnable()
    {
      private final WeakReference<cj> c = new WeakReference(paramcj);
      
      public void run()
      {
        cj localcj = (cj)this.c.get();
        if ((!mm.a(mm.this)) && (localcj != null))
        {
          localcj.bb();
          mm.this.b();
        }
      }
    };
  }
  
  public void a()
  {
    this.b = true;
    et.sv.removeCallbacks(this.a);
  }
  
  public void b()
  {
    et.sv.postDelayed(this.a, 250L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/mm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */