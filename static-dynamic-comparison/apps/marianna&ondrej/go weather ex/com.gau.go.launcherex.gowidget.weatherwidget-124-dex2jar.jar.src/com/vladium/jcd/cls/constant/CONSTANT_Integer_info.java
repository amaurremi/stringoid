package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CONSTANT_Integer_info
  extends CONSTANT_literal_info
{
  public static final byte TAG = 3;
  public int m_value;
  
  public CONSTANT_Integer_info(int paramInt)
  {
    this.m_value = paramInt;
  }
  
  protected CONSTANT_Integer_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_value = paramUDataInputStream.readInt();
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public final byte tag()
  {
    return 3;
  }
  
  public String toString()
  {
    return Integer.toString(this.m_value);
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeInt(this.m_value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_Integer_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */