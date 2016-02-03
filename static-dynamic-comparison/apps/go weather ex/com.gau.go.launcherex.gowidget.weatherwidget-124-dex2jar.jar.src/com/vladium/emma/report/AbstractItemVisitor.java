package com.vladium.emma.report;

public abstract class AbstractItemVisitor
  implements IItemVisitor
{
  public Object visit(AllItem paramAllItem, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(ClassItem paramClassItem, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(MethodItem paramMethodItem, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(PackageItem paramPackageItem, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(SrcFileItem paramSrcFileItem, Object paramObject)
  {
    return paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/AbstractItemVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */