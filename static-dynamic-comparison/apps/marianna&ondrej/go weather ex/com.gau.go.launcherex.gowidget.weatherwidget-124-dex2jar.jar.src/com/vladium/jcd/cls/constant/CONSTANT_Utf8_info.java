package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CONSTANT_Utf8_info
  extends CONSTANT_info
{
  public static final byte TAG = 1;
  public String m_value;
  
  protected CONSTANT_Utf8_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_value = paramUDataInputStream.readUTF();
  }
  
  public CONSTANT_Utf8_info(String paramString)
  {
    this.m_value = paramString;
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public final byte tag()
  {
    return 1;
  }
  
  public String toString()
  {
    return "CONSTANT_Utf8: [" + this.m_value + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeUTF(this.m_value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_Utf8_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */