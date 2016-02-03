package com.vladium.util.exception;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class AbstractException
  extends Exception
  implements ICodedException, IThrowableWrapper
{
  private final transient Object[] m_arguments;
  private final Throwable m_cause;
  private String m_message;
  
  public AbstractException()
  {
    this.m_cause = null;
    this.m_arguments = null;
  }
  
  public AbstractException(String paramString)
  {
    super(paramString);
    this.m_cause = null;
    this.m_arguments = null;
  }
  
  public AbstractException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.m_cause = paramThrowable;
    this.m_arguments = null;
  }
  
  public AbstractException(String paramString, Object[] paramArrayOfObject)
  {
    super(paramString);
    this.m_cause = null;
    if (paramArrayOfObject == null) {}
    for (paramString = (String)localObject;; paramString = (Object[])paramArrayOfObject.clone())
    {
      this.m_arguments = paramString;
      return;
    }
  }
  
  public AbstractException(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    super(paramString);
    this.m_cause = paramThrowable;
    if (paramArrayOfObject == null) {}
    for (paramString = null;; paramString = (Object[])paramArrayOfObject.clone())
    {
      this.m_arguments = paramString;
      return;
    }
  }
  
  public AbstractException(Throwable paramThrowable)
  {
    this.m_cause = paramThrowable;
    this.m_arguments = null;
  }
  
  public static void addExceptionResource(Class paramClass, String paramString)
  {
    ExceptionCommon.addExceptionResource(paramClass, paramString);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    getMessage();
    paramObjectOutputStream.defaultWriteObject();
  }
  
  public void __printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
  }
  
  public void __printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
  }
  
  public final Throwable getCause()
  {
    return this.m_cause;
  }
  
  public final String getErrorCode()
  {
    return super.getMessage();
  }
  
  public final String getLocalizedMessage()
  {
    return getMessage();
  }
  
  public final String getMessage()
  {
    String str3;
    Class localClass;
    String str1;
    String str2;
    if (this.m_message == null)
    {
      str3 = super.getMessage();
      localClass = getClass();
      if (this.m_arguments != null) {
        break label82;
      }
      str1 = ExceptionCommon.getMessage(localClass, str3);
      str2 = str1;
      if (str1 == null)
      {
        str2 = localClass.getName();
        if (str3 == null) {
          break label96;
        }
        str2 = str2 + ": " + str3;
      }
    }
    label82:
    label96:
    for (;;)
    {
      this.m_message = str2;
      return this.m_message;
      str1 = ExceptionCommon.getMessage(localClass, str3, this.m_arguments);
      break;
    }
  }
  
  public final void printStackTrace()
  {
    ExceptionCommon.printStackTrace(this, System.out);
  }
  
  public final void printStackTrace(PrintStream paramPrintStream)
  {
    ExceptionCommon.printStackTrace(this, paramPrintStream);
  }
  
  public final void printStackTrace(PrintWriter paramPrintWriter)
  {
    ExceptionCommon.printStackTrace(this, paramPrintWriter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/exception/AbstractException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */