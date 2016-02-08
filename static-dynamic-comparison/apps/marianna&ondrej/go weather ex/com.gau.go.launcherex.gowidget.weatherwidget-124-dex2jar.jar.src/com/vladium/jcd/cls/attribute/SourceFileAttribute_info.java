package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.cls.IConstantCollection;
import com.vladium.jcd.cls.constant.CONSTANT_Utf8_info;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class SourceFileAttribute_info
  extends Attribute_info
{
  public int m_sourcefile_index;
  
  public SourceFileAttribute_info(int paramInt)
  {
    super(paramInt, 0L);
  }
  
  SourceFileAttribute_info(int paramInt, long paramLong, UDataInputStream paramUDataInputStream)
    throws IOException
  {
    super(paramInt, paramLong);
    this.m_sourcefile_index = paramUDataInputStream.readU2();
  }
  
  public void accept(IAttributeVisitor paramIAttributeVisitor, Object paramObject)
  {
    paramIAttributeVisitor.visit(this, paramObject);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public CONSTANT_Utf8_info getSourceFile(ClassDef paramClassDef)
  {
    return (CONSTANT_Utf8_info)paramClassDef.getConstants().get(this.m_sourcefile_index);
  }
  
  public long length()
  {
    return 8L;
  }
  
  public String toString()
  {
    return "SourceFileAttribute_info: [attribute_name_index = " + this.m_name_index + ", attribute_length = " + this.m_attribute_length + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeU2(this.m_sourcefile_index);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/SourceFileAttribute_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */