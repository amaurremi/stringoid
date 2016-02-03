package com.getjar.sdk.logging;

import android.content.Context;
import java.util.Locale;

public class Logger
{
  private static Logger _Instance = null;
  private static Object _InstanceLock = new Object();
  private final AppenderInterface[] _appenders = new AppenderInterface[2];
  
  private Logger()
  {
    this._appenders[0] = LogCatAppender.getInstance();
    this._appenders[1] = RemoteAppender.getInstance();
  }
  
  public static void d(long paramLong, String paramString, Object... paramVarArgs)
  {
    getInstance().log(3, paramLong, null, paramString, paramVarArgs);
  }
  
  public static void d(long paramLong, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(3, paramLong, paramThrowable, paramString, paramVarArgs);
  }
  
  public static void e(long paramLong, String paramString, Object... paramVarArgs)
  {
    getInstance().log(6, paramLong, null, paramString, paramVarArgs);
  }
  
  public static void e(long paramLong, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(6, paramLong, paramThrowable, paramString, paramVarArgs);
  }
  
  public static Logger getInstance()
  {
    if (_Instance == null) {}
    synchronized (_InstanceLock)
    {
      if (_Instance == null) {
        _Instance = new Logger();
      }
      return _Instance;
    }
  }
  
  public static String getShortStack()
  {
    return getShortStack(Thread.currentThread().getStackTrace());
  }
  
  public static String getShortStack(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      localStringBuilder.append(':');
      localStringBuilder.append(localStackTraceElement.getFileName());
      localStringBuilder.append('.');
      localStringBuilder.append(localStackTraceElement.getLineNumber());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String getStackTrace()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 3;
    while (i < arrayOfStackTraceElement.length)
    {
      localStringBuffer.append(String.format(Locale.US, "%1$s : %2$s : %3$s [%4$d]\n", new Object[] { arrayOfStackTraceElement[i].getFileName(), arrayOfStackTraceElement[i].getClassName(), arrayOfStackTraceElement[i].getMethodName(), Integer.valueOf(arrayOfStackTraceElement[i].getLineNumber()) }));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String getStackTrace(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfStackTraceElement.length)
    {
      localStringBuffer.append(String.format(Locale.US, "%1$s : %2$s : %3$s [%4$d]\n", new Object[] { paramArrayOfStackTraceElement[i].getFileName(), paramArrayOfStackTraceElement[i].getClassName(), paramArrayOfStackTraceElement[i].getMethodName(), Integer.valueOf(paramArrayOfStackTraceElement[i].getLineNumber()) }));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String getThrowableDump(Throwable paramThrowable)
  {
    return String.format(Locale.US, "%s | %s | %s", new Object[] { paramThrowable.getClass().getName(), paramThrowable.getMessage(), getStackTrace(paramThrowable.getStackTrace()) });
  }
  
  public static void i(long paramLong, String paramString, Object... paramVarArgs)
  {
    getInstance().log(4, paramLong, null, paramString, paramVarArgs);
  }
  
  public static void i(long paramLong, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(4, paramLong, paramThrowable, paramString, paramVarArgs);
  }
  
  public static String levelToName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(String.format(Locale.US, "Unsupported log level [level:%1$d]", new Object[] { Integer.valueOf(paramInt) }));
    case 2: 
      return "V";
    case 3: 
      return "D";
    case 4: 
      return "I";
    case 5: 
      return "W";
    }
    return "E";
  }
  
  public static void v(long paramLong, String paramString, Object... paramVarArgs)
  {
    getInstance().log(2, paramLong, null, paramString, paramVarArgs);
  }
  
  public static void v(long paramLong, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(2, paramLong, paramThrowable, paramString, paramVarArgs);
  }
  
  public static void w(long paramLong, String paramString, Object... paramVarArgs)
  {
    getInstance().log(5, paramLong, null, paramString, paramVarArgs);
  }
  
  public static void w(long paramLong, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    getInstance().log(5, paramLong, paramThrowable, paramString, paramVarArgs);
  }
  
  public void configureAppenders(Context paramContext)
  {
    int i = 0;
    while (i < this._appenders.length)
    {
      this._appenders[i].configureAppender(paramContext);
      i += 1;
    }
  }
  
  public boolean isAreaActive(long paramLong)
  {
    int i = 0;
    while (i < this._appenders.length)
    {
      if (this._appenders[i].isAreaActive(paramLong)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isLevelActive(int paramInt)
  {
    int i = 0;
    while (i < this._appenders.length)
    {
      if (this._appenders[i].isLevelActive(paramInt)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void log(int paramInt, long paramLong, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("'area' cannot be less than or equal to 0");
    }
    if (paramString == null) {
      throw new IllegalArgumentException("'msg' cannot be NULL");
    }
    if (shouldLog(paramInt, paramLong))
    {
      String str = paramString;
      if (paramVarArgs != null)
      {
        str = paramString;
        if (paramVarArgs.length > 0) {
          str = String.format(Locale.US, paramString, paramVarArgs);
        }
      }
      paramString = new StringBuilder(100);
      Area.appendString(paramLong, paramString);
      paramString.append(": ");
      paramString.append(str);
      paramThrowable = new LogMessage(paramInt, paramLong, paramString.toString(), paramThrowable);
      paramString = this._appenders;
      int i = paramString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramString[paramInt].log(paramThrowable);
        paramInt += 1;
      }
    }
  }
  
  public boolean shouldLog(int paramInt, long paramLong)
  {
    int i = 0;
    while (i < this._appenders.length)
    {
      if (this._appenders[i].shouldLog(paramInt, paramLong)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/logging/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */