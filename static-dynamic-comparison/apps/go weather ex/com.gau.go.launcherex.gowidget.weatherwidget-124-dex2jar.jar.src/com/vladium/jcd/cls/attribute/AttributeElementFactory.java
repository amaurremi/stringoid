package com.vladium.jcd.cls.attribute;

public abstract class AttributeElementFactory
{
  public static IExceptionHandlerTable newExceptionHandlerTable(int paramInt)
  {
    return new ExceptionHandlerTable(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/AttributeElementFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */