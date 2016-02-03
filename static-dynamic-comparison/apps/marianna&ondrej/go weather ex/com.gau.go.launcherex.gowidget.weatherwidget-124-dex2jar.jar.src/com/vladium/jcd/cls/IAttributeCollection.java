package com.vladium.jcd.cls;

import com.vladium.jcd.cls.attribute.Attribute_info;
import com.vladium.jcd.cls.attribute.InnerClassesAttribute_info;
import com.vladium.jcd.compiler.IClassFormatOutput;

public abstract interface IAttributeCollection
  extends Cloneable, IClassFormatOutput
{
  public abstract void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject);
  
  public abstract int add(Attribute_info paramAttribute_info);
  
  public abstract Object clone();
  
  public abstract Attribute_info get(int paramInt);
  
  public abstract InnerClassesAttribute_info getInnerClassesAttribute();
  
  public abstract boolean hasBridge();
  
  public abstract boolean hasSynthetic();
  
  public abstract long length();
  
  public abstract Attribute_info remove(int paramInt);
  
  public abstract Attribute_info set(int paramInt, Attribute_info paramAttribute_info);
  
  public abstract int size();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/IAttributeCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */