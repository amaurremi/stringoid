package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CONSTANT_String_info
  extends CONSTANT_literal_info
{
  public static final byte TAG = 8;
  public int m_string_index;
  
  public CONSTANT_String_info(int paramInt)
  {
    this.m_string_index = paramInt;
  }
  
  protected CONSTANT_String_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_string_index = paramUDataInputStream.readU2();
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public final byte tag()
  {
    return 8;
  }
  
  public String toString()
  {
    return "CONSTANT_String: [string_index = " + this.m_string_index + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeU2(this.m_string_index);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_String_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */