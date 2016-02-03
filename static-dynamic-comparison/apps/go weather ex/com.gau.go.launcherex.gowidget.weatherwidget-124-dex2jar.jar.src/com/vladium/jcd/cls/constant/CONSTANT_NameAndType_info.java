package com.vladium.jcd.cls.constant;

import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.cls.IConstantCollection;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CONSTANT_NameAndType_info
  extends CONSTANT_info
{
  public static final byte TAG = 12;
  public int m_descriptor_index;
  public int m_name_index;
  
  public CONSTANT_NameAndType_info(int paramInt1, int paramInt2)
  {
    this.m_name_index = paramInt1;
    this.m_descriptor_index = paramInt2;
  }
  
  protected CONSTANT_NameAndType_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_name_index = paramUDataInputStream.readU2();
    this.m_descriptor_index = paramUDataInputStream.readU2();
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public String getDescriptor(ClassDef paramClassDef)
  {
    return ((CONSTANT_Utf8_info)paramClassDef.getConstants().get(this.m_descriptor_index)).m_value;
  }
  
  public String getName(ClassDef paramClassDef)
  {
    return ((CONSTANT_Utf8_info)paramClassDef.getConstants().get(this.m_name_index)).m_value;
  }
  
  public final byte tag()
  {
    return 12;
  }
  
  public String toString()
  {
    return "CONSTANT_NameAndType: [name_index = " + this.m_name_index + ", descriptor_index = " + this.m_descriptor_index + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeU2(this.m_name_index);
    paramUDataOutputStream.writeU2(this.m_descriptor_index);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_NameAndType_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */