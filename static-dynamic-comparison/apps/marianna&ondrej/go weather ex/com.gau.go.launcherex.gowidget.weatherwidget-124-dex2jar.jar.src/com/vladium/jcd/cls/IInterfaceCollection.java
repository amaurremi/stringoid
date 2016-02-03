package com.vladium.jcd.cls;

import com.vladium.jcd.compiler.IClassFormatOutput;

public abstract interface IInterfaceCollection
  extends Cloneable, IClassFormatOutput
{
  public abstract void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject);
  
  public abstract int add(int paramInt);
  
  public abstract Object clone();
  
  public abstract int get(int paramInt);
  
  public abstract int set(int paramInt1, int paramInt2);
  
  public abstract int size();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/IInterfaceCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */