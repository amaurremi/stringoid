package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import java.io.IOException;

public final class CONSTANT_Methodref_info
  extends CONSTANT_ref_info
{
  public static final byte TAG = 10;
  
  public CONSTANT_Methodref_info(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected CONSTANT_Methodref_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    super(paramUDataInputStream);
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public final byte tag()
  {
    return 10;
  }
  
  public String toString()
  {
    return "CONSTANT_Methodref_info: [class_index = " + this.m_class_index + ", name_and_type_index = " + this.m_name_and_type_index + ']';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_Methodref_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */