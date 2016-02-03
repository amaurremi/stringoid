package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CONSTANT_Long_info
  extends CONSTANT_literal_info
{
  public static final byte TAG = 5;
  public long m_value;
  
  public CONSTANT_Long_info(long paramLong)
  {
    this.m_value = paramLong;
  }
  
  protected CONSTANT_Long_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_value = paramUDataInputStream.readLong();
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public final byte tag()
  {
    return 5;
  }
  
  public String toString()
  {
    return Long.toString(this.m_value);
  }
  
  public int width()
  {
    return 2;
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeLong(this.m_value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_Long_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */