package com.vladium.emma.report;

public abstract interface IItemVisitor
{
  public abstract Object visit(AllItem paramAllItem, Object paramObject);
  
  public abstract Object visit(ClassItem paramClassItem, Object paramObject);
  
  public abstract Object visit(MethodItem paramMethodItem, Object paramObject);
  
  public abstract Object visit(PackageItem paramPackageItem, Object paramObject);
  
  public abstract Object visit(SrcFileItem paramSrcFileItem, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/IItemVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */