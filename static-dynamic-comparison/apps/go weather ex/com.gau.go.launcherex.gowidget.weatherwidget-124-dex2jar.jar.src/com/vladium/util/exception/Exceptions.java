package com.vladium.util.exception;

public abstract class Exceptions
{
  public static boolean unexpectedFailure(Throwable paramThrowable, Class[] paramArrayOfClass)
  {
    if (paramThrowable == null) {
      return false;
    }
    if (paramArrayOfClass == null) {
      return true;
    }
    paramThrowable = paramThrowable.getClass();
    int i = 0;
    if (i < paramArrayOfClass.length)
    {
      if (paramArrayOfClass[i] == null) {}
      while (!paramArrayOfClass[i].isAssignableFrom(paramThrowable))
      {
        i += 1;
        break;
      }
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/exception/Exceptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */