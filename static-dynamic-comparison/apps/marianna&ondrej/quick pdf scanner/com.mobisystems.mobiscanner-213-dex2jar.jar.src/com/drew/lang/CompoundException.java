package com.drew.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

public class CompoundException
  extends Exception
{
  private static final long serialVersionUID = -9207883813472069925L;
  private final Throwable _innerException;
  
  public CompoundException(String paramString)
  {
    this(paramString, null);
  }
  
  public CompoundException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this._innerException = paramThrowable;
  }
  
  public void printStackTrace()
  {
    super.printStackTrace();
    if (this._innerException != null)
    {
      System.err.println("--- inner exception ---");
      this._innerException.printStackTrace();
    }
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    if (this._innerException != null)
    {
      paramPrintStream.println("--- inner exception ---");
      this._innerException.printStackTrace(paramPrintStream);
    }
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    if (this._innerException != null)
    {
      paramPrintWriter.println("--- inner exception ---");
      this._innerException.printStackTrace(paramPrintWriter);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    if (this._innerException != null)
    {
      localStringBuilder.append("\n");
      localStringBuilder.append("--- inner exception ---");
      localStringBuilder.append("\n");
      localStringBuilder.append(this._innerException.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/lang/CompoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */