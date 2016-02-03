package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.cls.ElementFactory;
import com.vladium.jcd.cls.IAttributeCollection;
import com.vladium.jcd.cls.IConstantCollection;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public final class CodeAttribute_info
  extends Attribute_info
{
  private static final boolean DEBUG = false;
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private IAttributeCollection m_attributes;
  private byte[] m_code;
  private int m_codeSize;
  private IExceptionHandlerTable m_exceptionHandlerTable;
  public int m_max_locals;
  public int m_max_stack;
  
  public CodeAttribute_info(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, IExceptionHandlerTable paramIExceptionHandlerTable, IAttributeCollection paramIAttributeCollection) {}
  
  CodeAttribute_info(IConstantCollection paramIConstantCollection, int paramInt, long paramLong, UDataInputStream paramUDataInputStream)
    throws IOException
  {
    super(paramInt, paramLong);
    this.m_max_stack = paramUDataInputStream.readU2();
    this.m_max_locals = paramUDataInputStream.readU2();
    paramLong = paramUDataInputStream.readU4();
    this.m_code = new byte[(int)paramLong];
    paramUDataInputStream.readFully(this.m_code);
    this.m_codeSize = ((int)paramLong);
    int i = paramUDataInputStream.readU2();
    this.m_exceptionHandlerTable = AttributeElementFactory.newExceptionHandlerTable(i);
    paramInt = 0;
    Object localObject;
    while (paramInt < i)
    {
      localObject = new Exception_info(paramUDataInputStream);
      this.m_exceptionHandlerTable.add((Exception_info)localObject);
      paramInt += 1;
    }
    i = paramUDataInputStream.readU2();
    this.m_attributes = ElementFactory.newAttributeCollection(i);
    paramInt = 0;
    while (paramInt < i)
    {
      localObject = Attribute_info.new_Attribute_info(paramIConstantCollection, paramUDataInputStream);
      this.m_attributes.add((Attribute_info)localObject);
      paramInt += 1;
    }
  }
  
  public void accept(IAttributeVisitor paramIAttributeVisitor, Object paramObject)
  {
    paramIAttributeVisitor.visit(this, paramObject);
  }
  
  public Object clone()
  {
    CodeAttribute_info localCodeAttribute_info = (CodeAttribute_info)super.clone();
    if (this.m_codeSize == 0) {}
    for (byte[] arrayOfByte = EMPTY_BYTE_ARRAY;; arrayOfByte = (byte[])this.m_code.clone())
    {
      localCodeAttribute_info.m_code = arrayOfByte;
      localCodeAttribute_info.m_exceptionHandlerTable = ((IExceptionHandlerTable)this.m_exceptionHandlerTable.clone());
      localCodeAttribute_info.m_attributes = ((IAttributeCollection)this.m_attributes.clone());
      return localCodeAttribute_info;
    }
  }
  
  public IAttributeCollection getAttributes()
  {
    return this.m_attributes;
  }
  
  public final byte[] getCode()
  {
    return this.m_code;
  }
  
  public final int getCodeSize()
  {
    return this.m_codeSize;
  }
  
  public IExceptionHandlerTable getExceptionTable()
  {
    return this.m_exceptionHandlerTable;
  }
  
  public long length()
  {
    return this.m_codeSize + 14 + this.m_exceptionHandlerTable.length() + this.m_attributes.length();
  }
  
  public void setCode(byte[] paramArrayOfByte, int paramInt)
  {
    this.m_code = paramArrayOfByte;
    this.m_codeSize = paramInt;
  }
  
  public String toString()
  {
    String str = System.getProperty("line.separator");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CodeAttribute_info: [attribute_name_index = " + this.m_name_index + ", attribute_length = " + this.m_attribute_length + "]" + str);
    localStringBuffer.append("    max_stack/max_locals = " + this.m_max_stack + '/' + this.m_max_locals + str);
    localStringBuffer.append("    code [length " + this.m_codeSize + "]" + str);
    int i = 0;
    while (i < this.m_attributes.size())
    {
      localStringBuffer.append("         " + this.m_attributes.get(i) + str);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    paramUDataOutputStream.writeU2(this.m_max_stack);
    paramUDataOutputStream.writeU2(this.m_max_locals);
    paramUDataOutputStream.writeU4(this.m_codeSize);
    paramUDataOutputStream.write(this.m_code, 0, this.m_codeSize);
    this.m_exceptionHandlerTable.writeInClassFormat(paramUDataOutputStream);
    this.m_attributes.writeInClassFormat(paramUDataOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/CodeAttribute_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */