package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class gn
{
  private static boolean Cl = false;
  private boolean Cm;
  private boolean Cn;
  private String Co;
  private final String mTag;
  
  public gn(String paramString)
  {
    this(paramString, es());
  }
  
  public gn(String paramString, boolean paramBoolean)
  {
    this.mTag = paramString;
    this.Cm = paramBoolean;
    this.Cn = false;
  }
  
  private String e(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = String.format(paramString, paramVarArgs);
    paramString = paramVarArgs;
    if (!TextUtils.isEmpty(this.Co)) {
      paramString = this.Co + paramVarArgs;
    }
    return paramString;
  }
  
  public static boolean es()
  {
    return Cl;
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    if (er()) {
      Log.v(this.mTag, e(paramString, paramVarArgs));
    }
  }
  
  public void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if ((eq()) || (Cl)) {
      Log.d(this.mTag, e(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void ap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = String.format("[%s] ", new Object[] { paramString }))
    {
      this.Co = paramString;
      return;
    }
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    if ((eq()) || (Cl)) {
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
  
  public boolean eq()
  {
    return this.Cm;
  }
  
  public boolean er()
  {
    return this.Cn;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */