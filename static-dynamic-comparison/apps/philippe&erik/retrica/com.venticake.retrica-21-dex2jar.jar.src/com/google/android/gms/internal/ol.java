package com.google.android.gms.internal;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;

class ol
  implements Runnable
{
  private ol(go paramgo) {}
  
  public void run()
  {
    boolean bool = false;
    go.a(this.a, false);
    long l = SystemClock.elapsedRealtime();
    ??? = go.a(this.a).iterator();
    while (((Iterator)???).hasNext()) {
      ((gr)((Iterator)???).next()).d(l, 3);
    }
    for (;;)
    {
      synchronized (gr.CN)
      {
        Iterator localIterator = go.a(this.a).iterator();
        if (localIterator.hasNext())
        {
          if (((gr)localIterator.next()).ev()) {
            bool = true;
          }
        }
        else
        {
          go.b(this.a, bool);
          return;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */