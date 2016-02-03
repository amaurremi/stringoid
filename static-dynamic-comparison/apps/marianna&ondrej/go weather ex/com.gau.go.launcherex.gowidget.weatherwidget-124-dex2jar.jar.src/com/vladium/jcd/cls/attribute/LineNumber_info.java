package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.compiler.IClassFormatOutput;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class LineNumber_info
  implements Cloneable, IClassFormatOutput
{
  public int m_line_number;
  public int m_start_pc;
  
  public LineNumber_info(int paramInt1, int paramInt2)
  {
    this.m_start_pc = paramInt1;
    this.m_line_number = paramInt2;
  }
  
  LineNumber_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_start_pc = paramUDataInputStream.readU2();
    this.m_line_number = paramUDataInputStream.readU2();
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
    return "line_number_info: [start_pc = " + this.m_start_pc + ", line_number = " + this.m_line_number + "]";
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    paramUDataOutputStream.writeU2(this.m_start_pc);
    paramUDataOutputStream.writeU2(this.m_line_number);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/LineNumber_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */