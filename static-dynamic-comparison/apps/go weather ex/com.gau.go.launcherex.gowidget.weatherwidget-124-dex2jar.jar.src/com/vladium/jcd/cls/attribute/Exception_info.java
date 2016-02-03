package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.compiler.IClassFormatOutput;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class Exception_info
  implements Cloneable, IClassFormatOutput
{
  public int m_catch_type;
  public int m_end_pc;
  public int m_handler_pc;
  public int m_start_pc;
  
  public Exception_info(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m_start_pc = paramInt1;
    this.m_end_pc = paramInt2;
    this.m_handler_pc = paramInt3;
    this.m_catch_type = paramInt4;
  }
  
  Exception_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_start_pc = paramUDataInputStream.readU2();
    this.m_end_pc = paramUDataInputStream.readU2();
    this.m_handler_pc = paramUDataInputStream.readU2();
    this.m_catch_type = paramUDataInputStream.readU2();
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
    return "exception_info: [start_pc/end_pc = " + this.m_start_pc + '/' + this.m_end_pc + ", handler_pc = " + this.m_handler_pc + ", catch_type = " + this.m_catch_type + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    paramUDataOutputStream.writeU2(this.m_start_pc);
    paramUDataOutputStream.writeU2(this.m_end_pc);
    paramUDataOutputStream.writeU2(this.m_handler_pc);
    paramUDataOutputStream.writeU2(this.m_catch_type);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/Exception_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */