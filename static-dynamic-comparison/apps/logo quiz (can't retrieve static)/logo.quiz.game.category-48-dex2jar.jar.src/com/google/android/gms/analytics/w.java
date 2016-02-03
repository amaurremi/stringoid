package com.google.android.gms.analytics;

import android.text.TextUtils;

class w
{
  private String AE;
  private final long AF;
  private final long AG;
  private String AH = "https:";
  
  w(String paramString, long paramLong1, long paramLong2)
  {
    this.AE = paramString;
    this.AF = paramLong1;
    this.AG = paramLong2;
  }
  
  void aj(String paramString)
  {
    this.AE = paramString;
  }
  
  void ak(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {}
    while (!paramString.toLowerCase().startsWith("http:")) {
      return;
    }
    this.AH = "http:";
  }
  
  String eG()
  {
    return this.AE;
  }
  
  long eH()
  {
    return this.AF;
  }
  
  long eI()
  {
    return this.AG;
  }
  
  String eJ()
  {
    return this.AH;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/analytics/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */