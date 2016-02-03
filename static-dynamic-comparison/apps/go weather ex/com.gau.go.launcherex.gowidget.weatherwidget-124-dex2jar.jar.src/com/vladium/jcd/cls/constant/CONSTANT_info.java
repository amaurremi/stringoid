package com.vladium.jcd.cls.constant;

import com.vladium.jcd.compiler.IClassFormatOutput;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public abstract class CONSTANT_info
  implements Cloneable, IClassFormatOutput
{
  public static CONSTANT_info new_CONSTANT_info(UDataInputStream paramUDataInputStream)
    throws IOException
  {
    int i = paramUDataInputStream.readByte();
    switch (i)
    {
    case 2: 
    default: 
      throw new IllegalStateException("CONSTANT_info: invalid tag value [" + i + ']');
    case 1: 
      return new CONSTANT_Utf8_info(paramUDataInputStream);
    case 3: 
      return new CONSTANT_Integer_info(paramUDataInputStream);
    case 4: 
      return new CONSTANT_Float_info(paramUDataInputStream);
    case 5: 
      return new CONSTANT_Long_info(paramUDataInputStream);
    case 6: 
      return new CONSTANT_Double_info(paramUDataInputStream);
    case 7: 
      return new CONSTANT_Class_info(paramUDataInputStream);
    case 8: 
      return new CONSTANT_String_info(paramUDataInputStream);
    case 9: 
      return new CONSTANT_Fieldref_info(paramUDataInputStream);
    case 10: 
      return new CONSTANT_Methodref_info(paramUDataInputStream);
    case 11: 
      return new CONSTANT_InterfaceMethodref_info(paramUDataInputStream);
    }
    return new CONSTANT_NameAndType_info(paramUDataInputStream);
  }
  
  public static String tagToString(CONSTANT_info paramCONSTANT_info)
  {
    switch (paramCONSTANT_info.tag())
    {
    case 2: 
    default: 
      throw new IllegalStateException("CONSTANT_info: invalid tag value [" + paramCONSTANT_info.tag() + ']');
    case 1: 
      return "CONSTANT_Utf8";
    case 3: 
      return "CONSTANT_Integer";
    case 4: 
      return "CONSTANT_Float";
    case 5: 
      return "CONSTANT_Long";
    case 6: 
      return "CONSTANT_Double";
    case 7: 
      return "CONSTANT_Class";
    case 8: 
      return "CONSTANT_String";
    case 9: 
      return "CONSTANT_Fieldref";
    case 10: 
      return "CONSTANT_Methodref";
    case 11: 
      return "CONSTANT_InterfaceMethodref";
    }
    return "CONSTANT_NameAndType";
  }
  
  public abstract Object accept(ICONSTANTVisitor paramICONSTANTVisitor, Object paramObject);
  
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
  
  public abstract byte tag();
  
  public abstract String toString();
  
  public int width()
  {
    return 1;
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    paramUDataOutputStream.writeByte(tag());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/constant/CONSTANT_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */