package com.vladium.jcd.cls;

public abstract class ElementFactory
{
  public static IAttributeCollection newAttributeCollection(int paramInt)
  {
    return new AttributeCollection(paramInt);
  }
  
  public static IConstantCollection newConstantCollection(int paramInt)
  {
    return new ConstantCollection(paramInt);
  }
  
  public static IFieldCollection newFieldCollection(int paramInt)
  {
    return new FieldCollection(paramInt);
  }
  
  public static IInterfaceCollection newInterfaceCollection(int paramInt)
  {
    return new InterfaceCollection(paramInt);
  }
  
  public static IMethodCollection newMethodCollection(int paramInt)
  {
    return new MethodCollection(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/ElementFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */