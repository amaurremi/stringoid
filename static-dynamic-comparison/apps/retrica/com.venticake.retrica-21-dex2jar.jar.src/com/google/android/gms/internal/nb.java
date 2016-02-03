package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

final class nb
{
  private long a = -1L;
  private long b = -1L;
  
  public long a()
  {
    return this.b;
  }
  
  public void b()
  {
    this.b = SystemClock.elapsedRealtime();
  }
  
  public void c()
  {
    this.a = SystemClock.elapsedRealtime();
  }
  
  public Bundle d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("topen", this.a);
    localBundle.putLong("tclose", this.b);
    return localBundle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/nb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */