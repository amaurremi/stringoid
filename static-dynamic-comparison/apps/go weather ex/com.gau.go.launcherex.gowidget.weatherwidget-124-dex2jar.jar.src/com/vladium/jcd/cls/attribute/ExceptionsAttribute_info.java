package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class ExceptionsAttribute_info
  extends Attribute_info
{
  private IDeclaredExceptionTable m_exceptions;
  
  ExceptionsAttribute_info(int paramInt, long paramLong, UDataInputStream paramUDataInputStream)
    throws IOException
  {
    super(paramInt, paramLong);
    int i = paramUDataInputStream.readU2();
    this.m_exceptions = new DeclaredExceptionTable(i);
    paramInt = 0;
    while (paramInt < i)
    {
      int j = paramUDataInputStream.readU2();
      this.m_exceptions.add(j);
      paramInt += 1;
    }
  }
  
  public ExceptionsAttribute_info(int paramInt, IDeclaredExceptionTable paramIDeclaredExceptionTable)
  {
    super(paramInt, paramIDeclaredExceptionTable.length());
    this.m_exceptions = paramIDeclaredExceptionTable;
  }
  
  public void accept(IAttributeVisitor paramIAttributeVisitor, Object paramObject)
  {
    paramIAttributeVisitor.visit(this, paramObject);
  }
  
  public Object clone()
  {
    ExceptionsAttribute_info localExceptionsAttribute_info = (ExceptionsAttribute_info)super.clone();
    localExceptionsAttribute_info.m_exceptions = ((IDeclaredExceptionTable)this.m_exceptions.clone());
    return localExceptionsAttribute_info;
  }
  
  public IDeclaredExceptionTable getDeclaredExceptions()
  {
    return this.m_exceptions;
  }
  
  public long length()
  {
    return 6L + this.m_exceptions.length();
  }
  
  public String toString()
  {
    return "ExceptionsAttribute_info: [attribute_name_index = " + this.m_name_index + ", attribute_length = " + this.m_attribute_length + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    this.m_exceptions.writeInClassFormat(paramUDataOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/ExceptionsAttribute_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */