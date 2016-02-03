package com.vladium.jcd.compiler;

import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.cls.IConstantCollection;
import com.vladium.jcd.cls.constant.CONSTANT_Integer_info;
import com.vladium.jcd.opcodes.IOpcodes;
import com.vladium.util.ByteArrayOStream;

public abstract class CodeGen
  implements IOpcodes
{
  public static void load_local_object_var(ByteArrayOStream paramByteArrayOStream, int paramInt)
  {
    if (paramInt <= 3)
    {
      paramByteArrayOStream.write(paramInt + 42);
      return;
    }
    if (paramInt <= 255)
    {
      paramByteArrayOStream.write2(25, paramInt);
      return;
    }
    paramByteArrayOStream.write4(196, 25, paramInt >>> 8, paramInt);
  }
  
  public static void push_constant_index(ByteArrayOStream paramByteArrayOStream, int paramInt)
  {
    if (paramInt <= 255)
    {
      paramByteArrayOStream.write2(18, paramInt);
      return;
    }
    paramByteArrayOStream.write3(19, paramInt >>> 8, paramInt);
  }
  
  public static void push_int_value(ByteArrayOStream paramByteArrayOStream, ClassDef paramClassDef, int paramInt)
  {
    if ((-1 <= paramInt) && (paramInt <= 5))
    {
      paramByteArrayOStream.write(paramInt + 3);
      return;
    }
    if ((-128 <= paramInt) && (paramInt <= 127))
    {
      paramByteArrayOStream.write2(16, paramInt);
      return;
    }
    if ((32768 <= paramInt) && (paramInt <= 32767))
    {
      paramByteArrayOStream.write3(17, paramInt >>> 8, paramInt);
      return;
    }
    paramInt = paramClassDef.getConstants().add(new CONSTANT_Integer_info(paramInt));
    if (paramInt <= 255)
    {
      paramByteArrayOStream.write2(18, paramInt);
      return;
    }
    paramByteArrayOStream.write3(19, paramInt >>> 8, paramInt);
  }
  
  public static void store_local_object_var(ByteArrayOStream paramByteArrayOStream, int paramInt)
  {
    if (paramInt <= 3)
    {
      paramByteArrayOStream.write(paramInt + 75);
      return;
    }
    if (paramInt <= 255)
    {
      paramByteArrayOStream.write2(58, paramInt);
      return;
    }
    paramByteArrayOStream.write4(196, 58, paramInt >>> 8, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/compiler/CodeGen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */