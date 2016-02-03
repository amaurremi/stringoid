package com.vladium.emma.data;

import com.vladium.util.IConstants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

public final class ClassDescriptor
  implements IConstants, Serializable
{
  private final boolean m_hasCompleteLineNumberInfo;
  private transient int m_hash;
  private final MethodDescriptor[] m_methods;
  private final String m_name;
  private final String m_packageVMName;
  private final String m_srcFileName;
  private final long m_stamp;
  
  public ClassDescriptor(String paramString1, String paramString2, long paramLong, String paramString3, MethodDescriptor[] paramArrayOfMethodDescriptor)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("null input: packageVMName");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("null input: name");
    }
    if (paramArrayOfMethodDescriptor == null) {
      throw new IllegalArgumentException("null input: methods");
    }
    this.m_packageVMName = paramString1;
    this.m_name = paramString2;
    this.m_stamp = paramLong;
    this.m_srcFileName = paramString3;
    this.m_methods = paramArrayOfMethodDescriptor;
    boolean bool2 = true;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.m_methods.length)
      {
        if (((paramArrayOfMethodDescriptor[i].getStatus() & 0xE) == 0) && (!this.m_methods[i].hasLineNumberInfo())) {
          bool1 = false;
        }
      }
      else
      {
        this.m_hasCompleteLineNumberInfo = bool1;
        return;
      }
      i += 1;
    }
  }
  
  static ClassDescriptor readExternal(DataInput paramDataInput)
    throws IOException
  {
    String str2 = paramDataInput.readUTF();
    String str3 = paramDataInput.readUTF();
    long l = paramDataInput.readLong();
    if (paramDataInput.readByte() != 0) {}
    MethodDescriptor[] arrayOfMethodDescriptor;
    for (String str1 = paramDataInput.readUTF();; str1 = null)
    {
      int j = paramDataInput.readInt();
      arrayOfMethodDescriptor = new MethodDescriptor[j];
      int i = 0;
      while (i < j)
      {
        arrayOfMethodDescriptor[i] = MethodDescriptor.readExternal(paramDataInput);
        i += 1;
      }
    }
    return new ClassDescriptor(str2, str3, l, str1, arrayOfMethodDescriptor);
  }
  
  static void writeExternal(ClassDescriptor paramClassDescriptor, DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeUTF(paramClassDescriptor.m_packageVMName);
    paramDataOutput.writeUTF(paramClassDescriptor.m_name);
    paramDataOutput.writeLong(paramClassDescriptor.m_stamp);
    if (paramClassDescriptor.m_srcFileName != null)
    {
      paramDataOutput.writeByte(1);
      paramDataOutput.writeUTF(paramClassDescriptor.m_srcFileName);
    }
    for (;;)
    {
      paramClassDescriptor = paramClassDescriptor.m_methods;
      int j = paramClassDescriptor.length;
      paramDataOutput.writeInt(j);
      int i = 0;
      while (i < j)
      {
        MethodDescriptor.writeExternal(paramClassDescriptor[i], paramDataOutput);
        i += 1;
      }
      paramDataOutput.writeByte(0);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ClassDescriptor)) {}
    do
    {
      return false;
      paramObject = (ClassDescriptor)paramObject;
    } while ((hashCode() != ((ClassDescriptor)paramObject).hashCode()) || (!this.m_name.equals(((ClassDescriptor)paramObject).m_name)) || (!this.m_packageVMName.equals(((ClassDescriptor)paramObject).m_packageVMName)));
    return true;
  }
  
  public final String getClassVMName()
  {
    if (this.m_packageVMName.length() == 0) {
      return this.m_name;
    }
    return this.m_packageVMName + "/" + this.m_name;
  }
  
  public final MethodDescriptor[] getMethods()
  {
    return this.m_methods;
  }
  
  public final String getName()
  {
    return this.m_name;
  }
  
  public final String getPackageVMName()
  {
    return this.m_packageVMName;
  }
  
  public final String getSrcFileName()
  {
    return this.m_srcFileName;
  }
  
  public final long getStamp()
  {
    return this.m_stamp;
  }
  
  public final boolean hasCompleteLineNumberInfo()
  {
    return this.m_hasCompleteLineNumberInfo;
  }
  
  public final boolean hasSrcFileInfo()
  {
    return this.m_srcFileName != null;
  }
  
  public final int hashCode()
  {
    if (this.m_hash == 0)
    {
      int i = this.m_name.hashCode() + this.m_packageVMName.hashCode() * 16661;
      this.m_hash = i;
      return i;
    }
    return this.m_hash;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  public String toString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("class [");
    if (this.m_packageVMName.length() > 0) {}
    for (Object localObject = this.m_packageVMName + "/";; localObject = "")
    {
      localObject = new StringBuffer((String)localObject + this.m_name + "] descriptor:");
      int i = 0;
      while (i < this.m_methods.length)
      {
        ((StringBuffer)localObject).append(EOL);
        ((StringBuffer)localObject).append(this.m_methods[i].toString(paramString + "  "));
        i += 1;
      }
    }
    return ((StringBuffer)localObject).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/ClassDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */