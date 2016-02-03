package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;

public abstract class iv<T>
{
  private static a JG = null;
  private static final Object mw = new Object();
  protected final String JH;
  protected final T JI;
  private T JJ = null;
  
  protected iv(String paramString, T paramT)
  {
    this.JH = paramString;
    this.JI = paramT;
  }
  
  public static void H(Context paramContext)
  {
    synchronized (mw)
    {
      if (JG == null) {
        JG = new b(paramContext.getContentResolver());
      }
      return;
    }
  }
  
  public static iv<Integer> a(String paramString, Integer paramInteger)
  {
    new iv(paramString, paramInteger) {};
  }
  
  public static iv<Boolean> g(String paramString, boolean paramBoolean)
  {
    new iv(paramString, Boolean.valueOf(paramBoolean)) {};
  }
  
  public static iv<String> m(String paramString1, String paramString2)
  {
    new iv(paramString1, paramString2) {};
  }
  
  public String getKey()
  {
    return this.JH;
  }
  
  private static abstract interface a {}
  
  private static class b
    implements iv.a
  {
    private final ContentResolver mContentResolver;
    
    public b(ContentResolver paramContentResolver)
    {
      this.mContentResolver = paramContentResolver;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/iv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */