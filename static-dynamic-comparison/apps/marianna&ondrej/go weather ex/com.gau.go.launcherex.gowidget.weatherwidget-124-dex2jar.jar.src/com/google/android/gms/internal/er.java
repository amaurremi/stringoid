package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class er
{
  private static boolean zC = false;
  private final String mTag;
  private boolean zD;
  private boolean zE;
  private String zF;
  
  public er(String paramString)
  {
    this(paramString, dR());
  }
  
  public er(String paramString, boolean paramBoolean)
  {
    this.mTag = paramString;
    this.zD = paramBoolean;
    this.zE = false;
  }
  
  public static boolean dR()
  {
    return zC;
  }
  
  private String e(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = String.format(paramString, paramVarArgs);
    paramString = paramVarArgs;
    if (!TextUtils.isEmpty(this.zF)) {
      paramString = this.zF + paramVarArgs;
    }
    return paramString;
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    if (dQ()) {
      Log.v(this.mTag, e(paramString, paramVarArgs));
    }
  }
  
  public void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if ((dP()) || (zC)) {
      Log.d(this.mTag, e(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void ab(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = String.format("[%s] ", new Object[] { paramString }))
    {
      this.zF = paramString;
      return;
    }
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    if ((dP()) || (zC)) {
      Log.d(this.mTag, e(paramString, paramVarArgs));
    }
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    Log.i(this.mTag, e(paramString, paramVarArgs));
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    Log.w(this.mTag, e(paramString, paramVarArgs));
  }
  
  public boolean dP()
  {
    return this.zD;
  }
  
  public boolean dQ()
  {
    return this.zE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */