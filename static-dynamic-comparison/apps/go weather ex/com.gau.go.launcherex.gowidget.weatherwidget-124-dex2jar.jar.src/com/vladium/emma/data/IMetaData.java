package com.vladium.emma.data;

import java.util.Iterator;

public abstract interface IMetaData
  extends IMergeable
{
  public abstract boolean add(ClassDescriptor paramClassDescriptor, boolean paramBoolean);
  
  public abstract CoverageOptions getOptions();
  
  public abstract boolean hasDescriptor(String paramString);
  
  public abstract boolean hasLineNumberData();
  
  public abstract boolean hasSrcFileData();
  
  public abstract Iterator iterator();
  
  public abstract Object lock();
  
  public abstract IMetaData shallowCopy();
  
  public abstract int size();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/IMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */