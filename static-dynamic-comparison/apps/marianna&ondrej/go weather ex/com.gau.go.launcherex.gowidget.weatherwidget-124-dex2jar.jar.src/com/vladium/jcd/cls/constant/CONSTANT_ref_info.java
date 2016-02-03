package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public abstract class CONSTANT_ref_info
  extends CONSTANT_info
{
  public int m_class_index;
  public int m_name_and_type_index;
  
  protected CONSTANT_ref_info(int paramInt1, int paramInt2)
  {
    this.m_class_index = paramInt1;
    this.m_name_and_type_index = paramInt2;
  }
  
  protected CONSTANT_ref_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_class_index = paramUDataInputStream.readU2();
    this.m_name_and_type_index = paramUDataInputStream.readU2();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeU2(this.m_class_index);
    paramUDataOutputStream.writeU2(this.m_name_and_type_index);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_ref_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */