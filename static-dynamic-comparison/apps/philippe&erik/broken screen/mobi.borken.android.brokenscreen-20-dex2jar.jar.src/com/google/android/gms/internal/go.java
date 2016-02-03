package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class go
{
  private static boolean Ci = false;
  private boolean Cj;
  private boolean Ck;
  private String Cl;
  private final String mTag;
  
  public go(String paramString)
  {
    this(paramString, en());
  }
  
  public go(String paramString, boolean paramBoolean)
  {
    this.mTag = paramString;
    this.Cj = paramBoolean;
    this.Ck = false;
  }
  
  private String e(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = String.format(paramString, paramVarArgs);
    paramString = paramVarArgs;
    if (!TextUtils.isEmpty(this.Cl)) {
      paramString = this.Cl + paramVarArgs;
    }
    return paramString;
  }
  
  public static boolean en()
  {
    return Ci;
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    if (em()) {
      Log.v(this.mTag, e(paramString, paramVarArgs));
    }
  }
  
  public void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if ((el()) || (Ci)) {
      Log.d(this.mTag, e(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void ap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = String.format("[%s] ", new Object[] { paramString }))
    {
      this.Cl = paramString;
      return;
    }
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    if ((el()) || (Ci)) {
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
  
  public boolean el()
  {
    return this.Cj;
  }
  
  public boolean em()
  {
    return this.Ck;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */