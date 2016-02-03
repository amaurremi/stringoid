package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.compiler.IClassFormatOutput;

public abstract interface IExceptionHandlerTable
  extends Cloneable, IClassFormatOutput
{
  public abstract int add(Exception_info paramException_info);
  
  public abstract Object clone();
  
  public abstract Exception_info get(int paramInt);
  
  public abstract long length();
  
  public abstract Exception_info set(int paramInt, Exception_info paramException_info);
  
  public abstract int size();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/IExceptionHandlerTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */