package com.vladium.jcd.cls.constant;

public abstract interface ICONSTANTVisitor
{
  public abstract Object visit(CONSTANT_Class_info paramCONSTANT_Class_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_Double_info paramCONSTANT_Double_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_Fieldref_info paramCONSTANT_Fieldref_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_Float_info paramCONSTANT_Float_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_Integer_info paramCONSTANT_Integer_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_InterfaceMethodref_info paramCONSTANT_InterfaceMethodref_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_Long_info paramCONSTANT_Long_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_Methodref_info paramCONSTANT_Methodref_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_NameAndType_info paramCONSTANT_NameAndType_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_String_info paramCONSTANT_String_info, Object paramObject);
  
  public abstract Object visit(CONSTANT_Utf8_info paramCONSTANT_Utf8_info, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/ICONSTANTVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */