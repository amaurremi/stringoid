package com.vladium.jcd.cls.attribute;

import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class InnerClassesAttribute_info
  extends Attribute_info
{
  private List m_classes;
  
  InnerClassesAttribute_info(int paramInt, long paramLong, UDataInputStream paramUDataInputStream)
    throws IOException
  {
    super(paramInt, paramLong);
    int i = paramUDataInputStream.readU2();
    ArrayList localArrayList = new ArrayList(i);
    paramInt = 0;
    while (paramInt < i)
    {
      localArrayList.add(new InnerClass_info(paramUDataInputStream));
      paramInt += 1;
    }
    this.m_classes = localArrayList;
  }
  
  public void accept(IAttributeVisitor paramIAttributeVisitor, Object paramObject)
  {
    paramIAttributeVisitor.visit(this, paramObject);
  }
  
  public Object clone()
  {
    InnerClassesAttribute_info localInnerClassesAttribute_info = (InnerClassesAttribute_info)super.clone();
    List localList = this.m_classes;
    int j = localList.size();
    localInnerClassesAttribute_info.m_classes = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localInnerClassesAttribute_info.m_classes.add(((InnerClass_info)localList.get(i)).clone());
      i += 1;
    }
    return localInnerClassesAttribute_info;
  }
  
  public final InnerClass_info get(int paramInt)
  {
    return (InnerClass_info)this.m_classes.get(paramInt);
  }
  
  public final long length()
  {
    return (this.m_classes.size() << 3) + 8;
  }
  
  public boolean makesClassNested(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int j;
    if (paramInt > 0)
    {
      i = 0;
      j = size();
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        InnerClass_info localInnerClass_info = get(i);
        if (localInnerClass_info.m_inner_class_index == paramInt)
        {
          paramArrayOfInt[0] = localInnerClass_info.m_inner_access_flags;
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final int size()
  {
    return this.m_classes.size();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("InnerClassesAttribute_info: [attribute_name_index = " + this.m_name_index + ", attribute_length = " + length() + "]\n");
    int i = 0;
    while (i < size())
    {
      localStringBuffer.append("            " + get(i));
      localStringBuffer.append("\n");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    super.writeInClassFormat(paramUDataOutputStream);
    List localList = this.m_classes;
    int j = localList.size();
    paramUDataOutputStream.writeU2(j);
    int i = 0;
    while (i < j)
    {
      ((InnerClass_info)localList.get(i)).writeInClassFormat(paramUDataOutputStream);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/attribute/InnerClassesAttribute_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */