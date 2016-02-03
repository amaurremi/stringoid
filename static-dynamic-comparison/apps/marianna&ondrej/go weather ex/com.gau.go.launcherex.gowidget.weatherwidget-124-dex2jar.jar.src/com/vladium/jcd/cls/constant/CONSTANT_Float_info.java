package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CONSTANT_Float_info
  extends CONSTANT_literal_info
{
  public static final byte TAG = 4;
  public float m_value;
  
  public CONSTANT_Float_info(float paramFloat)
  {
    this.m_value = paramFloat;
  }
  
  protected CONSTANT_Float_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_value = paramUDataInputStream.readFloat();
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public final byte tag()
  {
    return 4;
  }
  
  public String toString()
  {
    return Float.toString(this.m_value);
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeFloat(this.m_value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_Float_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */