package com.vladium.jcd.cls;

import com.vladium.jcd.cls.constant.CONSTANT_info;
import com.vladium.jcd.compiler.IClassFormatOutput;

public abstract interface IConstantCollection
  extends Cloneable, IClassFormatOutput
{
  public abstract void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject);
  
  public abstract int add(CONSTANT_info paramCONSTANT_info);
  
  public abstract Object clone();
  
  public abstract int find(int paramInt, IConstantComparator paramIConstantComparator);
  
  public abstract int findCONSTANT_Utf8(String paramString);
  
  public abstract CONSTANT_info get(int paramInt);
  
  public abstract IConstantIterator iterator();
  
  public abstract CONSTANT_info set(int paramInt, CONSTANT_info paramCONSTANT_info);
  
  public abstract int size();
  
  public static abstract interface IConstantComparator
  {
    public abstract boolean equals(CONSTANT_info paramCONSTANT_info);
  }
  
  public static abstract interface IConstantIterator
  {
    public abstract CONSTANT_info nextConstant();
    
    public abstract int nextIndex();
    
    public abstract CONSTANT_info set(CONSTANT_info paramCONSTANT_info);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/IConstantCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */