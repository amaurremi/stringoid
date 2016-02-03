package com.google.android.gms.internal;

import android.util.Log;

public final class hf
{
  private final String GI;
  
  public hf(String paramString)
  {
    this.GI = ((String)hm.f(paramString));
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (ap(4)) {
      Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public boolean ap(int paramInt)
  {
    return Log.isLoggable(this.GI, paramInt);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (ap(6)) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (ap(2)) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public void j(String paramString1, String paramString2)
  {
    if (ap(5)) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public void k(String paramString1, String paramString2)
  {
    if (ap(6)) {
      Log.e(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */