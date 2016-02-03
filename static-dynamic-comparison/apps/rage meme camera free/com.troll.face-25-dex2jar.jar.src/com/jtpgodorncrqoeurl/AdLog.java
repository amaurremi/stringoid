package com.jtpgodorncrqoeurl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class AdLog
{
  private static boolean a = false;
  private static Handler b;
  private static String c = "";
  
  private static void a(String paramString1, String paramString2)
  {
    if (b != null)
    {
      Message localMessage = new Message();
      Bundle localBundle = new Bundle();
      localBundle.putString("tag", paramString1);
      localBundle.putString("msg", c + paramString2);
      localMessage.setData(localBundle);
      b.sendMessage(localMessage);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a)
    {
      Log.d(paramString1, c + paramString2);
      new StringBuilder().append(c).append(paramString2).toString();
      a(paramString1, c + paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a)
    {
      Log.e(paramString1, c + paramString2);
      new StringBuilder().append(c).append(paramString2).toString();
      a(paramString1, c + paramString2);
    }
  }
  
  public static void enableLog(boolean paramBoolean)
  {
    Log.i("LBAdController", "enableLog: " + paramBoolean);
    new StringBuilder("enableLog: ").append(paramBoolean).toString();
    a = paramBoolean;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (a)
    {
      Log.i(paramString1, c + paramString2);
      new StringBuilder().append(c).append(paramString2).toString();
      a(paramString1, c + paramString2);
    }
  }
  
  public static void printStackTrace(String paramString, Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = localStringWriter.toString();
    Log.d(paramString, paramException);
    a(paramString, paramException);
  }
  
  public static String readLog()
  {
    return "";
  }
  
  public static void setHandler(Handler paramHandler)
  {
    b = paramHandler;
  }
  
  public static void setPreText(String paramString)
  {
    c = paramString;
  }
  
  public static void timeTracK(String paramString)
  {
    if (a)
    {
      CharSequence localCharSequence = DateFormat.format("h:mm:ss", new Date().getTime());
      Log.v("AdLogTimeTest", "Function - " + paramString + ": Time = " + localCharSequence);
      new StringBuilder("Function - ").append(paramString).append(": Time = ").append(localCharSequence).toString();
      a("AdLogTimeTest", "Function - " + paramString + ": Time = " + localCharSequence);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (a)
    {
      Log.v(paramString1, c + paramString2);
      new StringBuilder().append(c).append(paramString2).toString();
      a(paramString1, c + paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (a)
    {
      Log.w(paramString1, c + paramString2);
      new StringBuilder().append(c).append(paramString2).toString();
      a(paramString1, c + paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */