package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.compiler.IClassFormatOutput;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class InnerClass_info
  implements Cloneable, IClassFormatOutput
{
  public int m_inner_access_flags;
  public int m_inner_class_index;
  public int m_inner_name_index;
  public int m_outer_class_index;
  
  public InnerClass_info(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m_outer_class_index = paramInt1;
    this.m_inner_class_index = paramInt2;
    this.m_inner_name_index = paramInt3;
    this.m_inner_access_flags = paramInt4;
  }
  
  InnerClass_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_inner_class_index = paramUDataInputStream.readU2();
    this.m_outer_class_index = paramUDataInputStream.readU2();
    this.m_inner_name_index = paramUDataInputStream.readU2();
    this.m_inner_access_flags = paramUDataInputStream.readU2();
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public String toString()
  {
    return "innerclass_info: [m_outer_class_index = " + this.m_outer_class_index + ", m_inner_class_index = " + this.m_inner_class_index + ", m_inner_name_index = " + this.m_inner_name_index + ", m_inner_access_flags = " + this.m_inner_access_flags + "]";
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    paramUDataOutputStream.writeU2(this.m_inner_class_index);
    paramUDataOutputStream.writeU2(this.m_outer_class_index);
    paramUDataOutputStream.writeU2(this.m_inner_name_index);
    paramUDataOutputStream.writeU2(this.m_inner_access_flags);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/InnerClass_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */