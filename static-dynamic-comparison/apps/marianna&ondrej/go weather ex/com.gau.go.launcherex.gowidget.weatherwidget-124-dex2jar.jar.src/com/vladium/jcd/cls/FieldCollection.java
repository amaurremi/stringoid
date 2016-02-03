package com.vladium.jcd.cls;

import com.vladium.jcd.lib.UDataOutputStream;
import com.vladium.util.IntVector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class FieldCollection
  implements IFieldCollection
{
  private List m_fields;
  
  FieldCollection(int paramInt)
  {
    if (paramInt < 0) {}
    for (ArrayList localArrayList = new ArrayList();; localArrayList = new ArrayList(paramInt))
    {
      this.m_fields = localArrayList;
      return;
    }
  }
  
  public void accept(IClassDefVisitor paramIClassDefVisitor, Object paramObject)
  {
    paramIClassDefVisitor.visit(this, paramObject);
  }
  
  public int add(Field_info paramField_info)
  {
    int i = this.m_fields.size();
    this.m_fields.add(paramField_info);
    return i;
  }
  
  public Object clone()
  {
    try
    {
      FieldCollection localFieldCollection = (FieldCollection)super.clone();
      int j = this.m_fields.size();
      localFieldCollection.m_fields = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localFieldCollection.m_fields.add(((Field_info)this.m_fields.get(i)).clone());
        i += 1;
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError(localCloneNotSupportedException.toString());
    }
  }
  
  public Field_info get(int paramInt)
  {
    return (Field_info)this.m_fields.get(paramInt);
  }
  
  public int[] get(ClassDef paramClassDef, String paramString)
  {
    if (paramClassDef == null) {
      throw new IllegalArgumentException("null input: cls");
    }
    int j = this.m_fields.size();
    IntVector localIntVector = new IntVector(j);
    int i = 0;
    while (i < j)
    {
      if (((Field_info)this.m_fields.get(i)).getName(paramClassDef).equals(paramString)) {
        localIntVector.add(i);
      }
      i += 1;
    }
    return localIntVector.values();
  }
  
  public Field_info set(int paramInt, Field_info paramField_info)
  {
    return (Field_info)this.m_fields.set(paramInt, paramField_info);
  }
  
  public int size()
  {
    return this.m_fields.size();
  }
  
  public void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException
  {
    int j = this.m_fields.size();
    paramUDataOutputStream.writeU2(j);
    int i = 0;
    while (i < j)
    {
      get(i).writeInClassFormat(paramUDataOutputStream);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/cls/FieldCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */