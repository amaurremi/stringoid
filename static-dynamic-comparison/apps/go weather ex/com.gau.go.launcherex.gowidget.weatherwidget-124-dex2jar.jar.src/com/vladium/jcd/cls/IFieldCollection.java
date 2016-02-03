package com.vladium.jcd.cls;

import com.vladium.jcd.compiler.IClassFormatOutput;

public abstract interface IFieldCollection
  extends Cloneable, IClassFormatOutput
{
  public abstract void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject);
  
  public abstract int add(Field_info paramField_info);
  
  public abstract Object clone();
  
  public abstract Field_info get(int paramInt);
  
  public abstract int[] get(ClassDef paramClassDef, String paramString);
  
  public abstract Field_info set(int paramInt, Field_info paramField_info);
  
  public abstract int size();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/IFieldCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */