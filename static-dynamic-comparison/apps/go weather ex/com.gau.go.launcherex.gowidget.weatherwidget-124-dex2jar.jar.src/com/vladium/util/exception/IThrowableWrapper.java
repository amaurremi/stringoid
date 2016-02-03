package com.vladium.util.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

abstract interface IThrowableWrapper
{
  public abstract void __printStackTrace(PrintStream paramPrintStream);
  
  public abstract void __printStackTrace(PrintWriter paramPrintWriter);
  
  public abstract Throwable getCause();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/exception/IThrowableWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */