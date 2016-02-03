package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class SyntheticAttribute_info
  extends Attribute_info
{
  public SyntheticAttribute_info(int paramInt)
  {
    super(paramInt, 0L);
  }
  
  SyntheticAttribute_info(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public void accept(IAttributeVisitor paramIAttributeVisitor, Object paramObject)
  {
    paramIAttributeVisitor.visit(this, paramObject);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public long length()
  {
    return 6L;
  }
  
  public String toString()
  {
    return "SyntheticValueAttribute_info: [attribute_name_index = " + this.m_name_index + ", attribute_length = " + this.m_attribute_length + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/SyntheticAttribute_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */