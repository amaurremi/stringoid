package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class LineNumberTableAttribute_info
  extends Attribute_info
{
  private List m_lines;
  
  LineNumberTableAttribute_info(int paramInt, long paramLong, UDataInputStream paramUDataInputStream)
    throws IOException
  {
    super(paramInt, paramLong);
    int i = paramUDataInputStream.readU2();
    this.m_lines = new ArrayList(i);
    paramInt = 0;
    while (paramInt < i)
    {
      this.m_lines.add(new LineNumber_info(paramUDataInputStream));
      paramInt += 1;
    }
  }
  
  public void accept(IAttributeVisitor paramIAttributeVisitor, Object paramObject)
  {
    paramIAttributeVisitor.visit(this, paramObject);
  }
  
  public Object clone()
  {
    LineNumberTableAttribute_info localLineNumberTableAttribute_info = (LineNumberTableAttribute_info)super.clone();
    int j = this.m_lines.size();
    localLineNumberTableAttribute_info.m_lines = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localLineNumberTableAttribute_info.m_lines.add(((LineNumber_info)this.m_lines.get(i)).clone());
      i += 1;
    }
    return localLineNumberTableAttribute_info;
  }
  
  public LineNumber_info get(int paramInt)
  {
    return (LineNumber_info)this.m_lines.get(paramInt);
  }
  
  public long length()
  {
    return (this.m_lines.size() << 2) + 8;
  }
  
  public int size()
  {
    return this.m_lines.size();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LineNumberTableAttribute_info: [attribute_name_index = " + this.m_name_index + ", attribute_length = " + length() + "]\n");
    int i = 0;
    while (i < size())
    {
      localStringBuffer.append("            " + get(i));
      localStringBuffer.append("\n");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    int j = this.m_lines.size();
    paramUDataOutputStream.writeU2(j);
    int i = 0;
    while (i < j)
    {
      ((LineNumber_info)this.m_lines.get(i)).writeInClassFormat(paramUDataOutputStream);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/LineNumberTableAttribute_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */