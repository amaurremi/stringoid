package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.compiler.IClassFormatOutput;

public abstract interface IDeclaredExceptionTable
  extends Cloneable, IClassFormatOutput
{
  public abstract int add(int paramInt);
  
  public abstract Object clone();
  
  public abstract int get(int paramInt);
  
  public abstract long length();
  
  public abstract int set(int paramInt1, int paramInt2);
  
  public abstract int size();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/IDeclaredExceptionTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */