package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class z
{
  private final long a;
  private final long b;
  private final long c;
  private String d;
  
  z(long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
  }
  
  long a()
  {
    return this.a;
  }
  
  void a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {
      return;
    }
    this.d = paramString;
  }
  
  long b()
  {
    return this.c;
  }
  
  String c()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */