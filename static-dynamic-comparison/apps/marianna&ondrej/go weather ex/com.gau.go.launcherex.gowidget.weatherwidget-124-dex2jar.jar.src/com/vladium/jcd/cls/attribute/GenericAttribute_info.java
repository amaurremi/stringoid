package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class GenericAttribute_info
  extends Attribute_info
{
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  public byte[] m_info = new byte[(int)this.m_attribute_length];
  
  GenericAttribute_info(int paramInt, long paramLong, UDataInputStream paramUDataInputStream)
    throws IOException
  {
    super(paramInt, paramLong);
    paramUDataInputStream.readFully(this.m_info);
  }
  
  public GenericAttribute_info(int paramInt, byte[] paramArrayOfByte) {}
  
  public void accept(IAttributeVisitor paramIAttributeVisitor, Object paramObject)
  {
    paramIAttributeVisitor.visit(this, paramObject);
  }
  
  public Object clone()
  {
    GenericAttribute_info localGenericAttribute_info = (GenericAttribute_info)super.clone();
    if (this.m_info.length == 0) {}
    for (byte[] arrayOfByte = EMPTY_BYTE_ARRAY;; arrayOfByte = (byte[])this.m_info.clone())
    {
      localGenericAttribute_info.m_info = arrayOfByte;
      return localGenericAttribute_info;
    }
  }
  
  public long length()
  {
    return this.m_info.length + 6;
  }
  
  public String toString()
  {
    return "generic attribute_info: [attribute_name_index = " + this.m_name_index + ", attribute_length = " + this.m_attribute_length + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.write(this.m_info, 0, this.m_info.length);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/GenericAttribute_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */