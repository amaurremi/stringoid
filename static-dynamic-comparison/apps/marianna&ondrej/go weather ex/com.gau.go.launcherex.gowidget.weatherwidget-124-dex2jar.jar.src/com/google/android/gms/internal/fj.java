package com.google.android.gms.internal;

import android.util.Log;

public final class fj
{
  private final String DH;
  
  public fj(String paramString)
  {
    this.DH = ((String)fq.f(paramString));
  }
  
  public boolean P(int paramInt)
  {
    return Log.isLoggable(this.DH, paramInt);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (P(6)) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public void f(String paramString1, String paramString2)
  {
    if (P(2)) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public void g(String paramString1, String paramString2)
  {
    if (P(5)) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public void h(String paramString1, String paramString2)
  {
    if (P(6)) {
      Log.e(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */