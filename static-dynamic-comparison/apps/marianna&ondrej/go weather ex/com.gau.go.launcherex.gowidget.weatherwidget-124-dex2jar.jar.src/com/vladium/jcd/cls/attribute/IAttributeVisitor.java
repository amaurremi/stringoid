package com.vladium.jcd.cls.attribute;

public abstract interface IAttributeVisitor
{
  public abstract Object visit(BridgeAttribute_info paramBridgeAttribute_info, Object paramObject);
  
  public abstract Object visit(CodeAttribute_info paramCodeAttribute_info, Object paramObject);
  
  public abstract Object visit(ConstantValueAttribute_info paramConstantValueAttribute_info, Object paramObject);
  
  public abstract Object visit(ExceptionsAttribute_info paramExceptionsAttribute_info, Object paramObject);
  
  public abstract Object visit(GenericAttribute_info paramGenericAttribute_info, Object paramObject);
  
  public abstract Object visit(InnerClassesAttribute_info paramInnerClassesAttribute_info, Object paramObject);
  
  public abstract Object visit(LineNumberTableAttribute_info paramLineNumberTableAttribute_info, Object paramObject);
  
  public abstract Object visit(SourceFileAttribute_info paramSourceFileAttribute_info, Object paramObject);
  
  public abstract Object visit(SyntheticAttribute_info paramSyntheticAttribute_info, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/IAttributeVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */