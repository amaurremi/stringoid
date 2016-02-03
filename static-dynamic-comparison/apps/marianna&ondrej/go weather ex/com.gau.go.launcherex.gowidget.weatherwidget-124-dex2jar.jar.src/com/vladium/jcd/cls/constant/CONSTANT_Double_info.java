package com.vladium.jcd.cls.constant;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CONSTANT_Double_info
  extends CONSTANT_literal_info
{
  public static final byte TAG = 6;
  public double m_value;
  
  public CONSTANT_Double_info(double paramDouble)
  {
    this.m_value = paramDouble;
  }
  
  protected CONSTANT_Double_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_value = paramUDataInputStream.readDouble();
  }
  
  public Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject)
  {
    return paramICONSTANTVisitor.visit(this, paramObject);
  }
  
  public final byte tag()
  {
    return 6;
  }
  
  public String toString()
  {
    return Double.toString(this.m_value);
  }
  
  public int width()
  {
    return 2;
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeDouble(this.m_value);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_Double_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */