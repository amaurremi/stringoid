package com.mobisystems.pdf;

import android.util.Log;

public class PDFTrace
{
  public static final int ASSERT = 7;
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  private static final String TAG = "PDFTrace";
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  
  public static int d(String paramString)
  {
    return Log.d("PDFTrace", paramString);
  }
  
  public static int d(String paramString, Throwable paramThrowable)
  {
    return Log.d("PDFTrace", paramString, paramThrowable);
  }
  
  public static int e(String paramString)
  {
    return Log.e("PDFTrace", paramString);
  }
  
  public static int e(String paramString, Throwable paramThrowable)
  {
    return Log.e("PDFTrace", paramString, paramThrowable);
  }
  
  public static int i(String paramString)
  {
    return Log.i("PDFTrace", paramString);
  }
  
  public static int i(String paramString, Throwable paramThrowable)
  {
    return Log.i("PDFTrace", paramString, paramThrowable);
  }
  
  public static boolean isLoggable(int paramInt)
  {
    return Log.isLoggable("PDFTrace", paramInt);
  }
  
  public static int v(String paramString)
  {
    return Log.v("PDFTrace", paramString);
  }
  
  public static int v(String paramString, Throwable paramThrowable)
  {
    return Log.v("PDFTrace", paramString, paramThrowable);
  }
  
  public static int w(String paramString)
  {
    return Log.w("PDFTrace", paramString);
  }
  
  public static int w(String paramString, Throwable paramThrowable)
  {
    return Log.w("PDFTrace", paramString, paramThrowable);
  }
  
  public static int wtf(String paramString)
  {
    return Log.wtf("PDFTrace", paramString);
  }
  
  public static int wtf(String paramString, Throwable paramThrowable)
  {
    return Log.wtf("PDFTrace", paramString, paramThrowable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFTrace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */