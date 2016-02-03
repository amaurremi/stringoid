package com.vladium.jcd.cls;

public abstract class AbstractClassDefVisitor
  implements IClassDefVisitor
{
  public Object visit(ClassDef paramClassDef, Object paramObject)
  {
    visit(paramClassDef.getConstants(), paramObject);
    visit(paramClassDef.getInterfaces(), paramObject);
    visit(paramClassDef.getFields(), paramObject);
    visit(paramClassDef.getMethods(), paramObject);
    visit(paramClassDef.getAttributes(), paramObject);
    return paramObject;
  }
  
  public Object visit(IAttributeCollection paramIAttributeCollection, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(IConstantCollection paramIConstantCollection, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(IFieldCollection paramIFieldCollection, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(IInterfaceCollection paramIInterfaceCollection, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(IMethodCollection paramIMethodCollection, Object paramObject)
  {
    return paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/AbstractClassDefVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */