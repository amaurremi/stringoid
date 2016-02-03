package com.vladium.jcd.cls.constant;

import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.cls.IConstantCollection;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CONSTANT_Class_info
  extends CONSTANT_info
{
  public static final byte TAG = 7;
  public int m_name_index;
  
  public CONSTANT_Class_info(int paramInt)
  {
    this.m_name_index = paramInt;
  }
  
  protected CONSTANT_Class_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_name_index = paramUDataInputStream.readU2();
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public String getName(ClassDef paramClassDef)
  {
    return ((CONSTANT_Utf8_info)paramClassDef.getConstants().get(this.m_name_index)).m_value;
  }
  
  public final byte tag()
  {
    return 7;
  }
  
  public String toString()
  {
    return "CONSTANT_Class: [name_index = " + this.m_name_index + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeU2(this.m_name_index);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_Class_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */