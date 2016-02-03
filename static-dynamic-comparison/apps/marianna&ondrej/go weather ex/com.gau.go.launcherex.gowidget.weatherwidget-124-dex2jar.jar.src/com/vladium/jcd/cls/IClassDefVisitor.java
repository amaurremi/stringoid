package com.vladium.jcd.cls;

public abstract interface IClassDefVisitor
{
  public abstract Object visit(ClassDef paramClassDef, Object paramObject);
  
  public abstract Object visit(IAttributeCollection paramIAttributeCollection, Object paramObject);
  
  public abstract Object visit(IConstantCollection paramIConstantCollection, Object paramObject);
  
  public abstract Object visit(IFieldCollection paramIFieldCollection, Object paramObject);
  
  public abstract Object visit(IInterfaceCollection paramIInterfaceCollection, Object paramObject);
  
  public abstract Object visit(IMethodCollection paramIMethodCollection, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/IClassDefVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */