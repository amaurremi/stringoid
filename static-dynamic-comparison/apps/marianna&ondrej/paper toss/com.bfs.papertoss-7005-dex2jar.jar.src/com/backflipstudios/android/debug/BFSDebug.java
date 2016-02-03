package com.backflipstudios.android.debug;

import android.util.Log;

public class BFSDebug
{
  public static final boolean LOG_ENABLED = true;
  private static final String TAG = "game";
  
  public static final void d(String paramString)
  {
    d("game", paramString);
  }
  
  public static final void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public static final void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static final void d(String paramString, Throwable paramThrowable)
  {
    d("game", paramString, paramThrowable);
  }
  
  public static final void e(String paramString)
  {
    e("game", paramString);
  }
  
  public static final void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static final void e(String paramString, Throwable paramThrowable)
  {
    e("game", paramString, paramThrowable);
  }
  
  public static final void i(String paramString)
  {
    i("game", paramString);
  }
  
  public static final void i(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public static final void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static final void i(String paramString, Throwable paramThrowable)
  {
    i("game", paramString, paramThrowable);
  }
  
  public static final void v(String paramString)
  {
    v("game", paramString);
  }
  
  public static final void v(String paramString1, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public static final void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static final void v(String paramString, Throwable paramThrowable)
  {
    v("game", paramString, paramThrowable);
  }
  
  public static final void w(String paramString)
  {
    w("game", paramString);
  }
  
  public static final void w(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public static final void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static final void w(String paramString, Throwable paramThrowable)
  {
    w("game", paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/backflipstudios/android/debug/BFSDebug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */