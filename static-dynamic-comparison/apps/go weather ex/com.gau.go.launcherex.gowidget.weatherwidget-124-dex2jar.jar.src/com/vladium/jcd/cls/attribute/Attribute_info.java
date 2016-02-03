package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.cls.IConstantCollection;
import com.vladium.jcd.cls.constant.CONSTANT_Utf8_info;
import com.vladium.jcd.compiler.IClassFormatOutput;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public abstract class Attribute_info
  implements Cloneable, IClassFormatOutput
{
  public static final String ATTRIBUTE_BRIDGE = "Bridge";
  public static final String ATTRIBUTE_CODE = "Code";
  public static final String ATTRIBUTE_CONSTANT_VALUE = "ConstantValue";
  public static final String ATTRIBUTE_EXCEPTIONS = "Exceptions";
  public static final String ATTRIBUTE_INNERCLASSES = "InnerClasses";
  public static final String ATTRIBUTE_LINE_NUMBER_TABLE = "LineNumberTable";
  public static final String ATTRIBUTE_SOURCEFILE = "SourceFile";
  public static final String ATTRIBUTE_SYNTHETIC = "Synthetic";
  protected long m_attribute_length;
  public int m_name_index;
  
  protected Attribute_info(int paramInt, long paramLong)
  {
    this.m_name_index = paramInt;
    this.m_attribute_length = paramLong;
  }
  
  public static Attribute_info new_Attribute_info(IConstantCollection paramIConstantCollection, UDataInputStream paramUDataInputStream)
    throws IOException
  {
    int i = paramUDataInputStream.readU2();
    long l = paramUDataInputStream.readU4();
    String str = ((CONSTANT_Utf8_info)paramIConstantCollection.get(i)).m_value;
    if ("Code".equals(str)) {
      return new CodeAttribute_info(paramIConstantCollection, i, l, paramUDataInputStream);
    }
    if ("ConstantValue".equals(str)) {
      return new ConstantValueAttribute_info(i, l, paramUDataInputStream);
    }
    if ("Exceptions".equals(str)) {
      return new ExceptionsAttribute_info(i, l, paramUDataInputStream);
    }
    if ("InnerClasses".equals(str)) {
      return new InnerClassesAttribute_info(i, l, paramUDataInputStream);
    }
    if ("Synthetic".equals(str)) {
      return new SyntheticAttribute_info(i, l);
    }
    if ("Bridge".equals(str)) {
      return new BridgeAttribute_info(i, l);
    }
    if ("LineNumberTable".equals(str)) {
      return new LineNumberTableAttribute_info(i, l, paramUDataInputStream);
    }
    if ("SourceFile".equals(str)) {
      return new SourceFileAttribute_info(i, l, paramUDataInputStream);
    }
    return new GenericAttribute_info(i, l, paramUDataInputStream);
  }
  
  public abstract void accept(IAttributeVisitor paramIAttributeVisitor, Object paramObject);
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public String getName(ClassDef paramClassDef)
  {
    return ((CONSTANT_Utf8_info)paramClassDef.getConstants().get(this.m_name_index)).m_value;
  }
  
  public abstract long length();
  
  public abstract String toString();
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    paramUDataOutputStream.writeU2(this.m_name_index);
    paramUDataOutputStream.writeU4(length() - 6L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/Attribute_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */