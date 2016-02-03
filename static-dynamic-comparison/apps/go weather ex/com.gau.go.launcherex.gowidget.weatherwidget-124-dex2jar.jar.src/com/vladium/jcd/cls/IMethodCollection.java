package com.vladium.jcd.cls;

import com.vladium.jcd.compiler.IClassFormatOutput;

public abstract interface IMethodCollection
  extends Cloneable, IClassFormatOutput
{
  public abstract void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject);
  
  public abstract int add(Method_info paramMethod_info);
  
  public abstract Object clone();
  
  public abstract Method_info get(int paramInt);
  
  public abstract int[] get(ClassDef paramClassDef, String paramString);
  
  public abstract Method_info remove(int paramInt);
  
  public abstract Method_info set(int paramInt, Method_info paramMethod_info);
  
  public abstract int size();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/IMethodCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */