package com.vladium.jcd.cls;

import com.vladium.jcd.cls.attribute.Attribute_info;
import com.vladium.jcd.cls.constant.CONSTANT_Utf8_info;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class Field_info
  implements Cloneable, IAccessFlags
{
  private static final boolean DEBUG = false;
  private int m_access_flags;
  private IAttributeCollection m_attributes;
  public int m_descriptor_index;
  public int m_name_index;
  
  public Field_info(int paramInt1, int paramInt2, int paramInt3, IAttributeCollection paramIAttributeCollection)
  {
    this.m_access_flags = paramInt1;
    this.m_name_index = paramInt2;
    this.m_descriptor_index = paramInt3;
    this.m_attributes = paramIAttributeCollection;
  }
  
  public Field_info(IConstantCollection paramIConstantCollection, UDataInputStream paramUDataInputStream)
    throws IOException
  {
    this.m_access_flags = paramUDataInputStream.readU2();
    this.m_name_index = paramUDataInputStream.readU2();
    this.m_descriptor_index = paramUDataInputStream.readU2();
    int j = paramUDataInputStream.readU2();
    this.m_attributes = ElementFactory.newAttributeCollection(j);
    int i = 0;
    while (i < j)
    {
      Attribute_info localAttribute_info = Attribute_info.new_Attribute_info(paramIConstantCollection, paramUDataInputStream);
      this.m_attributes.add(localAttribute_info);
      i += 1;
    }
  }
  
  public Object clone()
  {
    try
    {
      Field_info localField_info = (Field_info)super.clone();
      localField_info.m_attributes = ((IAttributeCollection)this.m_attributes.clone());
      return localField_info;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public final int getAccessFlags()
  {
    return this.m_access_flags;
  }
  
  public IAttributeCollection getAttributes()
  {
    return this.m_attributes;
  }
  
  public String getDescriptor(ClassDef paramClassDef)
  {
    return ((CONSTANT_Utf8_info)paramClassDef.getConstants().get(this.m_descriptor_index)).m_value;
  }
  
  public String getName(ClassDef paramClassDef)
  {
    return ((CONSTANT_Utf8_info)paramClassDef.getConstants().get(this.m_name_index)).m_value;
  }
  
  public boolean isSynthetic()
  {
    return this.m_attributes.hasSynthetic();
  }
  
  public final void setAccessFlags(int paramInt)
  {
    this.m_access_flags = paramInt;
  }
  
  public String toString()
  {
    return "field_info: [modifiers: 0x" + Integer.toHexString(this.m_access_flags) + ", name_index = " + this.m_name_index + ", descriptor_index = " + this.m_descriptor_index + ']';
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    paramUDataOutputStream.writeU2(this.m_access_flags);
    paramUDataOutputStream.writeU2(this.m_name_index);
    paramUDataOutputStream.writeU2(this.m_descriptor_index);
    this.m_attributes.writeInClassFormat(paramUDataOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/Field_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */