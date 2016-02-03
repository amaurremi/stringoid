package com.vladium.util;

public class ClassLoadContext
{
  private final Class m_caller;
  
  ClassLoadContext(Class paramClass)
  {
    this.m_caller = paramClass;
  }
  
  public final Class getCallerClass()
  {
    return this.m_caller;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/ClassLoadContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */