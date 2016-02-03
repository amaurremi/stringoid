package com.appfireworks.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.appfireworks.android.track.AppTracker;
import java.util.Calendar;

public class AppExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private String apikey;
  private Context context;
  private Thread.UncaughtExceptionHandler def;
  
  public AppExceptionHandler(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.apikey = paramString;
    this.def = Thread.getDefaultUncaughtExceptionHandler();
  }
  
  private SharedPreferences getPrefs()
  {
    return this.context.getSharedPreferences("APPFIREWORKS_" + this.apikey, 0);
  }
  
  private String getSID()
  {
    return getPrefs().getString("SID", "");
  }
  
  private void writeTrace(String paramString1, String paramString2)
  {
    int i = (int)(Calendar.getInstance().getTimeInMillis() / 1000L);
    String str3 = "CrashData_" + this.apikey + i + ".stacktrace";
    String str2 = i + "+=+=+=+=" + paramString1 + "+=+=+=+=" + paramString2 + "+=+=+=+=" + getSID();
    AppLog.d("AppFireworks", "Content - " + str2);
    String str1 = "";
    try
    {
      str2 = AppEncryption.encryptAES("tiJ8e+8Fb^21xd|5", str2);
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!AppTracker.saveFileWithContent(str3, "/AppData//" + this.apikey + "/", str1)) {
      AppTracker.crashReport(this.context, paramString1, paramString2);
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        localObject = ((StringBuilder)localObject).toString();
      }
      try
      {
        AppTracker.crashReport(this.context, (String)localObject, paramThrowable.getMessage());
        this.def.uncaughtException(paramThread, paramThrowable);
        return;
        ((StringBuilder)localObject).append(arrayOfStackTraceElement[i].toString());
        ((StringBuilder)localObject).append("\\n");
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          writeTrace((String)localObject, paramThrowable.getMessage());
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/util/AppExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */